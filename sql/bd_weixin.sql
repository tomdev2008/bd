/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : bd_weixin

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-07-08 23:41:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bd_abs_tx_name
-- ----------------------------
DROP TABLE IF EXISTS `bd_abs_tx_name`;
CREATE TABLE `bd_abs_tx_name` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='超类：事务/名称';

-- ----------------------------
-- Records of bd_abs_tx_name
-- ----------------------------

-- ----------------------------
-- Table structure for bd_account_position
-- ----------------------------
DROP TABLE IF EXISTS `bd_account_position`;
CREATE TABLE `bd_account_position` (
  `positionid` varchar(42) NOT NULL DEFAULT '',
  `accountid` varchar(42) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作用户职位关系表';

-- ----------------------------
-- Records of bd_account_position
-- ----------------------------

-- ----------------------------
-- Table structure for bd_position_authbtn
-- ----------------------------
DROP TABLE IF EXISTS `bd_position_authbtn`;
CREATE TABLE `bd_position_authbtn` (
  `positionid` varchar(42) NOT NULL DEFAULT '',
  `buttonid` varchar(42) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`buttonid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位权限按钮关系表';

-- ----------------------------
-- Records of bd_position_authbtn
-- ----------------------------

-- ----------------------------
-- Table structure for bd_position_authcolumn
-- ----------------------------
DROP TABLE IF EXISTS `bd_position_authcolumn`;
CREATE TABLE `bd_position_authcolumn` (
  `positionid` varchar(42) NOT NULL DEFAULT '',
  `columnid` varchar(42) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`columnid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位权限列关系表';

-- ----------------------------
-- Records of bd_position_authcolumn
-- ----------------------------

-- ----------------------------
-- Table structure for bd_position_authmenu
-- ----------------------------
DROP TABLE IF EXISTS `bd_position_authmenu`;
CREATE TABLE `bd_position_authmenu` (
  `positionid` varchar(42) NOT NULL DEFAULT '',
  `menuid` varchar(42) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位权限菜单关系表';

-- ----------------------------
-- Records of bd_position_authmenu
-- ----------------------------

-- ----------------------------
-- Table structure for bd_position_authrow
-- ----------------------------
DROP TABLE IF EXISTS `bd_position_authrow`;
CREATE TABLE `bd_position_authrow` (
  `positionid` varchar(42) NOT NULL DEFAULT '',
  `rowid` varchar(42) NOT NULL DEFAULT '',
  PRIMARY KEY (`positionid`,`rowid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位权限行关系表';

-- ----------------------------
-- Records of bd_position_authrow
-- ----------------------------

-- ----------------------------
-- Table structure for bd_sys_account
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
  `userid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作用户';

-- ----------------------------
-- Records of bd_sys_account
-- ----------------------------
INSERT INTO `bd_sys_account` VALUES ('01', '系统管理员', '0', '1', 'admin', '0b1ed08adacc1110', 'e1f49c1eb6046d5595c6c3f0beee35ade18186e2', '01');
INSERT INTO `bd_sys_account` VALUES ('8a83b6b14641fc5c014641fcc4a20000', '测试', '0', '1', '2014052801', '632dd97bbef16325', '1efa673c0b1cacbf5143f4ce41fed012f6925630', '8a83b6b14641db3e014641e2727f0000');

-- ----------------------------
-- Table structure for bd_sys_auth_btn
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_btn`;
CREATE TABLE `bd_sys_auth_btn` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(128) DEFAULT NULL,
  `catalogid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限按钮';

-- ----------------------------
-- Records of bd_sys_auth_btn
-- ----------------------------
INSERT INTO `bd_sys_auth_btn` VALUES ('402881e545f0ed6c0145f0ed71450001', '添加用户按钮', '0', '1', 'SysAccount:Add', '402881e545f0ed6c0145f0ed70dd0000');

-- ----------------------------
-- Table structure for bd_sys_auth_btn_catalog
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_btn_catalog`;
CREATE TABLE `bd_sys_auth_btn_catalog` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限按钮目录';

-- ----------------------------
-- Records of bd_sys_auth_btn_catalog
-- ----------------------------
INSERT INTO `bd_sys_auth_btn_catalog` VALUES ('402881e545f0ed6c0145f0ed70dd0000', '系统按钮', '0', '1', '');

-- ----------------------------
-- Table structure for bd_sys_auth_column
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_column`;
CREATE TABLE `bd_sys_auth_column` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(128) DEFAULT NULL,
  `catalogid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限列';

-- ----------------------------
-- Records of bd_sys_auth_column
-- ----------------------------

-- ----------------------------
-- Table structure for bd_sys_auth_column_catalog
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_column_catalog`;
CREATE TABLE `bd_sys_auth_column_catalog` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限列目录';

-- ----------------------------
-- Records of bd_sys_auth_column_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for bd_sys_auth_menu
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_menu`;
CREATE TABLE `bd_sys_auth_menu` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(256) DEFAULT NULL,
  `catalogid` varchar(42) DEFAULT NULL,
  `menutype` int(11) DEFAULT NULL,
  `value` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单';

-- ----------------------------
-- Records of bd_sys_auth_menu
-- ----------------------------
INSERT INTO `bd_sys_auth_menu` VALUES ('00101', '管理员工信息', '1', '1', 'menu:manage:sysuser', '001', '1', './static/core/user/IndexView');
INSERT INTO `bd_sys_auth_menu` VALUES ('00102', '管理操作用户信息', '1', '1', 'menu:manage:sysaccount', '001', '1', './static/core/account/IndexView');
INSERT INTO `bd_sys_auth_menu` VALUES ('09001', '数据仓库', '1', '1', 'menu:data:repository', '090', '1', './static/data/repository/IndexView');
INSERT INTO `bd_sys_auth_menu` VALUES ('09002', '数据元素设计', '1', '1', 'menu:data:datagroup', '090', '1', './static/data/datagroup/IndexView');
INSERT INTO `bd_sys_auth_menu` VALUES ('09003', '图形报表仓库', '1', '1', 'menu:data:grahdesigner', '090', '1', './static/data/graphreporter/IndexView');

-- ----------------------------
-- Table structure for bd_sys_auth_menu_catalog
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_menu_catalog`;
CREATE TABLE `bd_sys_auth_menu_catalog` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单目录';

-- ----------------------------
-- Records of bd_sys_auth_menu_catalog
-- ----------------------------
INSERT INTO `bd_sys_auth_menu_catalog` VALUES ('001', '权限管理', '1', '1', null);
INSERT INTO `bd_sys_auth_menu_catalog` VALUES ('090', '报表设计工具', '1', '1', null);

-- ----------------------------
-- Table structure for bd_sys_auth_row
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_row`;
CREATE TABLE `bd_sys_auth_row` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `code` varchar(256) DEFAULT NULL,
  `catalogid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限行';

-- ----------------------------
-- Records of bd_sys_auth_row
-- ----------------------------

-- ----------------------------
-- Table structure for bd_sys_auth_row_catalog
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_auth_row_catalog`;
CREATE TABLE `bd_sys_auth_row_catalog` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限行目录';

-- ----------------------------
-- Records of bd_sys_auth_row_catalog
-- ----------------------------

-- ----------------------------
-- Table structure for bd_sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_organization`;
CREATE TABLE `bd_sys_organization` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `parentid` varchar(42) DEFAULT NULL,
  `principalid` varchar(42) DEFAULT NULL,
  `orglevel` int(11) DEFAULT NULL,
  `secretkey` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织架构';

-- ----------------------------
-- Records of bd_sys_organization
-- ----------------------------
INSERT INTO `bd_sys_organization` VALUES ('8a83b6b145dec0d60145dec0d8f40000', '绵阳科技城大数据技术有限公司', '0', '1', '0', '', '10', '');

-- ----------------------------
-- Table structure for bd_sys_position
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_position`;
CREATE TABLE `bd_sys_position` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `orgid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位';

-- ----------------------------
-- Records of bd_sys_position
-- ----------------------------

-- ----------------------------
-- Table structure for bd_sys_property
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统属性';

-- ----------------------------
-- Records of bd_sys_property
-- ----------------------------
INSERT INTO `bd_sys_property` VALUES ('01', '长虹微信AK', '1', '1', 'wechatak', 'wx2b2e75b10999bc54', 'chspider');
INSERT INTO `bd_sys_property` VALUES ('02', '长虹微信SK', '1', '1', 'wechatsk', '5b5220e01c92d2a8c39d1e687988b75e', 'chspider');
INSERT INTO `bd_sys_property` VALUES ('03', '多滋味测试微信AK', '1', '1', 'wechatak', 'wxb0b753bbd3269940', 'lotaste');
INSERT INTO `bd_sys_property` VALUES ('04', '多滋味测试微信SK', '1', '1', 'wechatsk', 'fc7d2ee5029b0e4a995ed8e4314d1d56', 'lotaste');
INSERT INTO `bd_sys_property` VALUES ('05', '多滋味BAEAK', '1', '1', 'baeak', 'AmlXySaIBwQFzRi35tAMIaq6', 'lotaste');
INSERT INTO `bd_sys_property` VALUES ('06', '多滋味BAESK', '1', '1', 'baesk', 'Um0VoGl8LNZKykcWBqq6T54F0ov4cUqm', 'lotaste');

-- ----------------------------
-- Table structure for bd_sys_region
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_region`;
CREATE TABLE `bd_sys_region` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `postcode` varchar(42) DEFAULT NULL,
  `parentid` varchar(42) DEFAULT NULL,
  `regionlevel` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通用地区';

-- ----------------------------
-- Records of bd_sys_region
-- ----------------------------
INSERT INTO `bd_sys_region` VALUES ('0', '世界', '1', '1', '000000', '', 'world');

-- ----------------------------
-- Table structure for bd_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `bd_sys_user`;
CREATE TABLE `bd_sys_user` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `userid` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(42) DEFAULT NULL,
  `address` text,
  `regionid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息';

-- ----------------------------
-- Records of bd_sys_user
-- ----------------------------
INSERT INTO `bd_sys_user` VALUES ('01', 'admin', '1', '1', 'admin', 'yao.qi@changhong.com', '0816888888', '你猜', '0');
INSERT INTO `bd_sys_user` VALUES ('8a83b6b1463b248701463b248c940000', '漆尧', '0', '1', '20148815', 'yao.qi@changhong.com', '18628209093', '游仙区桑林坝8号', '0');
INSERT INTO `bd_sys_user` VALUES ('8a83b6b14641db3e014641e2727f0000', '测试', '0', '1', '2014052801', 'yao.qi@changhong.com', '186', '地址', '0');

-- ----------------------------
-- Table structure for chiq_watch_time_analy
-- ----------------------------
DROP TABLE IF EXISTS `chiq_watch_time_analy`;
CREATE TABLE `chiq_watch_time_analy` (
  `time` varchar(50) DEFAULT NULL COMMENT '对应时间',
  `category` varchar(50) DEFAULT NULL COMMENT '分类(分类看、带走看、多屏看、总时长）',
  `contain_store_tv` int(1) DEFAULT NULL COMMENT '是否包含卖场机（0、1）',
  `modes` varchar(50) DEFAULT NULL COMMENT '统计方式：按（月、周、天）',
  `content` bigint(100) DEFAULT NULL COMMENT '时长（单位s)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录更新时间',
  KEY `index_category` (`category`),
  KEY `index_mode` (`modes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chiq_watch_time_analy
-- ----------------------------
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-02', '分类看', '1', 'daily', '22', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-02', '多屏看', '1', 'daily', '118', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-02', '带走看', '1', 'daily', '4535', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-03', '分类看', '1', 'daily', '4', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-03', '带走看', '1', 'daily', '103', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-04', '分类看', '1', 'daily', '33', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-04', '带走看', '1', 'daily', '232', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-06', '分类看', '1', 'daily', '8', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-11', '多屏看', '1', 'daily', '85', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01-11', '带走看', '1', 'daily', '17', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-02-02', '带走看', '1', 'daily', '184', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-06', '分类看', '1', 'daily', '778', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-06', '带走看', '1', 'daily', '2979', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-07', '带走看', '1', 'daily', '25', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-10', '分类看', '1', 'daily', '14', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-10', '带走看', '1', 'daily', '1100', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-11', '带走看', '1', 'daily', '296', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-12', '带走看', '1', 'daily', '30', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-13', '带走看', '1', 'daily', '249', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-15', '分类看', '1', 'daily', '4', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-15', '带走看', '1', 'daily', '234', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01-16', '带走看', '1', 'daily', '298', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2000-01-01', '分类看', '1', 'daily', '277', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2000-01-01', '带走看', '1', 'daily', '431', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2000-01-03', '分类看', '1', 'daily', '1', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2000-01-03', '带走看', '1', 'daily', '25', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2000-01-23', '分类看', '1', 'daily', '156', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2000-01-23', '带走看', '1', 'daily', '21', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2001-06-07', '带走看', '1', 'daily', '33', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2004-05-15', '带走看', '1', 'daily', '175', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2004-05-18', '带走看', '1', 'daily', '167', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2004-05-19', '分类看', '1', 'daily', '1', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2004-05-19', '带走看', '1', 'daily', '105', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2009-01-06', '带走看', '1', 'daily', '670', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2009-01-14', '分类看', '1', 'daily', '211', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2009-01-14', '带走看', '1', 'daily', '457', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2009-01-17', '带走看', '1', 'daily', '455', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-01', '分类看', '1', 'daily', '14', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-01', '多屏看', '1', 'daily', '14', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-01', '带走看', '1', 'daily', '722', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-02', '分类看', '1', 'daily', '4', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-02', '带走看', '1', 'daily', '407', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-04', '带走看', '1', 'daily', '22', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-05', '分类看', '1', 'daily', '23', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-05', '带走看', '1', 'daily', '6', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-07', '分类看', '1', 'daily', '100', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-10', '分类看', '1', 'daily', '583', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-10', '带走看', '1', 'daily', '54', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-12', '带走看', '1', 'daily', '567', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-13', '分类看', '1', 'daily', '96', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-13', '带走看', '1', 'daily', '126', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-15', '带走看', '1', 'daily', '840', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-17', '带走看', '1', 'daily', '916', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-18', '带走看', '1', 'daily', '173', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-19', '带走看', '1', 'daily', '1980', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01-20', '带走看', '1', 'daily', '56', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-01-02', '分类看', '1', 'daily', '68', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-01-02', '带走看', '1', 'daily', '86', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-01-04', '分类看', '1', 'daily', '39', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-01-04', '多屏看', '1', 'daily', '503', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-01-04', '带走看', '1', 'daily', '27', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-03-15', '分类看', '1', 'daily', '12', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-03-15', '带走看', '1', 'daily', '1138', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-01-01', '分类看', '1', 'daily', '113', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-01-01', '多屏看', '1', 'daily', '11', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-01-01', '带走看', '1', 'daily', '3938', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-01-02', '分类看', '1', 'daily', '280', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-01-02', '带走看', '1', 'daily', '3317', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-04-09', '分类看', '1', 'daily', '55', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-04-09', '多屏看', '1', 'daily', '318', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-04-09', '带走看', '1', 'daily', '2522', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-06-01', '分类看', '1', 'daily', '26', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-06-06', '带走看', '1', 'daily', '205', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07-01', '分类看', '1', 'daily', '47', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07-01', '多屏看', '1', 'daily', '1708', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07-01', '带走看', '1', 'daily', '947', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07-16', '分类看', '1', 'daily', '4', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07-16', '多屏看', '1', 'daily', '20', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07-16', '带走看', '1', 'daily', '292', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-01-01', '分类看', '1', 'daily', '42', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-01-01', '带走看', '1', 'daily', '180', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-01-02', '分类看', '1', 'daily', '2', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-01-02', '带走看', '1', 'daily', '23', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-01-13', '分类看', '1', 'daily', '179', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-04-24', '带走看', '1', 'daily', '139', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-04-25', '带走看', '1', 'daily', '514', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-04-27', '分类看', '1', 'daily', '17', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-04-27', '带走看', '1', 'daily', '26', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-05-02', '多屏看', '1', 'daily', '203', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-05-02', '带走看', '1', 'daily', '54', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-06-02', '分类看', '1', 'daily', '76', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-06-02', '多屏看', '1', 'daily', '18', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-06-02', '带走看', '1', 'daily', '55', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-08-30', '分类看', '1', 'daily', '13', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-08-30', '带走看', '1', 'daily', '244', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-08-31', '分类看', '1', 'daily', '198', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-08-31', '带走看', '1', 'daily', '436', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-11-20', '带走看', '1', 'daily', '3', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-01-18', '分类看', '1', 'daily', '8', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-01-18', '多屏看', '1', 'daily', '51', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-01-18', '带走看', '1', 'daily', '655', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-03-24', '多屏看', '1', 'daily', '40', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-03-30', '分类看', '1', 'daily', '248', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-03-30', '带走看', '1', 'daily', '10', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-03', '带走看', '1', 'daily', '33', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-04', '分类看', '1', 'daily', '46', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-04', '带走看', '1', 'daily', '14', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-09', '多屏看', '1', 'daily', '121', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-09', '带走看', '1', 'daily', '44', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-16', '分类看', '0', 'daily', '254', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-16', '分类看', '1', 'daily', '251', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-16', '多屏看', '0', 'daily', '7', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-16', '多屏看', '1', 'daily', '7', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-16', '带走看', '0', 'daily', '9', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-16', '带走看', '1', 'daily', '625', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-17', '分类看', '1', 'daily', '485', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-17', '多屏看', '1', 'daily', '870', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-17', '带走看', '1', 'daily', '18076', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-18', '分类看', '1', 'daily', '977', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-18', '多屏看', '1', 'daily', '35', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-18', '带走看', '1', 'daily', '405', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-19', '分类看', '1', 'daily', '15313', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-19', '多屏看', '1', 'daily', '2853', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-19', '带走看', '1', 'daily', '44213', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-20', '分类看', '1', 'daily', '26829', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-20', '多屏看', '1', 'daily', '7192', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-20', '带走看', '1', 'daily', '75067', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-21', '分类看', '1', 'daily', '13574', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-21', '多屏看', '1', 'daily', '7418', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-21', '带走看', '1', 'daily', '61864', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-22', '分类看', '1', 'daily', '41282', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-22', '多屏看', '1', 'daily', '17773', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-22', '带走看', '1', 'daily', '173712', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-23', '分类看', '1', 'daily', '43470', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-23', '多屏看', '1', 'daily', '19541', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-23', '带走看', '0', 'daily', '6', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-23', '带走看', '1', 'daily', '167581', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-24', '分类看', '1', 'daily', '56697', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-24', '多屏看', '1', 'daily', '19956', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-24', '带走看', '1', 'daily', '166019', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-25', '分类看', '1', 'daily', '79720', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-25', '多屏看', '1', 'daily', '27137', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-25', '带走看', '1', 'daily', '233057', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-26', '分类看', '0', 'daily', '29', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-26', '分类看', '1', 'daily', '110582', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-26', '多屏看', '1', 'daily', '49866', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-26', '带走看', '0', 'daily', '68', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-26', '带走看', '1', 'daily', '333917', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-27', '分类看', '1', 'daily', '96214', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-27', '多屏看', '1', 'daily', '55803', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-27', '带走看', '1', 'daily', '357524', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-28', '分类看', '1', 'daily', '99067', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-28', '多屏看', '1', 'daily', '39317', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-28', '带走看', '1', 'daily', '213091', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-29', '分类看', '1', 'daily', '115016', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-29', '多屏看', '1', 'daily', '44819', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-29', '带走看', '0', 'daily', '21', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-29', '带走看', '1', 'daily', '321774', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-30', '分类看', '1', 'daily', '105386', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-30', '多屏看', '1', 'daily', '51586', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-30', '带走看', '0', 'daily', '283', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04-30', '带走看', '1', 'daily', '376748', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-01', '分类看', '0', 'daily', '44', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-01', '分类看', '1', 'daily', '166860', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-01', '多屏看', '1', 'daily', '73225', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-01', '带走看', '0', 'daily', '855', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-01', '带走看', '1', 'daily', '616148', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-02', '分类看', '0', 'daily', '175', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-02', '分类看', '1', 'daily', '122063', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-02', '多屏看', '0', 'daily', '83', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-02', '多屏看', '1', 'daily', '69068', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-02', '带走看', '0', 'daily', '643', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-02', '带走看', '1', 'daily', '514050', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-03', '分类看', '0', 'daily', '17', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-03', '分类看', '1', 'daily', '99840', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-03', '多屏看', '1', 'daily', '43919', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-03', '带走看', '0', 'daily', '180', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-03', '带走看', '1', 'daily', '443792', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-04', '分类看', '0', 'daily', '19', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-04', '分类看', '1', 'daily', '55151', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-04', '多屏看', '1', 'daily', '54625', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-04', '带走看', '0', 'daily', '115', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-04', '带走看', '1', 'daily', '214045', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-05', '分类看', '0', 'daily', '15', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-05', '分类看', '1', 'daily', '47130', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-05', '多屏看', '1', 'daily', '18826', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-05', '带走看', '0', 'daily', '627', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-05', '带走看', '1', 'daily', '231559', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-06', '分类看', '0', 'daily', '208', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-06', '分类看', '1', 'daily', '38924', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-06', '多屏看', '1', 'daily', '32170', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-06', '带走看', '0', 'daily', '31', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-06', '带走看', '1', 'daily', '182808', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-07', '分类看', '0', 'daily', '467', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-07', '分类看', '1', 'daily', '31539', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-07', '多屏看', '1', 'daily', '20543', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-07', '带走看', '0', 'daily', '121', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-07', '带走看', '1', 'daily', '188387', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-08', '分类看', '0', 'daily', '20', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-08', '分类看', '1', 'daily', '45293', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-08', '多屏看', '1', 'daily', '51953', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-08', '带走看', '0', 'daily', '25', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-08', '带走看', '1', 'daily', '186310', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-09', '分类看', '0', 'daily', '12', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-09', '分类看', '1', 'daily', '30485', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-09', '多屏看', '1', 'daily', '31031', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-09', '带走看', '0', 'daily', '71', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-09', '带走看', '1', 'daily', '227057', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-10', '分类看', '1', 'daily', '62951', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-10', '多屏看', '1', 'daily', '41924', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-10', '带走看', '0', 'daily', '162', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-10', '带走看', '1', 'daily', '231288', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-11', '分类看', '0', 'daily', '40', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-11', '分类看', '1', 'daily', '41614', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-11', '多屏看', '1', 'daily', '48534', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-11', '带走看', '0', 'daily', '88', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-11', '带走看', '1', 'daily', '263230', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-12', '分类看', '1', 'daily', '28495', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-12', '多屏看', '1', 'daily', '39410', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-12', '带走看', '1', 'daily', '189591', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-13', '分类看', '1', 'daily', '56231', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-13', '多屏看', '1', 'daily', '36478', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-13', '带走看', '0', 'daily', '104', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-13', '带走看', '1', 'daily', '219260', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-14', '分类看', '0', 'daily', '178', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-14', '分类看', '1', 'daily', '48889', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-14', '多屏看', '1', 'daily', '22086', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-14', '带走看', '0', 'daily', '10', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-14', '带走看', '1', 'daily', '249390', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-15', '分类看', '0', 'daily', '154', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-15', '分类看', '1', 'daily', '48519', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-15', '多屏看', '0', 'daily', '23', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-15', '多屏看', '1', 'daily', '73221', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-15', '带走看', '0', 'daily', '1311', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-15', '带走看', '1', 'daily', '216026', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-16', '分类看', '0', 'daily', '282', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-16', '分类看', '1', 'daily', '105042', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-16', '多屏看', '0', 'daily', '765', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-16', '多屏看', '1', 'daily', '80154', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-16', '带走看', '0', 'daily', '588', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-16', '带走看', '1', 'daily', '278882', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-17', '分类看', '1', 'daily', '64479', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-17', '多屏看', '1', 'daily', '47770', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-17', '带走看', '1', 'daily', '296294', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-18', '分类看', '0', 'daily', '125', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-18', '分类看', '1', 'daily', '81685', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-18', '多屏看', '1', 'daily', '44576', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-18', '带走看', '0', 'daily', '417', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-18', '带走看', '1', 'daily', '289582', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-19', '分类看', '1', 'daily', '43578', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-19', '多屏看', '1', 'daily', '25629', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-19', '带走看', '1', 'daily', '199676', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-20', '分类看', '1', 'daily', '50306', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-20', '多屏看', '1', 'daily', '30973', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-20', '带走看', '1', 'daily', '161745', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-21', '多屏看', '1', 'daily', '37', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-21', '带走看', '1', 'daily', '14', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-22', '带走看', '1', 'daily', '335', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-27', '带走看', '1', 'daily', '45', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-29', '分类看', '1', 'daily', '5', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-29', '带走看', '1', 'daily', '161', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05-30', '带走看', '1', 'daily', '95', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-06-01', '带走看', '1', 'daily', '70', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-06-03', '带走看', '1', 'daily', '240', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-06-13', '分类看', '1', 'daily', '1', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2015-05-01', '带走看', '1', 'daily', '81', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2015-05-02', '带走看', '1', 'daily', '80', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2015-05-30', '带走看', '1', 'daily', '45', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2018-02-05', '带走看', '1', 'daily', '71', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2034-04-29', '分类看', '1', 'daily', '106', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('2034-04-29', '带走看', '1', 'daily', '876', '2014-05-28 15:49:18', '2014-05-28 15:49:18');
INSERT INTO `chiq_watch_time_analy` VALUES ('19701', '分类看', '1', 'week', '59', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19701', '多屏看', '1', 'week', '118', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19701', '带走看', '1', 'week', '4870', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19702', '分类看', '1', 'week', '8', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19702', '多屏看', '1', 'week', '85', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19702', '带走看', '1', 'week', '17', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19706', '带走看', '1', 'week', '184', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19801', '分类看', '1', 'week', '778', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19801', '带走看', '1', 'week', '2979', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19802', '分类看', '1', 'week', '14', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19802', '带走看', '1', 'week', '1700', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19803', '分类看', '1', 'week', '4', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('19803', '带走看', '1', 'week', '532', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20001', '分类看', '1', 'week', '1', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20001', '带走看', '1', 'week', '25', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20003', '分类看', '1', 'week', '156', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20003', '带走看', '1', 'week', '21', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('200052', '分类看', '1', 'week', '277', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('200052', '带走看', '1', 'week', '431', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('200123', '带走看', '1', 'week', '33', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('200420', '带走看', '1', 'week', '175', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('200421', '分类看', '1', 'week', '1', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('200421', '带走看', '1', 'week', '272', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20092', '带走看', '1', 'week', '670', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20093', '分类看', '1', 'week', '211', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20093', '带走看', '1', 'week', '912', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20101', '分类看', '1', 'week', '706', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20101', '带走看', '1', 'week', '82', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20102', '分类看', '1', 'week', '96', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20102', '带走看', '1', 'week', '2449', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20103', '带走看', '1', 'week', '2209', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201053', '分类看', '1', 'week', '18', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201053', '多屏看', '1', 'week', '14', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201053', '带走看', '1', 'week', '1129', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20111', '分类看', '1', 'week', '39', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20111', '多屏看', '1', 'week', '503', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20111', '带走看', '1', 'week', '27', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201111', '分类看', '1', 'week', '12', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201111', '带走看', '1', 'week', '1138', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201152', '分类看', '1', 'week', '68', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201152', '带走看', '1', 'week', '86', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20121', '分类看', '1', 'week', '280', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20121', '带走看', '1', 'week', '3317', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201215', '分类看', '1', 'week', '55', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201215', '多屏看', '1', 'week', '318', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201215', '带走看', '1', 'week', '2522', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201222', '分类看', '1', 'week', '26', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201223', '带走看', '1', 'week', '205', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201226', '分类看', '1', 'week', '47', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201226', '多屏看', '1', 'week', '1708', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201226', '带走看', '1', 'week', '947', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201229', '分类看', '1', 'week', '4', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201229', '多屏看', '1', 'week', '20', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201229', '带走看', '1', 'week', '292', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201252', '分类看', '1', 'week', '113', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201252', '多屏看', '1', 'week', '11', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201252', '带走看', '1', 'week', '3938', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20131', '分类看', '1', 'week', '44', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20131', '带走看', '1', 'week', '203', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201317', '分类看', '1', 'week', '17', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201317', '带走看', '1', 'week', '679', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201318', '多屏看', '1', 'week', '203', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201318', '带走看', '1', 'week', '54', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20132', '分类看', '1', 'week', '179', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201322', '分类看', '1', 'week', '76', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201322', '多屏看', '1', 'week', '18', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201322', '带走看', '1', 'week', '55', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201335', '分类看', '1', 'week', '211', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201335', '带走看', '1', 'week', '680', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201347', '带走看', '1', 'week', '3', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201413', '分类看', '1', 'week', '248', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201413', '多屏看', '1', 'week', '40', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201413', '带走看', '1', 'week', '10', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201414', '分类看', '1', 'week', '46', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201414', '带走看', '1', 'week', '47', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201415', '多屏看', '1', 'week', '121', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201415', '带走看', '1', 'week', '44', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201416', '分类看', '0', 'week', '254', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201416', '分类看', '1', 'week', '43855', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201416', '多屏看', '0', 'week', '7', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201416', '多屏看', '1', 'week', '10957', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201416', '带走看', '0', 'week', '9', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201416', '带走看', '1', 'week', '138386', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201417', '分类看', '0', 'week', '29', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201417', '分类看', '1', 'week', '441539', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201417', '多屏看', '1', 'week', '715894', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201417', '带走看', '0', 'week', '74', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201417', '带走看', '1', 'week', '2249492', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201418', '分类看', '0', 'week', '255', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201418', '分类看', '1', 'week', '1406302', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201418', '多屏看', '0', 'week', '83', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201418', '多屏看', '1', 'week', '894959', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201418', '带走看', '0', 'week', '2097', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201418', '带走看', '1', 'week', '3781034', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201419', '分类看', '0', 'week', '762', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201419', '分类看', '1', 'week', '314366', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201419', '多屏看', '1', 'week', '391523', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201419', '带走看', '0', 'week', '1125', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201419', '带走看', '1', 'week', '2034801', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201420', '分类看', '0', 'week', '739', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201420', '分类看', '1', 'week', '477055', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201420', '多屏看', '0', 'week', '788', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201420', '多屏看', '1', 'week', '551374', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201420', '带走看', '0', 'week', '2430', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201420', '带走看', '1', 'week', '1765000', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201421', '分类看', '1', 'week', '93884', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201421', '多屏看', '1', 'week', '56639', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201421', '带走看', '1', 'week', '363082', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201422', '分类看', '1', 'week', '5', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201422', '带走看', '1', 'week', '371', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201423', '带走看', '1', 'week', '240', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201424', '分类看', '1', 'week', '1', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20143', '分类看', '1', 'week', '8', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20143', '多屏看', '1', 'week', '51', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20143', '带走看', '1', 'week', '655', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201518', '带走看', '1', 'week', '161', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('201522', '带走看', '1', 'week', '45', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('20186', '带走看', '1', 'week', '71', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('203417', '分类看', '1', 'week', '106', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('203417', '带走看', '1', 'week', '876', '2014-05-28 15:49:33', '2014-05-28 15:49:33');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01', '分类看', '1', 'month', '67', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01', '多屏看', '1', 'month', '203', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-01', '带走看', '1', 'month', '4887', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('1970-02', '带走看', '1', 'month', '184', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01', '分类看', '1', 'month', '796', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('1980-01', '带走看', '1', 'month', '5211', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2000-01', '分类看', '1', 'month', '434', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2000-01', '带走看', '1', 'month', '477', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2001-06', '带走看', '1', 'month', '33', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2004-05', '分类看', '1', 'month', '1', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2004-05', '带走看', '1', 'month', '447', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2009-01', '分类看', '1', 'month', '211', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2009-01', '带走看', '1', 'month', '1582', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01', '分类看', '1', 'month', '820', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01', '多屏看', '1', 'month', '14', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2010-01', '带走看', '1', 'month', '5869', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-01', '分类看', '1', 'month', '107', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-01', '多屏看', '1', 'month', '503', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-01', '带走看', '1', 'month', '113', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-03', '分类看', '1', 'month', '12', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2011-03', '带走看', '1', 'month', '1138', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-01', '分类看', '1', 'month', '393', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-01', '多屏看', '1', 'month', '11', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-01', '带走看', '1', 'month', '7255', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-04', '分类看', '1', 'month', '55', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-04', '多屏看', '1', 'month', '318', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-04', '带走看', '1', 'month', '2522', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-06', '分类看', '1', 'month', '26', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-06', '带走看', '1', 'month', '205', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07', '分类看', '1', 'month', '51', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07', '多屏看', '1', 'month', '1728', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2012-07', '带走看', '1', 'month', '1239', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-01', '分类看', '1', 'month', '223', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-01', '带走看', '1', 'month', '203', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-04', '分类看', '1', 'month', '17', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-04', '带走看', '1', 'month', '679', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-05', '多屏看', '1', 'month', '203', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-05', '带走看', '1', 'month', '54', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-06', '分类看', '1', 'month', '76', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-06', '多屏看', '1', 'month', '18', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-06', '带走看', '1', 'month', '55', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-08', '分类看', '1', 'month', '211', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-08', '带走看', '1', 'month', '680', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2013-11', '带走看', '1', 'month', '3', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-01', '分类看', '1', 'month', '8', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-01', '多屏看', '1', 'month', '51', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-01', '带走看', '1', 'month', '655', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-03', '分类看', '1', 'month', '248', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-03', '多屏看', '1', 'month', '40', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-03', '带走看', '1', 'month', '10', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04', '分类看', '0', 'month', '283', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04', '分类看', '1', 'month', '929428', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04', '多屏看', '0', 'month', '7', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04', '多屏看', '1', 'month', '482923', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04', '带走看', '0', 'month', '387', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-04', '带走看', '1', 'month', '2785125', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05', '分类看', '0', 'month', '1756', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05', '分类看', '1', 'month', '1330178', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05', '多屏看', '0', 'month', '871', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05', '多屏看', '1', 'month', '1240458', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05', '带走看', '0', 'month', '5348', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-05', '带走看', '1', 'month', '5443060', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-06', '分类看', '1', 'month', '1', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2014-06', '带走看', '1', 'month', '310', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2015-05', '带走看', '1', 'month', '206', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2018-02', '带走看', '1', 'month', '71', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2034-04', '分类看', '1', 'month', '106', '2014-05-28 15:49:50', '2014-05-28 15:49:50');
INSERT INTO `chiq_watch_time_analy` VALUES ('2034-04', '带走看', '1', 'month', '876', '2014-05-28 15:49:50', '2014-05-28 15:49:50');

-- ----------------------------
-- Table structure for data_data_ele
-- ----------------------------
DROP TABLE IF EXISTS `data_data_ele`;
CREATE TABLE `data_data_ele` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `groupid` varchar(42) DEFAULT NULL,
  `columnclassname` varchar(128) DEFAULT NULL,
  `columndisplaysize` int(11) DEFAULT NULL,
  `columnlabel` varchar(128) DEFAULT NULL,
  `columnname` varchar(128) DEFAULT NULL,
  `columntype` int(11) DEFAULT NULL,
  `columntypename` varchar(128) DEFAULT NULL,
  `columnprecision` int(11) DEFAULT NULL,
  `columnscale` int(11) DEFAULT NULL,
  `tableschema` varchar(128) DEFAULT NULL,
  `tablename` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据元素';

-- ----------------------------
-- Records of data_data_ele
-- ----------------------------
INSERT INTO `data_data_ele` VALUES ('8a83b6b14688a50f014688a516c00001', '', '0', '1', '8a83b6b14688a50f014688a516ae0000', 'java.lang.String', '50', '对应时间', 'time', '12', 'VARCHAR', '50', '0', '', 'chiq_watch_time_analy');
INSERT INTO `data_data_ele` VALUES ('8a83b6b14688a50f014688a516c00002', '', '0', '1', '8a83b6b14688a50f014688a516ae0000', 'java.lang.String', '50', '分类', 'category', '12', 'VARCHAR', '50', '0', '', 'chiq_watch_time_analy');
INSERT INTO `data_data_ele` VALUES ('8a83b6b14688a50f014688a516c10003', '', '0', '1', '8a83b6b14688a50f014688a516ae0000', 'java.lang.Integer', '1', 'contain_store_tv', 'contain_store_tv', '4', 'INT', '1', '0', '', 'chiq_watch_time_analy');
INSERT INTO `data_data_ele` VALUES ('8a83b6b14688a50f014688a516c10004', '', '0', '1', '8a83b6b14688a50f014688a516ae0000', 'java.lang.String', '50', '统计方式', 'modes', '12', 'VARCHAR', '50', '0', '', 'chiq_watch_time_analy');
INSERT INTO `data_data_ele` VALUES ('8a83b6b14688a50f014688a516c10005', '', '0', '1', '8a83b6b14688a50f014688a516ae0000', 'java.math.BigDecimal', '67', '时长(小时)', '时长(小时)', '3', 'DECIMAL', '65', '4', '', '');
INSERT INTO `data_data_ele` VALUES ('8a83b6b14688a50f014688a516c10006', '', '0', '1', '8a83b6b14688a50f014688a516ae0000', 'java.sql.Timestamp', '19', '创建时间', 'create_time', '93', 'TIMESTAMP', '19', '0', '', 'chiq_watch_time_analy');
INSERT INTO `data_data_ele` VALUES ('8a83b6b14688a50f014688a516c10007', '', '0', '1', '8a83b6b14688a50f014688a516ae0000', 'java.sql.Timestamp', '19', '更新时间', 'update_time', '93', 'TIMESTAMP', '19', '0', '', 'chiq_watch_time_analy');

-- ----------------------------
-- Table structure for data_data_ele_group
-- ----------------------------
DROP TABLE IF EXISTS `data_data_ele_group`;
CREATE TABLE `data_data_ele_group` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `repid` varchar(42) DEFAULT NULL,
  `processlanguage` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据元素集';

-- ----------------------------
-- Records of data_data_ele_group
-- ----------------------------
INSERT INTO `data_data_ele_group` VALUES ('8a83b6b14688a50f014688a516ae0000', 'CHiQ三看', '0', '1', '01', 'select time as \'对应时间\',category as \'分类\',contain_store_tv,modes as \'统计方式\',content/3600 as \'时长(小时)\',create_time as \'创建时间\',update_time as \'更新时间\' from chiq_watch_time_analy');

-- ----------------------------
-- Table structure for data_reporter
-- ----------------------------
DROP TABLE IF EXISTS `data_reporter`;
CREATE TABLE `data_reporter` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `uiconfig` longtext,
  `dataconfig` longtext,
  `userid` varchar(42) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `shareid` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='超类：事务/名称';

-- ----------------------------
-- Records of data_reporter
-- ----------------------------
INSERT INTO `data_reporter` VALUES ('297e94c246d6be3c0146d6c15a1f0000', '2', '2', '1', '', '[{\"Path\":\"./static/data/c/twodimpie/\",\"attr\":{\"width\":\"610\",\"height\":\"286\",\"top\":\"15\",\"left\":\"114\"}},{\"Path\":\"./static/data/c/twodimpie/\",\"attr\":{\"width\":\"612\",\"height\":\"200\",\"top\":\"305\",\"left\":\"129\"}}]', '01', '系统管理员', '');
INSERT INTO `data_reporter` VALUES ('402883824690378d0146903fb7db0007', '哈哈', '7', '1', '', '[{\"Path\":\"./static/data/c/twodimpie/\",\"attr\":{\"width\":\"578\",\"height\":\"232\",\"top\":\"215\",\"left\":\"265\"}},{\"Path\":\"./static/data/c/twodimpie/\",\"attr\":{\"width\":\"581\",\"height\":\"200\",\"top\":\"-8\",\"left\":\"265\"}}]', '01', '系统管理员', '');
INSERT INTO `data_reporter` VALUES ('402883824690378d01469040599a0008', '呵呵', '0', '1', '', '', '01', '系统管理员', '');
INSERT INTO `data_reporter` VALUES ('402883824690378d01469040d6f40009', '嘻嘻', '0', '1', '', '', '01', '系统管理员', '');
INSERT INTO `data_reporter` VALUES ('402883824690378d014690429d55000a', '呵呵', '0', '1', '', '', '01', '系统管理员', '');
INSERT INTO `data_reporter` VALUES ('402883824690378d014690444a87000b', 'hehe', '0', '1', '', '', '01', '系统管理员', '');
INSERT INTO `data_reporter` VALUES ('402883824690513a0146906131f70000', '1', '0', '1', '', '', '01', '系统管理员', '');

-- ----------------------------
-- Table structure for data_repository
-- ----------------------------
DROP TABLE IF EXISTS `data_repository`;
CREATE TABLE `data_repository` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `rep_driver` varchar(96) DEFAULT NULL,
  `rep_url` varchar(256) DEFAULT NULL,
  `rep_username` varchar(42) DEFAULT NULL,
  `rep_password` varchar(128) DEFAULT NULL,
  `rep_schema` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据仓库';

-- ----------------------------
-- Records of data_repository
-- ----------------------------
INSERT INTO `data_repository` VALUES ('01', '本地Mysql', '1', '1', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/bd_weixin?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true', 'tony', '123456', 'bd_wexin');

-- ----------------------------
-- Table structure for file_file
-- ----------------------------
DROP TABLE IF EXISTS `file_file`;
CREATE TABLE `file_file` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `ownerid` varchar(42) DEFAULT NULL,
  `type` varchar(96) DEFAULT NULL,
  `suffix` varchar(36) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='超类：事务/名称';

-- ----------------------------
-- Records of file_file
-- ----------------------------
INSERT INTO `file_file` VALUES ('4028838546ed2e850146ed2e922a0000', 'Tony', '0', '1', 'tony', 'image/gif', 'jpg', '3802');

-- ----------------------------
-- Table structure for file_folder
-- ----------------------------
DROP TABLE IF EXISTS `file_folder`;
CREATE TABLE `file_folder` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='超类：事务/名称';

-- ----------------------------
-- Records of file_folder
-- ----------------------------

-- ----------------------------
-- Table structure for quartz_task
-- ----------------------------
DROP TABLE IF EXISTS `quartz_task`;
CREATE TABLE `quartz_task` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tasktype` varchar(512) DEFAULT NULL,
  `implclass` varchar(256) DEFAULT NULL,
  `taskexpress` varchar(256) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `params` varchar(256) DEFAULT NULL,
  `userid` varchar(42) DEFAULT NULL,
  `username` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='超类：事务/名称';

-- ----------------------------
-- Records of quartz_task
-- ----------------------------
INSERT INTO `quartz_task` VALUES ('1', '1', '1', '1', 'network', 'com.changhong.bd.quartz.task.impl.NetworkTask', '0/7 * * * * ?', '2014-07-07 21:59:06', 'www.baidu.com', ' 1', ' 1');

-- ----------------------------
-- Table structure for quartz_task_log
-- ----------------------------
DROP TABLE IF EXISTS `quartz_task_log`;
CREATE TABLE `quartz_task_log` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `taskid` varchar(42) DEFAULT NULL,
  `state` varchar(36) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `result` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='超类：事务/名称';

-- ----------------------------
-- Records of quartz_task_log
-- ----------------------------

-- ----------------------------
-- Table structure for social_bind
-- ----------------------------
DROP TABLE IF EXISTS `social_bind`;
CREATE TABLE `social_bind` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `bindtype` varchar(42) DEFAULT NULL,
  `openid` varchar(96) DEFAULT NULL,
  `accountid` varchar(42) DEFAULT NULL,
  `binddate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社交账号绑定';

-- ----------------------------
-- Records of social_bind
-- ----------------------------
INSERT INTO `social_bind` VALUES ('402883824643592f0146435c3c140001', '0', '1', 'wechat', 'o0X10uJT99Xk31wx4M7iPdLP0q4c', '8a83b6b14641fc5c014641fcc4a20000', '2014-05-28 23:04:17');
INSERT INTO `social_bind` VALUES ('4028838345fff17c0145fff1a3b80000', '0', '1', 'wechat', '01', 'admin', '2014-05-15 20:53:17');
INSERT INTO `social_bind` VALUES ('40288385460f621001460f62ba850000', '0', '1', 'wechat', '01', 'admin', '2014-05-18 20:51:07');
INSERT INTO `social_bind` VALUES ('40288385460f621001460f62c9020001', '0', '1', 'wechat', '01', 'admin', '2014-05-18 20:51:11');
INSERT INTO `social_bind` VALUES ('40288385460f621001460f62d5610002', '0', '1', 'wechat', '01', 'admin', '2014-05-18 20:51:14');

-- ----------------------------
-- Table structure for social_wechat_channel
-- ----------------------------
DROP TABLE IF EXISTS `social_wechat_channel`;
CREATE TABLE `social_wechat_channel` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL,
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `wechatopenid` varchar(96) DEFAULT NULL,
  `wechatchannelid` varchar(128) DEFAULT NULL,
  `wechatchanelname` varchar(128) DEFAULT NULL,
  `channelinfo` longtext,
  `intime` datetime DEFAULT NULL,
  `expiretime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='超类：事务/名称';

-- ----------------------------
-- Records of social_wechat_channel
-- ----------------------------
INSERT INTO `social_wechat_channel` VALUES ('4028838346b47fdd0146b47fe54e0000', 'name', '0', '1', 'wechatOpenId', 'wechatChannelId', 'wechatChannelName', 'channelInfo', '2014-06-19 22:19:19', '2014-06-10 22:50:19');
INSERT INTO `social_wechat_channel` VALUES ('4028838346b481f30146b481fafa0000', 'name', '0', '1', 'wechatOpenId', 'wechatChannelId', 'wechatChannelName', 'channelInfo', '2014-06-19 22:21:36', '2014-06-19 22:52:36');

-- ----------------------------
-- Table structure for social_wechat_message
-- ----------------------------
DROP TABLE IF EXISTS `social_wechat_message`;
CREATE TABLE `social_wechat_message` (
  `id` varchar(42) NOT NULL DEFAULT '',
  `optlock` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `openid` varchar(128) DEFAULT NULL,
  `userid` varchar(42) DEFAULT NULL,
  `indate` datetime DEFAULT NULL,
  `inmessage` text,
  `inmessagetype` varchar(12) DEFAULT NULL,
  `outmessage` text,
  `outmessagetype` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信信息历史记录';

-- ----------------------------
-- Records of social_wechat_message
-- ----------------------------
