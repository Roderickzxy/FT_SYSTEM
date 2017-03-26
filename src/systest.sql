/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : yxxycms

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2015-07-30 06:24:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_info`;
CREATE TABLE `tb_info` (
  `info_id` int(10) NOT NULL AUTO_INCREMENT,
  `info1` varchar(100) DEFAULT NULL,
  `info2` varchar(100) DEFAULT NULL,
  `info3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_info
-- ----------------------------
INSERT INTO `tb_info` VALUES ('1', 'a1', 'a2', 'a3');
INSERT INTO `tb_info` VALUES ('2', 'b1', 'b2', 'b3');
INSERT INTO `tb_info` VALUES ('3', 'c1', 'c2', 'c3');
INSERT INTO `tb_info` VALUES ('4', 'd1', 'd2', 'd3');
INSERT INTO `tb_info` VALUES ('5', 'e1', 'e2', 'e3');
INSERT INTO `tb_info` VALUES ('6', 'f1', 'f2', 'f3');
INSERT INTO `tb_info` VALUES ('7', 'g1', 'g2', 'g3');
INSERT INTO `tb_info` VALUES ('8', 'h1', 'h2', 'h3');
INSERT INTO `tb_info` VALUES ('9', 'i1', 'i2', 'i3');
INSERT INTO `tb_info` VALUES ('10', 'j1', 'j2', 'j3');
INSERT INTO `tb_info` VALUES ('11', 'k1', 'k2', 'k3');
INSERT INTO `tb_info` VALUES ('12', 'l1', 'l2', 'l3');
INSERT INTO `tb_info` VALUES ('13', 'm1', 'm2', 'm3');
INSERT INTO `tb_info` VALUES ('14', 'n1', 'n2', 'n3');
INSERT INTO `tb_info` VALUES ('15', 'o1', 'o2', 'o3');
INSERT INTO `tb_info` VALUES ('16', 'p1', 'p2', 'p3');
INSERT INTO `tb_info` VALUES ('17', 'q1', 'q2', 'q3');
INSERT INTO `tb_info` VALUES ('18', 'r1', 'r2', 'r3');
INSERT INTO `tb_info` VALUES ('19', 's1', 's2', 's3');
INSERT INTO `tb_info` VALUES ('20', 't1', 't2', 't3');
INSERT INTO `tb_info` VALUES ('21', 'u1', 'u2', 'u3');
INSERT INTO `tb_info` VALUES ('22', 'v1', 'v2', 'v3');
INSERT INTO `tb_info` VALUES ('23', 'w1', 'w2', 'w3');
INSERT INTO `tb_info` VALUES ('24', 'x1', 'x2', 'x3');
INSERT INTO `tb_info` VALUES ('25', 'y1', 'y2', 'y3');
INSERT INTO `tb_info` VALUES ('26', 'z1', 'z2', 'z3');

