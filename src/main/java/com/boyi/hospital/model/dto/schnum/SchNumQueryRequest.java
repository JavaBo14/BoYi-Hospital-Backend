package com.boyi.hospital.model.dto.schnum;

import lombok.Data;

import java.io.Serializable;

@Data
public class SchNumQueryRequest implements Serializable {

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

    /**
     * 排班ID
     */
    private String scheduleId;


}

