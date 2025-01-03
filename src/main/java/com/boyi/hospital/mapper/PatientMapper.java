package com.boyi.hospital.mapper;

import com.boyi.hospital.model.entity.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boyi.hospital.model.vo.Patient.PatientDetailVO;
import org.apache.ibatis.annotations.Param;

/**
* @author Bo
* @description 针对表【t_patient_info(患者表)】的数据库操作Mapper
* @createDate 2024-12-31 15:08:51
* @Entity generator.domain.Patient
*/
public interface PatientMapper extends BaseMapper<Patient> {

    PatientDetailVO getPatientDetail(@Param("hospitalNo") String hospitalNo, @Param("patientId")String patientId);

}




