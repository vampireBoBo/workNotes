/*
Navicat MySQL Data Transfer

Source Server         : 192.168.9.159
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : lhb-shiro

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-01-02 14:19:00
*/

/*create database IF not exists `lhb-shiro`;*/

/*user database `lhb-shiro`;*/


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_permission`
-- ----------------------------
DROP TABLE IF EXISTS `s_permission`;
CREATE TABLE `s_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(100) DEFAULT NULL,
  `remark` varchar(560) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_permission
-- ----------------------------
INSERT INTO `s_permission` VALUES ('1', 'user:all', '用户模块所有功能');
INSERT INTO `s_permission` VALUES ('2', 'user:list', '用户显示功能');
INSERT INTO `s_permission` VALUES ('3', 'role:all', '角色模块所有权限');
INSERT INTO `s_permission` VALUES ('4', 'role:list', '角色显示功能');
INSERT INTO `s_permission` VALUES ('5', 'permission:all', '权限模块所有权限');
INSERT INTO `s_permission` VALUES ('6', 'permission:list', '权限显示功能');

-- ----------------------------
-- Table structure for `s_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rcode` varchar(100) DEFAULT NULL COMMENT '角色编码',
  `rname` varchar(100) DEFAULT NULL,
  `remark` varchar(560) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', 'systemAdmin', '系统管理员', '主要负责系统模块的操作');
INSERT INTO `s_role` VALUES ('2', 'usual', '普通人员', '可查看用户角色权限列表的权限');

-- ----------------------------
-- Table structure for `s_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `s_role_permission`;
CREATE TABLE `s_role_permission` (
  `rpid` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rpid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role_permission
-- ----------------------------
INSERT INTO `s_role_permission` VALUES ('1', '1', '1');
INSERT INTO `s_role_permission` VALUES ('2', '1', '3');
INSERT INTO `s_role_permission` VALUES ('3', '1', '5');

-- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(100) DEFAULT NULL,
  `loginPassWord` varchar(100) DEFAULT NULL,
  `uname` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'admin', '123456', 'admin', '24', '女');
INSERT INTO `s_user` VALUES ('2', 'lhb', '123456', 'lhb', '24', '女');
INSERT INTO `s_user` VALUES ('3', 'lyx', '123456', '罗云熙', '24', '男');

-- ----------------------------
-- Table structure for `s_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `urid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`urid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_role
-- ----------------------------
INSERT INTO `s_user_role` VALUES ('1', '1', '1');
