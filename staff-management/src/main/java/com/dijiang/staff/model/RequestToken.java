package com.dijiang.staff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/7 13:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestToken  implements Serializable {
    private String username;
    private String password;
    private Long userId;
//    private List<Map<String,String>> authorities;
//    private List<GrantedAuthority> authorities;
    private Set<String> authorities;
}
