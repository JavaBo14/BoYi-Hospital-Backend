package com.boyi.hospital.model.dto.order;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrderRequest implements Serializable {

    /**
     * 医院编码
     */
    private String hospitalNo;

    /**
     * 挂号ID
     */
    private String registerId;

    /**
     * 订单ID
     */
    private String orderId;
}
