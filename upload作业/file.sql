/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : file

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-12-05 23:25:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `name` varchar(255) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `route` varchar(255) DEFAULT NULL,
  `shuoming` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('2014-11-5 17-2-14 518.jpg', '775702', '2014-11-5 17-2-14', 'upload/2014-11-5 17-2-14 518.jpg', '');
INSERT INTO `information` VALUES ('2014-11-5 17-2-23 772.jpg', '780831', '2014-11-5 17-2-23', 'upload/2014-11-5 17-2-23 772.jpg', '544631');
INSERT INTO `information` VALUES ('2014-11-5 21-43-43 330.jpg', '879394', '2014-11-5 21-43-43', 'upload/2014-11-5 21-43-43 330.jpg', '菊花');
INSERT INTO `information` VALUES ('2014-11-5 21-43-43 792.', '0', '2014-11-5 21-43-43', 'upload/2014-11-5 21-43-43 792.', '');
INSERT INTO `information` VALUES ('2014-11-5 21-44-11 823.jpg', '845941', '2014-11-5 21-44-11', 'upload/2014-11-5 21-44-11 823.jpg', '沙漠');
INSERT INTO `information` VALUES ('2014-11-5 21-44-22 136.jpg', '595284', '2014-11-5 21-44-22', 'upload/2014-11-5 21-44-22 136.jpg', '八仙花');
INSERT INTO `information` VALUES ('2014-11-5 21-44-47 204.jpg', '775702', '2014-11-5 21-44-47', 'upload/2014-11-5 21-44-47 204.jpg', '水母');
INSERT INTO `information` VALUES ('2014-11-5 21-46-11 600.jpg', '561276', '2014-11-5 21-46-11', 'upload/2014-11-5 21-46-11 600.jpg', '灯塔');
INSERT INTO `information` VALUES ('2014-11-5 21-46-11 718.jpg', '780831', '2014-11-5 21-46-11', 'upload/2014-11-5 21-46-11 718.jpg', '考拉');
INSERT INTO `information` VALUES ('2014-11-5 21-46-11 893.jpg', '620888', '2014-11-5 21-46-11', 'upload/2014-11-5 21-46-11 893.jpg', '郁金香');
INSERT INTO `information` VALUES ('2014-11-5 21-54-47 770.jpg', '879394', '2014-11-5 21-54-47', 'upload/2014-11-5 21-54-47 770.jpg', '菊花');
INSERT INTO `information` VALUES ('2014-11-5 21-58-26 694.jpg', '595284', '2014-11-5 21-58-26', 'upload/2014-11-5 21-58-26 694.jpg', 'zzw八仙');
INSERT INTO `information` VALUES ('2014-11-5 22-20-47 376.jpg', '780831', '2014-11-5 22-20-47', 'upload/2014-11-5 22-20-47 376.jpg', '001');
INSERT INTO `information` VALUES ('2014-11-5 22-28-37 790.jpg', '780831', '2014-11-5 22-28-37', 'upload/2014-11-5 22-28-37 790.jpg', '001');
INSERT INTO `information` VALUES ('2014-11-5 22-9-14 849.jpg', '879394', '2014-11-5 22-9-14', 'upload/2014-11-5 22-9-14 849.jpg', '菊花123');
