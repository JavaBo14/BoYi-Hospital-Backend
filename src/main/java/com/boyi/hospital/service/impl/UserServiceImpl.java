package com.boyi.hospital.service.impl;


import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.mapper.UserMapper;
import com.boyi.hospital.model.dto.mobile.MobileRequest;
import com.boyi.hospital.model.entity.User;
import com.boyi.hospital.model.enums.UserStatusEnum;
import com.boyi.hospital.model.vo.user.CodeLoginVo;
import com.boyi.hospital.model.vo.user.CodeVo;
import com.boyi.hospital.service.UserService;
import com.boyi.hospital.utils.JWTUtil;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

/**
* @author Bo
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2024-12-30 11:44:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 获取手机验证码
     * @param mobileRequest
     * @return
     */
    @Override
    public CodeVo getPhoneCode(MobileRequest mobileRequest) {
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
        return codeVo;
    }

    /**
     * 用户登录
     * @param mobileRequest
     * @return
     */
    @Override
    public CodeLoginVo phoneCodeLogin(MobileRequest mobileRequest) {
        String code = mobileRequest.getCode();
        String mobile = mobileRequest.getMobile();

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
        User user = this.getOne(queryWrapper);
        // 如果用户不存在，自动注册新用户
        if (user == null) {
            user = new User();
            user.setUserId(IdUtil.simpleUUID());
            user.setAccount(mobile);
            user.setStatus(UserStatusEnum.START.getValue());
            // TODO: 2024/12/31 机构编码 二维码
            user.setHospitalNo(IdUtil.simpleUUID());
            user.setUserNick("用户" + mobile.substring(mobile.length() - 4));  // 可以根据手机号生成昵称
            this.save(user);  // 保存用户到数据库
        }
        // 生成 JWT 登录凭证
        String token = JWTUtil.geneJsonWebToken(user);
        CodeLoginVo codeLoginVo = new CodeLoginVo();
        codeLoginVo.setAccessToken(token);
        // 登录成功后，清除 Redis 中的验证码
        redisTemplate.delete(redisKey);
        return codeLoginVo;
    }
}




