package com.dijiang.staff.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/25 16:42
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public  ResultBody businessException(HttpServletRequest req, BusinessException e){
        log.info("发生业务异常！原因是：{}",e.getMessage());
        return ResultBody.error(e.getMessage());
    }
}
