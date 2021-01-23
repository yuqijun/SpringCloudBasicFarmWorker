package com.dijiang.staff.exception;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/25 11:18
 */
public enum ExceptionInfoEnum implements BaseExceptionInfo {
    SUCCESS("请求成功","200"),
    FAIL("请求异常","-1")

    ;


    private String message ;
    private String code ;

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    ExceptionInfoEnum(String message , String code){
        this.message = message ;
        this.code = code ;
    }
}
