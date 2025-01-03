package com.boyi.hospital.service;

import com.boyi.hospital.model.dto.schnum.SchNumQueryRequest;
import com.boyi.hospital.model.entity.ScheNum;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boyi.hospital.model.vo.schenum.DoctorScheNumListVO;

/**
* @author Bo
* @description 针对表【t_sche_num_info(医生号源表)】的数据库操作Service
* @createDate 2024-12-31 15:10:57
*/
public interface ScheNumService extends IService<ScheNum> {

    /**
     * 医生号源列表查询
     * @param scheduleQueryRequest
     * @return
     */
    DoctorScheNumListVO doctorScheNumList(SchNumQueryRequest scheduleQueryRequest);

}
