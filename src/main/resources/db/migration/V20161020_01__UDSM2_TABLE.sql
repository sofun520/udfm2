/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : jettytestrun

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-10-21 16:21:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_api
-- ----------------------------
DROP TABLE IF EXISTS `t_api`;
CREATE TABLE `t_api` (
  `A_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '接口ID',
  `A_NAME` varchar(50) DEFAULT NULL COMMENT '接口名称',
  `A_URL` varchar(100) DEFAULT NULL COMMENT '接口url',
  `A_REQUEST_TYPE` char(1) DEFAULT NULL COMMENT '请求类型',
  `A_PARAM` varchar(100) DEFAULT NULL COMMENT '请求参数',
  `A_COUNT` int(11) DEFAULT NULL COMMENT '请求计数',
  `A_DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '接口描述',
  `A_DATE` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`A_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_api
-- ----------------------------
INSERT INTO `t_api` VALUES ('1', '验证用户登录接口', '/api/user/checkLogin.do', '1', 'username,password', null, '验证用户登录接口', '2016-10-21 16:11:42');

-- ----------------------------
-- Table structure for t_auth_user
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_user`;
CREATE TABLE `t_auth_user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(32) DEFAULT NULL COMMENT '密码',
  `MOBILE` varchar(30) DEFAULT NULL COMMENT '手机号',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '电子邮件地址',
  `REGIST_DATE` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth_user
-- ----------------------------
INSERT INTO `t_auth_user` VALUES ('1', 'admin', 'admin', '154545454', '3242343@qq.com', '2016-10-20 10:28:58');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `M_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `M_NAME` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `M_URL` varchar(100) DEFAULT NULL COMMENT '菜单url',
  `M_PARENT` int(10) DEFAULT NULL COMMENT '父菜单id',
  `M_TYPE` char(1) DEFAULT NULL COMMENT '菜单类型（1：管理员管理后台，2：用户管理后台，3:移动端）',
  `M_DATE` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '菜单管理', '', null, '1', '2016-10-21 14:22:54');
INSERT INTO `t_menu` VALUES ('2', '菜单列表', 'menu.do', '1', '1', '2016-10-21 14:23:55');
INSERT INTO `t_menu` VALUES ('3', '角色菜单配置', '', null, '1', '2016-10-21 14:32:07');
INSERT INTO `t_menu` VALUES ('4', '角色列表', 'role.do', '3', '1', '2016-10-21 14:33:13');
INSERT INTO `t_menu` VALUES ('5', '菜单配置', 'roleConfig.do', '3', '1', '2016-10-21 14:34:41');
INSERT INTO `t_menu` VALUES ('6', 'Api接口管理', '', null, '1', '2016-10-21 14:37:14');
INSERT INTO `t_menu` VALUES ('7', '接口列表', 'api.do', '6', '1', '2016-10-21 14:37:52');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `R_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色代码',
  `R_NAME` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `R_DATE` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`R_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '2016-10-21 15:06:51');
INSERT INTO `t_role` VALUES ('2', '系统管理员', '2016-10-21 15:07:06');
INSERT INTO `t_role` VALUES ('3', '普通管理员', '2016-10-21 15:07:17');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `RA_ID` int(10) NOT NULL AUTO_INCREMENT,
  `RA_ROLE_ID` int(10) DEFAULT NULL,
  `RA_MENU_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`RA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
