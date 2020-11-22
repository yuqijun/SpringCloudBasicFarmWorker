package com.dijiang.common.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dijiang.common.entity.Permissions;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/22 15:14
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PermissionsDto implements Serializable {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限所对应的url
     */
    private String url;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限描述
     */
    private String permissionDesc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 权限id编号
     */
    private Integer permissionId;
}
