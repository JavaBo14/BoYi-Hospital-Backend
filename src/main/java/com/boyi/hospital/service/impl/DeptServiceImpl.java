package com.boyi.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.model.entity.Dept;
import com.boyi.hospital.service.DeptService;
import com.boyi.hospital.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_dept_info(科室表)】的数据库操作Service实现
* @createDate 2024-12-31 15:06:27
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




