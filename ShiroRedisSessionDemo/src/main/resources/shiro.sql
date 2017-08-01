/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2017-07-31 16:05:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
-- DROP TABLE IF EXISTS `sys_permission`;
-- CREATE TABLE `sys_permission` (
--   `permission_id` bigint(20) NOT NULL auto_increment,
--   `available` bit(1) default NULL,
--   `name` varchar(255) default NULL,
--   `parent_id` bigint(20) default NULL,
--   `parent_ids` varchar(255) default NULL,
--   `permission` varchar(255) default NULL,
--   `resource_type` enum('menu','button') default NULL,
--   `url` varchar(255) default NULL,
--   PRIMARY KEY  (`permission_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '', '用户管理', '0', '0/', 'userInfo:view', 'menu', 'userInfo/userList');
INSERT INTO `sys_permission` VALUES ('2', '', '用户添加', '1', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `sys_permission` VALUES ('3', '', '用户删除', '1', '0/1', 'userInfo:del', 'button', 'userInfo/userDel');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
-- DROP TABLE IF EXISTS `sys_role`;
-- CREATE TABLE `sys_role` (
--   `role_id` bigint(20) NOT NULL auto_increment,
--   `available` bit(1) default NULL,
--   `description` varchar(255) default NULL,
--   `role` varchar(255) default NULL,
--   PRIMARY KEY  (`role_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('2', '', 'VIP会员', 'vip');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
-- DROP TABLE IF EXISTS `sys_role_permission`;
-- CREATE TABLE `sys_role_permission` (
--   `role_id` bigint(20) NOT NULL,
--   `permission_id` bigint(20) NOT NULL,
--   KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`),
--   KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`),
--   CONSTRAINT `FK9q28ewrhntqeipl1t04kh1be7` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
--   CONSTRAINT `FKomxrs8a388bknvhjokh440waq` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`permission_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
-- DROP TABLE IF EXISTS `sys_user_role`;
-- CREATE TABLE `sys_user_role` (
--   `uid` bigint(20) NOT NULL,
--   `role_id` bigint(20) NOT NULL,
--   KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
--   KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`uid`),
--   CONSTRAINT `FKgkmyslkrfeyn9ukmolvek8b8f` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`),
--   CONSTRAINT `FKhh52n8vd4ny9ff4x9fb8v65qx` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
-- DROP TABLE IF EXISTS `user_info`;
-- CREATE TABLE `user_info` (
--   `uid` bigint(20) NOT NULL auto_increment,
--   `name` varchar(255) default NULL,
--   `password` varchar(255) default NULL,
--   `salt` varchar(255) default NULL,
--   `state` tinyint(4) NOT NULL,
--   `username` varchar(255) default NULL,
--   PRIMARY KEY  (`uid`),
--   UNIQUE KEY `UK_f2ksd6h8hsjtd57ipfq9myr64` (`username`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0', 'admin');
