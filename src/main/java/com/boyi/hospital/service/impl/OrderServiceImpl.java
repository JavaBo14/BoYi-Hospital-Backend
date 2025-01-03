package com.boyi.hospital.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.exception.ThrowUtils;
import com.boyi.hospital.model.dto.order.OrderRequest;
import com.boyi.hospital.model.entity.Order;
import com.boyi.hospital.mapper.OrderMapper;
import com.boyi.hospital.model.vo.order.OrderVO;
import com.boyi.hospital.service.OrderService;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_order(订单记录表)】的数据库操作Service实现
* @createDate 2024-12-31 14:59:59
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {

    /**
     * 挂号支付
     * @param orderRequest
     * @return
     */
    @Override
    public OrderVO registerPay(OrderRequest orderRequest) {
        String registerId = orderRequest.getRegisterId();
        String orderId = orderRequest.getOrderId();
        String hospitalNo = orderRequest.getHospitalNo();
        ThrowUtils.throwIf(StrUtil.isBlank(registerId), ErrorCode.PARAMS_ERROR, "挂号ID不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(orderId), ErrorCode.PARAMS_ERROR, "订单ID不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(hospitalNo), ErrorCode.PARAMS_ERROR, "医院编码不能为空");
        return null;
    }
}




