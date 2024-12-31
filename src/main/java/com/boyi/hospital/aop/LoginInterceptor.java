package com.boyi.hospital.aop;

import com.boyi.hospital.common.ErrorCode;
import com.boyi.hospital.exception.BusinessException;
import com.boyi.hospital.model.entity.User;
import com.boyi.hospital.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public static ThreadLocal<User> threadLocal = new ThreadLocal<>();
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String successToken = request.getHeader("token");
        if (successToken == null) {
            successToken = request.getParameter("token");
        }
        if (StringUtils.isNoneBlank(successToken)) {
            Claims claims = JWTUtil.checkJWT(successToken);
            if (claims == null) {
                throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR, "用户未登录");
            }
            String userId = (String) claims.get("user_id");
            String userAccount = (String) claims.get("user_account");
            String userNick = (String) claims.get("user_nick");
            User user = new User();
            user.setUserId(userId);
            user.setAccount(userAccount);
            user.setUserNick(userNick);
            threadLocal.set(user);
            return true;
        }
        return false;
    }
}