-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `menu_id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '系统管理', '', null);
INSERT INTO `tb_menu` VALUES ('5', '用户管理', 'user.html', '1');
INSERT INTO `tb_menu` VALUES ('6', '角色管理', 'role.html', '1');
INSERT INTO `tb_menu` VALUES ('7', '菜单管理', 'menu.html', '1');
INSERT INTO `tb_menu` VALUES ('8', '内容管理', '', null);
INSERT INTO `tb_menu` VALUES ('9', '新闻管理', 'msg.html', '8');
INSERT INTO `tb_menu` VALUES ('10', '新闻类型', 'msgType.html', '8');
INSERT INTO `tb_menu` VALUES ('11', '导航管理', 'navigation.html', '8');
INSERT INTO `tb_menu` VALUES ('12', '系统设置', 'site.html', '8');
INSERT INTO `tb_menu` VALUES ('13', ' 作品管理', 'msgPic.html', '8');

-- ----------------------------
-- Table structure for `tb_msg`
-- ----------------------------
DROP TABLE IF EXISTS `tb_msg`;
CREATE TABLE `tb_msg` (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `loginname` varchar(50) DEFAULT NULL COMMENT '登录账号',
  `video` varchar(200) DEFAULT NULL COMMENT '视频路径',
  `pic` varchar(100) DEFAULT NULL COMMENT '图片1',
  `msg_type_id` int(11) DEFAULT NULL COMMENT '  usr ub ID',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_msg
-- ----------------------------
INSERT INTO `tb_msg` VALUES ('5', '测试', '测试啊内容', '启用', 'admin', null, null, null);
INSERT INTO `tb_msg` VALUES ('7', 'aaasss1', 'ssss1', '启用', 'admin', null, null, null);
INSERT INTO `tb_msg` VALUES ('8', '工作', '恭恭敬敬', '启用', 'admin', '111', '1', null);
INSERT INTO `tb_msg` VALUES ('10', '1ew', '2ww', '启用', 'admin', '2e', '3e', null);
INSERT INTO `tb_msg` VALUES ('11', 'qq', 'qq', '启用', 'admin', 'qe', '', null);
INSERT INTO `tb_msg` VALUES ('12', '112', '22', '启用', 'admin', '12121', '', null);
INSERT INTO `tb_msg` VALUES ('13', 'dd', 'dssd', '启用', 'admin', 'sdsd', '', null);
INSERT INTO `tb_msg` VALUES ('14', 'sdssd', 'sdsd', '启用', 'admin', 'dd', '', null);
INSERT INTO `tb_msg` VALUES ('15', 'ddww', 'ss', '启用', 'admin', 'dd', '', null);
INSERT INTO `tb_msg` VALUES ('16', 'zxx111', 'aas<img src=\"/yxxy/upload/image/20150727/20150727083643_301.gif\" alt=\"\" />', '启用', null, 'zxx111', '111', null);
INSERT INTO `tb_msg` VALUES ('17', 'aas', 'saa', '启用', 'admin', 'aa', '', null);
INSERT INTO `tb_msg` VALUES ('18', 'ssdsd', 'dssd你好。<img src=\"/yxxy/upload/image/20150727/20150727083731_541.gif\" alt=\"\" />', '启用', null, '111', null, null);
INSERT INTO `tb_msg` VALUES ('19', 'wwqw', 'wewe<img src=\"/yxxy/upload/image/20150729/20150729083735_348.gif\" alt=\"\" />', '启用', null, 'wwewe', '/yxxy/upload/image/20150729/20150729083743_305.gif', null);
INSERT INTO `tb_msg` VALUES ('20', '延时摄影的相机参数调整及后期处理小知识 ', '<p>\r\n	最近身旁有愈来愈朋友在玩延时摄影，而这是什么东东呢?其实说穿了，就是把原来记录了几个小时、几天，所拍摄的照片在短短的数分钟，透过动态影像的方式将它呈现出来，透过短短的数秒钟，就能看到一小时、一天的变化，看起来很酷，但其拍摄并不困难， \r\n且有不少相机内建就有此功能，就连iPhone也有相关的APP，而梅干趁假日闲来无事，用Nikon \r\nD700拍摄了一小段，并将拍摄的重点与给归纳出来，希望对于想玩延时的朋友有所帮助，现在就一块来看看吧!\r\n</p>\r\n<p>\r\n	所需工具：\r\n</p>\r\n<p>\r\n	相机三角脚：愈稳定愈好\r\n</p>\r\n<p>\r\n	机身：D700\r\n</p>\r\n<p>\r\n	快门线：若机身内建无定时拍摄功能，需另购定时电子拍摄器拍摄技巧：\r\n</p>\r\n<p>\r\n	曝光模式：A (光圈先决)\r\n</p>\r\n<p>\r\n	ISO：200~400\r\n</p>\r\n<p>\r\n	对焦：手动对焦\r\n</p>\r\n<p>\r\n	白平衡：自动\r\n</p>\r\n<img alt=\"如何用间隔定时拍摄拍好延时摄影 三联‘\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/ab3172aef3a0f6f227fe95900c25a25a.jpg\" height=\"447\" border=\"1\" width=\"650\" />\r\n<p>\r\n	将对焦模式，设成M(手动对焦)。\r\n</p>\r\n<img alt=\"如何用间隔定时拍摄拍好延时摄影 三联\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/c21fff14b93f09a32ccf91d0cf36782c.jpg\" height=\"433\" border=\"1\" width=\"650\" />\r\n<p>\r\n	旋转对焦环，进行对焦。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/b3f032ef01c769870e88446b590a0188.jpg\" height=\"548\" border=\"1\" width=\"650\" />\r\n<p>\r\n	按Menu钮，进到「拍摄选单」找到「间隔定时拍摄」选项 。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/77b9831971349293cf65e1f39b18ae51.jpg\" height=\"558\" border=\"1\" width=\"650\" />\r\n<p>\r\n	选择「实时」选项。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/d4b687847fd181b57351d208a009d780.jpg\" height=\"545\" border=\"1\" width=\"650\" />\r\n<p>\r\n	设定多久拍一张，若是拍摄变化性较大的，拍摄间隔可设短一短会较顺项，若是像拍花卉，可能很久才有变化一次，就可设定5分钟或10分钟拍一张。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/59819274a88f9de3d065a2936d8696da.jpg\" height=\"550\" border=\"1\" width=\"650\" />\r\n<p>\r\n	再来就是设定拍摄的次数。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/3d90690929b3c851238911c004102346.jpg\" height=\"558\" border=\"1\" width=\"650\" />\r\n<p>\r\n	设定完成后，在下面就会看到每5秒拍一张，共拍100次，确定没问题后，就按「OK」。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/c9a9d60aad9c28a8e63679d08aca49b4.jpg\" height=\"433\" border=\"1\" width=\"650\" />\r\n<p>\r\n	在相机的面板，会看到INTVL字样，就会开始自动拍摄。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/3952f98c4464c2f10c91e807aef908b9.jpg\" height=\"433\" border=\"1\" width=\"650\" />\r\n<p>\r\n	这时什么事也不用作，拿出手机打发时间。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/7e9897ee59b2bc5fde8608a3eb876741.jpg\" height=\"485\" border=\"1\" width=\"650\" />\r\n<p>\r\n	过数小时后，就会看到一连串的静态照片。\r\n</p>\r\n<p>\r\n	接着就可利用后期工具，将序列影像，变成动态影片，以下就是串起来的效果，没想到看似不会动的云，却波涛汹涌，大自然真是奥妙。\r\n</p>\r\n<p>\r\n	之前在Photoshop加入影片功能时，梅干觉得这真是多此一举，随着版本不断的更新，功能逐渐的强化后，从原来的堪用也转变成可用，因此若手边有Photoshop \r\nCS6的朋友，透过Photoshop CS6后制就可快速，将照片串连起来成缩时摄影，是个相当方便的工具。Photoshop CS6延时摄影：\r\n</p>\r\n<p>\r\n	使用版本：Photoshop CS6\r\n</p>\r\n<p>\r\n	操作难易：易\r\n</p>\r\n<p>\r\n	实用性质：★★★★★\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/67b14544d577a07f147df5d2a1c8b869.jpg\" height=\"479\" border=\"1\" width=\"600\" />\r\n<p>\r\n	Step1\r\n</p>\r\n<p>\r\n	接着开启Photoshop CS6，选择功能表 档案 / 开启旧档。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/79404a0b4c248069a7cc0e706779e297.jpg\" height=\"464\" border=\"1\" width=\"700\" />\r\n<p>\r\n	Step2\r\n</p>\r\n<p>\r\n	对着第一张图片点一下，再把下方的「影像顺序」勾起来，接着按开启旧档。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/587f06c171759c90f668cd252607e31b.jpg\" height=\"491\" border=\"1\" width=\"592\" />\r\n<p>\r\n	Step3\r\n</p>\r\n<p>\r\n	设定影的速率，一般网页上，设定24~30格皆可。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/df818d4c60440f7efec5023cfb377e37.jpg\" height=\"311\" border=\"1\" width=\"492\" />\r\n<p>\r\n	Step4\r\n</p>\r\n<p>\r\n	载入完成后，在「时间轴」面板，就会看到影片片段，接着点「时间轴」面板下方的箭头图示，将影片输出。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/2fcd44c666643cb015a8a411f7401d66.jpg\" height=\"551\" border=\"1\" width=\"700\" />\r\n<p>\r\n	Step5\r\n</p>\r\n<p>\r\n	接着设定输出影片名称、位置、格式。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/c8870cf2965cf7053f2d15a9a932c1c9.jpg\" height=\"619\" border=\"1\" width=\"638\" />\r\n<p>\r\n	Step6\r\n</p>\r\n<p>\r\n	再按下「演算」，就会开始跑了。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/ffee6254e872e42099f0568a665bd01a.jpg\" height=\"498\" border=\"1\" width=\"700\" />\r\n<p>\r\n	Step7\r\n</p>\r\n<p>\r\n	完成后，在刚的资料夹，就会看到输出的影片档。\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/e742611ed27a1ca5e9e87d40c87758c9.jpg\" height=\"591\" border=\"1\" width=\"675\" />\r\n<p>\r\n	Step8\r\n</p>\r\n<p>\r\n	双响后就可直接播放影片，没想到拍了一个多小时，只有短短五秒钟XD~\r\n</p>\r\n<img alt=\"教你用间隔定时拍摄延时摄影\" src=\"http://img13.3lian.com/edu201311/h/h101/201311/acb2b3dfa7dff6bd8ef32bd997194f31.jpg\" height=\"518\" border=\"1\" width=\"670\" />', '启用', null, '', '', null);

-- ----------------------------
-- Table structure for `tb_msg_type`
-- ----------------------------
DROP TABLE IF EXISTS `tb_msg_type`;
CREATE TABLE `tb_msg_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `code` varchar(10) DEFAULT NULL COMMENT '代号',
  `parent` int(11) DEFAULT NULL COMMENT '父栏目',
  `child` int(11) DEFAULT NULL COMMENT '子栏目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_msg_type
