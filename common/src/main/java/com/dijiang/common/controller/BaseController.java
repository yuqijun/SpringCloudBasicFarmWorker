package com.dijiang.common.controller;

import com.dijiang.common.entity.ResponseResult;

public class BaseController {

    public ResponseResult SuccessResult(){
        return new ResponseResult(10000001,"请求成功");
    }

    public ResponseResult SuccessResult(String desc){
        return new ResponseResult(10000001,desc);
    }

    public  ResponseResult SuccessResult(Object data){
        return new ResponseResult(10000001,"请求成功",data);
    }

    public ResponseResult FailResult(){
        return new ResponseResult(40000001,"请求失败");
    }

    public ResponseResult FailResult(String desc){
        return new ResponseResult(40000001,desc);
    }
}
