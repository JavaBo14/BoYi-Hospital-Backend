package com.boyi.hospital.service;

import com.boyi.hospital.model.dto.parent.PatientDetailQueryRequest;
import com.boyi.hospital.model.entity.Patient;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boyi.hospital.model.vo.Patient.PatientDetailVO;

/**
* @author Bo
* @description 针对表【t_patient_info(患者表)】的数据库操作Service
* @createDate 2024-12-31 15:08:51
*/
public interface PatientService extends IService<Patient> {


    /**
     * 就诊人详情查询接口
     * @param patientDetailQueryRequest
     * @return
     */
    PatientDetailVO patientDetail(PatientDetailQueryRequest patientDetailQueryRequest);

}
