/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : oa

 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 01/13/2018 17:45:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '店员表',
  `department_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '部门ID',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '账号',
  `user_pwd` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `real_name` varchar(50) DEFAULT NULL,
  `user_type` int(11) unsigned DEFAULT '1' COMMENT '用户组 1=管理员 2=人事 3=财务 4=普通',
  `is_del` tinyint(1) unsigned DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `status` tinyint(1) unsigned DEFAULT '1' COMMENT '状态 1=有效 0=无效',
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登入时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `is_del` (`is_del`),
  KEY `idx_store_id` (`department_id`),
  KEY `idx_user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `admin`
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES ('1', '0', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '1', '0', '1', '2018-01-10 11:56:46', '2018-01-10 11:56:46', '2018-01-10 14:38:51'), ('2', '1', 'aaa', 'e10adc3949ba59abbe56e057f20f883e', 'aaaaa', '2', '0', '1', '2018-01-10 16:34:54', '2018-01-10 16:34:54', '2018-01-10 16:35:31');
COMMIT;

-- ----------------------------
--  Table structure for `adminext`
-- ----------------------------
DROP TABLE IF EXISTS `adminext`;
CREATE TABLE `adminext` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '职工扩展信息表',
  `department_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '部门id',
  `admin_id` int(11) unsigned DEFAULT '0' COMMENT '对应admin.id',
  `mobile` varchar(20) DEFAULT '' COMMENT '手机号码',
  `name` varchar(45) DEFAULT '' COMMENT '姓名',
  `sex` int(1) unsigned NOT NULL DEFAULT '3' COMMENT '性别: 0(女)，1（男） 3=保密',
  `idcard_number` varchar(60) DEFAULT '' COMMENT '身份证号码',
  `birthday` date DEFAULT '0000-00-00' COMMENT '生日',
  `age` smallint(4) DEFAULT '0' COMMENT '年龄',
  `email` varchar(60) DEFAULT '' COMMENT 'Email',
  `qq` varchar(15) DEFAULT '' COMMENT 'QQ号',
  `job` varchar(100) DEFAULT '' COMMENT '职位',
  `memo` text COMMENT '备注',
  `employee_number` varchar(30) DEFAULT '' COMMENT '员工工号',
  `storeadmin_status` tinyint(1) unsigned DEFAULT '1' COMMENT '会员状态 1=有效 0=无效',
  `is_del` tinyint(1) unsigned DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `avatar` varchar(50) DEFAULT '' COMMENT '职工头像',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_department_id` (`department_id`) USING BTREE,
  KEY `idx_admin_id` (`admin_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `username` varchar(24) NOT NULL COMMENT '用户名',
  `password` varchar(256) NOT NULL COMMENT '密码',
  `authority` tinyint(4) NOT NULL COMMENT '权限 1：总账号 2：人事 3：财务 4：普通',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `member`
-- ----------------------------
BEGIN;
INSERT INTO `member` VALUES ('1', 'chsyd1', 'b57d8d40a2d4a9c3e983e864d7ceea59', '1'), ('2', 'chsyd2', 'b57d8d40a2d4a9c3e983e864d7ceea59', '2'), ('3', 'chsyd3', 'b57d8d40a2d4a9c3e983e864d7ceea59', '3'), ('4', 'chsyd4', 'b57d8d40a2d4a9c3e983e864d7ceea59', '4');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
