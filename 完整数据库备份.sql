/*
MySQL Backup
Database: flower
Backup Time: 2020-06-01 08:58:41
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `flower`.`customer`;
DROP TABLE IF EXISTS `flower`.`flower`;
DROP TABLE IF EXISTS `flower`.`flowerstore`;
DROP TABLE IF EXISTS `flower`.`orders`;
DROP TABLE IF EXISTS `flower`.`shoplist`;
DROP TABLE IF EXISTS `flower`.`user`;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT COMMENT '顾客编号',
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `customer_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '顾客性别',
  `customer_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性签名',
  `customer_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '顾客电话',
  PRIMARY KEY (`customer_id`,`customer_name`) USING BTREE,
  KEY `customer_name` (`customer_name`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=143272 DEFAULT CHARSET=utf8;
CREATE TABLE `flower` (
  `flower_id` int NOT NULL AUTO_INCREMENT COMMENT '鲜花编号',
  `flower_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鲜花名字',
  `flower_num` int DEFAULT NULL COMMENT '库存数量',
  `flower_price` int DEFAULT NULL COMMENT '价格',
  `flower_color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '颜色',
  `store_id` int DEFAULT NULL COMMENT '商店编号',
  PRIMARY KEY (`flower_id`) USING BTREE,
  KEY `StoreID` (`store_id`),
  CONSTRAINT `StoreID` FOREIGN KEY (`store_id`) REFERENCES `flowerstore` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53314 DEFAULT CHARSET=utf8;
CREATE TABLE `flowerstore` (
  `store_id` int NOT NULL AUTO_INCREMENT COMMENT '商店编号',
  `store_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商店名字',
  `store_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商店位置',
  `store_Bishours` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '营业时间',
  PRIMARY KEY (`store_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=124372 DEFAULT CHARSET=utf8;
CREATE TABLE `orders` (
  `orders_id` int NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `flower_id` int DEFAULT NULL COMMENT '鲜花编号',
  `quantity` int DEFAULT NULL COMMENT '购买数量',
  `customer_id` int DEFAULT NULL COMMENT '顾客编号',
  `date` datetime DEFAULT NULL COMMENT '购买日期',
  `store_id` int DEFAULT NULL COMMENT '商店编号',
  PRIMARY KEY (`orders_id`),
  KEY `flower_ID` (`flower_id`),
  KEY `Customer_ID` (`customer_id`),
  KEY `Store_ID` (`store_id`),
  CONSTRAINT `Customer_ID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `flower_ID` FOREIGN KEY (`flower_id`) REFERENCES `flower` (`flower_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Store_ID` FOREIGN KEY (`store_id`) REFERENCES `flowerstore` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4670 DEFAULT CHARSET=utf8;
CREATE TABLE `shoplist` (
  `shoplist_id` int NOT NULL AUTO_INCREMENT COMMENT '宝贝编号',
  `customer_id` int DEFAULT NULL COMMENT '顾客编号',
  `flower_id` int DEFAULT NULL COMMENT '鲜花编号',
  `buynum` int DEFAULT NULL COMMENT '购买数量',
  `allprice` int DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`shoplist_id`),
  KEY `CustomerID` (`customer_id`),
  KEY `FlowerID` (`flower_id`),
  CONSTRAINT `CustomerID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FlowerID` FOREIGN KEY (`flower_id`) REFERENCES `flower` (`flower_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `user_id` int NOT NULL COMMENT '用户编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`),
  KEY `UserName` (`name`),
  CONSTRAINT `UserID` FOREIGN KEY (`user_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UserName` FOREIGN KEY (`name`) REFERENCES `customer` (`customer_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `flower`.`customer` WRITE;
DELETE FROM `flower`.`customer`;
INSERT INTO `flower`.`customer` (`customer_id`,`customer_name`,`customer_sex`,`customer_sign`,`customer_phone`) VALUES (1, 'root', 'Man', 'Alone', '999999'),(143258, 'RuvikM', '男', 'Nia!不要过来啊~', '16693932085'),(143261, 'Admin', '男', '', '12999'),(143262, '我是天才', NULL, NULL, NULL),(143266, 'LordVoldemort', '女', '嘿嘿嘿', '123214214'),(143267, 'Ruvik', '男', '12345，我要shi了', '1111'),(143269, 'Lord', NULL, NULL, NULL),(143270, 'LordM', '女', '1111', '123321'),(143271, 'LordN', '女', '111', '111');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`flower` WRITE;
DELETE FROM `flower`.`flower`;
INSERT INTO `flower`.`flower` (`flower_id`,`flower_name`,`flower_num`,`flower_price`,`flower_color`,`store_id`) VALUES (53287, '玫瑰', 210, 6, '褐玫瑰红', 12314),(53288, '紫罗兰', 640, 8, '暗紫罗兰色', 12314),(53289, '薰衣草', 149, 4, '暗紫色', 12314),(53290, '郁金香', 466, 13, '暗深红色', 12314),(53291, '勿忘我', 872, 9, '暗紫罗兰色', 12314),(53292, '满天星', 862, 5, '钢兰色', 12314),(53293, '非洲菊', 531, 8, '金色', 12315),(53294, '风信子', 732, 15, '间紫色', 12315),(53295, '百合花', 597, 19, '幽灵白', 12315),(53296, '剑兰', 480, 4, '亮珊瑚色', 12315),(53304, '梅花', 20, 44, '白色', 12314),(53309, '菊花', 390, 12, '浅粉色', 12315),(53311, '茉莉花', 88, 20, '雪白色', 12316),(53312, '兰花', 69, 19, '橘色', 12314),(53313, '月季', 74, 13, '粉色', 12315);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`flowerstore` WRITE;
DELETE FROM `flower`.`flowerstore`;
INSERT INTO `flower`.`flowerstore` (`store_id`,`store_name`,`store_location`,`store_Bishours`) VALUES (12314, '花梦谷', '上海', '7:00---19:00'),(12315, '奢漫花田', '上海', '9:00--17:00'),(12316, '小美的鲜花店', '三角洲', '14:00--19:00'),(124370, '沃尔玛', '北京', '9:00—14:00'),(124371, '联华', '上海', '10:00-18:00');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`orders` WRITE;
DELETE FROM `flower`.`orders`;
INSERT INTO `flower`.`orders` (`orders_id`,`flower_id`,`quantity`,`customer_id`,`date`,`store_id`) VALUES (4653, 53292, 99, 143267, '2020-05-25 10:18:58', 12314),(4654, 53290, 13, 143267, '2020-05-25 10:19:09', 12315),(4655, 53295, 1, 143267, '2020-05-25 11:30:21', 12314),(4656, 53296, 12, 143267, '2020-05-26 17:08:23', 12315),(4657, 53304, 13, 143267, '2020-05-26 17:08:43', 12314),(4658, 53294, 123, 143267, '2020-05-26 17:09:28', 12315),(4659, 53304, 10, 143267, '2020-05-26 17:16:11', 12314),(4660, 53296, 1, 143267, '2020-05-26 17:19:13', 12315),(4661, 53295, 26, 143267, '2020-05-26 17:21:42', 12315),(4662, 53311, 12, 143267, '2020-05-26 19:03:15', 12316),(4663, 53291, 2, 143267, '2020-05-26 19:17:10', 12314),(4664, 53290, 10, 143267, '2020-05-26 19:18:57', 12314),(4665, 53287, 7, 143267, '2020-05-26 19:22:04', 12314),(4666, 53309, 10, 143270, '2020-05-30 23:47:21', 12315),(4667, 53312, 31, 143270, '2020-05-30 23:52:15', 12314),(4668, 53313, 1, 143271, '2020-05-31 00:01:05', 12315),(4669, 53313, 13, 143271, '2020-05-31 00:01:10', 12315);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`shoplist` WRITE;
DELETE FROM `flower`.`shoplist`;
INSERT INTO `flower`.`shoplist` (`shoplist_id`,`customer_id`,`flower_id`,`buynum`,`allprice`) VALUES (134, 143258, 53292, 999, 4995),(174, 143258, 53304, 29, 1276),(186, 143269, 53295, -11, -209),(188, 143267, 53287, -11, -66),(192, 143271, 53313, 13, 13);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`user` WRITE;
DELETE FROM `flower`.`user`;
INSERT INTO `flower`.`user` (`user_id`,`name`,`password`) VALUES (1, 'root', '123321'),(143258, 'RuvikM', '123321'),(143261, 'Admin', '123123'),(143262, '我是天才', '123123'),(143266, 'LordVoldemort', '123321'),(143267, 'Ruvik', '123'),(143269, 'Lord', '123321'),(143270, 'LordM', '111111'),(143271, 'LordN', '123321');
UNLOCK TABLES;
COMMIT;
