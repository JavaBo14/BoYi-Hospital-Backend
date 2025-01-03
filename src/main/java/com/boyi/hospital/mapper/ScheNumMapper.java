package com.boyi.hospital.mapper;

import com.boyi.hospital.model.entity.ScheNum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boyi.hospital.model.vo.schenum.DoctorScheNumVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Bo
* @description 针对表【t_sche_num_info(医生号源表)】的数据库操作Mapper
* @createDate 2024-12-31 15:10:57
* @Entity generator.domain.ScheNum
*/
public interface ScheNumMapper extends BaseMapper<ScheNum> {

    // 自定义查询医生号源列表
    List<DoctorScheNumVO> getDoctorScheNumList(@Param("hospitalNo") String hospitalNo,
                                               @Param("deptCode") String deptCode,
                                               @Param("doctorCode") String doctorCode,
                                               @Param("scheduleId") String scheduleId);

}