-- ----------------------------
INSERT INTO `tb_msg_type` VALUES ('2', '企业新闻', 'HYXW', null, null);
INSERT INTO `tb_msg_type` VALUES ('4', '行业新闻', 'JYXW', null, null);
INSERT INTO `tb_msg_type` VALUES ('5', '作品展览', 'ZPZL1', null, null);
INSERT INTO `tb_msg_type` VALUES ('6', '影像学院', 'YXXY', null, null);

-- ----------------------------
-- Table structure for `tb_navigation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_navigation`;
CREATE TABLE `tb_navigation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `code` varchar(10) DEFAULT NULL COMMENT '代号',
  `url` varchar(200) DEFAULT NULL COMMENT '链接地址',
  `pic` varchar(150) DEFAULT NULL COMMENT '背景图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_navigation
-- ----------------------------
INSERT INTO `tb_navigation` VALUES ('2', '首页', 'index', null, null);
INSERT INTO `tb_navigation` VALUES ('3', '企业新闻', 'qyxw', null, null);
INSERT INTO `tb_navigation` VALUES ('4', '行业信息', 'hyxx', 'http;//www.baidu.com', null);
INSERT INTO `tb_navigation` VALUES ('6', '测试', 'test', 'http://www.sina.com', null);
INSERT INTO `tb_navigation` VALUES ('8', '1', '11', '11', null);
INSERT INTO `tb_navigation` VALUES ('10', 'www11', 'ww1', 'ww1', null);

-- ----------------------------
-- Table structure for `tb_pic`
-- ----------------------------
DROP TABLE IF EXISTS `tb_pic`;
CREATE TABLE `tb_pic` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `msg_id` bigint(11) DEFAULT NULL COMMENT '新闻ID',
  `pic` varchar(150) DEFAULT NULL COMMENT '图片地址',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `descripse` text COMMENT '描述',
  `status` varchar(10) DEFAULT NULL COMMENT '启用状态 1--启用，0--停用',
  `pic_type_id` bigint(11) DEFAULT NULL COMMENT '作品分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pic
-- ----------------------------
INSERT INTO `tb_pic` VALUES ('1', null, '/yxxy/upload/image/20150729/20150729091010_431.gif', '111', 'wwwww', '启用', null);
INSERT INTO `tb_pic` VALUES ('2', '1', '/yxxy/upload/image/20150729/20150729084721_444.gif', '11', '212', '启用', null);
INSERT INTO `tb_pic` VALUES ('4', '1', '/yxxy/upload/image/20150729/20150729085132_128.gif', '1112212', '22', '启用', null);

-- ----------------------------
-- Table structure for `tb_pic_type`
-- ----------------------------
DROP TABLE IF EXISTS `tb_pic_type`;
CREATE TABLE `tb_pic_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `code` varchar(10) DEFAULT NULL COMMENT '代号',
  `parent` int(11) DEFAULT NULL COMMENT '父栏目',
  `child` int(11) DEFAULT NULL COMMENT '子栏目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pic_type
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  `rights` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '系统管理员', '16354');
INSERT INTO `tb_role` VALUES ('2', '普通用户', '768');
INSERT INTO `tb_role` VALUES ('3', '系统用户', '230374');

-- ----------------------------
-- Table structure for `tb_site`
-- ----------------------------
DROP TABLE IF EXISTS `tb_site`;
CREATE TABLE `tb_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(100) DEFAULT NULL COMMENT '域名',
  `backimg` varchar(150) DEFAULT NULL COMMENT '背景图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_site
-- ----------------------------
INSERT INTO `tb_site` VALUES ('2', 'http://www.baidu.com', 'abc.jpg');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `rights` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', '管理员', '16354', '0', '1', '2015-07-29 15:49:36');
INSERT INTO `tb_user` VALUES ('2', 'test', 'test', '测试', '16354', '0', '2', '2015-06-24 00:24:48');
INSERT INTO `tb_user` VALUES ('3', 'lulu', 'lulu', '鹭鹭', '16354', '0', '3', null);
