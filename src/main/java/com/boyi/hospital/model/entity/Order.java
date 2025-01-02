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
 * 订单记录表
 *
 * @TableName t_order
 */
@TableName(value = "t_order")
@Data
public class Order implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单ID
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 业务ID
     */
    @TableField("biz_id")
    private String bizId;

    /**
     * 订单金额
     */
    @TableField("order_amt")
    private BigDecimal orderAmt;

    /**
     * 订单状态 WAIT_PAY-待支付, PA
     */
    @TableField("order_status")
    private String orderStatus;

    /**
     * 支付方式 WX-微信 INSUR-医保
     */
    @TableField("pay_type")
    private String payType;

    /**
     * 支付时间
     */
    @TableField("order_time")
    private Date orderTime;

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