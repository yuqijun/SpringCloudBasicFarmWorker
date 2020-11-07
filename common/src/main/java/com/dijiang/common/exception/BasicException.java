package com.dijiang.common.exception;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/4 13:29
 */
public class BasicException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code = 0;

    public BasicException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
