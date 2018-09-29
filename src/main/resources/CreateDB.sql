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
    `is_active` BOOLEAN NOT NULL , 
    CONSTRAINT pk_category_id PRIMARY KEY (`id`)
) ENGINE = MyISAM;

INSERT INTO `category`(`name`, `description`, `image_url`, `is_active`) VALUES ("Mobile", "Lorem ipsum", "mobile.jpg", 1);
INSERT INTO `category`(`name`, `description`, `image_url`, `is_active`) VALUES ("Television", "Lorem ipsum", "television.jpg", 1);
INSERT INTO `category`(`name`, `description`, `image_url`, `is_active`) VALUES ("Laptop", "Lorem ipsum", "laptop.jpg", 1);

/* USER DETAILS */
CREATE TABLE `onlineshop`.`user_detail` ( 
    `id` INT NOT NULL AUTO_INCREMENT , 
    `first_name` VARCHAR(50) NOT NULL , 
    `last_name` VARCHAR(50) NOT NULL , 
    `role` VARCHAR(50) NOT NULL , 
    `enabled` BOOLEAN NOT NULL , 
    `password` VARCHAR(50) NOT NULL , 
    `email` VARCHAR(50) NOT NULL , 
    `contact_number` VARCHAR(50) NOT NULL , 
    CONSTRAINT pk_use_id PRIMARY KEY (`id`))
) ENGINE = MyISAM;

INSERT INTO `user_detail`(`first_name`, `last_name`, `role`, `enabled`, `password`, `email`, `contact_number`) 
    VALUES ("Przemek", "C", "ADMIN", true, "123", "pc@mail.com", "123456789");
INSERT INTO `user_detail`(`first_name`, `last_name`, `role`, `enabled`, `password`, `email`, `contact_number`) 
    VALUES ("User1", "Nazwisko1", "SUPPLIER", true, "111", "user1@email.com", "111111111");
INSERT INTO `user_detail`(`first_name`, `last_name`, `role`, `enabled`, `password`, `email`, `contact_number`) 
    VALUES ("User2", "Nazwisko2", "SUPPLIER", true, "222", "user2@email.com", "222222222");

/* PRODUCT */
CREATE TABLE `onlineshop`.`product` ( 
    `id` INT NOT NULL AUTO_INCREMENT , 
    `code` VARCHAR(20) NOT NULL , 
    `name` VARCHAR(50) NOT NULL , 
    `brand` VARCHAR(50) NOT NULL , 
    `description` VARCHAR(255) NOT NULL , 
    `unit_price` DECIMAL(10, 2) NOT NULL , 
    `quantity` INT NOT NULL , 
    `is_active` BOOLEAN NOT NULL , 
    `category_id` INT NOT NULL , 
    `supplier_id` INT NOT NULL , 
    `purchases` INT NOT NULL DEFAULT '0' , 
    `views` INT NOT NULL DEFAULT '0' , 
    CONSTRAINT pk_product_id PRIMARY KEY (`id`),
    CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
    CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
) ENGINE = MyISAM;

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
    VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
    VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 1, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
    VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
    VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
    VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 3, 3, 0, 0 );
