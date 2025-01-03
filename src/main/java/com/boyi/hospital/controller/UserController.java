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
import com.boyi.hospital.model.vo.user.CodeLoginVo;
import com.boyi.hospital.model.vo.user.CodeVo;
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

    /**
     * 获取手机验证码
     *
     * @param mobileRequest
     * @return
     */
    @PostMapping("code")
    public BaseResponse<CodeVo> getPhoneCode(@RequestBody MobileRequest mobileRequest) {
        if (mobileRequest == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        CodeVo phoneCode = userService.getPhoneCode(mobileRequest);
        return ResultUtils.success(phoneCode);
    }

    /**
     * 用户登录
     * @param mobileRequest
     * @return
     */
    @PostMapping("login")
    public BaseResponse<CodeLoginVo> phoneCodeLogin(@RequestBody MobileRequest mobileRequest) {
        if (mobileRequest == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        CodeLoginVo codeLoginVo = userService.phoneCodeLogin(mobileRequest);
        return ResultUtils.success(codeLoginVo);
    }

}
