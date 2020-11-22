package com.dijiang.common.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dijiang.common.entity.Role;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/22 15:11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDto  implements Serializable {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 角色id编号
     */
    private Integer roleId;

    private List<PermissionsDto> permissionsList;

}
