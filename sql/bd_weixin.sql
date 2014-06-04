/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : bd_weixin

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2014-06-04 21:43:59
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
-- Table structure for `bd_social_bind`
-- ----------------------------
DROP TABLE IF EXISTS `bd_social_bind`;
CREATE TABLE `bd_social_bind` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `bindtype` varchar(32) DEFAULT NULL,
  `openid` varchar(96) DEFAULT NULL,
  `accountid` varchar(32) DEFAULT NULL,
  `binddate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_social_bind
-- ----------------------------
INSERT INTO `bd_social_bind` VALUES ('402883824643592f0146435c3c140001', '0', '1', 'wechat', 'o0X10uJT99Xk31wx4M7iPdLP0q4c', '8a83b6b14641fc5c014641fcc4a20000', '2014-05-28 23:04:17');
INSERT INTO `bd_social_bind` VALUES ('4028838345fff17c0145fff1a3b80000', '0', '1', 'wechat', '01', 'admin', '2014-05-15 20:53:17');
INSERT INTO `bd_social_bind` VALUES ('40288385460f621001460f62ba850000', '0', '1', 'wechat', '01', 'admin', '2014-05-18 20:51:07');
INSERT INTO `bd_social_bind` VALUES ('40288385460f621001460f62c9020001', '0', '1', 'wechat', '01', 'admin', '2014-05-18 20:51:11');
INSERT INTO `bd_social_bind` VALUES ('40288385460f621001460f62d5610002', '0', '1', 'wechat', '01', 'admin', '2014-05-18 20:51:14');

-- ----------------------------
-- Table structure for `bd_social_wechat_message`
-- ----------------------------
DROP TABLE IF EXISTS `bd_social_wechat_message`;
CREATE TABLE `bd_social_wechat_message` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `openid` varchar(128) DEFAULT NULL,
  `userid` varchar(32) DEFAULT NULL,
  `indate` datetime DEFAULT NULL,
  `inmessage` text,
  `inmessagetype` varchar(12) DEFAULT NULL,
  `outmessage` text,
  `outmessagetype` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_social_wechat_message
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
  `salt` varchar(64) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `userid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_account
-- ----------------------------
INSERT INTO `bd_sys_account` VALUES ('01', '系统管理员', '0', '1', 'admin', '0b1ed08adacc1110', 'e1f49c1eb6046d5595c6c3f0beee35ade18186e2', '01');
INSERT INTO `bd_sys_account` VALUES ('8a83b6b14641fc5c014641fcc4a20000', '测试', '0', '1', '2014052801', '632dd97bbef16325', '1efa673c0b1cacbf5143f4ce41fed012f6925630', '8a83b6b14641db3e014641e2727f0000');

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
  `menutype` int(11) DEFAULT NULL,
  `value` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_auth_menu
-- ----------------------------
INSERT INTO `bd_sys_auth_menu` VALUES ('00101', '管理员工信息', '1', '1', 'menu:manage:sysuser', '001', '1', './static/core/user/IndexView');
INSERT INTO `bd_sys_auth_menu` VALUES ('00102', '管理操作用户信息', '1', '1', 'menu:manage:sysaccount', '001', '1', './static/core/account/IndexView');
INSERT INTO `bd_sys_auth_menu` VALUES ('09001', '报表仓库', '1', '1', 'menu:reporter:designer', '001', '1', './static/data/designer/IndexView');

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
INSERT INTO `bd_sys_auth_menu_catalog` VALUES ('001', '权限管理', '1', '1', null);
INSERT INTO `bd_sys_auth_menu_catalog` VALUES ('090', '报表设计工具', '1', '1', null);

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
-- Table structure for `bd_sys_property`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_property`;
CREATE TABLE `bd_sys_property` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `propertyname` varchar(128) DEFAULT NULL,
  `propertyvalue` varchar(128) DEFAULT NULL,
  `appid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_property
-- ----------------------------

-- ----------------------------
-- Table structure for `bd_sys_region`
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_region`;
CREATE TABLE `bd_sys_region` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `postcode` varchar(32) DEFAULT NULL,
  `parentid` varchar(32) DEFAULT NULL,
  `regionlevel` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_region
-- ----------------------------
INSERT INTO `bd_sys_region` VALUES ('0', '世界', '1', '1', '000000', '', 'world');

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
  `address` text,
  `regionid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_sys_user
-- ----------------------------
INSERT INTO `bd_sys_user` VALUES ('01', 'admin', '1', '1', 'admin', 'yao.qi@changhong.com', '0816888888', '你猜', '0');
INSERT INTO `bd_sys_user` VALUES ('8a83b6b1463b248701463b248c940000', '漆尧', '0', '1', '20148815', 'yao.qi@changhong.com', '18628209093', '游仙区桑林坝8号', '0');
INSERT INTO `bd_sys_user` VALUES ('8a83b6b14641db3e014641e2727f0000', '测试', '0', '1', '2014052801', 'yao.qi@changhong.com', '186', '地址', '0');

-- ----------------------------
-- Table structure for `data_data_ele`
-- ----------------------------
DROP TABLE IF EXISTS `data_data_ele`;
CREATE TABLE `data_data_ele` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `groupid` varchar(32) DEFAULT NULL,
  `tablecatalog` varchar(128) DEFAULT NULL,
  `columnclassname` varchar(128) DEFAULT NULL,
  `columndisplaysize` int(11) DEFAULT NULL,
  `columnlabel` varchar(128) DEFAULT NULL,
  `columnname` varchar(128) DEFAULT NULL,
  `columntype` int(11) DEFAULT NULL,
  `columntypename` varchar(128) DEFAULT NULL,
  `precision` int(11) DEFAULT NULL,
  `scale` int(11) DEFAULT NULL,
  `tableschema` varchar(128) DEFAULT NULL,
  `tablename` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_data_ele
-- ----------------------------

-- ----------------------------
-- Table structure for `data_data_ele_group`
-- ----------------------------
DROP TABLE IF EXISTS `data_data_ele_group`;
CREATE TABLE `data_data_ele_group` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `repid` varchar(32) DEFAULT NULL,
  `processlanguage` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_data_ele_group
-- ----------------------------

-- ----------------------------
-- Table structure for `data_repository`
-- ----------------------------
DROP TABLE IF EXISTS `data_repository`;
CREATE TABLE `data_repository` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `rep_driver` varchar(96) DEFAULT NULL,
  `rep_url` varchar(256) DEFAULT NULL,
  `rep_username` varchar(32) DEFAULT NULL,
  `rep_password` varchar(128) DEFAULT NULL,
  `rep_schema` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_repository
-- ----------------------------
INSERT INTO `data_repository` VALUES ('01', '本地Mysql', '1', '1', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/bd_weixin?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true', 'tony', '123456', 'bd_wexin');
