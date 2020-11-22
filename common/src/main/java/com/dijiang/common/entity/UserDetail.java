package com.dijiang.common.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户详情表
 * </p>
 *
 * @author yqj
 * @since 2020-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user_detail")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id编号
     */
    private Integer userId;

    /**
     * 正被外派的公司：外派过、2：1_2_3  标识该员工同时同时供职于1、2、3 公司 (1、2、3)是公司id
     */
    private String userExpatriateStatus;

    /**
     * 在职状态：0 在职、1：待离职、2：离职
     */
    private Integer statusOfTheJob;

    /**
     * 外派状态0：未外派 ，1：外派中
     */
    private Integer userExpatriateState;

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
     * 员工性别
     */
    private Integer gender;

    /**
     * 员工生日
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
     * 教育信息表id
     */
    private Integer educationId;

    /**
     * 入职时间
     */
    private Date entryTime;

    /**
     * 离职时间
     */
    private Date departureTime;

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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
