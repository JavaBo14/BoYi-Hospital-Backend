package com.boyi.hospital.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.exception.ThrowUtils;
import com.boyi.hospital.model.dto.parent.PatientDetailQueryRequest;
import com.boyi.hospital.model.entity.Patient;
import com.boyi.hospital.model.vo.Patient.PatientDetailVO;
import com.boyi.hospital.service.PatientService;
import com.boyi.hospital.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Bo
* @description 针对表【t_patient_info(患者表)】的数据库操作Service实现
* @createDate 2024-12-31 15:08:51
*/
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient>
    implements PatientService{

    @Resource
    private PatientMapper patientMapper;

    /**
     * 就诊人详情查询接口
     * @param patientDetailQueryRequest
     * @return
     */
    @Override
    public PatientDetailVO patientDetail(PatientDetailQueryRequest patientDetailQueryRequest) {
        String patientId = patientDetailQueryRequest.getPatientId();
        String hospitalNo = patientDetailQueryRequest.getHospitalNo();
        ThrowUtils.throwIf(StrUtil.isBlank(hospitalNo), ErrorCode.PARAMS_ERROR, "医院编码不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(patientId), ErrorCode.PARAMS_ERROR, "患者号不能为空");
        PatientDetailVO patientDetailVO = patientMapper.getPatientDetail(hospitalNo, patientId);
        return patientDetailVO;
    }
}




