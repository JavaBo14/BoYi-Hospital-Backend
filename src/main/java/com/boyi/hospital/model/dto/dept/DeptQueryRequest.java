package com.boyi.hospital.model.dto.dept;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeptQueryRequest implements Serializable {

    /**
     * 医院编码
     */
    private String hospitalNo;
}