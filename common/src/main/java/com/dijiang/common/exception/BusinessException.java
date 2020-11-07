package com.dijiang.common.exception;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/4 13:30
 */
public class BusinessException extends BasicException {

    private static final long serialVersionUID = 1L;

    public BusinessException(int code, String message) {
        super(code, message);
    }
}