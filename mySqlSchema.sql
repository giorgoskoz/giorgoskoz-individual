CREATE DATABASE `giorgoskozindividualv2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `giorgoskozindividualv2`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` int(11) NOT NULL,
  `banned` tinyint(4) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

 
CREATE TABLE `messages` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `message_content` varchar(250) NOT NULL,
  `deleted_by_sender` tinyint(4) NOT NULL,
  `deleted_by_receiver` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  UNIQUE KEY `message_id_UNIQUE` (`message_id`),
  KEY `message sender id_idx` (`sender_id`),
  KEY `message receiver id_idx` (`receiver_id`),
  CONSTRAINT `message receiver id` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE,
  CONSTRAINT `message sender id` FOREIGN KEY (`sender_id`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `giorgoskozindividualv2`.`dailypass` (
  `dailypass_id` INT NOT NULL AUTO_INCREMENT,
  `dailypass_source` VARCHAR(45) NOT NULL,
  `dailypass_value` INT NOT NULL,
  PRIMARY KEY (`dailypass_id`));

INSERT INTO `users` VALUES(default, 'admin', 'admin', 6, 0);
INSERT INTO `users` VALUES(default, 'agent47', 'agent47', 1, 0);
INSERT INTO `users` VALUES(default, 'jbond', '007', 2, 0);
INSERT INTO `users` VALUES(default, 'q', 'q', 5, 0);
INSERT INTO `users` VALUES(default, 'editor1', 'editor1', 4, 0);
INSERT INTO `users` VALUES(default, 'alect', 'alect', 2, 0);

SELECT * FROM `users`;

INSERT INTO `messages` VALUES(default, NOW(), 15, 16, 'which button on the key unlocks the aston again?', 0, 0);
INSERT INTO `messages` VALUES(default, NOW(), 18, 16, 'oh so I get the lada again?', 0, 0);
INSERT INTO `messages` VALUES(default, NOW(), 16, 18, 'even IT is too good for you', 0, 0);
INSERT INTO `messages` VALUES(default, NOW(), 16, 15, 'I\'m coming to pick it up, it\'s the bus for you', 0, 0);

SELECT * FROM `messages` ORDER BY date_sent ASC;

UPDATE MESSAGES SET `deleted_by_sender` = 0 WHERE `message_id` = 15; 

DELETE FROM `messages` WHERE `message_id` = 13;

SELECT * FROM `messages` WHERE `sender_id` = 16 || `receiver_id` = 16 ORDER BY `date` ASC;

INSERT INTO `dailypass` VALUES(default, 'makeleio', 1111);