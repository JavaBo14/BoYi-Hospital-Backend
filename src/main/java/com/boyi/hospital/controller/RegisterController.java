package com.boyi.hospital.controller;

import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.dto.register.RegisterRequest;
import com.boyi.hospital.model.vo.register.RegisterVo;
import com.boyi.hospital.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 预约接口
 *
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 */
@RestController
@RequestMapping("v1/register")
@Slf4j
public class RegisterController {

     @Resource
     private RegisterService registerService;
    /**
     * 挂号预约接口
     *
     * @param registerRequest
     * @return
     */
    @PostMapping("appoint")
    public BaseResponse<RegisterVo> registerBooking(@RequestBody RegisterRequest registerRequest) {
        // 1. 参数验证
        if (registerRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        RegisterVo registerVo = registerService.registerBooking(registerRequest);
        return ResultUtils.success(registerVo);
    }
}