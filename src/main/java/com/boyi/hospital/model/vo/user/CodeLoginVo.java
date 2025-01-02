package com.boyi.hospital.model.vo.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class CodeLoginVo implements Serializable {
    /**
     * 访问凭证
     */
    private String accessToken;
    /**
     * 医院代码
     */
    private String hospitalNo;
    /**
     * 医院名称
     */
    private String hospitalName;
    /**
     * 头像
     */
    private String avatarImg;
    /**
     * 昵称
     */
    private String nickName;

}
