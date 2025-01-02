package com.boyi.hospital.model.dto.doctor;

import lombok.Data;

import java.io.Serializable;

@Data
public class DoctorQueryRequest implements Serializable {

    /**
     * 医院编码
     */
    private String hospitalNo;

    /**
     * 科室编码
     */
    private String deptCode;

    /**
     * 医生编码
     */
    private String doctorCode;

}
