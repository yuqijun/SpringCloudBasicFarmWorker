package com.dijiang.staff.mybatisplus.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文件版本信息表
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbFileVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 版本Id
     */
    @TableId(value = "versionId", type = IdType.AUTO)
    private Integer versionId;

    /**
     * 文件编号
     */
    private Integer id;

    /**
     * 部门编号
     */
    @TableField("deptId")
    private Integer deptId;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件大小 单位/kb
     */
    private Long size;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 文件类型（后缀名)
     */
    private String type;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private String createTime;

    /**
     * 创建者名称
     */
    private String creator;

    /**
     * 创建时间
     */
    @TableField("updateTime")
    private String updateTime;

    /**
     * 修改人名称
     */
    private String modifier;

    /**
     * 是否允许下载 0：不允许、1：允许  默认1
     */
    @TableField("allowDown")
    private String allowDown;

    /**
     * 权限组
     */
    @TableField("permissionGroup")
    private String permissionGroup;

    /**
     * 上次打开时间
     */
    @TableField("lastOpenTime")
    private String lastOpenTime;

    /**
     * 路径
     */
    private String route;

    /**
     * 版本编号
     */
    private Integer version;

    /**
     * 是否放入回收站;默认删除操作只将文件放入回收站：将该字段设为false
     */
    @TableField("isDelete")
    private String isDelete;

    /**
     * 更新说明
     */
    @TableField("versionInfo")
    private String versionInfo;


}
