/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : itcastoa0720

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-06-04 20:05:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `itcast_user`
-- ----------------------------
DROP TABLE IF EXISTS `itcast_user`;
CREATE TABLE `itcast_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itcast_user
-- ----------------------------
INSERT INTO `itcast_user` VALUES ('1', null);
INSERT INTO `itcast_user` VALUES ('2', null);
INSERT INTO `itcast_user` VALUES ('3', null);
INSERT INTO `itcast_user` VALUES ('4', null);
