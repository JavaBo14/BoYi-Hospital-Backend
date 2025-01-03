package com.boyi.hospital.controller;

import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.dto.schnum.SchNumQueryRequest;
import com.boyi.hospital.model.vo.schenum.DoctorScheNumListVO;
import com.boyi.hospital.service.ScheNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("v1/register/scheNum")
@Slf4j
public class ScheNumController {

    @Resource
    private ScheNumService scheNumService;

    /**
     * 医生号源列表查询接口
     * @param scheduleQueryRequest
     * @return
     */
    @PostMapping("list")
    public BaseResponse<DoctorScheNumListVO> doctorScheNumList(@RequestBody SchNumQueryRequest scheduleQueryRequest) {
        if (scheduleQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        DoctorScheNumListVO doctorScheNumListVO = scheNumService.doctorScheNumList(scheduleQueryRequest);
        return ResultUtils.success(doctorScheNumListVO);
    }
}
