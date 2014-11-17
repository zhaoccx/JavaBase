/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - db_patient
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_patient` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_patient`;

/*Table structure for table `t_ghinfo` */

DROP TABLE IF EXISTS `t_ghinfo`;

CREATE TABLE `t_ghinfo` (
  `ghId` int(11) NOT NULL AUTO_INCREMENT,
  `patientId` int(11) DEFAULT NULL,
  `ghNo` varchar(20) NOT NULL,
  `date` date DEFAULT NULL,
  `officeName` varchar(20) DEFAULT NULL,
  `ghDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ghId`,`ghNo`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `t_ghinfo` */

insert  into `t_ghinfo`(`ghId`,`patientId`,`ghNo`,`date`,`officeName`,`ghDesc`) values (38,36,'20130806203900','2013-08-08','外科','骨折'),(39,36,'20130806203955','2013-08-07','精神科','头晕眼花流鼻血'),(40,40,'20130806230648','2013-08-02','五官科','流鼻血'),(42,41,'20130807080040','2013-08-07','五官科','耳鸣'),(48,37,'20130807150814','2013-08-16','精神科','头疼'),(50,41,'20130807151108','2013-08-15','精神科','失心疯'),(51,42,'20130807152759','2013-08-13','精神科','精神紊乱'),(52,42,'20130807181248','2013-08-10','精神科','精神科患者'),(54,35,'20130807214004','2013-08-01','儿科','儿童患者');

/*Table structure for table `t_patient` */

DROP TABLE IF EXISTS `t_patient`;

CREATE TABLE `t_patient` (
  `patientId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `patientName` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `idNumber` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `patientDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`patientId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `t_patient` */

insert  into `t_patient`(`patientId`,`userId`,`patientName`,`sex`,`birthday`,`idNumber`,`tel`,`patientDesc`) values (35,1,'吴莫愁','女','1990-07-06','1212928749503434','2323232','少林寺达摩堂'),(36,1,'张玮','男','1989-07-20','395839230329232','11212','天山派三十六房'),(37,2,'丁丁','女','1990-03-08','132948599349839','092839453','华山派后山'),(38,2,'梁博','男','1985-01-15','1111111123329340','12121223','钓鱼岛'),(40,2,'那英','女','1960-02-19','9872948599349839','11212','北京天安门'),(41,2,'哈林','女','1993-03-04','343548729379534958','13120394950','西直门2号'),(42,2,'刘欢','男','2013-08-07','93028465859475748','10086','书房斋');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`userId`,`userName`,`password`,`role`) values (1,'admin','123',0),(2,'java1234','123456',1),(3,'张','123',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
