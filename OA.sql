/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : dijiang

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 19/11/2020 17:59:00
*/

-- ----------------------------
-- 创建数据库、普通用户分配权限
-- ----------------------------
CREATE DATABASE IF NOT EXISTS `dijiang`;
USE `dijiang`;

create user 'nihao'@'%' identified by 'nihao';
grant all privileges on dijiang.* to "nihao"@'%';
flush privileges;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_company_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_company_project`;
CREATE TABLE `tb_company_project`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `company_id` int(32) NOT NULL COMMENT '公司编号',
  `project_developer_id` int(32) NULL DEFAULT NULL COMMENT '外派员工项目详情id',
  `project_id` int(32) NOT NULL COMMENT '项目id',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户公司-项目关系表' ROW_FORMAT = Dynamic;





-- ----------------------------
-- Table structure for tb_cooperative_company
-- ----------------------------
DROP TABLE IF EXISTS `tb_cooperative_company`;
CREATE TABLE `tb_cooperative_company`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `company_id` int(32) NULL DEFAULT NULL COMMENT '公司id编号',
  `user_id` int(32) NULL DEFAULT NULL COMMENT '用户id编号',
  `company_name` varchar(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名称',
  `user_in_company_status` int(2) NULL DEFAULT NULL COMMENT '员工在公司状态 0：进入、1：离开',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户公司表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for tb_daily
-- ----------------------------
DROP TABLE IF EXISTS `tb_daily`;
CREATE TABLE `tb_daily`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日报内容',
  `start_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '工作开始时间',
  `end_time` timestamp(0) NOT NULL COMMENT '工作结束时间',
  `submit_time` timestamp(0) NOT NULL COMMENT '日报提交时间',
  `time` bigint(32) NOT NULL COMMENT '工作时长',
  `daily_create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `daily_update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日报' ROW_FORMAT = Dynamic;




-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `department_id` varchar(10)  CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门编号',
  `department_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `department_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  UNIQUE KEY (`department_id`),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for tb_department_staff
-- ----------------------------
DROP TABLE IF EXISTS `tb_department_staff`;
CREATE TABLE `tb_department_staff`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `staff_id` int(32) NULL DEFAULT NULL COMMENT '员工id',
  `department_id` int(32) NULL DEFAULT NULL COMMENT '部门id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;




-- ----------------------------
-- Table structure for tb_dict
-- ----------------------------
DROP TABLE IF EXISTS `tb_dict`;
CREATE TABLE `tb_dict`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_code` int(50) NOT NULL COMMENT '字典类别编号',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典分类名字',
  `item_code` int(50) NULL DEFAULT NULL COMMENT '字典编号',
  `item_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典名',
  `item_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典值',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dict
-- ----------------------------
INSERT INTO `tb_dict` VALUES (1, 10100, 'gitlab登录配置', 10101, 'client_id', '7d06e15f8ce0b41569d893400afd71526c34af9dd152a84f66166e0ab136210a', '2020-11-16 21:22:57', NULL);
INSERT INTO `tb_dict` VALUES (2, 10100, 'gitlab登录配置', 10102, 'redirect_uri', 'http://192.168.188.63:19870/login', '2020-11-16 21:23:00', NULL);
INSERT INTO `tb_dict` VALUES (3, 10100, 'gitlab登录配置', 10103, 'response_type', 'code', '2020-11-16 21:23:03', NULL);
INSERT INTO `tb_dict` VALUES (4, 10100, 'gitlab登录配置', 10104, 'scope', 'read_user', '2020-11-16 21:23:05', NULL);
INSERT INTO `tb_dict` VALUES (5, 10100, 'gitlab登录配置', 10105, 'client_secret', 'e1c31dcd67ab41b14f0119871cba334af82ca87a58a57476e3b5bd2b76cfb1dd', '2020-11-17 15:57:26', NULL);
INSERT INTO `tb_dict` VALUES (6, 10100, 'gitlab登录配置', 10106, 'grant_type', 'authorization_code', '2020-11-17 15:57:28', NULL);
INSERT INTO `tb_dict` VALUES (7, 10100, 'gitlab登录配置', 10107, 'url', 'https://g.showgold.cn', '2020-11-17 15:57:30', NULL);

-- ----------------------------
-- Table structure for _education
-- ----------------------------
DROP TABLE IF EXISTS `tb_education`;
CREATE TABLE `tb_education`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `education_id` int(32) UNIQUE NULL DEFAULT NULL COMMENT '教育id编号',
  `education_start_time` timestamp(0) NULL DEFAULT NULL COMMENT '教育开始时间',
  `education_end_time` timestamp(0) NULL DEFAULT NULL COMMENT '教育结束时间',
  `education_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `school_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校名称',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户教育背景表' ROW_FORMAT = Dynamic;




-- ----------------------------
-- Table structure for tb_hr
-- ----------------------------
DROP TABLE IF EXISTS `tb_hr`;
CREATE TABLE `tb_hr`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NULL DEFAULT NULL,
  `entry_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '办理入职表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_interview_apply
