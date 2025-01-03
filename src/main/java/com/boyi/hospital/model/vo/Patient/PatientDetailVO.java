package com.boyi.hospital.model.vo.Patient;

import lombok.Data;

import java.io.Serializable;
@Data
public class PatientDetailVO  implements Serializable {

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 患者地址
     */
    private String address;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 身份证
     */
    private String certNo;

    /**
     * 患者号
     */
    private String patientNo;

    /**
     * 就诊号条形码
     */
    private String barCode;

    /**
     * 就诊人二维码
     */
    private String qrCode;

}
