-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema e_computer
--

CREATE DATABASE IF NOT EXISTS e_computer;
USE e_computer;

--
-- Definition of table `brand`
--

DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brand_name` varchar(255) NOT NULL default '0',
  `remarks` varchar(255) default NULL,
  PRIMARY KEY  (`brand_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `brand`
--

/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`brand_name`,`remarks`) VALUES 
 ('Microsoft','ok'),
 ('Samsung','ok');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_name` varchar(255) NOT NULL,
  `category_code` varchar(255) NOT NULL,
  PRIMARY KEY  USING BTREE (`category_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`category_name`,`category_code`) VALUES 
 ('HardDisk','101'),
 ('Monitor','102'),
 ('Mobile','103'),
 ('pen drive','2001'),
 ('keyboard','555');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_name` varchar(255) NOT NULL,
  `address` varchar(255) default NULL,
  `mobile_no` varchar(255) NOT NULL default '0',
  `balance` double default '0',
  PRIMARY KEY  (`mobile_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`company_name`,`address`,`mobile_no`,`balance`) VALUES 
 ('Mobile World','Multiplan,Dhaka','01724119442',871399),
 ('Mark Business Ltd','Bashundhara R/A','01729414208',0);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;


--
-- Definition of table `company_payment`
--

DROP TABLE IF EXISTS `company_payment`;
CREATE TABLE `company_payment` (
  `sn` double NOT NULL auto_increment,
  `date` varchar(45) NOT NULL,
  `company_name` varchar(45) NOT NULL,
  `amount` double NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  `notes` varchar(45) NOT NULL,
  PRIMARY KEY  (`sn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company_payment`
--

/*!40000 ALTER TABLE `company_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_payment` ENABLE KEYS */;


--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` double NOT NULL auto_increment,
  `customer_name` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `mobile_no` varchar(255) default NULL,
  `balance` double default '0',
  PRIMARY KEY  USING BTREE (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customer_id`,`customer_name`,`address`,`mobile_no`,`balance`) VALUES 
 (1,'Md.Tarikul Islam','Mirpur','01923335691',317800);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `customer_payment`
--

DROP TABLE IF EXISTS `customer_payment`;
CREATE TABLE `customer_payment` (
  `sn` double NOT NULL auto_increment,
  `date` varchar(45) NOT NULL,
  `customer_name` varchar(45) NOT NULL,
  `amount` double NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  `mobile_no` varchar(45) NOT NULL,
  `notes` varchar(45) NOT NULL,
  PRIMARY KEY  (`sn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_payment`
--

/*!40000 ALTER TABLE `customer_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_payment` ENABLE KEYS */;


--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_name` varchar(255) NOT NULL,
  `item_category` varchar(255) NOT NULL,
  `item_code` varchar(255) NOT NULL,
  `selling_rate` double NOT NULL,
  `purchase_rate` double NOT NULL,
  `warranty` varchar(255) NOT NULL,
  `supplier_name` varchar(255) NOT NULL,
  `opening_stock` int(11) NOT NULL,
  `re_order` int(11) NOT NULL,
  `brand_company` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`item_name`,`item_category`,`item_code`,`selling_rate`,`purchase_rate`,`warranty`,`supplier_name`,`opening_stock`,`re_order`,`brand_company`) VALUES 
 ('sata','HardDisk','101',4000,3000,'1','Mark Business Ltd',10,10,'Asus'),
 ('Lumia','Mobile','102',1600,15000,'1','Mobile World',100,10,'Microsoft');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_type` varchar(45) NOT NULL,
  PRIMARY KEY  (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`user_name`,`password`,`user_type`) VALUES 
 ('e_computer','123','Admin'),
 ('tarikul','123','employee');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `payment_customer`
--

DROP TABLE IF EXISTS `payment_customer`;
CREATE TABLE `payment_customer` (
  `id` double NOT NULL auto_increment,
  `trans_date` date NOT NULL,
  `customer_id` varchar(45) NOT NULL,
  `pay_amount` double NOT NULL,
  `invoice_no` varchar(255) NOT NULL,
  `remarks` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_customer`
--

/*!40000 ALTER TABLE `payment_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_customer` ENABLE KEYS */;


--
-- Definition of table `purchase_invoice`
--

DROP TABLE IF EXISTS `purchase_invoice`;
CREATE TABLE `purchase_invoice` (
  `company_name` varchar(255) default NULL,
  `invoice_no` int(10) unsigned NOT NULL default '0',
  `address` varchar(255) default NULL,
  `mobile_no` varchar(45) default NULL,
  `date` varchar(45) default NULL,
  `item_code` double default '0',
  `item_category` varchar(255) default NULL,
  `item_name` varchar(255) default NULL,
  `stock` int(11) default NULL,
  `quantity` int(11) default NULL,
  `purchase_rate` int(11) default NULL,
  `selling_rate` int(11) default NULL,
  `warranty` varchar(45) default NULL,
  `total` double default NULL,
  `paid` double default NULL,
  `bill_balance` double default NULL,
  `commission` int(11) default NULL,
  `grand_total` double default NULL,
  `brand_name` varchar(255) default NULL,
  `commission_deduction` int(11) default NULL,
  PRIMARY KEY  USING BTREE (`invoice_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_invoice`
--

/*!40000 ALTER TABLE `purchase_invoice` DISABLE KEYS */;
INSERT INTO `purchase_invoice` (`company_name`,`invoice_no`,`address`,`mobile_no`,`date`,`item_code`,`item_category`,`item_name`,`stock`,`quantity`,`purchase_rate`,`selling_rate`,`warranty`,`total`,`paid`,`bill_balance`,`commission`,`grand_total`,`brand_name`,`commission_deduction`) VALUES 
 ('Mobile World',45,'Multiplan,Dhaka','01724119442','13/06/2015',101,'Mobile','Nokia Lumia 800',151,2,20000,24000,'2 years',40000,0,40000,0,40000,'Microsoft',0),
 ('Mobile World',88,'Multi plan ,Dhaka','01923335691','13/06/2015',101,'Mobile','Nokia Lumia 800',146,5,20000,24000,'2 years',101000,101000,0,0,101000,'Microsoft',0),
 ('Mobile World',222,'Multiplan,Dhaka','01724119442','20/06/2015',101,'Mobile','Nokia Lumia 800',153,2,20000,24000,'2 years',40000,0,40000,0,40000,'Microsoft',0),
 ('Mobile World',444,'khih','01729414208','13/06/2015',101,'Mobile','Nokia Lumia 800',138,8,20000,24000,'2 years',160400,160000,400,0,160400,'Microsoft',0),
 ('Mobile World',2221,'Multiplan,Dhaka','01724119442','20/06/2015',102,'Monitor','Philips',5,100,8075,4000,'2',807549,0,791399,2,791399,'Microsoft',16150);
/*!40000 ALTER TABLE `purchase_invoice` ENABLE KEYS */;


--
-- Definition of table `purchase_sub`
--

DROP TABLE IF EXISTS `purchase_sub`;
CREATE TABLE `purchase_sub` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `vendor_name` varchar(255) NOT NULL,
  `brand_name` varchar(255) NOT NULL,
  `date` varchar(45) NOT NULL,
  `mobile_no` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `invoice_no` int(10) unsigned NOT NULL,
  `item_code` varchar(255) NOT NULL,
  `item_category` varchar(255) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `purchase_rate` int(11) NOT NULL,
  `selling_rate` int(11) NOT NULL,
  `warranty` varchar(45) NOT NULL,
  `sub_total` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_sub`
--

/*!40000 ALTER TABLE `purchase_sub` DISABLE KEYS */;
INSERT INTO `purchase_sub` (`id`,`vendor_name`,`brand_name`,`date`,`mobile_no`,`address`,`invoice_no`,`item_code`,`item_category`,`item_name`,`stock`,`quantity`,`purchase_rate`,`selling_rate`,`warranty`,`sub_total`) VALUES 
 (9,'Mark Business Ltd','Asus','13/06/2015','01729414208','khih',444,'5552','keyboard','bijoy',15,2,200,250,'1 year',400),
 (10,'Mobile World','Microsoft','13/06/2015','01729414208','khih',444,'101','Mobile','Nokia Lumia 800',138,8,20000,24000,'2 years',160000),
 (11,'Mark Business Ltd','Asus','13/06/2015','01729414208','khih',444,'5552','keyboard','bijoy',17,5,200,250,'1 year',1000),
 (12,'Mobile World','Microsoft','13/06/2015','01729414208','khih',444,'101','Mobile','Nokia Lumia 800',146,6,20000,24000,'2 years',120000),
 (13,'Mark Business Ltd','Asus','13/06/2015','01923335691','Multi plan ,Dhaka',88,'5552','keyboard','bijoy',17,5,200,250,'1 year',1000),
 (14,'Mobile World','Microsoft','13/06/2015','01923335691','Multi plan ,Dhaka',88,'101','Mobile','Nokia Lumia 800',146,5,20000,24000,'2 years',100000),
 (15,'Mark Business Ltd','Asus','13/06/2015','01729414208','khih',888,'5552','keyboard','bijoy',22,6,200,250,'1 year',1200),
 (16,'Mobile World','Microsoft','13/06/2015','01729414208','khih',888,'102','Monitor','Philips',19,6,9923,4000,'2',1200),
 (17,'Mobile World','Microsoft','13/06/2015','01729414208','khih',888,'102','Monitor','Philips',19,5,9923,4000,'2',49614),
 (18,'Mark Business Ltd','Asus','13/06/2015','01729414208','khih',888,'5552','keyboard','bijoy',22,5,200,250,'1 year',49614),
 (20,'Mobile World','Microsoft','13/06/2015','01923335691','Multi plan ,Dhaka',3,'101','Mobile','Nokia Lumia 800',151,2,20000,24000,'2 years',40000),
 (21,'Mobile World','Microsoft','13/06/2015','01923335691','Multi plan ,Dhaka',3,'102','Monitor','Philips',19,4,8075,4000,'2',32302),
 (23,'Mobile World','Microsoft','13/06/2015','01724119442','Multiplan,Dhaka',45,'101','Mobile','Nokia Lumia 800',151,2,20000,24000,'2 years',40000),
 (26,'Mark Business Ltd','Asus','13/06/2015','01729414208','Bashundhara R/A',3232,'3001','Monitor','Asus_CRT',10,10,2500,2800,'1 year',25000),
 (27,'Mobile World','Microsoft','13/06/2015','01729414208','Bashundhara R/A',3232,'101','Mobile','Nokia Lumia 800',153,3,20000,24000,'2 years',60000),
 (28,'Mark Business Ltd','Asus','13/06/2015','01729414208','Bashundhara R/A',12,'3001','Monitor','Asus_CRT',10,10,2500,2800,'1 year',25000),
 (29,'Mobile World','Microsoft','13/06/2015','01729414208','Bashundhara R/A',12,'101','Mobile','Nokia Lumia 800',153,10,20000,24000,'2 years',200000),
 (30,'Mobile World','Microsoft','20/06/2015','01724119442','Multiplan,Dhaka',222,'101','Mobile','Nokia Lumia 800',153,2,20000,24000,'2 years',40000),
 (31,'Mobile World','Microsoft','20/06/2015','01724119442','Multiplan,Dhaka',2221,'102','Monitor','Philips',5,100,8075,4000,'2',807549);
/*!40000 ALTER TABLE `purchase_sub` ENABLE KEYS */;


--
-- Definition of table `purchase_tem`
--

DROP TABLE IF EXISTS `purchase_tem`;
CREATE TABLE `purchase_tem` (
  `id` int(11) NOT NULL auto_increment,
  `vendor_name` varchar(255) NOT NULL,
  `brand_name` varchar(255) NOT NULL,
  `date` varchar(45) NOT NULL,
  `mobile_no` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `invoice_no` int(10) unsigned NOT NULL,
  `item_code` varchar(255) NOT NULL,
  `item_category` varchar(255) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `purchase_rate` int(11) NOT NULL,
  `selling_rate` int(11) NOT NULL,
  `warranty` varchar(45) NOT NULL,
  `sub_total` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_tem`
--

/*!40000 ALTER TABLE `purchase_tem` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_tem` ENABLE KEYS */;


--
-- Definition of table `sale_invoice`
--

DROP TABLE IF EXISTS `sale_invoice`;
CREATE TABLE `sale_invoice` (
  `customer_name` varchar(255) NOT NULL,
  `invoice_no` int(11) NOT NULL auto_increment,
  `mobile_no` varchar(45) default NULL,
  `address` varchar(255) default NULL,
  `date` varchar(45) default NULL,
  `item_name` varchar(255) default NULL,
  `item_category` varchar(255) default NULL,
  `stock` int(11) default NULL,
  `quantity` int(11) default NULL,
  `selling_rate` int(11) default NULL,
  `purchase_rate` int(11) default NULL,
  `warranty` varchar(255) default NULL,
  `discount` int(11) default NULL,
  `total` int(11) default NULL,
  `paid` int(11) default NULL,
  `grand_total` int(11) default NULL,
  `profit` int(11) NOT NULL,
  `total_purchase` double default NULL,
  `commission_deduction` int(11) default NULL,
  `bill_balance` int(11) default NULL,
  PRIMARY KEY  USING BTREE (`invoice_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale_invoice`
--

/*!40000 ALTER TABLE `sale_invoice` DISABLE KEYS */;
INSERT INTO `sale_invoice` (`customer_name`,`invoice_no`,`mobile_no`,`address`,`date`,`item_name`,`item_category`,`stock`,`quantity`,`selling_rate`,`purchase_rate`,`warranty`,`discount`,`total`,`paid`,`grand_total`,`profit`,`total_purchase`,`commission_deduction`,`bill_balance`) VALUES 
 ('Md.Tarikul Islam',1,'01923335691','Mirpur','13/06/2015','bijoy','keyboard',9,5,250,2001,'1 year',0,17250,17250,17250,-23054,40304.04,0,0),
 ('Md.Tarikul Islam',2,'01923335691','Mirpur','14/06/2015','Nokia Lumia 800','Mobile',94,4,24000,20000,'1',0,96000,0,96000,16000,80000,0,96000);
/*!40000 ALTER TABLE `sale_invoice` ENABLE KEYS */;


--
-- Definition of table `sale_sub`
--

DROP TABLE IF EXISTS `sale_sub`;
CREATE TABLE `sale_sub` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `customer_name` varchar(255) NOT NULL,
  `invoice_no` int(11) NOT NULL,
  `mobile_no` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `date` varchar(45) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_category` varchar(255) NOT NULL,
  `item_code` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `selling_rate` int(11) NOT NULL,
  `purchase_rate` int(11) NOT NULL,
  `warranty` varchar(255) NOT NULL,
  `sub_total` int(11) NOT NULL,
  `brand_name` varchar(255) NOT NULL,
  `total_purchase` double NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale_sub`
--

/*!40000 ALTER TABLE `sale_sub` DISABLE KEYS */;
INSERT INTO `sale_sub` (`id`,`customer_name`,`invoice_no`,`mobile_no`,`address`,`date`,`item_name`,`item_category`,`item_code`,`stock`,`quantity`,`selling_rate`,`purchase_rate`,`warranty`,`sub_total`,`brand_name`,`total_purchase`) VALUES 
 (8,'Md.Tarikul Islam',1,'01923335691','Mirpur','13/06/2015','bijoy','keyboard','5552',9,10,250,2001,'1 year',2500,'Asus',8002.08),
 (9,'Md.Tarikul Islam',1,'01923335691','Mirpur','13/06/2015','Philips','Monitor','102',9,4,4000,8075,'2',16000,'Microsoft',32301.96),
 (13,'Md.Tarikul Islam',2,'01923335691','Mirpur','14/06/2015','Nokia Lumia 800','Mobile','103',94,4,24000,20000,'1',96000,'Microsoft',80000);
/*!40000 ALTER TABLE `sale_sub` ENABLE KEYS */;


--
-- Definition of table `sale_tem`
--

DROP TABLE IF EXISTS `sale_tem`;
CREATE TABLE `sale_tem` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `customer_name` varchar(255) NOT NULL,
  `invoice_no` int(11) NOT NULL,
  `mobile_no` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  `date` varchar(45) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_category` varchar(255) NOT NULL,
  `item_code` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `selling_rate` int(11) NOT NULL,
  `purchase_rate` int(11) NOT NULL,
  `warranty` varchar(255) NOT NULL,
  `sub_total` int(11) NOT NULL,
  `brand_name` varchar(255) NOT NULL,
  `total_purchase` double NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale_tem`
--

/*!40000 ALTER TABLE `sale_tem` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_tem` ENABLE KEYS */;


--
-- Definition of table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `total_stock` int(11) NOT NULL,
  `quantity` int(11) default '0',
  `item_category` varchar(45) NOT NULL,
  `item_code` varchar(45) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `warranty` varchar(45) NOT NULL,
  `brand_company` varchar(45) NOT NULL,
  `selling_rate` int(11) NOT NULL,
  `purchase_rate` int(11) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  PRIMARY KEY  USING BTREE (`item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` (`total_stock`,`quantity`,`item_category`,`item_code`,`item_name`,`warranty`,`brand_company`,`selling_rate`,`purchase_rate`,`company_name`) VALUES 
 (10,0,'HardDisk','101','sata','1','Asus',4000,3000,'Mark Business Ltd'),
 (100,0,'Mobile','102','Lumia','1','Microsoft',1600,15000,'Mobile World');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
