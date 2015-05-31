/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-05-21 10:34:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `person_id` int(11) NOT NULL,
  `course_name` varchar(255) NOT NULL,
  PRIMARY KEY (`person_id`,`course_name`),
  KEY `FKAF42E01B7E64D6C7` (`person_id`),
  CONSTRAINT `FKAF42E01B7E64D6C7` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `major` char(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'Tom', '29', 'Computer Science');
INSERT INTO `person` VALUES ('2', 'Ken', '39', 'Math Science');
INSERT INTO `person` VALUES ('3', 'Tom', '29', 'Computer Science');
INSERT INTO `person` VALUES ('4', 'Tom', '29', 'Computer Science');
