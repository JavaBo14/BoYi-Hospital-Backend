package com.boyi.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.model.entity.Register;
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

}




