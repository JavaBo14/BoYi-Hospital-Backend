package com.boyi.hospital.mapper;

import com.boyi.hospital.model.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boyi.hospital.model.vo.schedule.DoctorScheduleVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
* @author Bo
* @description 针对表【t_doctor_info(医生表)】的数据库操作Mapper
* @createDate 2024-12-31 15:07:15
* @Entity generator.domain.Doctor
*/
public interface DoctorMapper extends BaseMapper<Doctor> {

    List<DoctorScheduleVO> getDoctorScheduleVO(@Param("hospitalNo") String hospitalNo, @Param("deptCode") String deptCode,@Param("scheDate") Date scheDate);
}




