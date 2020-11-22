package com.dijiang.staff.component;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/7 11:04
 */



import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.AES;
import com.dijiang.common.util.AESUtil;
import com.dijiang.common.util.JsonUtil;
//import com.dijiang.staff.model.SelfUserEntity;
import com.alibaba.fastjson.JSONObject;
//import com.dijiang.staff.config.JWTConfig;
import com.dijiang.staff.model.RequestToken;
import com.dijiang.staff.model.SelfUserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationManager;
/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/5 13:51
 */
public class TokenFilter  extends BasicAuthenticationFilter {
//    public JWTAuthenticationTokenFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }

    public TokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头中JWT的Token
        String tokenHeader = request.getHeader("djtoken");
        if (null != tokenHeader) {
            try {
                //将token解析并且获取其中的 authorities
                String token = AESUtil.decrypt(tokenHeader, AESUtil.ASSETS_DEV_PWD_FIELD);
                System.err.println("TokenFilter ----token："+token);
                HashMap<String,Object> map = new HashMap();
                RequestToken  token1 = JSON.parseObject(token,RequestToken.class);
                Long userId = (Long)map.get("userId");
                SelfUserEntity selfUserEntity = new SelfUserEntity();
                selfUserEntity.setUsername(token1.getUsername());
                selfUserEntity.setUserId(token1.getUserId());
                List<GrantedAuthority> authorities = new ArrayList<>();
//                for(int i=0;i<token1.getAuthorities().size();i++){
//                    authorities.add(new SimpleGrantedAuthority(token1.getAuthorities().get(i).get("authority")));
//                }
                for(String author : token1.getAuthorities()){
                    authorities.add(new SimpleGrantedAuthority(author));
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(selfUserEntity,userId,authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (ExpiredJwtException e) {
                System.out.println("Token过期");
            } catch (Exception e) {
                System.out.println("Token无效");
            }
        }
        filterChain.doFilter(request, response);
        return;
    }
}
