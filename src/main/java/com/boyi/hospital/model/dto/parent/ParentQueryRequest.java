package com.boyi.hospital.model.dto.parent;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParentQueryRequest implements Serializable {
    /**
     * 医院编码
     */
    private String hospitalNo;

}