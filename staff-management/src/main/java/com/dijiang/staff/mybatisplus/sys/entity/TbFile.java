package com.dijiang.staff.mybatisplus.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("deptId")
    private Integer deptId;

    private String name;

    private Long size;

    private String path;

    private String type;

    private String creator;

    @TableField("createTime")
    private String createTime;

    private String modifier;

    @TableField("updateTime")
    private String updateTime;

    /**
     * 是否允许别人下载1允许0不允许
     */
    @TableField("allowDown")
    private Integer allowDown;

    /**
     * 下载/删除/编辑/查看/复制:1-1-1-1-1
     */
    @TableField("permissionGroup")
    private String permissionGroup;

    @TableField("lastOpenTime")
    private LocalDateTime lastOpenTime;

    /**
     * 文件路径
     */
    private String route;

    /**
     * 文件版本
     */
    private String version;

    /**
     * 是否放入回收站，默认否
     */
    @TableField("isDelete")
    private String isDelete;


}
