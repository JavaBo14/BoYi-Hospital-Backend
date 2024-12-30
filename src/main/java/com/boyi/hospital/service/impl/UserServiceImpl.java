package com.boyi.hospital.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyi.hospital.mapper.UserMapper;
import com.boyi.hospital.model.entity.User;
import com.boyi.hospital.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author Bo
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2024-12-30 11:44:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