-- ----------------------------
DROP TABLE IF EXISTS `tb_interview_apply`;
CREATE TABLE `tb_interview_apply`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `interview_state` int(2) NULL DEFAULT NULL COMMENT '面试类型，0：本公司面试，1：外派面试',
  `current_residence` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现居地',
  `working_years` int(2) NULL DEFAULT NULL COMMENT '工作年限',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请职位',
  `salary` decimal(32, 5) NULL DEFAULT NULL COMMENT '期望薪水/月',
  `hands_on_ackground` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作经验',
  `educational_background` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教育背景',
  `self_evaluation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自我评价',
  `interview_apply_status` int(2) NULL DEFAULT NULL COMMENT '面试状态0：未邀请，1：邀请面试，2：面试未通过，3：面试通过',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `upddate_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '面试申请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_interview_apply_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_interview_apply_detail`;
CREATE TABLE `tb_interview_apply_detail`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `first_interviewer_id` int(32) NULL DEFAULT NULL COMMENT '面试官编号 (即尼好公司员工id)',
  `interview_apply_id` int(32) NULL DEFAULT NULL COMMENT '关联面试申请id',
  `second_interviewer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面试官 (甲方公司面试官)',
  `interview_round` int(11) NULL DEFAULT NULL COMMENT '面试轮数 1：第一轮、2：第二轮、...',
  `interview_start_time` timestamp(0) NULL DEFAULT NULL COMMENT '面试开始时间',
  `interview_end_time` timestamp(0) NULL DEFAULT NULL COMMENT '面试结束时间',
  `interview_evaluate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面试官评价',
  `interview_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '面试地点',
  `interview_result` int(2) NULL DEFAULT NULL COMMENT '本轮面试结果 0：待定、1：未通过、2：通过',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '面试申请详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_permissions
-- ----------------------------
DROP TABLE IF EXISTS `tb_permissions`;
CREATE TABLE `tb_permissions`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `permissions_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限所对应的url',
  `permission_name` varchar(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `permission_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  UNIQUE KEY (`permission_name`),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户权限表' ROW_FORMAT = Dynamic;;



-- ----------------------------
-- Table structure for tb_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_project`;
CREATE TABLE `tb_project`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_leader_id` int(32) NULL DEFAULT NULL COMMENT '项目负责人id',
  `interview_apply_id` int(32) NULL DEFAULT NULL COMMENT '面试申请id',
  `user_id` int(32) NULL DEFAULT NULL COMMENT '用户id',
  `project_name` varchar(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `user_in_project_status` int(2) NULL DEFAULT NULL COMMENT '用户在项目中的状态 0：参与中、1：离开项目',
  `project_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  `project_initiator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目发起方',
  `project_holder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目持有者',
  `project_development` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目开发方',
  `project_start_time` timestamp(0) NULL DEFAULT NULL COMMENT '项目开始时间',
  `project_expet_end_time` timestamp(0) NULL DEFAULT NULL COMMENT '项目预期结束时间',
  `project_continued_time` int(11) NULL DEFAULT NULL COMMENT '项目已持续时间',
  `project_end_time` timestamp(0) NULL DEFAULT NULL COMMENT '项目结束时间',
  `project_cycle` int(11) NULL DEFAULT NULL COMMENT '项目周期',
  `project_manager_id` int(32) NULL DEFAULT NULL COMMENT '项目经理',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  UNIQUE KEY (`project_name`),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;;




-- ----------------------------
-- Table structure for tb_project_developer
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_developer`;
CREATE TABLE `tb_project_developer`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `participate_project_time` timestamp(0) NULL DEFAULT NULL COMMENT '参与项目时间',
  `leave_project_time` timestamp(0) NULL DEFAULT NULL COMMENT '离开项目时间',
  `job_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作内容',
  `job_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '在项目中担任什么角色',
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '在项目中遇到了那些问题',
  `responsible_function` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要负责功能',
  `solve_problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '解决了那些问题',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '外派员工项目详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_project_leader
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_leader`;
CREATE TABLE `tb_project_leader`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目负责人表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_project_setting
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_setting`;
CREATE TABLE `tb_project_setting`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_id` int(32) NOT NULL COMMENT '项目id编号',
  `user_id` int(32) NOT NULL COMMENT '项目开发者id',
  `user_in_project_status` int(3) NOT NULL DEFAULT 0 COMMENT '开发者在项目中的状态，0：参与项目(默认值)、1：离开项目',
  `developer_type` int(3) NULL DEFAULT NULL COMMENT '项目开发者类型/角色',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目开发人员配置表' ROW_FORMAT = Dynamic;




-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '角色id编号',
  `name` varchar(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  UNIQUE KEY (`name`),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户权限角色表' ROW_FORMAT = Dynamic;






-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态:是否被禁用,0:可用,1:禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for tb_tripartite_account
-- ----------------------------
DROP TABLE IF EXISTS `tb_tripartite_account`;
CREATE TABLE `tb_tripartite_account`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NULL DEFAULT NULL COMMENT '用户id编号',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '三方账号',
  `tripartite_type` int(2) NULL DEFAULT NULL COMMENT '三方账号类型 0：github ,1：gitlab',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '第三方账户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户id编号',
  `username` varchar(255)  CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `enable` int(11) NULL DEFAULT NULL COMMENT '是否在用',
  `locked` int(11) NULL DEFAULT NULL COMMENT '是否被禁用',
  `last_login_time` timestamp(0) NULL DEFAULT NULL COMMENT '上次登录时间',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  UNIQUE KEY (`username`),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for tb_user_daily
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_daily`;
CREATE TABLE `tb_user_daily`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(32) NOT NULL COMMENT '用户id编号',
  `daily_id` int(32) NOT NULL COMMENT '日志id编号',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日报关联用户' ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for tb_user_detaile
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_detail`;
CREATE TABLE `tb_user_detaile`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NULL DEFAULT NULL COMMENT '用户id编号',
  `user_expatriate_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正被外派的公司：外派过、2：1_2_3  标识该员工同时同时供职于1、2、3 公司 (1、2、3)是公司id',
  `status_of_the_job` INT(3) NOT NULL COMMENT'在职状态：0 在职、1：待离职、2：离职',
  `user_expatriate_state` int(3) NULL DEFAULT NULL COMMENT '外派状态0：未外派 ，1：外派中',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱账号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户现居地址',
  `gender` int(2) NULL DEFAULT NULL COMMENT '员工性别',
  `birthday` timestamp(0) NULL DEFAULT NULL COMMENT '员工生日',
  `nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `user_state` int(2) NULL DEFAULT NULL COMMENT '0：普通用户，1：公司员工、2：客户公司员工',
  `id_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `permanent_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户籍地址',
  `education_id` int(32) NULL DEFAULT NULL COMMENT '教育信息表id',
  `entry_time` timestamp(0) NULL DEFAULT NULL COMMENT '入职时间',
  `departure_time` timestamp(0) NULL DEFAULT NULL COMMENT '离职时间',
  `salary` decimal(32, 5) NULL DEFAULT NULL COMMENT '薪水/月',
  `work_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作地址',
  `resume_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存储在文件服务器上的简历的地址',
  `file_server_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件服务器类型名称',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户详情表' ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for tb_user_position
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_position`;
CREATE TABLE `tb_user_position`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) NULL DEFAULT NULL COMMENT '用户id编号',
  `position_id` int(32) NULL DEFAULT NULL COMMENT '职位id编号',
  `position_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工职位名称',
  `position_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工职位描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户职位表' ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(32) NULL DEFAULT NULL COMMENT '角色id',
  `user_id` int(32) NULL DEFAULT NULL COMMENT '用户id',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户对应角色表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO tb_user_role  VALUES (101,101,101,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_role  VALUES (102,102,102,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_role  VALUES (103,103,103,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_role  VALUES (104,104,104,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_role  VALUES (105,105,105,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_role  VALUES (106,106,106,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_role  VALUES (107,107,107,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_role  VALUES (108,108,108,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_role  VALUES (109,109,109,'2020-11-16 21:23:05','2020-11-16 21:23:05');



INSERT INTO tb_company_project  VALUES (101,101,101,101,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_company_project  VALUES (102,102,102,102,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_company_project  VALUES (103,103,103,103,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_company_project  VALUES (104,104,104,104,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_company_project  VALUES (105,105,105,105,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_company_project  VALUES (106,106,106,106,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_company_project  VALUES (107,107,107,107,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_company_project  VALUES (108,108,108,108,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_company_project  VALUES (109,109,109,109,'2020-11-16 21:23:05','2020-11-16 21:23:05');



INSERT INTO tb_cooperative_company  VALUES (101,101,101,'蓝猫科技',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_cooperative_company  VALUES (102,102,102,'黑猫科技',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_cooperative_company  VALUES (103,103,103,'橘猫科技',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_cooperative_company  VALUES (104,104,104,'虹猫科技',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_cooperative_company  VALUES (105,105,105,'白兔奶糖',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_cooperative_company  VALUES (106,106,106,'漆喜集团',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_cooperative_company  VALUES (107,107,107,'响飘飘奶茶',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_cooperative_company  VALUES (108,108,108,'桂州茅台',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_cooperative_company  VALUES (109,109,109,'驴地集团',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');


INSERT INTO tb_daily  VALUES (101,'今晚不加班1','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_daily  VALUES (102,'今晚不加班2','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_daily  VALUES (103,'今晚不加班3','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_daily  VALUES (104,'今晚不加班4','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_daily  VALUES (105,'今晚不加班5','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_daily  VALUES (106,'今晚不加班6','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_daily  VALUES (107,'今晚不加班7','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_daily  VALUES (108,'今晚不加班8','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_daily  VALUES (109,'今晚不加班9','2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05','2020-11-16 21:23:05');


INSERT INTO tb_department  VALUES (101,'101','小卖部','部门描述1','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department  VALUES (102,'102','小卖部','部门描述2','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department  VALUES (103,'103','小卖部','部门描述3','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department  VALUES (104,'104','小卖部','部门描述4','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department  VALUES (105,'105','小卖部','部门描述5','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department  VALUES (106,'106','小卖部','部门描述6','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department  VALUES (107,'107','小卖部','部门描述7','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department  VALUES (108,'108','小卖部','部门描述8','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department  VALUES (109,'109','小卖部','部门描述9','2020-11-16 21:23:05','2020-11-16 21:23:05');



INSERT INTO tb_department_staff  VALUES (101,101,101,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department_staff  VALUES (102,102,102,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department_staff  VALUES (103,103,103,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department_staff  VALUES (104,104,104,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department_staff  VALUES (105,105,105,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department_staff  VALUES (106,106,106,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department_staff  VALUES (107,107,107,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department_staff  VALUES (108,108,108,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_department_staff  VALUES (109,109,109,'2020-11-16 21:23:05','2020-11-16 21:23:05');


INSERT INTO tb_education  VALUES (101,101,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_education  VALUES (102,102,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_education  VALUES (103,103,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_education  VALUES (104,104,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_education  VALUES (105,105,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_education  VALUES (106,106,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_education  VALUES (107,107,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_education  VALUES (108,108,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_education  VALUES (109,109,'2020-11-16 21:23:05','2020-11-16 21:23:05','小学','高级手扶拖拉机技工','葛家庄后巷沟小学','2020-11-16 21:23:05','2020-11-16 21:23:05');



INSERT INTO tb_permissions  VALUES (101,'www.baidu.com','/root/home1','permission描述1','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_permissions  VALUES (102,'www.baidu.com','/root/home2','permission描述2','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_permissions  VALUES (103,'www.baidu.com','/root/home3','permission描述3','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_permissions  VALUES (104,'www.baidu.com','/root/home4','permission描述4','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_permissions  VALUES (105,'www.baidu.com','/root/home5','permission描述5','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_permissions  VALUES (106,'www.baidu.com','/root/home6','permission描述6','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_permissions  VALUES (107,'www.baidu.com','/root/home7','permission描述7','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_permissions  VALUES (108,'www.baidu.com','/root/home8','permission描述8','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_permissions  VALUES (109,'www.baidu.com','/root/home9','permission描述9','2020-11-16 21:23:05','2020-11-16 21:23:05');


INSERT INTO tb_project  VALUES (101,101,101,101,'手机端web1项目',0,'项目描述1','会员1','股东1','施工队1','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,101,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project  VALUES (102,102,102,102,'手机端web2项目',0,'项目描述2','会员2','股东2','施工队2','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,102,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project  VALUES (103,103,103,103,'手机端web3项目',0,'项目描述3','会员3','股东3','施工队3','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,103,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project  VALUES (104,104,104,104,'手机端web4项目',0,'项目描述4','会员4','股东4','施工队4','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,104,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project  VALUES (105,105,105,105,'手机端web5项目',0,'项目描述5','会员5','股东5','施工队5','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,105,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project  VALUES (106,106,106,106,'手机端web6项目',0,'项目描述6','会员6','股东6','施工队6','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,106,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project  VALUES (107,107,107,107,'手机端web7项目',0,'项目描述7','会员7','股东7','施工队7','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,107,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project  VALUES (108,108,108,108,'手机端web8项目',0,'项目描述8','会员8','股东8','施工队8','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,108,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project  VALUES (109,109,109,109,'手机端web9项目',0,'项目描述9','会员9','股东9','施工队9','2020-11-16 21:23:05','2020-11-16 21:23:05',0,'2020-11-16 21:23:05',0,109,'2020-11-16 21:23:05','2020-11-16 21:23:05');



INSERT INTO tb_project_setting  VALUES (101,101,101,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project_setting  VALUES (102,102,102,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project_setting  VALUES (103,103,103,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project_setting  VALUES (104,104,104,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project_setting  VALUES (105,105,105,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project_setting  VALUES (106,106,106,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project_setting  VALUES (107,107,107,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project_setting  VALUES (108,108,108,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_project_setting  VALUES (109,109,109,0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05');




INSERT INTO tb_role VALUES(101,'admin1','admin1的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_role VALUES(102,'admin2','admin2的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_role VALUES(103,'admin3','admin3的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_role VALUES(104,'admin4','admin4的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_role VALUES(105,'admin5','admin5的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_role VALUES(106,'admin6','admin6的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_role VALUES(107,'admin7','admin7的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_role VALUES(108,'admin8','admin8的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_role VALUES(109,'admin9','admin9的描述','2020-11-16 21:23:05','2020-11-16 21:23:05');



INSERT INTO tb_role_permission  VALUES (101,101,101,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);
INSERT INTO tb_role_permission  VALUES (102,102,102,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);
INSERT INTO tb_role_permission  VALUES (103,103,103,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);
INSERT INTO tb_role_permission  VALUES (104,104,104,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);
INSERT INTO tb_role_permission  VALUES (105,105,105,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);
INSERT INTO tb_role_permission  VALUES (106,106,106,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);
INSERT INTO tb_role_permission  VALUES (107,107,107,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);
INSERT INTO tb_role_permission  VALUES (108,108,108,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);
INSERT INTO tb_role_permission  VALUES (109,109,109,'2020-11-16 21:23:05','2020-11-16 21:23:05',0);



INSERT INTO tb_user VALUES (101,'yqj100002','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (102,'yqj100003','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (103,'yqj100004','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (104,'yqj100005','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (105,'yqj100006','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (106,'yqj100007','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (107,'yqj100008','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (108,'yqj100009','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (109,'yqj100010','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user VALUES (110,'yqj100001','123456',0,0,'2020-11-16 21:23:05','2020-11-16 21:23:05','2020-11-16 21:23:05');




INSERT INTO tb_user_daily  VALUES (101,101,101,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_daily  VALUES (102,102,102,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_daily  VALUES (103,103,103,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_daily  VALUES (104,104,104,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_daily  VALUES (105,105,105,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_daily  VALUES (106,106,106,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_daily  VALUES (107,107,107,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_daily  VALUES (108,108,108,'2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_daily  VALUES (109,109,109,'2020-11-16 21:23:05','2020-11-16 21:23:05');



INSERT INTO tb_user_detaile VALUES(101,101,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',101,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_detaile VALUES(102,102,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',102,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_detaile VALUES(103,103,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',103,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_detaile VALUES(104,104,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',104,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_detaile VALUES(105,105,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',105,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_detaile VALUES(106,106,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',106,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_detaile VALUES(107,107,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',107,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_detaile VALUES(108,108,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',108,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_detaile VALUES(109,109,null,0,0,'zhangsan','张三','15079859640','861475974@qq.com','上海',0,'2020-11-16 21:23:05','汉族',1,'361452696965879854','南昌',109,'2020-11-16 21:23:05','2020-11-16 21:23:05',6500.00000,'青浦','www.baidu.com','fastdfs','2020-11-16 21:23:05','2020-11-16 21:23:05');


INSERT INTO tb_user_position VALUES(101,101,101,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_position VALUES(102,102,102,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_position VALUES(103,103,103,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_position VALUES(104,104,104,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_position VALUES(105,105,105,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_position VALUES(106,106,106,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_position VALUES(107,107,107,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_position VALUES(108,108,108,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
INSERT INTO tb_user_position VALUES(109,109,109,'后端api模型工程师','面向群友编程','2020-11-16 21:23:05','2020-11-16 21:23:05');
