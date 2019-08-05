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
  PRIMARY KEY (`id`),
  KEY `FK_pets_owner` (`owner`),
  CONSTRAINT `FK_pets_owner` FOREIGN KEY (`owner`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pets` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
