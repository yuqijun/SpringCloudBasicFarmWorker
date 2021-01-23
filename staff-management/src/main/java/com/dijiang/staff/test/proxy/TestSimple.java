package com.dijiang.staff.test.proxy;

import org.springframework.security.core.parameters.P;

import java.lang.reflect.InvocationHandler;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/25 18:10
 */
public class TestSimple {
    public static void main(String [] args){
        MaoTaiJiu maoTaiJiu = new MaoTaiJiu();
        InvocationHandler  proxy =new   Proxy(maoTaiJiu);

    }
}
