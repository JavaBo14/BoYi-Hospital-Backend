package com.boyi.hospital.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.constant.AvatarImgConstant;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.exception.ThrowUtils;
import com.boyi.hospital.mapper.DeptMapper;
import com.boyi.hospital.mapper.DoctorMapper;
import com.boyi.hospital.model.dto.schdule.ScheduleQueryRequest;
import com.boyi.hospital.model.dto.schnum.SchNumQueryRequest;
import com.boyi.hospital.model.entity.Doctor;
import com.boyi.hospital.model.entity.Schedule;
import com.boyi.hospital.model.vo.schedule.DoctorScheduleListVO;
import com.boyi.hospital.model.vo.schedule.DoctorScheduleVO;
import com.boyi.hospital.model.vo.schenum.DoctorScheNumListVO;
import com.boyi.hospital.service.ScheduleService;
import com.boyi.hospital.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
* @author Bo
* @description 针对表【t_schedule_info(医生排班表)】的数据库操作Service实现
* @createDate 2024-12-31 15:12:01
*/
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule>
    implements ScheduleService {
    @Resource private DeptMapper deptMapper;
    @Resource private DoctorMapper doctorMapper;

    /**
     * 医生排班列表查询
     * @param scheduleQueryRequest
     * @return
     */
    @Override
    public DoctorScheduleListVO listDoctorSchedule(ScheduleQueryRequest scheduleQueryRequest) {
        String hospitalNo = scheduleQueryRequest.getHospitalNo();
        String deptCode = scheduleQueryRequest.getDeptCode();
        Date scheDate = scheduleQueryRequest.getScheDate();
        // 参数校验
        ThrowUtils.throwIf(StrUtil.isBlank(hospitalNo), ErrorCode.PARAMS_ERROR, "医院编码不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(deptCode), ErrorCode.PARAMS_ERROR, "科室编码不能为空");
        // 将传递的 scheDate 转换为当天的零时（00:00:00）
        Date scheDateStart = DateUtil.beginOfDay(scheDate);
        // TODO: 2025/1/2  
        // 查询科室名称
        String deptName = deptMapper.getDeptNameByCode(deptCode);
        // TODO: 2025/1/2  
        // 查询医生排班信息
        List<DoctorScheduleVO> doctorScheduleVOList = doctorMapper.getDoctorScheduleVO(hospitalNo, deptCode, scheDateStart);
        // 如果没有数据，返回空列表
        if (CollectionUtils.isEmpty(doctorScheduleVOList)) {
            return new DoctorScheduleListVO();
        }
        doctorScheduleVOList.forEach(doctorScheduleVO -> doctorScheduleVO.setDeptName(deptName));
        doctorScheduleVOList.forEach(doctorScheduleVO -> doctorScheduleVO.setAvatarImg(AvatarImgConstant.AvatarImg));
        // 构建 DoctorScheduleListVO 对象
        DoctorScheduleListVO doctorScheduleListVO = new DoctorScheduleListVO();
        doctorScheduleListVO.setDeptCode(deptCode);
        doctorScheduleListVO.setDeptName(deptName);
        doctorScheduleListVO.setDoctors(doctorScheduleVOList); // 设置医生排班信息
        return doctorScheduleListVO;
    }
}




