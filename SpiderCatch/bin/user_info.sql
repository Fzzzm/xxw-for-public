/*
Navicat MySQL Data Transfer

Source Server         : ����
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : user_info

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-03-22 17:09:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '����',
  `location` varchar(255) DEFAULT NULL COMMENT '��ס��',
  `business` varchar(255) DEFAULT NULL COMMENT '��ҵ',
  `employment` varchar(255) DEFAULT NULL COMMENT '��˾',
  `position` varchar(255) DEFAULT NULL COMMENT 'ְλ',
  `education` varchar(255) DEFAULT NULL COMMENT '��ѧ',
  `major` varchar(255) DEFAULT NULL COMMENT 'רҵ',
  `userInfo` varchar(4096) DEFAULT NULL COMMENT '���˼��',
  `answersNum` int(11) DEFAULT NULL COMMENT '������',
  `starsNum` bigint(20) DEFAULT NULL COMMENT '����ͬ��',
  `thxNum` bigint(20) DEFAULT NULL COMMENT '����л��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
