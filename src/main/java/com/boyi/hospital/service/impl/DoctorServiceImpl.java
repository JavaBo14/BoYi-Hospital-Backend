package com.boyi.hospital.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.constant.AvatarImgConstant;
import com.boyi.hospital.exception.ThrowUtils;
import com.boyi.hospital.mapper.DeptMapper;
import com.boyi.hospital.mapper.OrgMapper;
import com.boyi.hospital.model.dto.doctor.DoctorQueryRequest;
import com.boyi.hospital.model.entity.Doctor;
import com.boyi.hospital.model.vo.dector.DoctorDetailQuery;
import com.boyi.hospital.model.vo.dector.DoctorDetailVO;
import com.boyi.hospital.service.DoctorService;
import com.boyi.hospital.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author Bo
* @description 针对表【t_doctor_info(医生表)】的数据库操作Service实现
* @createDate 2024-12-31 15:07:15
*/
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
    implements DoctorService{
    @Resource
    private OrgMapper orgMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private DoctorMapper doctorMapper;

    /**
     * 医生详情查询
     * @param doctorQueryRequest
     * @return
     */
    @Override
    public DoctorDetailVO doctorDetailQuery(DoctorQueryRequest doctorQueryRequest) {
        String hospitalNo = doctorQueryRequest.getHospitalNo();
        String deptCode = doctorQueryRequest.getDeptCode();
        String doctorCode = doctorQueryRequest.getDoctorCode();
        // 参数校验
        ThrowUtils.throwIf(StrUtil.isBlank(hospitalNo), ErrorCode.PARAMS_ERROR, "医院编码不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(deptCode), ErrorCode.PARAMS_ERROR, "科室编码不能为空");
        ThrowUtils.throwIf(StrUtil.isBlank(doctorCode), ErrorCode.PARAMS_ERROR, "医生编码不能为空");
        // TODO: 2025/1/2  
        String hospitalName = orgMapper.getHospitalNameByNo(hospitalNo);
        String deptName = deptMapper.getDeptNameByCode(deptCode);
        DoctorDetailQuery doctorDetailQuery = doctorMapper.getDoctorDetail(hospitalNo, deptCode, doctorCode);
        DoctorDetailVO doctorDetailVO=new DoctorDetailVO();
        BeanUtil.copyProperties(doctorDetailQuery,doctorDetailVO);
        doctorDetailVO.setAvatarImg(AvatarImgConstant.AvatarImg);
        doctorDetailVO.setHospitalName(hospitalName);
        doctorDetailVO.setDeptName(deptName);
        return doctorDetailVO;
    }
}




