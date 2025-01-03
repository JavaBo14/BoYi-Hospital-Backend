package com.boyi.hospital.service;

import com.boyi.hospital.model.dto.schdule.ScheduleQueryRequest;
import com.boyi.hospital.model.dto.schnum.SchNumQueryRequest;
import com.boyi.hospital.model.entity.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boyi.hospital.model.vo.schedule.DoctorScheduleListVO;
import com.boyi.hospital.model.vo.schenum.DoctorScheNumListVO;

import java.util.List;

/**
* @author Bo
* @description 针对表【t_schedule_info(医生排班表)】的数据库操作Service
* @createDate 2024-12-31 15:12:01
*/
public interface ScheduleService extends IService<Schedule> {

    /**
     * 医生排班列表查询
     * @param scheduleQueryRequest
     * @return
     */
    DoctorScheduleListVO listDoctorSchedule(ScheduleQueryRequest scheduleQueryRequest);

}
