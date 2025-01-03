package com.boyi.hospital.controller;

import cn.hutool.core.util.StrUtil;
import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.mapper.RegisterMapper;
import com.boyi.hospital.model.dto.parent.PatientDetailQueryRequest;
import com.boyi.hospital.model.dto.parent.PatientInformationQueryRequest;
import com.boyi.hospital.model.vo.Patient.PatientDetailVO;
import com.boyi.hospital.model.vo.Patient.PatientInformationVO;
import com.boyi.hospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 患者接口
 *
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 */
@RestController
@RequestMapping("v1/patient")
@Slf4j
public class ParentController {

    @Resource
    private RegisterMapper registerMapper;

    @Resource
    private PatientService patientService;

    /**
     * 就诊人基本信息列表查询接口
     * @param patientInformationQueryRequest
     * @return
     */
    @PostMapping("/simple/list")
    public BaseResponse<List<PatientInformationVO>> patientInformation(@RequestBody PatientInformationQueryRequest patientInformationQueryRequest) {
        String hospitalNo = patientInformationQueryRequest.getHospitalNo();
        if (patientInformationQueryRequest == null || StrUtil.isBlank(hospitalNo)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<PatientInformationVO> parentListVO = registerMapper.patientInformation(hospitalNo);
        return ResultUtils.success(parentListVO);
    }

    /**
     * 就诊人详情查询接口
     * @param patientDetailQueryRequest
     * @return
     */
    @PostMapping("detail")
    public BaseResponse<PatientDetailVO> patientDetail(@RequestBody PatientDetailQueryRequest patientDetailQueryRequest) {
        if (patientDetailQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        PatientDetailVO patientDetailVO = patientService.patientDetail(patientDetailQueryRequest);
        return ResultUtils.success(patientDetailVO);
    }
}
