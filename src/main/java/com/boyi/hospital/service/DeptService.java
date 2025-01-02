package com.boyi.hospital.service;

import com.boyi.hospital.model.dto.dept.DeptQueryRequest;
import com.boyi.hospital.model.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boyi.hospital.model.vo.dept.DeptListVO;

import java.util.List;

/**
* @author Bo
* @description 针对表【t_dept_info(科室表)】的数据库操作Service
* @createDate 2024-12-31 15:06:27
*/
public interface DeptService extends IService<Dept> {

    /**
     * 科室列表查询
     * @param deptQueryRequest
     * @return
     */
    List<DeptListVO> listDeptVO(DeptQueryRequest deptQueryRequest);

}
