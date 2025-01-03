package com.boyi.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boyi.hospital.model.entity.Register;
import com.boyi.hospital.model.vo.PatientVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author Bo
* @description 针对表【t_register(预约记录表)】的数据库操作Mapper
* @createDate 2024-12-31 15:05:14
* @Entity generator.domain.Register
*/
public interface RegisterMapper extends BaseMapper<Register> {

    // 通过医院编码查询患者信息
    @Select("SELECT patient_id, patient_name, patient_no FROM t_register WHERE hospital_no = #{hospitalNo}")
    List<PatientVO> selectPatientByHospitalNo(@Param("hospitalNo") String hospitalNo);

}




