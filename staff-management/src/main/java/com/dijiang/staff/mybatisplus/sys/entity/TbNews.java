package com.dijiang.staff.mybatisplus.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户操作记录表
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbNews implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 操作者姓名
     */
    private String operator;

    /**
     * 操作者id
     */
    private Integer operatorId;

    /**
     * 操作者类型
     */
    private String operationType;

    /**
     * 操作目标 （文件夹路径）
     */
    private String target;

    /**
     * 操作目标id  ,文件或者文件夹id
     */
    private Integer targetId;

    /**
     * 操作目标类型，文件/文件夹/图片......
     */
    private String newsType;

    /**
     * 操作信息说明
     */
    private String details;


}
