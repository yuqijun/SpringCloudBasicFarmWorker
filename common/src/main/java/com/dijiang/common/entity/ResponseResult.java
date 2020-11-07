package com.dijiang.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseResult {
    private int code;
    private String desc;
    private Object data;

    public ResponseResult(String desc){
        this.desc = desc;
    }

    public ResponseResult(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
