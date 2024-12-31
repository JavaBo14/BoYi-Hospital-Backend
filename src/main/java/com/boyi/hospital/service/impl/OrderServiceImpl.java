package com.boyi.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.model.entity.Order;
import generator.service.OrderService;
import com.boyi.hospital.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_order(订单记录表)】的数据库操作Service实现
* @createDate 2024-12-31 14:59:59
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




