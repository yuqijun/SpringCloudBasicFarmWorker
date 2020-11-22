package com.dijiang.staff.config;
//
import com.dijiang.staff.component.CustomUserDetailsService;
import com.dijiang.staff.component.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/6 17:36
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private  CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                .cors()
                .and()
                // 取消跨站请求伪造防护
                .csrf().disable()
                    /* 警用session  cookie */
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                // 所有人都能访问登录接口
                .authorizeRequests()
                .antMatchers("/hello/userLogin").permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/hello/userLogin")
                .failureForwardUrl("/hello/loginFail")
                .successForwardUrl("/hello/loginSuccess")
                .and()
                .authorizeRequests()
                .antMatchers("/product/**").hasAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/hello/noPermission")
//                    .accessDeniedHandler(userAuthAccessDeniedHandler)
                .and()
                .headers().cacheControl();
            http.addFilter(new TokenFilter(authenticationManager()));
    }
}