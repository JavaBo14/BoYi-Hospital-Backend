
package com.boyi.hospital.model.vo.dector;

import lombok.Data;

import java.io.Serializable;

@Data
public class DoctorDetailQuery implements Serializable {
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
}
