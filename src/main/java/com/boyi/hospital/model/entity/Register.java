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
 * 预约记录表
 * @TableName t_register
 */
@TableName(value = "t_register")
@Data
public class Register implements Serializable {
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
     * 医院名称
     */
    @TableField("hospital_name")
    private String hospitalName;

    /**
     * 科室编码
     */
    @TableField("dept_code")
    private String deptCode;

    /**
     * 科室名称
     */
    @TableField("dept_name")
    private String deptName;

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
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 患者ID
     */
    @TableField("patient_id")
    private String patientId;

    /**
     * 患者号
     */
    @TableField("patient_no")
    private String patientNo;

    /**
     * 患者姓名
     */
    @TableField("patient_name")
    private String patientName;

    /**
     * 挂号ID
     */
    @TableField("register_id")
    private String registerId;

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
     * 预约日期
     */
    @TableField("sche_date")
    private String scheDate;

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
     * 支付订单号
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 挂号状态  WAIT_PAY-待支付, SUCCEED-预约成功
     */
    @TableField("register_status")
    private String registerStatus;

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