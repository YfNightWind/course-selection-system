/*
 Navicat Premium Data Transfer

 Source Server         : AlexLin
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 114.215.209.136:3306
 Source Schema         : javaee

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 09/01/2022 01:19:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `a_id` int(2) NOT NULL AUTO_INCREMENT,
  `a_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `a_password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (1, 'admin', 'admin123', 4);
COMMIT;

-- ----------------------------
-- Table structure for selectinfo
-- ----------------------------
DROP TABLE IF EXISTS `selectinfo`;
CREATE TABLE `selectinfo` (
  `s_id` int(5) NOT NULL,
  `state` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT 'Ready',
  `v1` int(2) DEFAULT NULL,
  `v2` int(2) DEFAULT NULL,
  `v3` int(2) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of selectinfo
-- ----------------------------
BEGIN;
INSERT INTO `selectinfo` VALUES (1, 'Ready', 1, 1, 1);
INSERT INTO `selectinfo` VALUES (2, 'Ready', 1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(5) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `s_password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `s_num` varchar(10) COLLATE utf8_bin NOT NULL,
  `t_id` int(2) NOT NULL DEFAULT '0',
  `state` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT 'Start',
  `v1` int(2) DEFAULT NULL,
  `v2` int(2) DEFAULT NULL,
  `v3` int(2) DEFAULT NULL,
  PRIMARY KEY (`s_id`,`s_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (2, 'bob', 'asdfg1', '1927230207', 6, 'Finish', 2, 3, 4);
INSERT INTO `student` VALUES (3, 'zhang3', '1234', '1927230209', 6, 'Finish', NULL, NULL, NULL);
INSERT INTO `student` VALUES (4, '张三', '123456', '1927230203', 6, 'Finish', 1, 1, 1);
INSERT INTO `student` VALUES (9, '张无f', '22222', '1927230202', 6, 'Finish', 1, 1, 1);
INSERT INTO `student` VALUES (11, 'wala', '1234', '1927230', 1, 'V1Out', NULL, NULL, 1);
INSERT INTO `student` VALUES (12, 'wala', '1234', '192723', 1, 'Finish', 1, 1, 1);
INSERT INTO `student` VALUES (14, 'test', '1234', '19272300', 6, 'V1Out', NULL, NULL, NULL);
INSERT INTO `student` VALUES (22, '测试', '111', '29292', 6, 'V1Out', NULL, NULL, NULL);
INSERT INTO `student` VALUES (23, '发', '烦烦烦', '192323232', 6, 'V1Out', NULL, NULL, NULL);
INSERT INTO `student` VALUES (25, '林渝鸿', '123', '1927230264', 0, 'V1Out', 1, 6, 7);
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(2) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `t_password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `s_count` int(2) NOT NULL DEFAULT '0',
  `s_max` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES (1, 'alex', '1234', 9, 7);
INSERT INTO `teacher` VALUES (6, '何老师', '12323', 12, 12);
INSERT INTO `teacher` VALUES (7, 'zhang', '12121', 0, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
