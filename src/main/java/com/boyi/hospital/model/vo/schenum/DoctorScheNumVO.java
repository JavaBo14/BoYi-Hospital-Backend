package com.boyi.hospital.model.vo.schenum;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class DoctorScheNumVO  implements Serializable {

    /**
     * 医院编码
     */
    private String hospitalNo;

    /**
     * 科室编码
     */
    private String deptCode;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 医生编码
     */
    private String doctorCode;

    /**
     * 挂号费
     */
    private BigDecimal registerFee;

    /**
     * 排班日期
     */
    private Date scheDate;

    /**
     * 午别
     */
    private String apm;

    /**
     * 开始时间
     */
    @JsonIgnore
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonIgnore
    private Date endTime;

    /**
     * 周
     */
    private String week;


    /**
     * 余号数
     */
    private Integer surplus;

    /**
     * 日期提示
     */
    private String scheDateTips;

    /**
     * 排班ID
     */
    private String scheduleId;

    /**
     * 号源ID
     */
    private String scheNumId;

}
