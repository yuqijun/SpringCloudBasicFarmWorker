package com.dijiang.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class ResponseResult {
    private int code;
    private String message;
    private Object data;

    public ResponseResult(String desc){
        this.message = desc;
    }

    public ResponseResult(int code, String desc){
        this.code = code;
        this.message = desc;
    }

    public ResponseResult(int code ,String message,Object data){
        this.code = code;
        this.message =message ;
        this.data = data;
    }
}
