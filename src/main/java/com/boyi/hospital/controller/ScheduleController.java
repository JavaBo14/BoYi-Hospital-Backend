package com.boyi.hospital.controller;

import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.dto.dept.DeptQueryRequest;
import com.boyi.hospital.model.dto.schdule.ScheduleQueryRequest;
import com.boyi.hospital.model.vo.dept.DeptListVO;
import com.boyi.hospital.model.vo.schedule.DoctorScheduleListVO;
import com.boyi.hospital.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 科室接口
 *
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 */
@RestController
@RequestMapping("v1/register/schedule")
@Slf4j
public class ScheduleController {

    @Resource
    private ScheduleService scheduleService;

    /**
     * 医生排班列表查询接口
     * @param scheduleQueryRequest
     * @return
     */
    @PostMapping("list")
    public BaseResponse<DoctorScheduleListVO> listDoctorSchedule(@RequestBody ScheduleQueryRequest scheduleQueryRequest) {
        if (scheduleQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        DoctorScheduleListVO doctorScheduleListVO = scheduleService.listDoctorSchedule(scheduleQueryRequest);
        return ResultUtils.success(doctorScheduleListVO);
    }
}
