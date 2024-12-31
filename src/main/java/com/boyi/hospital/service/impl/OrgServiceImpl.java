package com.boyi.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.model.entity.Org;
import com.boyi.hospital.service.OrgService;
import com.boyi.hospital.mapper.OrgMapper;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_org_info(机构表)】的数据库操作Service实现
* @createDate 2024-12-31 15:08:02
*/
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org>
    implements OrgService{

}




