/*
Navicat MySQL Data Transfer

Source Server         : LOCALHOST-DB
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : mybatis_plus

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2022-04-18 16:13:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tab_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tab_teacher`;
CREATE TABLE `tab_teacher` (
  `pk_teacher_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '老师主键id,起始为1',
  `teacher_name` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '老师姓名',
  `teacher_sex` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '老师性别',
  `teacher_salary` double(6,1) DEFAULT NULL COMMENT '老师工资',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录修改时间',
  `visibility` tinyint(4) DEFAULT NULL COMMENT '0表示未删除，1表示删除',
  PRIMARY KEY (`pk_teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tab_teacher
-- ----------------------------
INSERT INTO `tab_teacher` VALUES ('9', 'test2', '女', '9876.5', '2022-04-18 14:39:49', '0000-00-00 00:00:00', '0');
INSERT INTO `tab_teacher` VALUES ('10', 'test2', '女', '9876.5', '2022-04-18 14:39:49', '0000-00-00 00:00:00', '0');
INSERT INTO `tab_teacher` VALUES ('11', 'test2', '女', '9876.5', '2022-04-18 14:39:49', '0000-00-00 00:00:00', '0');
INSERT INTO `tab_teacher` VALUES ('12', 'test2', '女', '9876.5', '2022-04-18 14:39:49', '0000-00-00 00:00:00', '0');
INSERT INTO `tab_teacher` VALUES ('13', 'test2', '女', '9876.5', '2022-04-18 14:39:49', '0000-00-00 00:00:00', '0');
INSERT INTO `tab_teacher` VALUES ('14', 'test2', '女', '9876.5', '2022-04-18 14:44:34', '0000-00-00 00:00:00', null);
INSERT INTO `tab_teacher` VALUES ('15', 'test2', '女', '9876.5', '2022-04-18 14:44:35', '0000-00-00 00:00:00', null);
INSERT INTO `tab_teacher` VALUES ('16', 'test2', '女', '9876.5', '2022-04-18 14:44:35', '0000-00-00 00:00:00', null);
INSERT INTO `tab_teacher` VALUES ('17', 'test2', '女', '9876.5', '2022-04-18 14:44:36', '0000-00-00 00:00:00', null);
INSERT INTO `tab_teacher` VALUES ('18', 'test2', '女', '9876.5', '2022-04-18 14:44:36', '0000-00-00 00:00:00', null);
INSERT INTO `tab_teacher` VALUES ('19', 'test2', '女', '9876.5', '2022-04-18 14:44:42', '0000-00-00 00:00:00', null);
INSERT INTO `tab_teacher` VALUES ('20', 'test2', '女', '9876.5', '2022-04-18 14:44:42', '0000-00-00 00:00:00', null);
INSERT INTO `tab_teacher` VALUES ('21', 'test2', '男', '9876.5', '2022-04-18 15:09:01', '0000-00-00 00:00:00', null);
INSERT INTO `tab_teacher` VALUES ('22', 'CHENEY-72', '男', '9876.5', '2022-04-18 15:09:02', '2022-04-18 15:08:11', '0');
INSERT INTO `tab_teacher` VALUES ('23', 'CHENEY-82', '男', '9876.5', '2022-04-18 15:09:03', '2022-04-18 15:08:11', '0');
INSERT INTO `tab_teacher` VALUES ('24', 'CHENEY-73', '男', '9876.5', '2022-04-18 15:09:06', '2022-04-18 15:08:12', '0');
INSERT INTO `tab_teacher` VALUES ('25', 'CHENEY-62', '女', '9876.5', '2022-04-18 15:08:12', '2022-04-18 15:08:12', '0');
INSERT INTO `tab_teacher` VALUES ('26', 'CHENEY-4', '女', '9876.5', '2022-04-18 15:08:13', '2022-04-18 15:08:13', '0');
INSERT INTO `tab_teacher` VALUES ('27', 'CHENEY-51', '女', '9876.5', '2022-04-18 15:08:16', '2022-04-18 15:08:16', '0');
INSERT INTO `tab_teacher` VALUES ('28', 'CHENEY-82', '女', '9876.5', '2022-04-18 15:08:17', '2022-04-18 15:08:17', '0');
INSERT INTO `tab_teacher` VALUES ('29', 'CHENEY-68', '女', '9876.5', '2022-04-18 15:08:17', '2022-04-18 15:08:17', '0');
INSERT INTO `tab_teacher` VALUES ('30', 'CHENEY-27', '女', '9876.5', '2022-04-18 15:08:18', '2022-04-18 15:08:18', '0');
INSERT INTO `tab_teacher` VALUES ('31', 'CHENEY-9', '女', '9876.5', '2022-04-18 15:08:20', '2022-04-18 15:08:20', '0');
INSERT INTO `tab_teacher` VALUES ('32', 'CHENEY-76', '女', '9876.5', '2022-04-18 15:08:20', '2022-04-18 15:08:20', '0');
INSERT INTO `tab_teacher` VALUES ('33', 'CHENEY-13', '女', '9876.5', '2022-04-18 15:08:21', '2022-04-18 15:08:21', '0');
INSERT INTO `tab_teacher` VALUES ('34', 'CHENEY-14', '女', '9876.5', '2022-04-18 15:08:22', '2022-04-18 15:08:22', '0');
INSERT INTO `tab_teacher` VALUES ('35', 'CHENEY-81', '女', '9876.5', '2022-04-18 15:08:22', '2022-04-18 15:08:22', '0');
INSERT INTO `tab_teacher` VALUES ('36', 'CHENEY-47', '女', '9876.5', '2022-04-18 15:08:23', '2022-04-18 15:08:23', '0');
INSERT INTO `tab_teacher` VALUES ('37', 'CHENEY-57', '女', '9876.5', '2022-04-18 15:08:23', '2022-04-18 15:08:23', '0');
INSERT INTO `tab_teacher` VALUES ('38', 'CHENEY-29', '女', '9876.5', '2022-04-18 15:08:24', '2022-04-18 15:08:24', '0');
INSERT INTO `tab_teacher` VALUES ('39', 'CHENEY-98', '女', '9876.5', '2022-04-18 15:08:24', '2022-04-18 15:08:24', '0');
INSERT INTO `tab_teacher` VALUES ('40', 'CHENEY-27', '女', '9876.5', '2022-04-18 15:08:26', '2022-04-18 15:08:26', '0');
INSERT INTO `tab_teacher` VALUES ('41', 'CHENEY-61', '女', '9876.5', '2022-04-18 15:08:27', '2022-04-18 15:08:27', '0');
INSERT INTO `tab_teacher` VALUES ('42', 'CHENEY-58', '女', '9876.5', '2022-04-18 15:08:37', '2022-04-18 15:08:37', '0');
INSERT INTO `tab_teacher` VALUES ('43', 'CHENEY-71', '女', '9876.5', '2022-04-18 15:08:38', '2022-04-18 15:08:38', '0');
INSERT INTO `tab_teacher` VALUES ('44', 'CHENEY-64', '女', '9876.5', '2022-04-18 15:08:38', '2022-04-18 15:08:38', '0');
INSERT INTO `tab_teacher` VALUES ('45', 'CHENEY-99', '女', '9876.5', '2022-04-18 15:08:38', '2022-04-18 15:08:38', '0');
INSERT INTO `tab_teacher` VALUES ('46', 'CHENEY-67', '女', '9876.5', '2022-04-18 15:08:39', '2022-04-18 15:08:39', '0');
INSERT INTO `tab_teacher` VALUES ('47', 'CHENEY-7', '女', '9876.5', '2022-04-18 15:08:39', '2022-04-18 15:08:39', '0');
INSERT INTO `tab_teacher` VALUES ('48', 'CHENEY-25', '女', '9876.5', '2022-04-18 15:08:40', '2022-04-18 15:08:40', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jone', '18', 'test1@baomidou.com');
INSERT INTO `user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com');
INSERT INTO `user` VALUES ('3', 'Tom', '28', 'test3@baomidou.com');
INSERT INTO `user` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com');
INSERT INTO `user` VALUES ('5', 'Billie', '24', 'test5@baomidou.com');
