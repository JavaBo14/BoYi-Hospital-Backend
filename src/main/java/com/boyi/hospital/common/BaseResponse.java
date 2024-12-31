package com.boyi.hospital.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 通用返回类
 *
 * @param <T>
 * @author <a href="https://github.com/JavaBo14">Bo</a>
 * 
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;
    private String message;
    private T data;


    public BaseResponse(int code, String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(int code, T data) {
        this(code,"",data);
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage(),null);
    }

}
