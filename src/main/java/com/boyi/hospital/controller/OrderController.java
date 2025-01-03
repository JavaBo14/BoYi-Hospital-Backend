package com.boyi.hospital.controller;

import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.dto.dept.DeptQueryRequest;
import com.boyi.hospital.model.dto.order.OrderRequest;
import com.boyi.hospital.model.vo.dept.DeptListVO;
import com.boyi.hospital.model.vo.order.OrderVO;
import com.boyi.hospital.service.DeptService;
import com.boyi.hospital.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 支付接口
 *
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 */
@RestController
@RequestMapping("v1/register")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 挂号支付
     * @param orderRequest
     * @return
     */
    @PostMapping("order")
    public BaseResponse<OrderVO> registerPay(@RequestBody OrderRequest orderRequest) {
        if (orderRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        OrderVO orderVO = orderService.registerPay(orderRequest);
        return ResultUtils.success(orderVO);
    }
}
