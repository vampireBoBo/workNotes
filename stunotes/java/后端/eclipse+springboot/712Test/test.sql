/*
Navicat MySQL Data Transfer

Source Server         : 192.168.9.159
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-11-05 11:51:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` varchar(64) NOT NULL,
  `no` varchar(64) DEFAULT NULL,
  `name` varchar(188) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('6396aa32d1c043628faa3d49835b40d1', '002', '项目部');
INSERT INTO `dept` VALUES ('bf81a710fcdc44058d80065b30a720c6', '001', '项目部');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` varchar(64) NOT NULL,
  `no` varchar(64) DEFAULT '工牌号',
  `name` varchar(188) DEFAULT '姓名',
  `gender` varchar(1) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
