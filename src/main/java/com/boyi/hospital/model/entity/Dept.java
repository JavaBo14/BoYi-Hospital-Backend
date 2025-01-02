package com.boyi.hospital.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 科室表
 * @TableName t_dept_info
 */
@TableName(value ="t_dept_info")
@Data
public class Dept implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 医院编码
     */
    @TableField("hospital_no")  
    private String hospitalNo;

    /**
     * 科室编码
     */
    @TableField("dept_code")  
    private String deptCode;

    /**
     * 科室名称
     */
    @TableField("dept_name")  
    private String deptName;

    /**
     * 父级科室编码
     */
    @TableField("parent_dept_code")  
    private String parentDeptCode;

    /**
     * 科室图片
     */
    private String logo;

    /**
     * 科室简介
     */
    private String introduction;

    /**
     * 科室地址
     */
    private String address;

    /**
     * 状态 0-停用 1-启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("create_time")  
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")  
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}