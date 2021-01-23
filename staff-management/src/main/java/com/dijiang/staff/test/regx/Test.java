package com.dijiang.staff.test.regx;

import cn.hutool.core.util.ReUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String [] args){
        String pattern = "select user_name , user_password from (select bankcard_no , bankcard_password from tb_account ) t1";
        String [] str = pattern.split("from");
        for(int i = 0 ;i<str.length;i++){
            log.info(i+"："+str[i]);
        }
    }

    private static void find(String pattern,String matchedStr){
        log.info(" 正则表达式 【 {} 】； 被匹配的字符串 【 {} 】" ,pattern,matchedStr);
        log.info("findAll"+ReUtil.findAll(pattern,matchedStr,0));
        log.info("count"+ ReUtil.count(pattern,matchedStr));
        log.info("contains"+ReUtil.contains(pattern,matchedStr));
        //log.debug(length("contains"), ReUtil.get);
    }
}
