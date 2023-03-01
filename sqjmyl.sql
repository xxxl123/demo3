/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : sqjmyl

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 01/03/2023 21:38:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dep` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, '许医生', '1991-10-01', '男', '内科', '淮阴区蓝河公寓', '19838383835', '320181200110239211', 'doctor1', 'doctor1');
INSERT INTO `doctor` VALUES (2, '谢医生', '2001-03-26', '女', '生殖科', '淮阴区盐和花园', '18303894833', '421181200134220920', 'doctor2', 'doctor2');
INSERT INTO `doctor` VALUES (3, '戴医生', '2001-02-13', '男', '外科', '清江浦区浦南花园', '18181818115', '320181200102132316', 'doctor3', 'doctor3');

-- ----------------------------
-- Table structure for health
-- ----------------------------
DROP TABLE IF EXISTS `health`;
CREATE TABLE `health`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `userid` int(0) NULL DEFAULT NULL,
  `msg` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `times` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health
-- ----------------------------
INSERT INTO `health` VALUES (1, 2, '身体正常', '2022-04-26 23:58:50');
INSERT INTO `health` VALUES (2, 1, '身体正常', '2022-04-28 18:24:45');
INSERT INTO `health` VALUES (9, 1, '身体正常', '2022-04-29 16:29:45');
INSERT INTO `health` VALUES (10, 10, '身体正常', '2023-03-01 18:52:48');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `career` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES (1, '张三', '1998-10-02', '男', 'java工程师', '淮阴区王营社区法外狂徒村8幢', '18181818115', '421181200413224831', 'userzhang', 'userzhang');
INSERT INTO `patient` VALUES (2, '李四', '1992-10-18', '男', '学生', '淮阴区淮阴师范学院17号楼211', '13697546877', '332381200111224831', 'userli', 'userli');
INSERT INTO `patient` VALUES (3, '周杰伦', '2000-02-10', '男', '歌手', '淮阴区营西社区奶茶村14幢', '18181177711', '421181205551224831', 'userzhou', 'userzhou');
INSERT INTO `patient` VALUES (4, '林俊杰', '1999-05-04', '男', '歌手', '淮阴区营北社区江南镇6幢', '13708547937', '329840174901217034', 'userlin', 'userlin');
INSERT INTO `patient` VALUES (5, '王五', '2000-11-11', '男', '学生', '淮阴区营北社区江南镇6幢', '15652435626', '321323222022010035', 'userli', 'userli');
INSERT INTO `patient` VALUES (6, '二丫', '2001-11.01', '女', '学生', '淮阴区营北社区江南镇6幢', '15624326512', '321323201053565662', 'userli', 'userli');

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `patientid` int(0) NULL DEFAULT NULL,
  `doctorid` int(0) NULL DEFAULT NULL,
  `inpatientnumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `predate` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES (1, '胃部肿块', 1, NULL, '23', '2021-01-06 23:34:47', '手术。正常理疗.');
INSERT INTO `prescription` VALUES (2, '轻微夜盲症', 2, 1, '29', '2022-04-27 02:07:44', '吃维生素b，多喝水');
INSERT INTO `prescription` VALUES (3, '强直性脊柱炎', 3, 1, '37', '2022-04-28 18:28:20', '少喝奶茶');
INSERT INTO `prescription` VALUES (21, '许昌磊', 1, NULL, '17#', '2022-04-29 17:54:19', '去微软干活');
INSERT INTO `prescription` VALUES (27, '外科', 4, 1, '12312', '2022-04-30 08:55:22', '吃吃吃');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '周杰伦', '420138198809128734', 18, '18181177711');
INSERT INTO `user` VALUES (2, '成龙', '421123199802147813', 33, '18181177713');
INSERT INTO `user` VALUES (3, '王力宏', '422948198809187619', 22, '13288211164');
INSERT INTO `user` VALUES (4, '林俊杰', '329840174901217034', 35, '13708547937');
INSERT INTO `user` VALUES (5, '李荣浩', '359372198742290423', 22, '15173483984');
INSERT INTO `user` VALUES (6, '邓紫棋', '420495199538275302', 30, '15749457829');
INSERT INTO `user` VALUES (7, '赵丽颖', '330278199028747120', 29, '13855646512');
INSERT INTO `user` VALUES (8, '陈奕迅', '520494198027429411', 40, '13967852634');
INSERT INTO `user` VALUES (9, '张三', '389472043842870181', 102, '18723186469');
INSERT INTO `user` VALUES (10, '李四', '338456543213538497', 19, '13697546877');

SET FOREIGN_KEY_CHECKS = 1;
