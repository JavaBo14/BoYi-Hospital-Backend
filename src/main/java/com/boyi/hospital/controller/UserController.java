package com.boyi.hospital.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.dto.mobile.MobileRequest;
import com.boyi.hospital.model.entity.User;
import com.boyi.hospital.model.enums.UserStatusEnum;
import com.boyi.hospital.model.vo.CodeLoginVo;
import com.boyi.hospital.model.vo.CodeVo;
import com.boyi.hospital.service.UserService;
import com.boyi.hospital.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

/**
 * 用户接口
 *
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 * 
 */
@RestController
@RequestMapping("v1/auht/mobile")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 获取手机验证码
     *
     * @param mobileRequest
     * @return
     */
    @PostMapping("code")
    public BaseResponse<CodeVo> getPhoneCode(@RequestBody MobileRequest mobileRequest) {
        String mobile = mobileRequest.getMobile();
        // 验证手机号格式
        if (StrUtil.isBlank(mobile) || !mobile.matches("^1[3-9]\\d{9}$")) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "手机号格式不正确");
        }
        // TODO: 2024/12/31
        SecureRandom random = new SecureRandom();
        String code = String.format("%06d", random.nextInt(1000000));
        CodeVo codeVo=new CodeVo();
        codeVo.setCode(code);
        // 存储验证码
        String verificationCodeKey = "VERIFICATION_CODE:" + mobile;
        try {
            // 将验证码存储到 Redis，设置 1 分钟过期时间
            redisTemplate.opsForValue().set(verificationCodeKey, code, 1, TimeUnit.MINUTES);
        } catch (RedisConnectionFailureException e) {
            log.error("Redis 连接失败，无法存储验证码", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "系统繁忙，请稍后再试");
        } catch (Exception e) {
            log.error("存储验证码时发生未知错误", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "系统繁忙，请稍后再试");
        }
        return ResultUtils.success(codeVo);
    }

    /**
     * 用户登录
     * @param mobileRequest
     * @return
     */
    @PostMapping("login")
    public BaseResponse<CodeLoginVo> phoneCodeLogin(@RequestBody MobileRequest mobileRequest) {
        String mobile = mobileRequest.getMobile();
        String code = mobileRequest.getCode();
        // 验证手机号格式
        if (StrUtil.isBlank(mobile) || !mobile.matches("^1[3-9]\\d{9}$")) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "手机号格式不正确");
        }
        // 从 Redis 获取验证码
        String redisKey = "VERIFICATION_CODE:" + mobile;
        String storedCode = (String) redisTemplate.opsForValue().get(redisKey);
        // 验证码校验
        if (StrUtil.isBlank(storedCode)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "验证码已失效，请重新获取");
        }
        if (!storedCode.equals(code)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "验证码不正确");
        }
        // 检查手机号是否已注册
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", mobile);
        User user = userService.getOne(queryWrapper);
        // 如果用户不存在，自动注册新用户
        if (user == null) {
            user = new User();
            user.setUserId(IdUtil.simpleUUID());
            user.setAccount(mobile);
            user.setStatus(UserStatusEnum.START.getValue());
            // TODO: 2024/12/31 机构编码 
            user.setHospitalNo(IdUtil.simpleUUID());
            user.setUserNick("用户" + mobile.substring(mobile.length() - 4));  // 可以根据手机号生成昵称
            userService.save(user);  // 保存用户到数据库
        }
        // 生成 JWT 登录凭证
        String token = JWTUtil.geneJsonWebToken(user);
        CodeLoginVo codeLoginVo = new CodeLoginVo();
        codeLoginVo.setAccessToken(token);
        // 登录成功后，清除 Redis 中的验证码
        redisTemplate.delete(redisKey);
        // 返回成功响应，包含生成的 JWT Token
        return ResultUtils.success(codeLoginVo);
    }

}
