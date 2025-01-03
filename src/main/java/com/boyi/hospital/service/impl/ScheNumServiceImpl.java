package com.boyi.hospital.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.exception.ThrowUtils;
import com.boyi.hospital.mapper.DeptMapper;
import com.boyi.hospital.model.dto.schnum.SchNumQueryRequest;
import com.boyi.hospital.model.entity.ScheNum;
import com.boyi.hospital.model.vo.schenum.DoctorScheNumListVO;
import com.boyi.hospital.model.vo.schenum.DoctorScheNumVO;
import com.boyi.hospital.service.ScheNumService;
import com.boyi.hospital.mapper.ScheNumMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Bo
 * @description 针对表【t_sche_num_info(医生号源表)】的数据库操作Service实现
 * @createDate 2024-12-31 15:10:57
 */
@Service
public class ScheNumServiceImpl extends ServiceImpl<ScheNumMapper, ScheNum>
        implements ScheNumService {

    @Resource
    private ScheNumMapper scheNumMapper;

    @Resource
    private DeptMapper deptMapper;


    /**
     * 医生号源列表查询
     *
     * @param scheduleQueryRequest
     * @return
     */
    @Override
    public DoctorScheNumListVO doctorScheNumList(SchNumQueryRequest scheduleQueryRequest) {
        // 校验参数
        String hospitalNo = scheduleQueryRequest.getHospitalNo();
        String deptCode = scheduleQueryRequest.getDeptCode();
        String doctorCode = scheduleQueryRequest.getDoctorCode();
        String scheduleId = scheduleQueryRequest.getScheduleId();

        ThrowUtils.throwIf(StrUtil.isBlank(hospitalNo), ErrorCode.PARAMS_ERROR, "医院编码不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(deptCode), ErrorCode.PARAMS_ERROR, "科室编码不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(doctorCode), ErrorCode.PARAMS_ERROR, "医生编码不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(scheduleId), ErrorCode.PARAMS_ERROR, "排班ID不能为空");
        // 查询医生号源数据
        List<DoctorScheNumVO> DoctorScheNumListVO = scheNumMapper.getDoctorScheNumList(hospitalNo, deptCode, doctorCode, scheduleId);
        // 如果没有数据，返回空列表
        if (CollectionUtils.isEmpty(DoctorScheNumListVO)) {
            return new DoctorScheNumListVO();
        }
        // TODO: 2025/1/3
        // 获取科室名称（如果科室名称需要从科室表中查询）
        String deptName = deptMapper.getDeptNameByCode(deptCode);
        DoctorScheNumListVO.forEach(doctorScheNumVO -> {
            // 获取排班日期
            Date scheDate = doctorScheNumVO.getScheDate();
            // 设置科室名称
            doctorScheNumVO.setDeptName(deptName);
            // 处理字段：午别、星期几、日期提示
            if (scheDate != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                try {
                    Date noon = sdf.parse("12:00:00");
                    // TODO: 2025/1/3  
//                    String formattedDate = sdf.format(scheDate);
//                    // 将格式化后的字符串再转换回Date类型
//                    Date parsedDate = sdf.parse(formattedDate);
//                    doctorScheNumVO.setScheDate(parsedDate);
                    Date startTime = doctorScheNumVO.getStartTime();
                    Date endTime = doctorScheNumVO.getEndTime();
                    if (startTime.compareTo(noon) <= 0 && endTime.compareTo(noon) <= 0) {
                        doctorScheNumVO.setApm("上午");
                    } else if (startTime.compareTo(noon) > 0) {
                        doctorScheNumVO.setApm("下午");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 计算星期几
            LocalDate localDate = scheDate.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDate();
            String weekInChinese = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CHINESE);
            doctorScheNumVO.setWeek(weekInChinese);
            // 计算日期提示
            doctorScheNumVO.setScheDateTips(calculateScheDateTips(scheDate));
        });
        // 构建返回结果
        DoctorScheNumListVO doctorScheNumListVO = new DoctorScheNumListVO();
        doctorScheNumListVO.setDeptCode(deptCode);
        doctorScheNumListVO.setDeptName(deptName);
        doctorScheNumListVO.setScheNums(DoctorScheNumListVO);
        return doctorScheNumListVO;
    }

    // 计算日期提示（如 "1天后", "今天", "3天前"）
    private String calculateScheDateTips(Date scheDate) {
        LocalDate today = LocalDate.now();
        LocalDate scheduleDate = scheDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(today, scheduleDate);
        if (daysBetween == 0) {
            return "今天";
        } else if (daysBetween == 1) {
            return "明天";
        } else if (daysBetween > 1) {
            return daysBetween + "天后";
        } else {
            return Math.abs(daysBetween) + "天前";
        }
    }
}




