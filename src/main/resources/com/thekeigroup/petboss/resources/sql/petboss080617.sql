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
  `client` varchar(255) DEFAULT NULL,
  `booking_slot` datetime DEFAULT NULL,
  `booking_type` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
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

/*Table structure for table `client_transaction` */

DROP TABLE IF EXISTS `client_transaction`;

CREATE TABLE `client_transaction` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `debit` double DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
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
  `client` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_client_transaction_client` (`client`),
  CONSTRAINT `FK_client_transaction_client` FOREIGN KEY (`client`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `client_transaction` */

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

insert  into `clients`(`id`,`address_line`,`address_line1`,`created_date`,`date_of_registration`,`deleted`,`email`,`last_modified_by`,`last_modified_date`,`mobile_number`,`other_names`,`surname`,`telephone_number`,`updated`) values ('d85fe2206f0b4436a400c749b0754044','',NULL,'2017-05-19 23:10:25','2017-04-20',0,'',NULL,'2017-05-19 23:10:52','0266824444','Seth','Nartey','',0);

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
  `age` int(11) DEFAULT NULL,
  `animal_sp` varchar(255) DEFAULT NULL,
  `chip_code` varchar(255) DEFAULT NULL,
  `colour` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `date_of_registration` date DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `gender` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pet_type` varchar(255) DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `owner` varchar(255) DEFAULT NULL,
  `breed` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pets_owner` (`owner`),
  CONSTRAINT `FK_pets_owner` FOREIGN KEY (`owner`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pets` */

insert  into `pets`(`id`,`age`,`animal_sp`,`chip_code`,`colour`,`created_date`,`date_of_birth`,`date_of_registration`,`deleted`,`gender`,`last_modified_by`,`last_modified_date`,`name`,`pet_type`,`updated`,`owner`,`breed`) values ('bda9eab6244c4ef0a09ae0b8b8adbc9c',4,'','899838','Light Brown','2017-05-20 07:10:06',NULL,'2016-10-04',0,'MALE',NULL,'2017-05-20 07:10:55','Jack',NULL,0,'d85fe2206f0b4436a400c749b0754044','Dog');

/*Table structure for table `prescriptions` */

DROP TABLE IF EXISTS `prescriptions`;

CREATE TABLE `prescriptions` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `dosage_quantity` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `price` double DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `diagnosis` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_prescriptions_product` (`product`),
  KEY `FK_prescriptions_diagnosis` (`diagnosis`),
  CONSTRAINT `FK_prescriptions_diagnosis` FOREIGN KEY (`diagnosis`) REFERENCES `diagnosis` (`id`),
  CONSTRAINT `FK_prescriptions_product` FOREIGN KEY (`product`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `prescriptions` */

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

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` varchar(255) NOT NULL,
  `cover_image` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `direction_of_use` varchar(255) DEFAULT NULL,
  `dosage_qty` varchar(255) DEFAULT NULL,
  `front_image` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `side_effect` varchar(255) DEFAULT NULL,
  `side_image` varchar(255) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `product_form` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_products_product_form` (`product_form`),
  CONSTRAINT `FK_products_product_form` FOREIGN KEY (`product_form`) REFERENCES `product_form` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `products` */

/*Table structure for table `treatment_prescription` */

DROP TABLE IF EXISTS `treatment_prescription`;

CREATE TABLE `treatment_prescription` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `dosage_quantity` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `prescription` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `treatment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_treatment_prescription_treatment` (`treatment`),
  CONSTRAINT `FK_treatment_prescription_treatment` FOREIGN KEY (`treatment`) REFERENCES `treatments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `treatment_prescription` */

/*Table structure for table `treatments` */

DROP TABLE IF EXISTS `treatments`;

CREATE TABLE `treatments` (
  `id` varchar(255) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `month_code` int(11) DEFAULT NULL,
  `next_treatment_date` date DEFAULT NULL,
  `total_cost` double DEFAULT NULL,
  `treatment_type` varchar(255) DEFAULT NULL,
  `updated` tinyint(1) DEFAULT '0',
  `value_date` date DEFAULT NULL,
  `value_month` varchar(20) DEFAULT NULL,
  `value_quarter` varchar(20) DEFAULT NULL,
  `value_week` varchar(20) DEFAULT NULL,
  `value_year` int(11) DEFAULT NULL,
  `week_code` int(11) DEFAULT NULL,
  `diagnosis` varchar(255) DEFAULT NULL,
  `pet` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_treatments_diagnosis` (`diagnosis`),
  KEY `FK_treatments_pet` (`pet`),
  CONSTRAINT `FK_treatments_diagnosis` FOREIGN KEY (`diagnosis`) REFERENCES `diagnosis` (`id`),
  CONSTRAINT `FK_treatments_pet` FOREIGN KEY (`pet`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `treatments` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
