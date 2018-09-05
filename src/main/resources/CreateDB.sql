/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Przemek
 * Created: 2018-09-05
 */
CREATE TABLE `onlineshop`.`category` ( 
    `id` INT NOT NULL AUTO_INCREMENT , 
    `name` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL, 
    `description` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL , 
    `image_url` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL , 
    `is_active` BOOLEAN NOT NULL , PRIMARY KEY (`id`)
) ENGINE = MyISAM;

INSERT INTO `category`(`name`, `description`, `image_url`, `is_active`) VALUES ("Mobile", "Lorem ipsum", "mobile.jpg", 1);
INSERT INTO `category`(`name`, `description`, `image_url`, `is_active`) VALUES ("Television", "Lorem ipsum", "television.jpg", 1);
INSERT INTO `category`(`name`, `description`, `image_url`, `is_active`) VALUES ("Tablet", "Lorem ipsum", "tablet.jpg", 1);