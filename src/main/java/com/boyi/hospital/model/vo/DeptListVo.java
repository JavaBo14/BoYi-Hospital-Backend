package com.boyi.hospital.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.boyi.hospital.model.entity.Dept;
import lombok.Data;
import org.apache.poi.poifs.property.Child;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class DeptListVo implements Serializable {


    /**
     * 医院编码
     */
    private String hospitalNo;

    /**
     * 医院名称
     */
    private String hospitalName;

    /**
     * 科室编码
     */
    private String deptCode;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 父级科室编码
     */
    private String parentDeptCode;

    /**
     * 父级科室名称
     */
    private String parentDeptName;

    /**
     * 科室地址
     */
    private String address;

    /**
     *子科室列表
     */
    private List<ChildDeptListVo> childList;
}