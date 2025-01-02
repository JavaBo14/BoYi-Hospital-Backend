package com.boyi.hospital.service;

import com.boyi.hospital.model.dto.doctor.DoctorQueryRequest;
import com.boyi.hospital.model.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boyi.hospital.model.vo.dector.DoctorDetailVO;

/**
* @author Bo
* @description 针对表【t_doctor_info(医生表)】的数据库操作Service
* @createDate 2024-12-31 15:07:15
*/
public interface DoctorService extends IService<Doctor> {
    /**
     * 医生详情查询
     * @param doctorQueryRequest
     * @return
     */
    DoctorDetailVO doctorDetailQuery(DoctorQueryRequest doctorQueryRequest);

}
