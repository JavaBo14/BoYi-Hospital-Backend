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
@TableName(value ="t_register")
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
    private String hospitalNo;

    /**
     * 医院名称
     */
    private String hospitalName;

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
     * 用户ID
     */
    private String userId;

    /**
     * 患者ID
     */
    private String patientId;

    /**
     * 患者号
     */
    private String patientNo;

    /**
     * 患者姓名
     */
    private String patientName;

    /**
     * 挂号ID
     */
    private String registerId;

    /**
     * 排班ID
     */
    private String scheduleId;

    /**
     * 号源ID
     */
    private String scheNumId;

    /**
     * 预约日期
     */
    private String scheDate;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 挂号费
     */
    private BigDecimal registerFee;

    /**
     * 支付订单号
     */
    private String orderId;

    /**
     * 挂号状态  WAIT_PAY-待支付, SUCCEED-预约成功
     */
    private String registerStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}