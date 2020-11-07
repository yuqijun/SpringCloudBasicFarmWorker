package com.dijiang.staff.controller;

import com.alibaba.fastjson.JSON;
import com.dijiang.common.controller.BaseController;
import com.dijiang.common.entity.ResponseResult;
import com.dijiang.common.exception.BusinessException;
import com.dijiang.common.service.FastDFSFileOperator;

import com.dijiang.common.util.DjTokenUtil;
import com.dijiang.common.util.JsonUtil;
import com.dijiang.staff.component.CustomUserDetailsService;
//import com.dijiang.staff.component.JWTTokenUtils;
import com.dijiang.staff.interfacer.GetCommon;
import com.dijiang.staff.model.RequestToken;
import com.dijiang.staff.model.ResultUtil;
//import com.dijiang.staff.model.SelfUserEntity;
import com.dijiang.staff.mybatisplus.sys.entity.TbStaff;
import jdk.nashorn.internal.parser.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/hello")
//作用于类级别的安全设置
//@Secured({"ROLE_normal","ROLE_admin"})

public class HolleController extends BaseController {

    @Autowired
    private FastDFSFileOperator fast;

    @Autowired
    private GetCommon getCommon;



//    @Autowired
//    private JWTTokenUtils jwtTokenUtils;


//    @PostMapping("/login")
//    public ResponseResult login(@RequestBody SelfUserEntity selfUserEntity){
////        selfUserDetailsService.loadUserByUsername(selfUserEntity.getUsername());
//        return null;
//    }

//    @GetMapping("/getUserInfo")
//    @PostAuthorize(" returnObject!=null &&  returnObject.username == authentication.name")
//    public TbStaff getUserInfo() {
//        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        TbStaff user;
//        if("anonymousUser".equals(pricipal)) {
//            user = null;
//        }else {
//            user = (TbStaff) pricipal;
//        }
//        return user;
//    }

//    @PreAuthorize("hasRole('管理员')")
    //@PostAuthorize   方法执行后才进行验权
    @PostMapping("/need_security_path")
    public ResultUtil initDashboard() {
        Map<String, Object> result = new HashMap<>();
        result.put("key1", "仪表盘初始化");
        result.put("key2", "方向盘初始化");
        return ResultUtil.resultSuccess(result);
    }


    @GetMapping(value = "/commonnacos")
    public Object nacos(){
        log.info("进入 测试调用其他模块服务控制器--"+getCommon);
        Object obj =  getCommon.nacos();
        log.info("FeginClient  /nacos/nacos 返回的数据"+obj.toString());
        return JSON.toJSONString(getCommon.nacos());
    }

    @GetMapping("/")
    public Object hello(){
        return SuccessResult();
    }

//    @PreAuthorize("hasAnyRole('超级管理员')")
    @GetMapping("/hell3")
    public Object hello3(){
        return "hello 3";
    }

    @PostMapping("/upload")
    public Object upload(@RequestBody MultipartFile file){
        String path  = "";
        try {
            path = fast.uploadFile(file);
        }catch(Exception e){
            e.printStackTrace();
            return FailResult("上传失败");
        }
        return SuccessResult(path);

    }


    @GetMapping("/exception")
    public void exception () {
        System.err.println("进入异常控制器");
        throw new  BusinessException(409,"业务异常");
    }

    @GetMapping("/accountlogin")
    public String  login(){
        return "account/loing";
    }

    @RequestMapping("/authorLogin")
    public String authorLogin (){
        return "authorLogin =========";
    }


    @RequestMapping("/loginSuccess")
    public String loginSuccess(HttpServletRequest request,HttpServletResponse response){
        Map map = new HashMap();
        try {
            map.put("request---token：", request.getHeader("JWTToken"));
        }catch (Exception e){
            throw  new BusinessException(400,"登录成功请求头没有 token");
        }

        try {
            map.put("request---token：", response.getHeader("JWTToken"));
        }catch (Exception e){
            throw  new BusinessException(400,"登陆成功响应头没有 token");
        }

        return "登录成功......";
    }

    @RequestMapping("/loginFail")
    public String loginFail(){
        return "登录失败......";
    }

    @RequestMapping("/noPermission")
    public String noPermission(){
        return "你没有权限";
    }

    @GetMapping("/userLogin")
    public ResponseResult userLogin(@RequestBody String str){
        Map<String,String> map = new HashMap<>();
        map  = JsonUtil.toMap(str);
        String username = map.get("username");
        String password = map.get("password");
        System.err.println("进入自定义登录接口--------------username: "+username+"   password: "+password);


        UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(username, password);
        //authenticationManager  会调用 UserDetailsService的实现类中的 loadByUserName方法去验证登录结果，UserDetailsService是 security配置类中指定的实现类
        Authentication authentication = authenticationManager.authenticate(loginToken);
        //因为这里选择的是前后端分离 使用token进行验证交互的所以此处省略保存认证信息  SecurityContextHolder.getContext().setAuthentication(authentication);
        //像用户返回标识用户信息的  token
        RequestToken requestToken = new RequestToken();
        requestToken.setUsername(username);
        requestToken.setPassword(password);
        Set<String> authorityList =new HashSet<>();
        for(GrantedAuthority authority:authentication.getAuthorities()){
            authorityList.add(authority.getAuthority());
            System.err.println("进入自定义登录接口 循环中------"+authority.getAuthority());
        }
        requestToken.setAuthorities(authorityList);
        String respToken = DjTokenUtil.createToken(JSON.toJSONString(requestToken));
        System.err.println("进入自定义登录接口  authentication"+JSON.toJSONString(authentication));
        return SuccessResult(respToken);
    }

    @Autowired
    private AuthenticationManager authenticationManager ;


}
