package com.boyi.hospital.model.dto.mobile;

import lombok.Data;

import java.io.Serializable;

@Data
public class MobileDTO implements Serializable {
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 验证码
     */
    private String code;
}