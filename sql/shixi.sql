/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : shixi

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-10-19 15:36:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(255) DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  PRIMARY KEY (`categoryId`),
  KEY `FK9gtxe1j91qfxgw3py7a1182ps` (`deptId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '后端开发', '1');
INSERT INTO `category` VALUES ('2', '移动开发', '1');
INSERT INTO `category` VALUES ('3', '前端开发', '1');
INSERT INTO `category` VALUES ('4', '测试', '1');
INSERT INTO `category` VALUES ('5', '运维', '1');
INSERT INTO `category` VALUES ('6', 'DBA', '1');
INSERT INTO `category` VALUES ('7', '项目管理', '1');
INSERT INTO `category` VALUES ('8', '产品经理', '2');
INSERT INTO `category` VALUES ('9', '产品设计', '2');
INSERT INTO `category` VALUES ('10', '视觉设计', '3');
INSERT INTO `category` VALUES ('11', '交互设计', '3');
INSERT INTO `category` VALUES ('12', '用户研究', '3');
INSERT INTO `category` VALUES ('13', '运营', '4');
INSERT INTO `category` VALUES ('14', '编辑', '4');
INSERT INTO `category` VALUES ('15', '客服', '4');
INSERT INTO `category` VALUES ('16', '市场与营销', '5');
INSERT INTO `category` VALUES ('17', '公关', '5');
INSERT INTO `category` VALUES ('18', '销售', '5');
INSERT INTO `category` VALUES ('19', '人力资源', '6');
INSERT INTO `category` VALUES ('20', '行政', '6');
INSERT INTO `category` VALUES ('21', '财务', '6');

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '杭州', '阿里巴巴', '阿里巴巴', '0737-26155912');
INSERT INTO `company` VALUES ('2', '北京', '新浪', '新浪', '0738-2112123');
INSERT INTO `company` VALUES ('3', '深圳', '腾讯', '腾讯', '2321334');
INSERT INTO `company` VALUES ('4', '广州', '优酷', '优酷', '3123124');
INSERT INTO `company` VALUES ('5', '上海', '百度', '百度', '481947219471');
INSERT INTO `company` VALUES ('6', '广州', '虎扑', '虎扑', '8492138');
INSERT INTO `company` VALUES ('7', '杭州', '滴滴出行', '滴滴出行', '4721490');
INSERT INTO `company` VALUES ('8', '深圳', '小米', '小米', '38291041');
INSERT INTO `company` VALUES ('9', '广州', '美团', '美团', '421948291');
INSERT INTO `company` VALUES ('10', '深圳', '饿了么', '饿了么', '84921031');
INSERT INTO `company` VALUES ('11', '苏州', '去哪儿', '去哪儿', '2412012');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `depId` int(11) NOT NULL AUTO_INCREMENT,
  `depName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '技术');
INSERT INTO `department` VALUES ('2', '产品');
INSERT INTO `department` VALUES ('3', '设计');
INSERT INTO `department` VALUES ('4', '运营');
INSERT INTO `department` VALUES ('5', '市场');
INSERT INTO `department` VALUES ('6', '职能');

-- ----------------------------
-- Table structure for `favor`
-- ----------------------------
DROP TABLE IF EXISTS `favor`;
CREATE TABLE `favor` (
  `favorId` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`favorId`),
  KEY `FKtigjpmlhukqjpnyya0uuuwu6g` (`pid`),
  KEY `FKol8n4mwuhx3n8exy2esp50s2m` (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favor
-- ----------------------------
INSERT INTO `favor` VALUES ('12', '9', '1');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `positionId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `requirement` varchar(255) DEFAULT NULL,
  `salaryDown` int(11) DEFAULT NULL,
  `salaryUp` int(11) DEFAULT NULL,
  `workCity` varchar(255) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`positionId`),
  KEY `FKm94nwwvcut9eff47dumqq3oog` (`categoryId`),
  KEY `FKleckcbaj3tdmyala3rtxqjbe6` (`companyId`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', 'JAVA工程师', '1', '精通JAVA', '10000', '15000', '杭州', '1', '1');
INSERT INTO `position` VALUES ('2', 'C++工程师', '1', '精通C++', '12000', '16000', '深圳', '1', '2');
INSERT INTO `position` VALUES ('3', 'PHP工程师', '1', '精通PHP', '10000', '15000', '广州', '1', '3');
INSERT INTO `position` VALUES ('4', '安卓开发', '2', '精通安卓', '10000', '13000', '广州', '2', '4');
INSERT INTO `position` VALUES ('5', 'IOS开发', '3', '精通IOS', '11000', '13000', '长沙', '2', '5');
INSERT INTO `position` VALUES ('6', 'WEB前端', '1', '精通HTML、CSS', '10000', '20000', '广州', '3', '6');
INSERT INTO `position` VALUES ('7', 'U3D开发', '2', '精通U3D', '12000', '13000', '深圳', '3', '7');
INSERT INTO `position` VALUES ('8', '测试工程师', '1', '精通软件测试', '10000', '12000', '广州', '4', '6');
INSERT INTO `position` VALUES ('9', '自动化测试', '2', '精通自动化测试', '13000', '15000', '深圳', '4', '5');

-- ----------------------------
-- Table structure for `resume`
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `resumeId` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `resumeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resumeId`),
  KEY `FKqprno02vhjlnqmsy23v0fi23w` (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('17', '1', '尚硅谷_宋红康_Maven的配置.pdf');
INSERT INTO `resume` VALUES ('18', '1', 'Git&GitHub.pdf');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleId`),
  KEY `FK2sxwvkcadqxpmg44g32mujak0` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `graYear` int(11) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1013431730@qq.com', '202122', '计科', '18174450486', '郑皓云', 'd084c71bab10acda3c9cbe1588e9d053', 'VLV/JSeHixkrIu5y3Z2cRg==', '长沙理工大学');
INSERT INTO `user` VALUES ('2', 'admin', '0', '计科', '123456', '管理员', 'a6f01be4a7c44c6fc7aa4e0490a92f08', 'VrlT6NTqjHc/Ezw0lP1JFg==', '长沙理工大学');
INSERT INTO `user` VALUES ('14', 'test', '0', null, null, null, '77c1df0272aecf924ac59cc15665d306', 'eGEx9oXy/FcD9LMP/n2tpw==', null);
