package com.dijiang.staff.model;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.servlet.http.HttpServletResponse;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/5 14:56
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultUtil {
    private HttpServletResponse resp;
    private Object data;
    private Integer code;
    private String msg;

    public static ResultUtil responseJson(HttpServletResponse resp ,Object data){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setResp(resp);
        resultUtil.setData(data);
        return resultUtil;
    }

    public static ResultUtil resultCode(Integer code,String msg){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(code);
        resultUtil.setMsg(msg);
        return resultUtil;
    }

    public static ResultUtil resultSuccess(Object data){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setData(data);
        return resultUtil;
    }
}
