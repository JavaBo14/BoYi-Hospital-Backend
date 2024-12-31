package com.boyi.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.model.entity.Doctor;
import com.boyi.hospital.service.DoctorService;
import com.boyi.hospital.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_doctor_info(医生表)】的数据库操作Service实现
* @createDate 2024-12-31 15:07:15
*/
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
    implements DoctorService{

}




