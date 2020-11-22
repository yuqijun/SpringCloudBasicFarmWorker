package com.dijiang.common.entity.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/11/22 14:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto  implements Serializable {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否在用
     */
    private Integer enable;

    /**
     * 是否被禁用
     */
    private Integer locked;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;


    /**
     * 用户id编号
     */
    private Integer userId;

    private String userExpatriateStatus;

    /**
     * 在职状态：0 在职、1：待离职、2：离职
     */
    private Integer statusOfTheJob;


    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱账号
     */
    private String email;

    /**
     * 用户现居地址
     */
    private String address;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 民族
     */
    private String nation;

    /**
     * 0：普通用户，1：公司员工、2：客户公司员工
     */
    private Integer userState;

    /**
     * 身份证号码
     */
    private String idNo;

    /**
     * 户籍地址
     */
    private String permanentAddress;



    /**
     * 薪水/月
     */
    private BigDecimal salary;

    /**
     * 工作地址
     */
    private String workAddress;

    /**
     * 存储在文件服务器上的简历的地址
     */
    private String resumePath;

    /**
     * 文件服务器类型名称
     */
    private String fileServerType;

    private List<RoleDto> roleList;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
