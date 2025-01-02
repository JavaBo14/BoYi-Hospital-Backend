package com.boyi.hospital.model.vo.schedule;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class DoctorScheduleListVO implements Serializable {


    /**
     * 科室编码
     */
    private String deptCode;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 医生列表
     */
    private List<DoctorScheduleVO> doctors;

}