package com.dijiang.common.util;

import java.text.DecimalFormat;

public class MathUtil {
    public static String txfloat(int a,int b) {
        // TODO 自动生成的方法存根

        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数

        return df.format((float)a/b);

    }
}
