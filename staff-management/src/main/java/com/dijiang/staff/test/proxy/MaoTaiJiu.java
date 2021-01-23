package com.dijiang.staff.test.proxy;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/25 18:05
 */
public class MaoTaiJiu implements SellWine{

    @Override
    public void maijiu() {
        System.out.println("我是茅台酒.....");
    }
}
