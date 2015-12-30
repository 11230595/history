/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : hexun

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2015-12-30 16:24:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ts_content
-- ----------------------------
DROP TABLE IF EXISTS `ts_content`;
CREATE TABLE `ts_content` (
  `ID` varchar(40) NOT NULL,
  `TITLE` varchar(255) NOT NULL COMMENT '标题',
  `CONTENT` text COMMENT '内容',
  `USER_ID` varchar(40) DEFAULT NULL COMMENT '用户id',
  `DEL_FLAG` int(1) DEFAULT NULL COMMENT '删除标记',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `EDIT_TIME` datetime DEFAULT NULL COMMENT '编辑时间',
  `EDIT_USER_ID` varchar(40) DEFAULT NULL COMMENT '操作人ID',
  `RECOM` int(2) DEFAULT NULL COMMENT '推荐级别',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_content
-- ----------------------------
INSERT INTO `ts_content` VALUES ('12291611363950001', '小学生给市委书记写信:能不能让大人少骂点脏话', '小学生给市委书记写信:能不能让大人少骂点脏话', '1234', '0', '2015-12-29 16:11:36', null, null, '0');
INSERT INTO `ts_content` VALUES ('12301504483950000', '越南网友称海滩惊现美人鱼，却惹恼了政府？', '<p style=\"text-align:center;color:#252525;text-indent:0px;background-color:#FFFFFF;\" class=\"f_center\">\r\n	<img style=\"border:0px currentColor;\" border=\"3\" alt=\"网友称越南发现48公斤重美人鱼，结果让政府大为光火\" src=\"http://img1.cache.netease.com/catchpic/3/34/349231258DE82F497C4F73214E8CD427.jpg\" />\r\n</p>\r\n<p style=\"text-align:justify;color:#252525;text-indent:2em;background-color:#FFFFFF;\">\r\n	越南网友恶作剧，称渔民在海滩上抓到美人鱼。\r\n</p>\r\n<p style=\"text-align:justify;color:#252525;text-indent:2em;background-color:#FFFFFF;\">\r\n	据Etoday报道，越南一对新人将婚纱照传到到脸书上，新娘的美人鱼造型受人瞩目，却被网友拿来恶搞，以“渔民在广南省（Quang Nam）海滩抓到48公斤重的美人鱼”为标题，在其他网站上骗人。这消息让不少网友信以为真，越南政府只好出面灭火，并调查散播者行为。\r\n</p>\r\n<p style=\"text-align:center;color:#252525;text-indent:0px;background-color:#FFFFFF;\" class=\"f_center\">\r\n	<img style=\"border:0px currentColor;\" alt=\"网友称越南发现48公斤重美人鱼，结果让政府大为光火\" src=\"http://img6.cache.netease.com/cnews/2015/12/28/20151228191434840bb_550.jpg\" />\r\n</p>\r\n<p style=\"text-align:justify;color:#252525;text-indent:2em;background-color:#FFFFFF;\">\r\n	照片中，美丽的新娘扮成美人鱼，全身被渔网缠住倒在沙滩上。扮演白马王子的新郎，因看到受困的美人鱼就来个英雄救美。从此，两人因生好感并坠入爱河，美人鱼更因爱情而变成人类，两人幸福的走向婚姻。\r\n</p>\r\n<p style=\"text-align:center;color:#252525;text-indent:0px;background-color:#FFFFFF;\" class=\"f_center\">\r\n	<img style=\"border:0px currentColor;\" alt=\"网友称越南发现48公斤重美人鱼，结果让政府大为光火\" src=\"http://img1.cache.netease.com/cnews/2015/12/28/20151228191436e0222_550.jpg\" />\r\n</p>\r\n<p style=\"text-align:justify;color:#252525;text-indent:2em;background-color:#FFFFFF;\">\r\n	这组婚纱照晒到到脸书上时，众人好评如潮。却有无聊的网友，引用其中几张照片，并以“渔民抓到美人鱼”为题，声称有渔民在广南省捕获一条48公斤重的美人鱼，还说这美人鱼正在当地医院接受治疗，等待外国医疗专家进行研究。\r\n</p>\r\n<p style=\"text-align:justify;color:#252525;text-indent:2em;background-color:#FFFFFF;\">\r\n	讯息传出后，竟比原先的婚纱照更引起网友兴趣，纷纷转载分享，甚至还有地方媒体作相关报导，使得不少更网友信以为真。由于情况夸张，广南省当局已出面澄清，证实这则贴文为不实谣言，散播者传上网的目的为吸引网友按赞、分享，政府将依法调查与处分散播者行为。\r\n</p>\r\n<p style=\"text-align:center;color:#252525;text-indent:0px;background-color:#FFFFFF;\" class=\"f_center\">\r\n	<img style=\"border:0px currentColor;\" border=\"3\" alt=\"网友称越南发现48公斤重美人鱼，结果让政府大为光火\" src=\"http://img1.cache.netease.com/catchpic/2/2B/2BE9F10248541403B44B261A6ED3B118.jpg\" width=\"600\" height=\"425\" />\r\n</p>', '1234', '0', '2015-12-30 15:04:48', null, null, '0');
INSERT INTO `ts_content` VALUES ('12301505283160002', '坑!网友贪便宜买低价大虾,撕开包装那一刻他哭了', '<p style=\"text-align:justify;color:#252525;text-indent:2em;background-color:#FFFFFF;\">\r\n	<span>最近，有日本网友在Twitter上分享了一则感人故事…他表示自己在超市看到了一盒9只装的原产大虾，看上去还蛮大的...主要是价格超低！他觉得自己赚到了，赶紧买一盒回家..</span>\r\n</p>\r\n<p style=\"text-align:center;color:#252525;text-indent:0px;background-color:#FFFFFF;\" class=\"f_center\">\r\n	<img style=\"border:0px currentColor;\" alt=\"坑!网友贪便宜买低价大虾,撕开包装那一刻他哭了\" src=\"http://img6.cache.netease.com/cnews/2015/12/28/20151228170303beb48_550.png\" />\r\n</p>\r\n<p style=\"text-align:justify;color:#252525;text-indent:2em;background-color:#FFFFFF;\">\r\n	结果他把包装纸撕开后，却发现尼玛这整整少了三分之一啊，坑爹呢这是！万般无奈之下，他只好把图片分享到网上，告诫大家不要中招...事实证明，你永远也别想在奸商那讨便宜...\r\n</p>\r\n<p style=\"text-align:center;color:#252525;text-indent:0px;background-color:#FFFFFF;\" class=\"f_center\">\r\n	<img style=\"border:0px currentColor;\" alt=\"坑!网友贪便宜买低价大虾,撕开包装那一刻他哭了\" src=\"http://img2.cache.netease.com/cnews/2015/12/28/2015122817104285353_550.png\" />\r\n</p>', '1234', '0', '2015-12-30 15:05:28', null, null, '0');

-- ----------------------------
-- Table structure for ts_read_count
-- ----------------------------
DROP TABLE IF EXISTS `ts_read_count`;
CREATE TABLE `ts_read_count` (
  `ID` varchar(40) NOT NULL,
  `CONTENT_ID` varchar(40) NOT NULL,
  `USER_ID` varchar(40) DEFAULT NULL COMMENT '阅读人ID',
  `TS_COUNT` int(11) NOT NULL COMMENT '统计',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_read_count
-- ----------------------------
INSERT INTO `ts_read_count` VALUES ('12281635203490004', '12281633129480000', '', '5', '2015-12-28 16:35:20');
INSERT INTO `ts_read_count` VALUES ('12281635279530005', '12281634124910002', '', '3', '2015-12-28 16:35:27');
INSERT INTO `ts_read_count` VALUES ('12281637537100007', '12281637145220006', '', '5', '2015-12-28 16:37:53');
INSERT INTO `ts_read_count` VALUES ('12281640526610000', '12281638344290008', '', '6', '2015-12-28 16:40:52');
INSERT INTO `ts_read_count` VALUES ('12291543068750001', '12291541252050000', '', '1', '2015-12-29 15:43:06');
INSERT INTO `ts_read_count` VALUES ('12291611431490002', '12291611363950001', '', '5', '2015-12-29 16:11:43');
INSERT INTO `ts_read_count` VALUES ('12301504545700001', '12301504483950000', '', '1', '2015-12-30 15:04:54');
INSERT INTO `ts_read_count` VALUES ('12301505393360003', '12301505283160002', '', '133', '2015-12-30 15:05:39');

-- ----------------------------
-- Table structure for ts_user
-- ----------------------------
DROP TABLE IF EXISTS `ts_user`;
CREATE TABLE `ts_user` (
  `ID` varchar(40) NOT NULL,
  `USER_NAME` varchar(128) DEFAULT NULL COMMENT '昵称',
  `USER_CODE` varchar(128) DEFAULT NULL COMMENT '用户名',
  `EMALL` varchar(128) DEFAULT NULL COMMENT 'Emall',
  `PHONE` varchar(128) DEFAULT NULL COMMENT '手机',
  `USER_DESC` varchar(255) DEFAULT NULL COMMENT '备注',
  `LEVEL` int(2) DEFAULT NULL COMMENT '用户级别',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `EDIT_TIME` datetime DEFAULT NULL COMMENT '编辑时间',
  `PASSWORD` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ts_user
-- ----------------------------
INSERT INTO `ts_user` VALUES ('12281538356750000', null, 'aaaa', null, '18511833392', null, '0', '2015-12-28 15:38:35', null, null);
INSERT INTO `ts_user` VALUES ('12281549137330000', null, '123', null, '1234', null, '0', '2015-12-28 15:49:13', null, '123456');
INSERT INTO `ts_user` VALUES ('12281654254080000', null, '1234', null, '', null, '0', '2015-12-28 16:54:25', null, '');
INSERT INTO `ts_user` VALUES ('12291436329930000', null, '12345', null, '', null, '0', '2015-12-29 14:36:32', null, '');
INSERT INTO `ts_user` VALUES ('1229161044720000', null, '456', null, '23123123', null, '0', '2015-12-29 16:10:44', null, '123456');
INSERT INTO `ts_user` VALUES ('1230144413560000', null, 'aaa', null, '18511833392', null, '0', '2015-12-30 14:44:13', null, '123456');
INSERT INTO `ts_user` VALUES ('12301444272840001', null, 'abc', null, '18511833392', null, '0', '2015-12-30 14:44:27', null, '123456');
INSERT INTO `ts_user` VALUES ('12301444341550002', null, 'abcd', null, '18511833392', null, '0', '2015-12-30 14:44:34', null, '123456');
INSERT INTO `ts_user` VALUES ('12301444424080003', null, 'abcde', null, '18511833392', null, '0', '2015-12-30 14:44:42', null, '123456');
INSERT INTO `ts_user` VALUES ('12301444528560004', null, 'abcdef', null, '18511833392', null, '0', '2015-12-30 14:44:52', null, '123456');
INSERT INTO `ts_user` VALUES ('12301446087480005', null, '1222', null, '18511833392', null, '0', '2015-12-30 14:46:08', null, '123456');
INSERT INTO `ts_user` VALUES ('12301446177470006', null, '122234', null, '18511833392', null, '0', '2015-12-30 14:46:17', null, '123456');
INSERT INTO `ts_user` VALUES ('12301446267080007', null, '12223476', null, '18511833392', null, '0', '2015-12-30 14:46:26', null, '123456');
INSERT INTO `ts_user` VALUES ('12301446349640008', null, '1222347687684', null, '18511833392', null, '0', '2015-12-30 14:46:34', null, '123456');
INSERT INTO `ts_user` VALUES ('12301448315600000', null, '155', null, '18511833392', null, '0', '2015-12-30 14:48:31', null, '123456');
INSERT INTO `ts_user` VALUES ('12301448428250001', null, '1550', null, '18511833392', null, '0', '2015-12-30 14:48:42', null, '123456');
INSERT INTO `ts_user` VALUES ('12301448509240002', null, '15501', null, '18511833392', null, '0', '2015-12-30 14:48:50', null, '123456');
INSERT INTO `ts_user` VALUES ('12301449006720003', null, '15502', null, '18511833392', null, '0', '2015-12-30 14:49:00', null, '123456');
INSERT INTO `ts_user` VALUES ('1230144908470004', null, '15503', null, '18511833392', null, '0', '2015-12-30 14:49:08', null, '123456');
INSERT INTO `ts_user` VALUES ('12301449155140005', null, '15504', null, '18511833392', null, '0', '2015-12-30 14:49:15', null, '123456');
INSERT INTO `ts_user` VALUES ('12301449234900006', null, '15505', null, '18511833392', null, '0', '2015-12-30 14:49:23', null, '123456');
INSERT INTO `ts_user` VALUES ('12301449316770007', null, '15506', null, '18511833392', null, '0', '2015-12-30 14:49:31', null, '123456');
INSERT INTO `ts_user` VALUES ('1230144939910008', null, '15507', null, '18511833392', null, '0', '2015-12-30 14:49:39', null, '123456');
INSERT INTO `ts_user` VALUES ('12301449467800009', null, '15508', null, '18511833392', null, '0', '2015-12-30 14:49:46', null, '123456');
INSERT INTO `ts_user` VALUES ('12301449538490010', null, '15509', null, '18511833392', null, '0', '2015-12-30 14:49:53', null, '123456');
INSERT INTO `ts_user` VALUES ('12301450249190011', null, '166', null, '18511833392', null, '0', '2015-12-30 14:50:24', null, '123456');
INSERT INTO `ts_user` VALUES ('12301450334110012', null, '1660', null, '18511833392', null, '0', '2015-12-30 14:50:33', null, '123456');
INSERT INTO `ts_user` VALUES ('12301450437620013', null, '16601', null, '18511833392', null, '0', '2015-12-30 14:50:43', null, '123456');
INSERT INTO `ts_user` VALUES ('12301450535810014', null, '16602', null, '18511833392', null, '0', '2015-12-30 14:50:53', null, '123456');
INSERT INTO `ts_user` VALUES ('12301451009610015', null, '16603', null, '18511833392', null, '0', '2015-12-30 14:51:00', null, '123456');
INSERT INTO `ts_user` VALUES ('1230145110400016', null, '16604', null, '18511833392', null, '0', '2015-12-30 14:51:10', null, '123456');
INSERT INTO `ts_user` VALUES ('12301451186430017', null, '16605', null, '18511833392', null, '0', '2015-12-30 14:51:18', null, '123456');
INSERT INTO `ts_user` VALUES ('12301451261350018', null, '16606', null, '18511833392', null, '0', '2015-12-30 14:51:26', null, '123456');
INSERT INTO `ts_user` VALUES ('1230145133630019', null, '16607', null, '18511833392', null, '0', '2015-12-30 14:51:33', null, '123456');
INSERT INTO `ts_user` VALUES ('12301451398200020', null, '16608', null, '18511833392', null, '0', '2015-12-30 14:51:39', null, '123456');
INSERT INTO `ts_user` VALUES ('12301451474260021', null, '16609', null, '18511833392', null, '0', '2015-12-30 14:51:47', null, '123456');
INSERT INTO `ts_user` VALUES ('12301452036240022', null, '33001', null, '18511833392', null, '0', '2015-12-30 14:52:03', null, '123456');
INSERT INTO `ts_user` VALUES ('12301452113360023', null, '33002', null, '18511833392', null, '0', '2015-12-30 14:52:11', null, '123456');
INSERT INTO `ts_user` VALUES ('1230145218990024', null, '33003', null, '18511833392', null, '0', '2015-12-30 14:52:18', null, '123456');
INSERT INTO `ts_user` VALUES ('12301452252760025', null, '33004', null, '18511833392', null, '0', '2015-12-30 14:52:25', null, '123456');
INSERT INTO `ts_user` VALUES ('12301452341120026', null, '33005', null, '18511833392', null, '0', '2015-12-30 14:52:34', null, '123456');
INSERT INTO `ts_user` VALUES ('12301452406220027', null, '33006', null, '18511833392', null, '0', '2015-12-30 14:52:40', null, '123456');
INSERT INTO `ts_user` VALUES ('12301452481570028', null, '33007', null, '18511833392', null, '0', '2015-12-30 14:52:48', null, '123456');
INSERT INTO `ts_user` VALUES ('1230145255960029', null, '33008', null, '18511833392', null, '0', '2015-12-30 14:52:55', null, '123456');
INSERT INTO `ts_user` VALUES ('12301453017080030', null, '33009', null, '18511833392', null, '0', '2015-12-30 14:53:01', null, '123456');
INSERT INTO `ts_user` VALUES ('12301453095950031', null, '33010', null, '18511833392', null, '0', '2015-12-30 14:53:09', null, '123456');
INSERT INTO `ts_user` VALUES ('12301453183180032', null, '33011', null, '18511833392', null, '0', '2015-12-30 14:53:18', null, '123456');
INSERT INTO `ts_user` VALUES ('1230145325780033', null, '33012', null, '18511833392', null, '0', '2015-12-30 14:53:25', null, '123456');
