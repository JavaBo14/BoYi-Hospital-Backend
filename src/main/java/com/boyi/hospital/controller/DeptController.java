package com.boyi.hospital.controller;

import cn.hutool.core.util.StrUtil;
import com.boyi.hospital.common.BaseResponse;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.common.ResultUtils;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.dto.mobile.DeptQueryRequest;
import com.boyi.hospital.model.vo.CodeVo;
import com.boyi.hospital.model.vo.DeptListVo;
import com.boyi.hospital.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户接口
 *
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 */
@RestController
@RequestMapping("v1/dept")
@Slf4j
public class DeptController {

    @Resource
    private DeptService deptService;
    @PostMapping("list")
    public BaseResponse<List<DeptListVo>> listDeptVO(@RequestBody DeptQueryRequest deptQueryRequest) {
        if (deptQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<DeptListVo> deptListVo = deptService.listDeptVO(deptQueryRequest);
        return ResultUtils.success(deptListVo);
    }
}
