package com.boyi.hospital.model.vo.register;

import lombok.Data;

import java.io.Serializable;
@Data
public class RegisterVo implements Serializable {

    /**
     * 挂号ID
     */
    private String registerId;

    /**
     * 支付订单号
     */
    private String orderId;

    /**
     * 挂号状态  WAIT_PAY-待支付, SUCCEED-预约成功
     */
    private String registerStatus;

    /**
     * 订单状态 WAIT_PAY-待支付, PA
     */
    private String orderStatus;
}
