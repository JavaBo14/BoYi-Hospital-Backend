package com.boyi.hospital.model.dto.schdule;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class ScheduleQueryRequest implements Serializable {

    /**
     * 医院编码
     */
    private String hospitalNo;

    /**
     * 科室编码
     */
    private String deptCode;

    /**
     * 排班日期
     */
    private Date scheDate;
}