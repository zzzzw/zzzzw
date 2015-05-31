/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : hibnie

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2011-04-20 16:02:37
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `c`
-- ----------------------------
DROP TABLE IF EXISTS `c`;
CREATE TABLE `c` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c
-- ----------------------------

-- ----------------------------
-- Table structure for `s`
-- ----------------------------
DROP TABLE IF EXISTS `s`;
CREATE TABLE `s` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s
-- ----------------------------
INSERT INTO s VALUES ('1', 'andylau');
INSERT INTO s VALUES ('2', 'james blunt');
INSERT INTO s VALUES ('13', 'jamy');
INSERT INTO s VALUES ('14', 'Herry');
INSERT INTO s VALUES ('16', 'jackey chen');
INSERT INTO s VALUES ('17', 'John woo');

-- ----------------------------
-- Table structure for `sc`
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `sid` int(10) DEFAULT NULL,
  `cid` int(10) DEFAULT NULL,
  `score` double(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
