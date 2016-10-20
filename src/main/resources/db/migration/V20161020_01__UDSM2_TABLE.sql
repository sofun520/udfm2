/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : jettytestrun

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-10-20 09:45:21
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth_user
-- ----------------------------
INSERT INTO `t_auth_user` VALUES ('1', 'sdfdf', '10', '154154515', null, null);
INSERT INTO `t_auth_user` VALUES ('2', 'sdfd', '12', '2425121251', null, null);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `M_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `M_NAME` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `M_URL` varchar(100) DEFAULT NULL COMMENT '菜单url',
  `M_PARENT` int(10) DEFAULT NULL COMMENT '父菜单id',
  `M_DATE` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
