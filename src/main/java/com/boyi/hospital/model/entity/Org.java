package com.boyi.hospital.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 机构表
 * @TableName t_org_info
 */
@TableName(value ="t_org_info")
@Data
public class Org implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 医院编码
     */
    private String hospitalNo;

    /**
     * 医院名称
     */
    private String hospitalName;

    /**
     * 医院简介
     */
    private String introduction;

    /**
     * 医院地址
     */
    private String address;

    /**
     * 医院logo
     */
    private String logo;

    /**
     * 状态 0-停用 1-启用
     */
    private Integer status;

    /**
     * 小程序APPID
     */
    private String appId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}