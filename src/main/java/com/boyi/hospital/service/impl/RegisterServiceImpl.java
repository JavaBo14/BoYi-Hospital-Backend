package com.boyi.hospital.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.exception.ThrowUtils;
import com.boyi.hospital.model.dto.register.RegisterRequest;
import com.boyi.hospital.model.entity.Register;
import com.boyi.hospital.model.vo.register.RegisterVo;
import com.boyi.hospital.service.RegisterService;
import com.boyi.hospital.mapper.RegisterMapper;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_register(预约记录表)】的数据库操作Service实现
* @createDate 2024-12-31 15:05:14
*/
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register>
    implements RegisterService{


    /**
     * 挂号预约
     * @param registerRequest
     * @return
     */
    @Override
    public RegisterVo registerBooking(RegisterRequest registerRequest) {
        String patientNo = registerRequest.getPatientNo();
        String hospitalNo = registerRequest.getHospitalNo();
        String scheNumId = registerRequest.getScheNumId();
        String payType = registerRequest.getPayType();
        ThrowUtils.throwIf(StrUtil.isBlank(patientNo), ErrorCode.PARAMS_ERROR, "患者不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(hospitalNo), ErrorCode.PARAMS_ERROR, "医院编码不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(scheNumId), ErrorCode.PARAMS_ERROR, "号源ID不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(payType), ErrorCode.PARAMS_ERROR, "支付方式不能为空");
        // 2. 校验支付方式
        if (!"WX".equals(payType) && !"INSUR".equals(payType)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"无效的支付方式");
        }
        // 3. 模拟生成挂号ID和支付订单号
        String registerId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        String orderId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        // 4. 创建预约记录
        RegisterVo registerVo = new RegisterVo();
        registerVo.setRegisterId(registerId);
        registerVo.setOrderId(orderId);
        registerVo.setRegisterStatus("WAIT_PAY");  // 挂号状态
        registerVo.setOrderStatus("WAIT_PAY");    // 支付状态
        // 5. 返回成功响应
        return registerVo;
    }
}




