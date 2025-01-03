package com.boyi.hospital.model.vo.schenum;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DoctorScheNumListVO implements Serializable {


    /**
     * 科室编码
     */
    private String deptCode;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 号源列表
     */
    private List<DoctorScheNumVO> scheNums;
}
