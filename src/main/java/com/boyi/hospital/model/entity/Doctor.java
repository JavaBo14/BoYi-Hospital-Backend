package com.boyi.hospital.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 医生表
 * @TableName t_doctor_info
 */
@TableName(value ="t_doctor_info")
@Data
public class Doctor implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 医院编码
     */
    @TableField("hospital_no")
    private String hospitalNo;

    /**
     * 科室编码
     */
    @TableField("dept_code")
    private String deptCode;

    /**
     * 医生编码
     */
    @TableField("doctor_code")
    private String doctorCode;

    /**
     * 医生姓名
     */
    @TableField("doctor_name")
    private String doctorName;

    /**
     * 医生头像
     */
    @TableField("avatar_img")
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
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_name")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}