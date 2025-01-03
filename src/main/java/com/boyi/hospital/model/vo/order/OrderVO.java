package com.boyi.hospital.model.vo.order;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrderVO implements Serializable {

    /**
     * 挂号ID
     */
    private String registerId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单状态 WAIT_PAY-待支付, PA
     */
    private String orderStatus;

}
