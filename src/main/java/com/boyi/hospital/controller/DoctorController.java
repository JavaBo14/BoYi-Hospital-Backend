package com.boyi.hospital.controller;

import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.dto.doctor.DoctorQueryRequest;
import com.boyi.hospital.model.vo.dector.DoctorDetailVO;
import com.boyi.hospital.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 科室接口
 *
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 */
@RestController
@RequestMapping("v1/doctor")
@Slf4j
public class DoctorController {

     @Resource
     private DoctorService doctorService;

    /**
     * 医生详情查询
     * @param doctorQueryRequest
     * @return
     */
    @PostMapping("detail")
    public BaseResponse<DoctorDetailVO> doctorDetailQuery(@RequestBody DoctorQueryRequest doctorQueryRequest) {
        if (doctorQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        DoctorDetailVO doctorDetailVO = doctorService.doctorDetailQuery(doctorQueryRequest);
        return ResultUtils.success(doctorDetailVO);
    }
}
