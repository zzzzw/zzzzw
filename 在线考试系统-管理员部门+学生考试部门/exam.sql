/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-05-31 15:10:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `administrator`
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `adid` varchar(6) NOT NULL,
  `aname` varchar(8) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `cardnumber` varchar(18) DEFAULT NULL,
  `pwd` varchar(8) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`adid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('admin', 'AD', 'M', '440402199305079096', 'admin', '15766228275');

-- ----------------------------
-- Table structure for `choicequestion`
-- ----------------------------
DROP TABLE IF EXISTS `choicequestion`;
CREATE TABLE `choicequestion` (
  `c_id` int(11) NOT NULL,
  `c_question` varchar(200) CHARACTER SET utf8 NOT NULL,
  `c_choiceA` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `c_choiceB` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `c_choiceC` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `c_choiceD` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `c_answer` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of choicequestion
-- ----------------------------
INSERT INTO `choicequestion` VALUES ('1', '你爱我吗', '啊', '爱过', '刚睡醒？', '呵呵', 'A');
INSERT INTO `choicequestion` VALUES ('2', '111', '11', '11', '11', '11', 'A');
INSERT INTO `choicequestion` VALUES ('3', '222', '22', '22', '22', '22', 'A');
INSERT INTO `choicequestion` VALUES ('4', '33', '33', '33', '33', '33', 'A');
INSERT INTO `choicequestion` VALUES ('5', '44', '44', '44', '44', '44', 'A');
INSERT INTO `choicequestion` VALUES ('6', '55', '55', '55', '55', '55', 'A');
INSERT INTO `choicequestion` VALUES ('7', '66', '66', '66', '66', '66', 'A');
INSERT INTO `choicequestion` VALUES ('8', '77', '77', '77', '77', '77', 'A');
INSERT INTO `choicequestion` VALUES ('9', '88', '88', '88', '88', '88', 'A');
INSERT INTO `choicequestion` VALUES ('10', '99', '99', '99', '99', '99', 'A');
INSERT INTO `choicequestion` VALUES ('11', '123', '123', '123', '213', '123', 'A');
INSERT INTO `choicequestion` VALUES ('12', '12312', '123123', '123123', 'df', 'asdf', 'A');
INSERT INTO `choicequestion` VALUES ('13', 'dahr', 'as', 'asg', 'sdga', 'agds', 'A');
INSERT INTO `choicequestion` VALUES ('14', 'asdgasdd', 'ad', 'asdfs', 'dfa', 'asfd', 'A');
INSERT INTO `choicequestion` VALUES ('15', 'asdfa', 'asdads', 'adgfa', 'SDFDa', 'SFDGFDASDA', 'A');
INSERT INTO `choicequestion` VALUES ('16', 'ASDFASDF', 'ASDGFaDFFA', 'ASDFDSFGSDF', 'GDSFGADFA', 'ADGSADFASDGA', 'A');
INSERT INTO `choicequestion` VALUES ('17', 'ASDAS', 'ADG', 'ASD', 'ASD', 'AWEGASDG', 'A');
INSERT INTO `choicequestion` VALUES ('18', 'asdgasdd', 'adD', 'ASD1', '112', '231312', 'A');
INSERT INTO `choicequestion` VALUES ('19', '2343654', '54', '456', '456', '456', 'A');
INSERT INTO `choicequestion` VALUES ('20', '7587', '876', '68', '4567', '765679', 'A');

-- ----------------------------
-- Table structure for `fillquestion`
-- ----------------------------
DROP TABLE IF EXISTS `fillquestion`;
CREATE TABLE `fillquestion` (
  `f_id` int(11) NOT NULL,
  `f_question` varchar(200) CHARACTER SET utf8 NOT NULL,
  `f_answer` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of fillquestion
-- ----------------------------
INSERT INTO `fillquestion` VALUES ('1', '最近好吗', '什么跟什么');
INSERT INTO `fillquestion` VALUES ('2', '21', '23');
INSERT INTO `fillquestion` VALUES ('3', '2343654', '4324523');
INSERT INTO `fillquestion` VALUES ('4', '25452', '3543');
INSERT INTO `fillquestion` VALUES ('5', '', '');
INSERT INTO `fillquestion` VALUES ('6', '45245', '23254234');
INSERT INTO `fillquestion` VALUES ('7', '252', '243245');
INSERT INTO `fillquestion` VALUES ('8', '234234', '4223452');
INSERT INTO `fillquestion` VALUES ('9', '24332652634', '46523246223');
INSERT INTO `fillquestion` VALUES ('10', '24623462', '362452626');
INSERT INTO `fillquestion` VALUES ('11', '246524623', '26524356423');
INSERT INTO `fillquestion` VALUES ('12', '46523442', '3424566523');
INSERT INTO `fillquestion` VALUES ('13', '2364452', '456475');
INSERT INTO `fillquestion` VALUES ('14', '424623', '6452653634');
INSERT INTO `fillquestion` VALUES ('15', '23654564', '234634654');
INSERT INTO `fillquestion` VALUES ('16', '34653456', '436564435');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(6) NOT NULL,
  `sname` varchar(8) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `cardnumber` varchar(18) DEFAULT NULL,
  `pwd` varchar(3) NOT NULL,
  `department` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0011', 'Jack', '男', '000000000000000001', '001', '计算机学院', '15766220001');
INSERT INTO `student` VALUES ('003', '李延辉', '男', '20150531', '003', '软件系', '666');
INSERT INTO `student` VALUES ('666', '曾志伟', '男', '20150531', '666', '软件系', '666');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` varchar(6) NOT NULL,
  `tname` varchar(8) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `cardnumber` varchar(18) DEFAULT NULL,
  `pwd` varchar(6) NOT NULL,
  `title` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('001', 'Frank', '男', '90000000000000001', '001', '教授', '12345678901');
INSERT INTO `teacher` VALUES ('90002', 'Susan', '女', '900000000000000002', '00002', '教授', '12345678902');
