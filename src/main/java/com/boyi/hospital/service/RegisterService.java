package com.boyi.hospital.service;

import com.boyi.hospital.model.dto.register.RegisterRequest;
import com.boyi.hospital.model.entity.Register;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boyi.hospital.model.vo.register.RegisterVo;

/**
* @author Bo
* @description 针对表【t_register(预约记录表)】的数据库操作Service
* @createDate 2024-12-31 15:05:14
*/
public interface RegisterService extends IService<Register> {

    /**
     * 挂号预约
     * @param registerRequest
     * @return
     */
    RegisterVo registerBooking(RegisterRequest registerRequest);
}
