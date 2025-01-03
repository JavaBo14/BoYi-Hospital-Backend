package com.boyi.hospital.model.vo.Patient;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatientInformationVO implements Serializable {

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
