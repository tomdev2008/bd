/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : bd_weixin

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2014-05-12 22:59:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bd_abs_tx_name`
-- ----------------------------
DROP TABLE IF EXISTS `bd_abs_tx_name`;
CREATE TABLE `bd_abs_tx_name` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_abs_tx_name
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_account_position`
-- ----------------------------
DROP TABLE IF EXISTS `bd_account_position`;
CREATE TABLE `bd_account_position` (
  `positionid` varchar(32) NOT NULL DEFAULT '',
  `accountid` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_account_position
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_position_authbtn`
-- ----------------------------
DROP TABLE IF EXISTS `bd_position_authbtn`;
CREATE TABLE `bd_position_authbtn` (
  `positionid` varchar(32) NOT NULL DEFAULT '',
  `buttonid` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`buttonid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_position_authbtn
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_position_authcolumn`
-- ----------------------------
DROP TABLE IF EXISTS `bd_position_authcolumn`;
CREATE TABLE `bd_position_authcolumn` (
  `positionid` varchar(32) NOT NULL DEFAULT '',
  `columnid` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`columnid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_position_authcolumn
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_position_authmenu`
-- ----------------------------
DROP TABLE IF EXISTS `bd_position_authmenu`;
CREATE TABLE `bd_position_authmenu` (
  `positionid` varchar(32) NOT NULL DEFAULT '',
  `menuid` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_position_authmenu
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_position_authrow`
-- ----------------------------
DROP TABLE IF EXISTS `bd_position_authrow`;
CREATE TABLE `bd_position_authrow` (
  `positionid` varchar(32) NOT NULL DEFAULT '',
  `rowid` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`rowid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_position_authrow
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_account`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_account`;
CREATE TABLE `bd_sys_account` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `loginname` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `userid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_account
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_auth_btn`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_btn`;
CREATE TABLE `bd_sys_auth_btn` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(128) DEFAULT NULL,
  `catalogid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_btn
-- ----------------------------
INSERT INTO `bd_sys_auth_btn` VALUES ('402881e545f0ed6c0145f0ed71450001', '添加用户按钮', '0', '1', 'SysAccount:Add', '402881e545f0ed6c0145f0ed70dd0000');

-- ----------------------------
-- Table structure for `bd_sys_auth_btn_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_btn_catalog`;
CREATE TABLE `bd_sys_auth_btn_catalog` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_btn_catalog
-- ----------------------------
INSERT INTO `bd_sys_auth_btn_catalog` VALUES ('402881e545f0ed6c0145f0ed70dd0000', '系统按钮', '0', '1', '');

-- ----------------------------
-- Table structure for `bd_sys_auth_column`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_column`;
CREATE TABLE `bd_sys_auth_column` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(128) DEFAULT NULL,
  `catalogid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_column
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_auth_column_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_column_catalog`;
CREATE TABLE `bd_sys_auth_column_catalog` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_column_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_auth_menu`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_menu`;
CREATE TABLE `bd_sys_auth_menu` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(256) DEFAULT NULL,
  `catalogid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_auth_menu_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_menu_catalog`;
CREATE TABLE `bd_sys_auth_menu_catalog` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_menu_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_auth_row`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_row`;
CREATE TABLE `bd_sys_auth_row` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(256) DEFAULT NULL,
  `catalogid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_row
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_auth_row_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_row_catalog`;
CREATE TABLE `bd_sys_auth_row_catalog` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_row_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_organization`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_organization`;
CREATE TABLE `bd_sys_organization` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(32) DEFAULT NULL,
  `principalid` varchar(32) DEFAULT NULL,
  `orglevel` int(11) DEFAULT NULL,
  `secretkey` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_organization
-- ----------------------------
INSERT INTO `bd_sys_organization` VALUES ('8a83b6b145dec0d60145dec0d8f40000', '绵阳科技城大数据技术有限公司', '0', '1', '0', '', '10', '');

-- ----------------------------
-- Table structure for `bd_sys_position`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_position`;
CREATE TABLE `bd_sys_position` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `orgid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_position
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_user`;
CREATE TABLE `bd_sys_user` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `userid` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_user
-- ----------------------------
