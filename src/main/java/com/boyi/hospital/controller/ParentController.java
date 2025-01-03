package com.boyi.hospital.controller;

import cn.hutool.core.util.StrUtil;
import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.mapper.RegisterMapper;
import com.boyi.hospital.model.dto.parent.ParentQueryRequest;
import com.boyi.hospital.model.vo.PatientVO;
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
@RequestMapping("v1/patient/simple")
@Slf4j
public class ParentController {

    @Resource
    private RegisterMapper registerMapper;

    /**
     * 就诊人基本信息列表查询接口
     * @param parentQueryRequest
     * @return
     */
    @PostMapping("list")
    public BaseResponse<List<PatientVO>> listDoctorSchedule(@RequestBody ParentQueryRequest parentQueryRequest) {
        String hospitalNo = parentQueryRequest.getHospitalNo();
        if (parentQueryRequest == null || StrUtil.isBlank(hospitalNo)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<PatientVO> parentListVO = registerMapper.selectPatientByHospitalNo(hospitalNo);
        return ResultUtils.success(parentListVO);
    }
}
