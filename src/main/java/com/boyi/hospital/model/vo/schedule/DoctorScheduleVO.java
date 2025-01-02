package com.boyi.hospital.model.vo.schedule;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DoctorScheduleVO implements Serializable {
    /**
     * 医院编码
     */
    private String hospitalNo;

    /**
     * 科室编码
     */
    private String deptCode;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 医生编码
     */
    private String doctorCode;

    /**
     * 医生姓名
     */
    private String doctorName;


    /**
     * 医生头像
     */
    private String avatarImg;

    /**
     * 职称
     */
    private String title;

    /**
     * 擅长
     */
    private String skills;

    /**
     * 余号数
     */
    private Integer surplus;


    /**
     * 挂号费
     */
    private BigDecimal registerFee;

    /**
     * 排班ID
     */
    private String scheduleId;
}
