/*
 Navicat MySQL Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : fces

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 24/03/2019 14:09:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '语文', '4', '2019-03-20 00:00:00', '2019-03-29 00:00:00');
INSERT INTO `class` VALUES (2, '数学', '3', '2019-03-22 00:00:00', '2019-03-27 00:00:00');
INSERT INTO `class` VALUES (3, '数学', '2', '2019-03-23 00:00:00', '2019-03-29 00:00:00');
INSERT INTO `class` VALUES (4, '英语', '1', '2019-03-26 00:00:00', '2019-03-28 00:00:00');
INSERT INTO `class` VALUES (5, '思想品德', '3', '2019-03-22 00:00:00', '2019-04-01 00:00:00');
INSERT INTO `class` VALUES (6, '生理', '1', '2019-03-22 00:00:00', '2019-03-28 00:00:00');
INSERT INTO `class` VALUES (7, '毛概', '4', '2019-03-22 00:00:00', '2019-03-29 00:00:00');

-- ----------------------------
-- Table structure for class_student
-- ----------------------------
DROP TABLE IF EXISTS `class_student`;
CREATE TABLE `class_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NULL DEFAULT NULL,
  `student_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_student
-- ----------------------------
INSERT INTO `class_student` VALUES (2, 4, 2);
INSERT INTO `class_student` VALUES (3, 4, 3);
INSERT INTO `class_student` VALUES (11, 4, 4);
INSERT INTO `class_student` VALUES (14, 4, 5);
INSERT INTO `class_student` VALUES (15, 6, 4);
INSERT INTO `class_student` VALUES (16, 6, 5);
INSERT INTO `class_student` VALUES (17, 6, 6);
INSERT INTO `class_student` VALUES (19, 4, 6);
INSERT INTO `class_student` VALUES (20, 4, 1);
INSERT INTO `class_student` VALUES (21, 4, 13);

-- ----------------------------
-- Table structure for score_student
-- ----------------------------
DROP TABLE IF EXISTS `score_student`;
CREATE TABLE `score_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NULL DEFAULT NULL,
  `to_student_id` int(11) NULL DEFAULT NULL,
  `from_student_id` int(11) NULL DEFAULT NULL,
  `score` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_student
-- ----------------------------
INSERT INTO `score_student` VALUES (1, 4, 2, 1, 89);
INSERT INTO `score_student` VALUES (2, 4, 3, 1, 56);
INSERT INTO `score_student` VALUES (3, 4, 2, 3, 77);
INSERT INTO `score_student` VALUES (4, 4, 4, 1, 100);
INSERT INTO `score_student` VALUES (5, 4, 5, 3, 34);
INSERT INTO `score_student` VALUES (6, 4, 13, 1, 77);

-- ----------------------------
-- Table structure for score_teacher
-- ----------------------------
DROP TABLE IF EXISTS `score_teacher`;
CREATE TABLE `score_teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NULL DEFAULT NULL,
  `student_id` int(11) NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  `score` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_teacher
-- ----------------------------
INSERT INTO `score_teacher` VALUES (1, 4, 3, 1, 99);
INSERT INTO `score_teacher` VALUES (3, 4, 4, 1, 15);
INSERT INTO `score_teacher` VALUES (4, 4, 1, 1, 15);
INSERT INTO `score_teacher` VALUES (5, 4, 2, 1, 78);
INSERT INTO `score_teacher` VALUES (6, 4, 6, 1, 123);
INSERT INTO `score_teacher` VALUES (7, 6, 6, 1, 67);
INSERT INTO `score_teacher` VALUES (8, 4, 5, 1, 100);
INSERT INTO `score_teacher` VALUES (9, 4, 13, 1, 76);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '20190322001', '王二小', '123456');
INSERT INTO `student` VALUES (2, '20190322002', '孙狗剩', '123456');
INSERT INTO `student` VALUES (3, '20190322003', '全志浓', '123456');
INSERT INTO `student` VALUES (4, '20190322004', '赵巍', '123456');
INSERT INTO `student` VALUES (5, '20190322005', '刘春江', '123456');
INSERT INTO `student` VALUES (6, '20190322006', '赵建国', '123456');
INSERT INTO `student` VALUES (9, '20190322008', '赵巍2', '123456');
INSERT INTO `student` VALUES (10, '20190322009', '刘春江2', '123456');
INSERT INTO `student` VALUES (11, '20190322010', '赵建国2', '123456');
INSERT INTO `student` VALUES (12, '20190322011', '楚云飞2', '123456');
INSERT INTO `student` VALUES (13, '20190322012', '关喆2', '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '2019032201', '刘丽', '123456');
INSERT INTO `teacher` VALUES (2, '2019032202', '王伟', '123456');
INSERT INTO `teacher` VALUES (3, '2019032203', '刘志', '123456');
INSERT INTO `teacher` VALUES (4, '2019032204', '李强森', '123456');

SET FOREIGN_KEY_CHECKS = 1;
