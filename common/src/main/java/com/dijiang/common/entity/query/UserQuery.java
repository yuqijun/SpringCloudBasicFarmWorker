package com.dijiang.common.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/5 15:44
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserQuery {
    private Integer id;
    private String account ;
}
