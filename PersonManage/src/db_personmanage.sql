/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.49-community : Database - db_personmanage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_personmanage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_personmanage`;

/*Table structure for table `t_department` */

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(20) DEFAULT NULL,
  `departmentDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `t_department` */

insert  into `t_department`(`departmentId`,`departmentName`,`departmentDesc`) values (1,'营销部','负责公司营销事务'),(2,'研发部','负责公司研发事务'),(27,'技术部','负责公司技术事务'),(29,'财务部','负责公司财务事务'),(30,'行政部','负责公司行政事务');

/*Table structure for table `t_employee` */

DROP TABLE IF EXISTS `t_employee`;

CREATE TABLE `t_employee` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeNo` varchar(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `nationality` varchar(10) DEFAULT NULL,
  `education` varchar(10) DEFAULT NULL,
  `profession` varchar(20) DEFAULT NULL,
  `departmentId` int(11) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `baseMoney` decimal(5,2) DEFAULT NULL,
  `overtime` decimal(5,2) DEFAULT NULL,
  `age` decimal(5,2) DEFAULT NULL,
  `check1` decimal(5,2) DEFAULT NULL,
  `absent` decimal(5,2) DEFAULT NULL,
  `safety` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `t_employee` */

insert  into `t_employee`(`employeeId`,`employeeNo`,`name`,`sex`,`birthday`,`nationality`,`education`,`profession`,`departmentId`,`position`,`baseMoney`,`overtime`,`age`,`check1`,`absent`,`safety`) values (3,'232626','张三','女','2013-07-01','汉族','本科','市场营销',1,'客户经理','12.11','11.20','2.20','1.20','2.20','2.20'),(11,'232322','李四','男','2013-07-01','满族','专科','计算机',27,'技术员','1.00','1.00','2.00','1.00','2.00','2.00'),(12,'121212','王五','女','2013-01-07','布衣','研究生','会计',29,'会计师','100.05','100.05','100.02','100.02','111.02','110.02');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`userId`,`userName`,`password`) values (1,'java1234','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
