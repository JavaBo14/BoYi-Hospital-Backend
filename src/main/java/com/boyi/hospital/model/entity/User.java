package com.boyi.hospital.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")  // 显式映射
    private String userId;

    /**
     * 用户昵称
     */
    @TableField("user_nick")  // 显式映射
    private String userNick;

    /**
     * 用户手机号
     */
    private String account;

    /**
     * 机构编码
     */
    @TableField("hospital_no")  // 显式映射
    private String hospitalNo;

    /**
     * 状态 0-停用 1-禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("create_time")  // 显式映射
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")  // 显式映射
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}