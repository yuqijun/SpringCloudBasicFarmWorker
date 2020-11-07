package com.dijiang.common.util;

import java.io.Serializable;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/7 14:37
 */
public class DjTokenUtil  {

    public static String  createToken(String data){
        return  AESUtil.encrypt(data, AESUtil.ASSETS_DEV_PWD_FIELD);
    }

    public static String parseToken(String data){
        return AESUtil.decrypt(data, AESUtil.ASSETS_DEV_PWD_FIELD);
    }
}
