package com.boyi.hospital.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boyi.hospital.model.dto.mobile.MobileRequest;
import com.boyi.hospital.model.entity.User;
import com.boyi.hospital.model.vo.user.CodeLoginVo;
import com.boyi.hospital.model.vo.user.CodeVo;
import org.springframework.web.bind.annotation.RequestBody;

/**
* @author Bo
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2024-12-30 11:44:27
*/
public interface UserService extends IService<User> {

    /**
     * 获取手机验证码
     * @param mobileRequest
     * @return
     */
    CodeVo getPhoneCode( MobileRequest mobileRequest);

    /**
     * 用户登录
     * @param mobileRequest
     * @return
     */
    CodeLoginVo phoneCodeLogin(MobileRequest mobileRequest);

}
