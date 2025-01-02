package com.boyi.hospital.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 患者表
 * @TableName t_patient_info
 */
@TableName(value ="t_patient_info")
@Data
public class Patient implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 患者ID
     */
    @TableField("patient_id")
    private String patientId;

    /**
     * 患者姓名
     */
    @TableField("patient_name")
    private String patientName;

    /**
     * 身份证
     */
    @TableField("cert_no")
    private String certNo;

    /**
     * 患者号
     */
    @TableField("patient_no")
    private String patientNo;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别，M-男 F-女
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 状态 0-停用 1-禁用
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