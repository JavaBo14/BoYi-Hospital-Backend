package com.boyi.hospital.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.mapper.DeptMapper;
import com.boyi.hospital.mapper.OrgMapper;
import com.boyi.hospital.model.dto.dept.DeptQueryRequest;
import com.boyi.hospital.model.entity.Dept;
import com.boyi.hospital.model.vo.dept.ChildDeptListVO;
import com.boyi.hospital.model.vo.dept.DeptListVO;
import com.boyi.hospital.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Bo
 * @description 针对表【t_dept_info(科室表)】的数据库操作Service实现
 * @createDate 2024-12-31 15:06:27
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
        implements DeptService {

    @Resource
    private OrgMapper orgMapper;

    /**
     * 科室列表查询
     * @param deptQueryRequest
     * @return
     */
    @Override
    public List<DeptListVO> listDeptVO(DeptQueryRequest deptQueryRequest) {
        String hospitalNo = deptQueryRequest.getHospitalNo();
        if (StrUtil.isBlank(hospitalNo)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        // 查询科室信息
        List<Dept> listDept = this.list(new QueryWrapper<Dept>().eq("hospital_no", hospitalNo));
        if (CollectionUtils.isEmpty(listDept)) {
            return Collections.emptyList(); // 如果没有科室，直接返回空列表
        }
        // TODO: 2025/1/2  
        // 获取医院名称
        String hospitalName = orgMapper.getHospitalNameByNo(hospitalNo);
        // 构建科室与子科室的映射关系
        Map<String, List<Dept>> deptTreeMap = listDept.stream()
                .collect(Collectors.groupingBy(dept -> StrUtil.isBlank(dept.getParentDeptCode()) ? "ROOT" : dept.getParentDeptCode()));
        // 构建父科室名称映射表
        Map<String, String> parentDeptNameMap = listDept.stream()
                .filter(dept -> StrUtil.isNotBlank(dept.getDeptCode()))
                .collect(Collectors.toMap(
                        Dept::getDeptCode,
                        Dept::getDeptName,
                        (existing, replacement) -> existing // 处理重复键，保留第一个值
                ));
        // 获取所有科室及其子科室
        return listDept.stream()
                .filter(dept -> dept.getParentDeptCode() == null || dept.getParentDeptCode().equals("ROOT"))
                .map(dept -> buildDeptListVo(dept, hospitalName, parentDeptNameMap, deptTreeMap))
                .collect(Collectors.toList());
    }
    private DeptListVO buildDeptListVo(Dept dept, String hospitalName,
                                       Map<String, String> parentDeptNameMap,
                                       Map<String, List<Dept>> deptTreeMap) {
        DeptListVO deptListVo = new DeptListVO();
        deptListVo.setHospitalNo(dept.getHospitalNo());
        deptListVo.setHospitalName(hospitalName);
        deptListVo.setDeptCode(dept.getDeptCode());
        deptListVo.setDeptName(dept.getDeptName());
        deptListVo.setParentDeptCode(dept.getParentDeptCode());
        deptListVo.setParentDeptName(parentDeptNameMap.getOrDefault(dept.getParentDeptCode(), ""));
        deptListVo.setAddress(dept.getAddress());
        // 获取子科室
        List<Dept> childDepts = deptTreeMap.getOrDefault(dept.getDeptCode(), Collections.emptyList());
        deptListVo.setChildren(childDepts.stream()
                .map(childDept -> buildChildDeptListVo(childDept, hospitalName, parentDeptNameMap))
                .collect(Collectors.toList()));
        return deptListVo;
    }
    private ChildDeptListVO buildChildDeptListVo(Dept childDept, String hospitalName,
                                                 Map<String, String> parentDeptNameMap) {
        ChildDeptListVO childDeptListVo = new ChildDeptListVO();
        childDeptListVo.setHospitalNo(childDept.getHospitalNo());
        childDeptListVo.setHospitalName(hospitalName);
        childDeptListVo.setDeptCode(childDept.getDeptCode());
        childDeptListVo.setDeptName(childDept.getDeptName());
        childDeptListVo.setParentDeptCode(childDept.getParentDeptCode());
        childDeptListVo.setParentDeptName(parentDeptNameMap.getOrDefault(childDept.getParentDeptCode(), ""));
        childDeptListVo.setAddress(childDept.getAddress());
        return childDeptListVo;
    }

}




