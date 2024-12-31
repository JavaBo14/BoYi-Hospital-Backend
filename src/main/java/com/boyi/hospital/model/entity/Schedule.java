package com.boyi.hospital.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 医生排班表
 * @TableName t_schedule_info
 */
@TableName(value ="t_schedule_info")
@Data
public class Schedule implements Serializable {
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
     * 科室编码
     */
    private String deptCode;

    /**
     * 医生编码
     */
    private String doctorCode;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 排班日期
     */
    private Date scheDate;

    /**
     * 排班ID
     */
    private String scheduleId;

    /**
     * 挂号费
     */
    private BigDecimal registerFee;

    /**
     * 余号数
     */
    private Integer surplus;

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