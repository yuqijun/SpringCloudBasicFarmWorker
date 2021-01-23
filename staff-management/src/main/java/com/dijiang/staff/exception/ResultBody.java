package com.dijiang.staff.exception;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/25 16:27
 */
@Slf4j
public class ResultBody {

    private String message ;

    private String code ;

    private Object data ;

    public static ResultBody success(){
        ResultBody rb = new ResultBody();
        rb.setCode(ExceptionInfoEnum.SUCCESS.getCode());
        rb.setMessage(ExceptionInfoEnum.SUCCESS.getMessage());
        return rb;
    }

    public static ResultBody success(Object obj){
        ResultBody rb = new ResultBody();
        rb.setCode(ExceptionInfoEnum.SUCCESS.getCode());
        rb.setMessage(ExceptionInfoEnum.SUCCESS.getMessage());
        rb.setData(obj);
        return rb;
    }


    public static ResultBody error(BaseExceptionInfo baseExceptionInfo){
        ResultBody rb = new ResultBody();
        rb.setCode(baseExceptionInfo.getCode());
        rb.setMessage(baseExceptionInfo.getMessage());
        return rb;
    }

    public static ResultBody error(String code  ,String message){
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        return rb;
    }

    public static ResultBody error(String  message){
        ResultBody rb = new ResultBody();
        rb.setCode(ExceptionInfoEnum.FAIL.getCode());
        rb.setMessage(message);
        log.info("赋值的  异常信息-----"+rb.toString());
        return rb;
    }

    public ResultBody (){}

    public ResultBody(BaseExceptionInfo baseExceptionInfo){
        this.code = baseExceptionInfo.getCode();
        this.message = baseExceptionInfo.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
