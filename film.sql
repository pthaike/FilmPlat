/*
Navicat MySQL Data Transfer

Source Server         : scu
Source Server Version : 50142
Source Host           : 10.10.141.95:3306
Source Database       : film

Target Server Type    : MYSQL
Target Server Version : 50142
File Encoding         : 65001

Date: 2014-07-11 12:24:41
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `back_visit_record`
-- ----------------------------
DROP TABLE IF EXISTS `back_visit_record`;
CREATE TABLE `back_visit_record` (
  `back_visit_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_id` int(11) NOT NULL,
  `visit_date` date NOT NULL,
  PRIMARY KEY (`back_visit_id`,`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of back_visit_record
-- ----------------------------

-- ----------------------------
-- Table structure for `c_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `c_userinfo`;
CREATE TABLE `c_userinfo` (
  `parameter_id` int(11) NOT NULL AUTO_INCREMENT,
  `max_buy_amount` int(11) NOT NULL,
  `buy_deadline` int(11) NOT NULL,
  PRIMARY KEY (`parameter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `manager_info`
-- ----------------------------
DROP TABLE IF EXISTS `manager_info`;
CREATE TABLE `manager_info` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `manager_password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of manager_info
-- ----------------------------
INSERT INTO `manager_info` VALUES ('1', 'admin', '123');

-- ----------------------------
-- Table structure for `message_info`
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `message_content` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `message_time` date NOT NULL,
  `message_reply` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `FK_Reference_3` (`user_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of message_info
-- ----------------------------
INSERT INTO `message_info` VALUES ('1', '1', '不错啊，相当给力', '2014-07-12', 'thank you');
INSERT INTO `message_info` VALUES ('2', '1', '下次全家总动员', '2014-07-12', '您的支持就是我们最大的动力');
INSERT INTO `message_info` VALUES ('3', '1', '顶', '2014-07-12', '灰常感谢');
INSERT INTO `message_info` VALUES ('4', '1', '鼓掌', '2008-06-05', 'thank your all family');
INSERT INTO `message_info` VALUES ('5', '2', '继续努力吧', '2008-06-05', '谢谢您的宝贵意见');
INSERT INTO `message_info` VALUES ('6', '2', '还是不错的', '2008-06-05', '再接再厉');
INSERT INTO `message_info` VALUES ('7', '2', '期待更好', '2014-07-10', '非常感谢您');
INSERT INTO `message_info` VALUES ('8', '2', '哈哈', '2014-07-10', '感谢您全家');

-- ----------------------------
-- Table structure for `movie_hall_info`
-- ----------------------------
DROP TABLE IF EXISTS `movie_hall_info`;
CREATE TABLE `movie_hall_info` (
  `movie_hail_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_city_id` int(11) DEFAULT NULL,
  `movie_hail_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`movie_hail_id`),
  KEY `FK_Reference_4` (`movie_city_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`movie_city_id`) REFERENCES `movie_vity_info` (`movie_city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of movie_hall_info
-- ----------------------------
INSERT INTO `movie_hall_info` VALUES ('1', '1', 'VIP厅');
INSERT INTO `movie_hall_info` VALUES ('2', '1', '1号厅');
INSERT INTO `movie_hall_info` VALUES ('3', '1', '2号厅');
INSERT INTO `movie_hall_info` VALUES ('4', '1', '3号厅');
INSERT INTO `movie_hall_info` VALUES ('5', '2', '梅厅');
INSERT INTO `movie_hall_info` VALUES ('6', null, '兰厅');
INSERT INTO `movie_hall_info` VALUES ('7', '2', '竹厅');
INSERT INTO `movie_hall_info` VALUES ('8', '2', '菊厅');
INSERT INTO `movie_hall_info` VALUES ('9', '3', 'A厅');
INSERT INTO `movie_hall_info` VALUES ('10', '3', 'B厅');
INSERT INTO `movie_hall_info` VALUES ('11', '3', 'C厅');

-- ----------------------------
-- Table structure for `movie_info`
-- ----------------------------
DROP TABLE IF EXISTS `movie_info`;
CREATE TABLE `movie_info` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `movie_director` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `movie_actor` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `movie_type` int(11) NOT NULL,
  `movie_country` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `movie_length` int(11) NOT NULL,
  `movie_publish_date` date NOT NULL,
  `movie_grade` int(11) DEFAULT NULL,
  `movie_click_rate` int(11) DEFAULT NULL,
  `movie_shortcut` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `movie_introduction` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `movie_small_picture` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `movie_big_picture` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `movie_content_picture` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `movie_show_on` int(20) NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of movie_info
-- ----------------------------
INSERT INTO `movie_info` VALUES ('2', '哥斯拉', '加雷斯·爱德华', '亚伦·泰勒', '22', '美国', '222', '2008-06-05', '2', '2', '222', '222', './moviepic/1.jpg', '222', '222', '1');
INSERT INTO `movie_info` VALUES ('5', '沉睡魔咒', '罗伯特·斯特罗姆伯格', '安吉丽娜朱莉', '66', '美国', '67', '2008-06-14', '6', '6', '6', '6', './moviepic/2.jpg', '6', '6', '1');
INSERT INTO `movie_info` VALUES ('8', '西藏天空', '傅东育', '拉旺罗布', '111', '中国', '118', '2013-01-21', '946', '45', '45', '3', './moviepic/3.jpg', '75', '786', '1');
INSERT INTO `movie_info` VALUES ('35', '分手大师', '俞白眉', '邓超', '555', '中国', '120', '2013-01-16', '454', '453', '45', '7454', './moviepic/4.jpg', '456', '48769', '0');
INSERT INTO `movie_info` VALUES ('46', '美国骗局', '大卫·欧·拉塞尔', '埃里克·辛格尔', '5', '美国', '138', '2013-01-18', '4', '5', '2', '7', './moviepic/5.jpg', '32', '6', '1');
INSERT INTO `movie_info` VALUES ('65', '笔仙3', '安兵基', '江一燕', '1', '中国', '106', '2013-01-29', '56', '634', '786', 'sdf', './moviepic/6.jpg', 'asft', 'jgh', '0');
INSERT INTO `movie_info` VALUES ('134', '变形金刚2', '迈克尔·贝', '马克·沃尔伯格', '3', '美国', '157', '2013-01-22', '35', '345', 'dg', 'sdfhy', './moviepic/7.jpg', 'asdg', 'dfh', '1');

-- ----------------------------
-- Table structure for `movie_show_info`
-- ----------------------------
DROP TABLE IF EXISTS `movie_show_info`;
CREATE TABLE `movie_show_info` (
  `movie_show_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) NOT NULL,
  `movie_city_id` int(11) NOT NULL,
  `movie_hail_id` int(11) NOT NULL,
  `movie_vison` int(11) DEFAULT NULL,
  `movie_time` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `movie_price` int(11) NOT NULL,
  `movie_play_date` date NOT NULL,
  PRIMARY KEY (`movie_show_id`),
  KEY `FK_Reference_10` (`movie_id`),
  KEY `FK_Reference_11` (`movie_city_id`),
  KEY `FK_Reference_12` (`movie_hail_id`),
  KEY `FK_Reference_14` (`movie_vison`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`movie_id`) REFERENCES `movie_info` (`movie_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`movie_city_id`) REFERENCES `movie_vity_info` (`movie_city_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`movie_hail_id`) REFERENCES `movie_hall_info` (`movie_hail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of movie_show_info
-- ----------------------------
INSERT INTO `movie_show_info` VALUES ('1', '2', '1', '1', '1', '8:10', '30', '2008-06-19');
INSERT INTO `movie_show_info` VALUES ('2', '5', '2', '5', '1', '20:30', '35', '2014-07-31');
INSERT INTO `movie_show_info` VALUES ('3', '8', '3', '9', '1', '14:50', '30', '2014-06-12');
INSERT INTO `movie_show_info` VALUES ('4', '8', '1', '2', '1', '18:40', '40', '2014-07-17');

-- ----------------------------
-- Table structure for `movie_type`
-- ----------------------------
DROP TABLE IF EXISTS `movie_type`;
CREATE TABLE `movie_type` (
  `movie_id` int(11) NOT NULL,
  `type_comedy` int(11) DEFAULT NULL,
  `type_action` int(11) DEFAULT NULL,
  `type_love` int(11) DEFAULT NULL,
  `type_fiction` int(11) DEFAULT NULL,
  `type_dracula` int(11) DEFAULT NULL,
  PRIMARY KEY (`movie_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`movie_id`) REFERENCES `movie_info` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of movie_type
-- ----------------------------

-- ----------------------------
-- Table structure for `movie_view_info`
-- ----------------------------
DROP TABLE IF EXISTS `movie_view_info`;
CREATE TABLE `movie_view_info` (
  `movie_view_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `movie_view_content` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `movie_view_date` date NOT NULL,
  `movie_comment_shield` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`movie_view_id`),
  KEY `FK_Reference_8` (`user_id`),
  KEY `FK_Reference_9` (`movie_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`movie_id`) REFERENCES `movie_info` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of movie_view_info
-- ----------------------------
INSERT INTO `movie_view_info` VALUES ('1', '1', '2', '影片不错，下次还来', '2014-07-12', null);
INSERT INTO `movie_view_info` VALUES ('2', '2', '5', 'nice,格瑞特', '2014-07-14', null);
INSERT INTO `movie_view_info` VALUES ('3', '1', '2', 'dfsdfasdf', '2014-07-11', null);

-- ----------------------------
-- Table structure for `movie_vity_info`
-- ----------------------------
DROP TABLE IF EXISTS `movie_vity_info`;
CREATE TABLE `movie_vity_info` (
  `movie_city_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_city_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `support_onlline` int(11) NOT NULL,
  `movie_city_address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `movie_city_phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `movie_city_intro` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`movie_city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of movie_vity_info
-- ----------------------------
INSERT INTO `movie_vity_info` VALUES ('1', '太平洋电影城', '0', '成都市锦江区花园街31号万科城市花园10栋负一楼', '028-84778323 ', '成都太平洋电影城（川师店）是由四川省电影公司、四川太平洋电影院线、四川紫荆影业联合投资兴建的一座星级标准的现代化多厅电影城。\r\n\r\n太平洋电影城(川师店)秉承“太平洋电影”的优良品质：专业、时尚、典雅、精致。面积1000余平方米，拥有5个国际标准电影放映厅，近500个符合人体力学的高级舒适座席。影城具有保障五星级标准的整套管理制度及服务质量保证体系，影厅采用符合世界潮流的等宽放映银幕、最新一代dolby CP650D解码器、高端数码立体声还音音响系统、一体化放映镜头，现代数字电影放映设备，高增益漫反射无接缝银幕等。');
INSERT INTO `movie_vity_info` VALUES ('2', '万达影院 ', '0', '成都市锦江区大业路6号', '028-66555588', '');
INSERT INTO `movie_vity_info` VALUES ('3', '王府井影城', '1', '成都市锦江区总府路15号王府井电影城6-11楼', '028-86756351 ', '成都王府井电影城是成都第一座国际标志性电影城，始建于2000年9月，地处成都最繁华的春熙商圈中的王府井百货6-9楼，融旅游、休闲、娱乐、购物为一体，投资8000余万元，历经6年的拓展，营业额已达1.2亿元，近3年来，年票房连续突破2000万元，位于全国前矛，荣居西部第一，深受成都市民的喜爱，已成为蓉城影迷的NO.1，跻身全国10大品牌影城之列，作为新兴影城的代表，入选中国电影博物馆。');

-- ----------------------------
-- Table structure for `news_artical_info`
-- ----------------------------
DROP TABLE IF EXISTS `news_artical_info`;
CREATE TABLE `news_artical_info` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `news_time` date NOT NULL,
  `news_content` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of news_artical_info
-- ----------------------------
INSERT INTO `news_artical_info` VALUES ('5', '《星星》推电影版 内地公司获独家发行权 ', '2013-01-11', '电视剧《来自星星的你》引发现象级热潮。日前，东阳盟将威影视文化有限公司正式公布，将推电影版《来自星星的你》。敬请关注！');
INSERT INTO `news_artical_info` VALUES ('6', '《明日边缘》定档 6月6日同步北美上映', '2013-01-14', '由华纳出品，导演道格-里曼执导，汤姆-克鲁斯与英国女星艾米丽-布朗特联袂主演的《明日边缘》正式定档6月6日同步北美上映。');
INSERT INTO `news_artical_info` VALUES ('12', '《激浪青春》6月上映 吴宇森4年磨一剑', '2013-01-24', '由吴宇森监制，陈乔恩领衔主演，黄晓明特别出演，黄轩，曾志伟，董璇，邵兵，于小伟，吴辰君，谢晶晶等参演的青春爱情电影《激浪青春》，已经正式定档6月全国激浪上映。');
INSERT INTO `news_artical_info` VALUES ('13', '最新电影资讯', '2013-01-25', '最近有好多好看的大片 《变形金刚》《白日焰火等》');
INSERT INTO `news_artical_info` VALUES ('14', 'fdfasdf', '2014-07-11', 'dsdasds');

-- ----------------------------
-- Table structure for `news_view_info`
-- ----------------------------
DROP TABLE IF EXISTS `news_view_info`;
CREATE TABLE `news_view_info` (
  `newsview_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `newsview_content` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `newsview_time` date NOT NULL,
  PRIMARY KEY (`newsview_id`),
  KEY `FK_Reference_1` (`news_id`),
  KEY `FK_Reference_2` (`user_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`news_id`) REFERENCES `news_artical_info` (`news_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of news_view_info
-- ----------------------------
INSERT INTO `news_view_info` VALUES ('2', '6', '1', 'chasjksadf', '2014-07-11');

-- ----------------------------
-- Table structure for `pay_info`
-- ----------------------------
DROP TABLE IF EXISTS `pay_info`;
CREATE TABLE `pay_info` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `movie_city_id` int(11) NOT NULL,
  `pay_amount` float NOT NULL,
  `pay_date` date NOT NULL,
  PRIMARY KEY (`pay_id`),
  KEY `FK_Reference_5` (`user_id`),
  KEY `FK_Reference_6` (`movie_id`),
  KEY `FK_Reference_7` (`movie_city_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`movie_id`) REFERENCES `movie_info` (`movie_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`movie_city_id`) REFERENCES `movie_vity_info` (`movie_city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of pay_info
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `user_realname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_sex` int(11) DEFAULT NULL,
  `user_idcard` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `user_birth` date DEFAULT NULL,
  `user_marry` int(11) DEFAULT NULL,
  `user_city` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_postcode` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_pnumber` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `user_email` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'cd', '33', '曹笛', '0', '142625199511220019', '2014-01-07', '1', '成都', '四川大学', '114304', '18200288036', 'cheng@qq.com');
INSERT INTO `user_info` VALUES ('2', 'yang', '123', 'vivian', '1', '120223199303030606', null, '1', '', '', '', '12345678900', '123@163.com');
INSERT INTO `user_info` VALUES ('3', 'hyf', '123', '侯雲峰', '1', '122332188766565353', '2014-07-16', '1', '成都', '滴答滴答', '678543', '12233334444', '12345678@qq.com');

-- ----------------------------
-- Table structure for `visitor_innfo`
-- ----------------------------
DROP TABLE IF EXISTS `visitor_innfo`;
CREATE TABLE `visitor_innfo` (
  `visitor_ip` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_date` date NOT NULL,
  `visitor_explorer` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `visitor_area` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `visitor_hd` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `visitor_os` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `visitor_language` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `visitor_endtype` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`visitor_ip`,`visitor_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of visitor_innfo
-- ----------------------------
