/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : student_analysis

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 12/09/2019 01:36:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (1, 'admin', '111', '2019-09-12 01:25:25');
COMMIT;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `paper_id` int(11) DEFAULT NULL,
  `select_answer` varchar(0) DEFAULT NULL,
  `completion_answer` varchar(0) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for completionquestion
-- ----------------------------
DROP TABLE IF EXISTS `completionquestion`;
CREATE TABLE `completionquestion` (
  `completion_id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `level` int(5) DEFAULT NULL COMMENT '难易程度  1最简单 5最难',
  `knowledge` varchar(50) DEFAULT NULL COMMENT '知识点',
  PRIMARY KEY (`completion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES (1, '数学', '2019-09-12 01:24:52');
INSERT INTO `course` VALUES (2, '语文', '2019-09-12 01:25:00');
INSERT INTO `course` VALUES (3, '英语', '2019-09-12 01:25:05');
COMMIT;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `paper_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_id` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `select_list` varchar(255) DEFAULT NULL,
  `completion_list` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `report_id` int(11) NOT NULL AUTO_INCREMENT,
  `report_name` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `paper_id` int(11) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for selectquestion
-- ----------------------------
DROP TABLE IF EXISTS `selectquestion`;
CREATE TABLE `selectquestion` (
  `select_id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `option_a` varchar(10) DEFAULT NULL,
  `option_b` varchar(10) DEFAULT NULL,
  `option_c` varchar(10) DEFAULT NULL,
  `option_d` varchar(10) DEFAULT NULL,
  `answer` varchar(10) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `knowledge` varchar(50) DEFAULT NULL,
  `level` int(5) DEFAULT NULL,
  PRIMARY KEY (`select_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_phone` varchar(50) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_password` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (1, '111', '王咸林', '111', '2019-09-12 01:26:00');
COMMIT;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(255) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
BEGIN;
INSERT INTO `type` VALUES (1, '客观分析能力', '2019-09-12 01:30:06');
INSERT INTO `type` VALUES (2, '推理能力', '2019-09-12 01:31:22');
INSERT INTO `type` VALUES (3, '动手能力', '2019-09-12 01:31:40');
INSERT INTO `type` VALUES (4, '计算能力', '2019-09-12 01:31:56');
INSERT INTO `type` VALUES (5, '应用能力', '2019-09-12 01:32:27');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
