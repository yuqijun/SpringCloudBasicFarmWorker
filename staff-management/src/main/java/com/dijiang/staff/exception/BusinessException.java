package com.dijiang.staff.exception;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/25 11:24
 */
public class BusinessException extends  RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message ;

    private String code ;

    public BusinessException(){
        super();
    }

    public BusinessException(BaseExceptionInfo baseExceptionInfo ){
        super(baseExceptionInfo.getCode());
        this.code = baseExceptionInfo.getCode();
        this.message = baseExceptionInfo.getMessage();
    }

    public BusinessException(BaseExceptionInfo baseExceptionInfo , Throwable throwable){
        super(baseExceptionInfo.getCode(),throwable);
        this.code = baseExceptionInfo.getCode();
        this.message = baseExceptionInfo.getMessage();
    }

    public BusinessException(String message ){
        super(message);
        this.message = message ;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
