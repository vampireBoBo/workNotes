/*
Navicat MySQL Data Transfer

Source Server         : 192.168.9.159
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : lhb-pdf

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-01-07 17:03:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  `remark` varchar(225) DEFAULT NULL,
  `university` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '李卉波', '24', '女', '用于测试利用remark模板进行pdf格式文件导出功能', '麻省理工');
