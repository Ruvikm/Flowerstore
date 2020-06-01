/*
MySQL Backup
Database: flower
Backup Time: 2020-05-26 19:39:02
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `flower`.`customer`;
DROP TABLE IF EXISTS `flower`.`flower`;
DROP TABLE IF EXISTS `flower`.`flowerstore`;
DROP TABLE IF EXISTS `flower`.`orders`;
DROP TABLE IF EXISTS `flower`.`shoplist`;
DROP TABLE IF EXISTS `flower`.`user`;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `customer_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `customer_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `customer_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `customer_name` (`customer_name`)
) ENGINE=InnoDB AUTO_INCREMENT=143268 DEFAULT CHARSET=utf8;
CREATE TABLE `flower` (
  `flower_id` int NOT NULL AUTO_INCREMENT,
  `flower_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `flower_num` int DEFAULT NULL,
  `flower_price` int DEFAULT NULL,
  `flower_color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`flower_id`) USING BTREE,
  KEY `StoreID` (`store_id`),
  CONSTRAINT `StoreID` FOREIGN KEY (`store_id`) REFERENCES `flowerstore` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53312 DEFAULT CHARSET=utf8;
CREATE TABLE `flowerstore` (
  `store_id` int NOT NULL AUTO_INCREMENT,
  `store_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `store_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `store_Bishours` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`store_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=124370 DEFAULT CHARSET=utf8;
CREATE TABLE `orders` (
  `orders_id` int NOT NULL AUTO_INCREMENT,
  `flower_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`orders_id`),
  KEY `flower_ID` (`flower_id`),
  KEY `Customer_ID` (`customer_id`),
  KEY `Store_ID` (`store_id`),
  CONSTRAINT `Customer_ID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `flower_ID` FOREIGN KEY (`flower_id`) REFERENCES `flower` (`flower_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Store_ID` FOREIGN KEY (`store_id`) REFERENCES `flowerstore` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4666 DEFAULT CHARSET=utf8;
CREATE TABLE `shoplist` (
  `shoplist_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `flower_id` int DEFAULT NULL,
  `buynum` int DEFAULT NULL,
  `allprice` int DEFAULT NULL,
  PRIMARY KEY (`shoplist_id`),
  KEY `CustomerID` (`customer_id`),
  KEY `FlowerID` (`flower_id`),
  CONSTRAINT `CustomerID` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FlowerID` FOREIGN KEY (`flower_id`) REFERENCES `flower` (`flower_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `UserName` (`name`),
  CONSTRAINT `UserID` FOREIGN KEY (`user_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UserName` FOREIGN KEY (`name`) REFERENCES `customer` (`customer_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `flower`.`customer` WRITE;
DELETE FROM `flower`.`customer`;
INSERT INTO `flower`.`customer` (`customer_id`,`customer_name`,`customer_sex`,`customer_sign`,`customer_phone`) VALUES (1, 'root', 'Man', 'Alone', '999999'),(143258, 'RuvikM', '男', 'Nia!不要过来啊~', '16693932085'),(143261, 'Admin', '男', '', '12999'),(143262, '我是天才', NULL, NULL, NULL),(143266, 'LordVoldemort', '女', '嘿嘿嘿', '123214214'),(143267, 'Ruvik', '男', '12345，我要shi了', '1111');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`flower` WRITE;
DELETE FROM `flower`.`flower`;
INSERT INTO `flower`.`flower` (`flower_id`,`flower_name`,`flower_num`,`flower_price`,`flower_color`,`store_id`) VALUES (53287, '玫瑰', 210, 6, '褐玫瑰红', 12314),(53288, '紫罗兰', 640, 8, '暗紫罗兰色', 12314),(53289, '薰衣草', 239, 4, '暗紫色', 12314),(53290, '郁金香', 466, 13, '暗深红色', 12314),(53291, '勿忘我', 872, 9, '暗紫罗兰色', 12314),(53292, '满天星', 862, 5, '钢兰色', 12314),(53293, '非洲菊', 531, 8, '金色', 12315),(53294, '风信子', 732, 15, '间紫色', 12315),(53295, '百合花', 597, 19, '幽灵白', 12315),(53296, '剑兰', 480, 4, '亮珊瑚色', 12315),(53304, '梅花', 20, 44, '白色', 12314),(53309, '菊花', 400, 12, '浅粉色', 12315),(53311, '茉莉花', 8, 20, '雪白色', 12316);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`flowerstore` WRITE;
DELETE FROM `flower`.`flowerstore`;
INSERT INTO `flower`.`flowerstore` (`store_id`,`store_name`,`store_location`,`store_Bishours`) VALUES (12314, '花梦谷', '大连', '7:00---19:00'),(12315, '奢漫花田', '上海', '9:00--17:00'),(12316, '小美的鲜花店', '三角洲', '14:00--19:00');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`orders` WRITE;
DELETE FROM `flower`.`orders`;
INSERT INTO `flower`.`orders` (`orders_id`,`flower_id`,`quantity`,`customer_id`,`date`,`store_id`) VALUES (4653, 53292, 99, 143267, '2020-05-25 10:18:58', 12314),(4654, 53290, 13, 143267, '2020-05-25 10:19:09', 12315),(4655, 53295, 1, 143267, '2020-05-25 11:30:21', 12314),(4656, 53296, 12, 143267, '2020-05-26 17:08:23', 12315),(4657, 53304, 13, 143267, '2020-05-26 17:08:43', 12314),(4658, 53294, 123, 143267, '2020-05-26 17:09:28', 12315),(4659, 53304, 10, 143267, '2020-05-26 17:16:11', 12314),(4660, 53296, 1, 143267, '2020-05-26 17:19:13', 12315),(4661, 53295, 26, 143267, '2020-05-26 17:21:42', 12315),(4662, 53311, 12, 143267, '2020-05-26 19:03:15', 12316),(4663, 53291, 2, 143267, '2020-05-26 19:17:10', 12314),(4664, 53290, 10, 143267, '2020-05-26 19:18:57', 12314),(4665, 53287, 7, 143267, '2020-05-26 19:22:04', 12314);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`shoplist` WRITE;
DELETE FROM `flower`.`shoplist`;
INSERT INTO `flower`.`shoplist` (`shoplist_id`,`customer_id`,`flower_id`,`buynum`,`allprice`) VALUES (134, 143258, 53292, 999, 4995),(174, 143258, 53304, 29, 1276),(185, 143267, 53293, 112, 896);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `flower`.`user` WRITE;
DELETE FROM `flower`.`user`;
INSERT INTO `flower`.`user` (`user_id`,`name`,`password`) VALUES (1, 'root', '123321'),(143258, 'RuvikM', '123321'),(143261, 'Admin', '123123'),(143262, '我是天才', '123123'),(143266, 'LordVoldemort', '123321'),(143267, 'Ruvik', '123');
UNLOCK TABLES;
COMMIT;
