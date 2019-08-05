/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.21-MariaDB : Database - petboss
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`petboss` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `petboss`;

/*Table structure for table `bookings` */

DROP TABLE IF EXISTS `bookings`;

CREATE TABLE `bookings` (
  `id` varchar(255) NOT NULL,
  `booking_slot` date DEFAULT NULL,
  `booking_type` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `month_code` int(11) DEFAULT NULL,
  `pet_chip_code` varchar(255) DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `value_date` date DEFAULT NULL,
  `value_month` varchar(20) DEFAULT NULL,
  `value_quarter` varchar(20) DEFAULT NULL,
  `value_week` varchar(20) DEFAULT NULL,
  `value_year` int(11) DEFAULT NULL,
  `week_code` int(11) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bookings_client` (`client`),
  CONSTRAINT `FK_bookings_client` FOREIGN KEY (`client`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bookings` */

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` varchar(255) NOT NULL,
  `brand_description` varchar(255) DEFAULT NULL,
  `brand_name` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `brand` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` varchar(255) NOT NULL,
  `category_description` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category` */

/*Table structure for table `client_account` */

DROP TABLE IF EXISTS `client_account`;

CREATE TABLE `client_account` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `debit` double DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `month_code` int(11) DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `value_date` date DEFAULT NULL,
  `value_month` varchar(20) DEFAULT NULL,
  `value_quarter` varchar(20) DEFAULT NULL,
  `value_week` varchar(20) DEFAULT NULL,
  `value_year` int(11) DEFAULT NULL,
  `week_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `client_account` */

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `id` varchar(255) NOT NULL,
  `address_line` varchar(255) DEFAULT NULL,
  `address_line1` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `date_of_registration` date DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `other_names` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `telephone_number` varchar(255) DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clients` */

insert  into `clients`(`id`,`address_line`,`address_line1`,`created_date`,`date_of_registration`,`deleted`,`email`,`last_modified_by`,`last_modified_date`,`mobile_number`,`other_names`,`surname`,`telephone_number`,`updated`) values ('6533e139cc7842e6ae4fa773094004aa',NULL,NULL,'2017-04-15 00:38:43',NULL,0,NULL,NULL,'2017-04-15 00:38:43',NULL,NULL,NULL,NULL,0);

/*Table structure for table `diagnosis` */

DROP TABLE IF EXISTS `diagnosis`;

CREATE TABLE `diagnosis` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `diagnosis_category` varchar(255) DEFAULT NULL,
  `diagnosis_name` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `diagnosis` */

insert  into `diagnosis`(`id`,`created_date`,`deleted`,`description`,`diagnosis_category`,`diagnosis_name`,`last_modified_by`,`last_modified_date`,`updated`) values ('d33d0b1db59341fc99ed5f21393a8742','2017-04-16 20:38:11',0,'','GENERAL_TREATMENTS','Tick Fever',NULL,'2017-04-16 20:40:28',0);

/*Table structure for table `diagnosis_category` */

DROP TABLE IF EXISTS `diagnosis_category`;

CREATE TABLE `diagnosis_category` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `diagnosis_name` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `diagnosis_category` */

/*Table structure for table `pet_boarding` */

DROP TABLE IF EXISTS `pet_boarding`;

CREATE TABLE `pet_boarding` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `month_code` int(11) DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `value_date` date DEFAULT NULL,
  `value_month` varchar(20) DEFAULT NULL,
  `value_quarter` varchar(20) DEFAULT NULL,
  `value_week` varchar(20) DEFAULT NULL,
  `value_year` int(11) DEFAULT NULL,
  `week_code` int(11) DEFAULT NULL,
  `pet` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pet_boarding_pet` (`pet`),
  CONSTRAINT `FK_pet_boarding_pet` FOREIGN KEY (`pet`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pet_boarding` */

/*Table structure for table `pets` */

DROP TABLE IF EXISTS `pets`;

CREATE TABLE `pets` (
  `id` varchar(255) NOT NULL,
  `chip_code` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `date_of_registration` date DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `pet_type` varchar(255) DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `owner` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pets_owner` (`owner`),
  CONSTRAINT `FK_pets_owner` FOREIGN KEY (`owner`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pets` */

/*Table structure for table `prescriptions` */

DROP TABLE IF EXISTS `prescriptions`;

CREATE TABLE `prescriptions` (
  `id` varchar(255) NOT NULL,
  `product` varchar(255) DEFAULT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `price` double DEFAULT '0',
  `dosage_quantity` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_prescriptions_product` (`product`),
  KEY `FK_prescriptions_diagnosis` (`diagnosis`),
  CONSTRAINT `FK_prescriptions_diagnosis` FOREIGN KEY (`diagnosis`) REFERENCES `diagnosis` (`id`),
  CONSTRAINT `FK_prescriptions_product` FOREIGN KEY (`product`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `prescriptions` */

insert  into `prescriptions`(`id`,`product`,`diagnosis`,`price`,`dosage_quantity`,`created_date`,`deleted`,`last_modified_by`,`last_modified_date`,`updated`) values ('82e8ff423e6c49e4aebd61cbf408a780','4c9006b8773b4c839ef40cd1ff02b83c','d33d0b1db59341fc99ed5f21393a8742',20,'7mg','2017-04-17 22:41:50',0,NULL,'2017-04-17 23:21:26',0);

/*Table structure for table `product_form` */

DROP TABLE IF EXISTS `product_form`;

CREATE TABLE `product_form` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `form_name` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_form` */

insert  into `product_form`(`id`,`created_date`,`deleted`,`description`,`form_name`,`last_modified_by`,`last_modified_date`,`updated`) values ('2c100e65309e444984fda09b88d86926','2017-04-15 00:12:11',0,'','Bead',NULL,'2017-04-15 00:12:26',0),('2c16c1543b3845079685c7720c8d8560','2017-04-15 00:12:04',0,'','Aerosol',NULL,'2017-04-15 00:12:11',0),('2f87d908a85d4a2199fa80f54ac48fbd','2017-04-15 00:11:51',0,'','Biscuit',NULL,'2017-04-15 00:11:58',0),('4c4946064ccc4e109938f6c03a64f837','2017-04-15 00:11:58',0,'','Dressing',NULL,'2017-04-15 00:12:04',0),('616280283c624a11ab0264fa5805d02c','2017-04-15 00:12:46',0,'','Cartridge',NULL,'2017-04-15 00:13:15',0),('872ef3540c45493886068ca7d3a144da','2017-04-15 00:12:32',0,'','Cement',NULL,'2017-04-15 00:12:46',0),('c02ae332486f4d21964d0322bba6066b','2017-04-15 00:13:15',0,'','Bolus',NULL,'2017-04-15 00:13:20',0),('c5ea08aa4b164f79bbf8c64b812917a6','2017-04-15 00:12:26',0,'','Bar Chewable',NULL,'2017-04-15 00:12:32',0),('c92a719319cd4c2dba556a2fb57bf0dc','2017-04-15 00:10:40',0,'','Pellet',NULL,'2017-04-15 00:10:46',0),('cb266b8cca3e4bb894b2f99c83768df4','2017-04-15 00:10:46',0,'','Capsule',NULL,'2017-04-15 00:11:51',0);

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` varchar(255) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `dosage_qty` varchar(255) DEFAULT NULL,
  `unit_price` double DEFAULT '0',
  `product_form` varchar(255) DEFAULT NULL,
  `front_image` varchar(255) DEFAULT NULL,
  `side_effect` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updated` tinyint(1) DEFAULT '0',
  `product_description` varchar(255) DEFAULT NULL,
  `cover_image` varchar(255) DEFAULT NULL,
  `direction_of_use` varchar(255) DEFAULT NULL,
  `side_image` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_products_product_form` (`product_form`),
  CONSTRAINT `FK_products_product_form` FOREIGN KEY (`product_form`) REFERENCES `product_form` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `products` */

insert  into `products`(`id`,`product_name`,`dosage_qty`,`unit_price`,`product_form`,`front_image`,`side_effect`,`last_modified_date`,`deleted`,`updated`,`product_description`,`cover_image`,`direction_of_use`,`side_image`,`created_date`,`last_modified_by`) values ('4c9006b8773b4c839ef40cd1ff02b83c','Prazivet Plus',NULL,0,'c5ea08aa4b164f79bbf8c64b812917a6',NULL,'','2017-04-15 00:16:09',0,0,NULL,NULL,'',NULL,'2017-04-15 00:15:32',NULL);

/*Table structure for table `treatment_prescription` */

DROP TABLE IF EXISTS `treatment_prescription`;

CREATE TABLE `treatment_prescription` (
  `id` varchar(255) NOT NULL,
  `prescription` varchar(255) DEFAULT NULL,
  `treatment` varchar(255) DEFAULT NULL,
  `dosage_quantity` varchar(50) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `price` double DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_treatment_prescription_treatment` (`treatment`),
  CONSTRAINT `FK_treatment_prescription_treatment` FOREIGN KEY (`treatment`) REFERENCES `treatments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `treatment_prescription` */

insert  into `treatment_prescription`(`id`,`prescription`,`treatment`,`dosage_quantity`,`deleted`,`last_modified_by`,`last_modified_date`,`updated`,`price`,`created_date`) values ('551bc0883db04dd69d1fc556b423c39f','82e8ff423e6c49e4aebd61cbf408a780','079aae9849bf4b03b8b2564dad7d4f38',NULL,0,NULL,'2017-04-17 23:34:33',0,0,'2017-04-17 23:21:57');

/*Table structure for table `treatments` */

DROP TABLE IF EXISTS `treatments`;

CREATE TABLE `treatments` (
  `id` varchar(255) NOT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `pet` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `next_treatment_date` date DEFAULT NULL,
  `total_cost` double DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `month_code` int(11) DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `treatment_type` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `value_date` date DEFAULT NULL,
  `value_month` varchar(20) DEFAULT NULL,
  `value_quarter` varchar(20) DEFAULT NULL,
  `value_week` varchar(20) DEFAULT NULL,
  `value_year` int(11) DEFAULT NULL,
  `week_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_treatments_diagnosis` (`diagnosis`),
  KEY `FK_treatments_pet` (`pet`),
  CONSTRAINT `FK_treatments_diagnosis` FOREIGN KEY (`diagnosis`) REFERENCES `diagnosis` (`id`),
  CONSTRAINT `FK_treatments_pet` FOREIGN KEY (`pet`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `treatments` */

insert  into `treatments`(`id`,`diagnosis`,`comment`,`pet`,`description`,`next_treatment_date`,`total_cost`,`deleted`,`last_modified_by`,`last_modified_date`,`month_code`,`updated`,`treatment_type`,`created_date`,`value_date`,`value_month`,`value_quarter`,`value_week`,`value_year`,`week_code`) values ('079aae9849bf4b03b8b2564dad7d4f38',NULL,'',NULL,NULL,NULL,0,0,NULL,'2017-04-17 23:34:33',NULL,0,NULL,'2017-04-17 23:31:49',NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
