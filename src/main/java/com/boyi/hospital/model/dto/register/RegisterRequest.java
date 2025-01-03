package com.boyi.hospital.model.dto.register;


import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {

    /**
     * 医院编码
     */
    private String hospitalNo;

    /**
     * 号源ID
     */
    private String scheNumId;

    /**
     * 患者号
     */
    private String patientNo;

    /**
     * 支付方式 WX-微信 INSUR-医保
     */
    private String payType;
}
