package com.boyi.hospital.model.vo.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class CodeVo implements Serializable {
    /**
     * 验证码
     */
    private String code;
}
