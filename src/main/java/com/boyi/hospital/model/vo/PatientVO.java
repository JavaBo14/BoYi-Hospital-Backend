package com.boyi.hospital.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatientVO implements Serializable {

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 患者姓名
     */
    private String patientName;


    /**
     * 患者号
     */
    private String patientNo;
}
