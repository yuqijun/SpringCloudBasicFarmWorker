package com.dijiang.staff.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/25 18:06
 */
public class Proxy implements InvocationHandler {

    private Object pingpai;

    Proxy(Object pingpai){
        this.pingpai = pingpai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("开始销售柜台是："+this.getClass().getSimpleName());
        method.invoke(pingpai,args);
        System.out.println("销售结束");
        return null;
    }
}
