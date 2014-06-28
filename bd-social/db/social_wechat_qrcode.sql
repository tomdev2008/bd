/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : bd_weixin

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-06-28 14:47:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `social_wechat_qrcode`
-- ----------------------------
DROP TABLE IF EXISTS `social_wechat_qrcode`;
CREATE TABLE `social_wechat_qrcode` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `codetype` varchar(128) DEFAULT NULL,
  `codeinfo` varchar(256) DEFAULT NULL,
  `wechatopenid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of social_wechat_qrcode
-- ----------------------------
