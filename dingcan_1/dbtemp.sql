/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : dbtemp

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-05-27 18:05:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `xuhao` int(11) NOT NULL DEFAULT '0',
  `mingchen` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `jiege` double DEFAULT NULL,
  `shuliang` int(11) DEFAULT NULL,
  PRIMARY KEY (`xuhao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cno` char(6) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `cname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `cpno` char(6) CHARACTER SET utf8 DEFAULT NULL,
  `ccredit` smallint(2) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `cpno` (`cpno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('201', 'C语言', '101', '2');
INSERT INTO `course` VALUES ('202', '数据结构', '102', '2');
INSERT INTO `course` VALUES ('203', '数据库', '103', '2');
INSERT INTO `course` VALUES ('204', 'java面向对象程序设计', '104', '2');
INSERT INTO `course` VALUES ('205', 'java web', '105', '2');
INSERT INTO `course` VALUES ('206', '算法设计', '106', '2');
INSERT INTO `course` VALUES ('207', 'asp.net', '107', '2');
INSERT INTO `course` VALUES ('208', '图像处理', '108', '2');
INSERT INTO `course` VALUES ('209', '音频处理', '109', '2');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dno` char(3) CHARACTER SET utf8 DEFAULT '',
  `dname` varchar(30) CHARACTER SET utf8 NOT NULL,
  `dmanager` char(8) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`dname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('9', '体育学院', '刘翔');
INSERT INTO `department` VALUES ('7', '化工学院', '门捷列夫');
INSERT INTO `department` VALUES ('12', '外国语学院', '李阳');
INSERT INTO `department` VALUES ('5', '工程学院', '詹天佑');
INSERT INTO `department` VALUES ('10', '政法学院', '胡惊涛');
INSERT INTO `department` VALUES ('11', '教育学院', '陶行知');
INSERT INTO `department` VALUES ('3', '数学学院', '华罗庚');
INSERT INTO `department` VALUES ('6', '生物学院', '巴氏');
INSERT INTO `department` VALUES ('8', '经济管理学院', '郎咸平');
INSERT INTO `department` VALUES ('4', '美术学院', '徐悲鸿');
INSERT INTO `department` VALUES ('1', '计算机学院', '马云');
INSERT INTO `department` VALUES ('2', '音乐学院', '刘欢');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `name` char(20) CHARACTER SET utf8 NOT NULL,
  `password` char(20) CHARACTER SET utf8 NOT NULL,
  `id` char(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`name`,`password`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('2012000', '000000', '管理员');
INSERT INTO `login` VALUES ('2012001', '123456', '学生');
INSERT INTO `login` VALUES ('2012002', '123456', '学生');
INSERT INTO `login` VALUES ('2012003', '123456', '学生');
INSERT INTO `login` VALUES ('2012004', '123456', '学生');
INSERT INTO `login` VALUES ('2012005', '123456', '学生');
INSERT INTO `login` VALUES ('2012006', '123456', '学生');
INSERT INTO `login` VALUES ('301', '654321', '教师');
INSERT INTO `login` VALUES ('302', '654321', '教师');
INSERT INTO `login` VALUES ('303', '654321', '教师');
INSERT INTO `login` VALUES ('304', '654321', '教师');
INSERT INTO `login` VALUES ('305', '654321', '教师');
INSERT INTO `login` VALUES ('306', '654321', '教师');

-- ----------------------------
-- Table structure for `sct`
-- ----------------------------
DROP TABLE IF EXISTS `sct`;
CREATE TABLE `sct` (
  `sno` char(9) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `cno` char(6) CHARACTER SET utf8 NOT NULL,
  `tno` char(8) CHARACTER SET utf8 NOT NULL,
  `grade` int(4) DEFAULT NULL,
  PRIMARY KEY (`sno`,`cno`,`tno`),
  KEY `cno` (`cno`),
  KEY `tno` (`tno`),
  CONSTRAINT `sct_ibfk_1` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sct_ibfk_2` FOREIGN KEY (`cno`) REFERENCES `course` (`cno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sct_ibfk_3` FOREIGN KEY (`tno`) REFERENCES `teacher` (`tno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sct
-- ----------------------------
INSERT INTO `sct` VALUES ('2012001', '201', '301', '99');
INSERT INTO `sct` VALUES ('2012001', '202', '301', '78');
INSERT INTO `sct` VALUES ('2012001', '203', '301', '88');
INSERT INTO `sct` VALUES ('2012002', '201', '301', '89');
INSERT INTO `sct` VALUES ('2012002', '202', '301', '99');
INSERT INTO `sct` VALUES ('2012003', '201', '301', '60');
INSERT INTO `sct` VALUES ('2012003', '202', '301', null);
INSERT INTO `sct` VALUES ('2012004', '201', '301', '74');
INSERT INTO `sct` VALUES ('2012004', '202', '301', null);
INSERT INTO `sct` VALUES ('2012005', '201', '301', '88');
INSERT INTO `sct` VALUES ('2012005', '202', '301', null);
INSERT INTO `sct` VALUES ('2012006', '201', '301', '96');
INSERT INTO `sct` VALUES ('2012006', '202', '301', null);

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `xuhao` int(11) NOT NULL,
  `mingchen` char(255) CHARACTER SET utf8 NOT NULL,
  `miaoshu` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `tupian` char(255) CHARACTER SET utf8 DEFAULT NULL,
  `jiege` double NOT NULL,
  `cunhuo` int(11) DEFAULT NULL,
  `zhuangtai` char(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`xuhao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', 's5', '', 'upload/s5.jpg', '4999', '100', '上架');
INSERT INTO `shop` VALUES ('2', 'note4', '', 'upload/note4.jpg', '3649', '10', '上架');
INSERT INTO `shop` VALUES ('3', 'note3', '', 'upload/note3.jpg', '3000', '10', '上架');
INSERT INTO `shop` VALUES ('4', 'Alpha', '', 'upload/Alpha.jpg', '3998', '10', '上架');
INSERT INTO `shop` VALUES ('5', 's9', '', 'upload/s9.jpg', '18888', '111', '上架');
INSERT INTO `shop` VALUES ('6', 'A3', '', 'upload/A3.jpg', '1499', '20', '上架');
INSERT INTO `shop` VALUES ('7', 'G9008W', '', 'upload/G9008W.jpg', '1449', '20', '上架');
INSERT INTO `shop` VALUES ('8', 'Note Edge', '', 'upload/Note Edge.jpg', '6699', '10', '上架');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` char(9) CHARACTER SET utf8 NOT NULL,
  `sname` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `ssex` char(1) CHARACTER SET utf8 DEFAULT NULL,
  `sage` int(4) DEFAULT NULL,
  `sdept` varchar(30) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`sno`),
  KEY `sdept` (`sdept`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`sdept`) REFERENCES `department` (`dname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2012001', '范裕彬', '男', '20', '计算机学院');
INSERT INTO `student` VALUES ('2012002', '刘翔', '男', '22', '体育学院');
INSERT INTO `student` VALUES ('2012003', '张增荣', '女', '20', '计算机学院');
INSERT INTO `student` VALUES ('2012004', '刘宏宏', '男', '20', '生物学院');
INSERT INTO `student` VALUES ('2012005', '王珊珊', '女', '20', '生物学院');
INSERT INTO `student` VALUES ('2012006', '李大扎', '男', '20', '体育学院');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tno` char(8) CHARACTER SET utf8 NOT NULL,
  `tname` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `tsex` char(1) CHARACTER SET utf8 DEFAULT NULL,
  `tage` int(4) DEFAULT NULL,
  `teb` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `tpt` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `cno1` char(6) CHARACTER SET utf8 DEFAULT NULL,
  `cno2` char(6) CHARACTER SET utf8 DEFAULT NULL,
  `cno3` char(6) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`tno`),
  KEY `cno1` (`cno1`),
  KEY `cno2` (`cno2`),
  KEY `cno3` (`cno3`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`cno1`) REFERENCES `course` (`cno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`cno2`) REFERENCES `course` (`cno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_ibfk_3` FOREIGN KEY (`cno3`) REFERENCES `course` (`cno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('301', '李思思', '女', '40', '学士', '助教', '201', '202', '203');
INSERT INTO `teacher` VALUES ('302', '岑宇森', '男', '45', '博士', '教授', '204', '205', '206');
INSERT INTO `teacher` VALUES ('303', '黄达成', '男', '46', '博士', '副教授', '207', '208', '209');
INSERT INTO `teacher` VALUES ('304', '王珂', '男', '55', '学士', '助教', '201', '202', '203');
INSERT INTO `teacher` VALUES ('305', '刘汉黄', '男', '45', '学士', '助教', '204', '205', '206');
INSERT INTO `teacher` VALUES ('306', '廖凡', '男', '46', '博士', '副教授', '207', '208', '209');

-- ----------------------------
-- Table structure for `tuser`
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `xh` char(20) NOT NULL DEFAULT '',
  `xm` char(20) DEFAULT NULL,
  `jieshao` text,
  PRIMARY KEY (`xh`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('', '', '');
INSERT INTO `tuser` VALUES ('003', '逗比三号', '逗比');
INSERT INTO `tuser` VALUES ('dddddddddddddddddd', 'dddddddddddd', 'ddd');
