package com.dijiang.staff.mybatisplus.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class TbStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

    private String salt;

    private String email;

    private String phone;

    private String role;

    /**
     * 单位为B，默认10G大小
     */
    private Long capacity;

    @TableField("deptId")
    private Integer deptId;

    @TableField("rootFolder")
    private Integer rootFolder;

    private Integer status;

    private Integer gender;

    private String birth;

    private String education;

    @TableField("mySelf")
    private String mySelf;

    @TableField("realName")
    private String realName;

    private String account;

    /**
     * 冻结时间
     */
    private String lockTime;


}
