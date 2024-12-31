package com.boyi.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.model.entity.Patient;
import com.boyi.hospital.service.PatientService;
import com.boyi.hospital.mapper.PatientMapper;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_patient_info(患者表)】的数据库操作Service实现
* @createDate 2024-12-31 15:08:51
*/
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient>
    implements PatientService{

}




