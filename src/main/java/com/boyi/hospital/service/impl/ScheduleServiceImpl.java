package com.boyi.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.model.entity.Schedule;
import com.boyi.hospital.service.ScheduleService;
import com.boyi.hospital.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_schedule_info(医生排班表)】的数据库操作Service实现
* @createDate 2024-12-31 15:12:01
*/
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
    implements ScheduleService{

}




