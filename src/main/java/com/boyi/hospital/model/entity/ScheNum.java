package com.boyi.hospital.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 医生号源表
 * @TableName t_sche_num_info
 */
@TableName(value = "t_sche_num_info")
@Data
public class ScheNum implements Serializable {
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
     * 排班日期
     */
    @TableField("sche_date")
    private Date scheDate;

    /**
     * 排班ID
     */
    @TableField("schedule_id")
    private String scheduleId;

    /**
     * 号源ID
     */
    @TableField("sche_num_id")
    private String scheNumId;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private Date endTime;

    /**
     * 挂号费
     */
    @TableField("register_fee")
    private BigDecimal registerFee;

    /**
     * 余号数
     */
    @TableField("surplus")
    private Integer surplus;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}