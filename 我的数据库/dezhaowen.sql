/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.60 : Database - dezhaowen
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dezhaowen` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dezhaowen`;

/*Table structure for table `academic_degree` */

DROP TABLE IF EXISTS `academic_degree`;

CREATE TABLE `academic_degree` (
  `collegeid` int(11) NOT NULL COMMENT '学位序号',
  `name` varchar(50) NOT NULL COMMENT '学位名称',
  PRIMARY KEY (`collegeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学位表';

/*Data for the table `academic_degree` */

insert  into `academic_degree`(`collegeid`,`name`) values (1,'研究生'),(2,'博士'),(3,'硕士');

/*Table structure for table `bank` */

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `bankid` int(11) NOT NULL AUTO_INCREMENT COMMENT '银行编号',
  `bankname` varchar(50) DEFAULT NULL COMMENT '银行名称',
  PRIMARY KEY (`bankid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='银行表';

/*Data for the table `bank` */

insert  into `bank`(`bankid`,`bankname`) values (1,'中国银行'),(2,'农业银行'),(3,'建设银行');

/*Table structure for table `billstype` */

DROP TABLE IF EXISTS `billstype`;

CREATE TABLE `billstype` (
  `id` int(11) NOT NULL COMMENT '单据类型编号',
  `type` varchar(50) DEFAULT NULL COMMENT '单据类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据类型';

/*Data for the table `billstype` */

insert  into `billstype`(`id`,`type`) values (1,'维修单'),(2,'站外援助单');

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `b_id` int(11) NOT NULL COMMENT '车型品牌编号',
  `b_name` varchar(20) DEFAULT NULL COMMENT '车型品牌名称',
  `b_inital` varchar(20) DEFAULT NULL COMMENT '品牌首字母',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车型品牌';

/*Data for the table `brand` */

insert  into `brand`(`b_id`,`b_name`,`b_inital`) values (1,'中国重汽1224','AD'),(2,'陕汽重卡12A','B'),(3,'上海红岩','C'),(6,'中国东风','FD'),(13,'其他重型车辆','E');

/*Table structure for table `businessclass` */

DROP TABLE IF EXISTS `businessclass`;

CREATE TABLE `businessclass` (
  `businessid` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务类别编号',
  `businessleb` varchar(50) DEFAULT NULL COMMENT '业务类别名称',
  PRIMARY KEY (`businessid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='业务类别表';

/*Data for the table `businessclass` */

insert  into `businessclass`(`businessid`,`businessleb`) values (1,'中国重汽'),(2,'美国重汽');

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车型编号',
  `c_coder` varchar(20) DEFAULT NULL COMMENT '车型编码',
  `c_show` int(11) DEFAULT NULL COMMENT 'App展示',
  `c_refeprice` float DEFAULT NULL COMMENT '参考价格',
  `c_vehicle` float DEFAULT NULL COMMENT '车辆年款',
  `c_power` varchar(20) DEFAULT NULL COMMENT '载重',
  `c_fuel` varchar(50) DEFAULT NULL COMMENT '燃油标号',
  `c_load` varchar(10) DEFAULT NULL COMMENT '载重',
  `e_id` int(11) DEFAULT NULL COMMENT '发动机品牌编号',
  `d_id` int(11) DEFAULT NULL COMMENT '进口国产序号',
  `b_id` int(11) DEFAULT NULL COMMENT '车型品牌编号',
  `p_id` varchar(20) DEFAULT NULL COMMENT '索赔厂，供货商编号',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`c_id`),
  KEY `e_id` (`e_id`),
  KEY `d_id` (`d_id`),
  KEY `b_id` (`b_id`),
  KEY `p_id` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='车型表';

/*Data for the table `car` */

insert  into `car`(`c_id`,`c_coder`,`c_show`,`c_refeprice`,`c_vehicle`,`c_power`,`c_fuel`,`c_load`,`e_id`,`d_id`,`b_id`,`p_id`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values (1,'1',NULL,6000,20000,'2022','11','200201',2,1,1,'24','德隆s5',NULL,NULL,NULL,NULL),(2,'2',NULL,45455,2445540,'24','2','21312',2,2,2,'1111','德隆sd62',NULL,NULL,NULL,NULL),(3,'3',NULL,123123,422424,'53','3','1221',3,1,3,'1111','大众504',NULL,NULL,NULL,NULL),(4,'4',NULL,24445,545445,'45','4','311221',4,1,1,'23','福特454',NULL,NULL,NULL,NULL),(5,'5',NULL,424545,422442,'42','5','12454',5,2,2,'18','保时捷985',NULL,NULL,NULL,NULL),(9,'9',NULL,12323,342,'45','4','432',8,3,6,'23','宝马985',NULL,NULL,NULL,NULL),(18,'1211',NULL,123123,13,'13','13','13',2,2,13,'3','兰博基尼985',NULL,NULL,NULL,NULL),(19,'1311',NULL,34234,21,'213','3213','213',1,1,13,'24','东风悦达起亚985',NULL,NULL,NULL,NULL),(20,'12323',NULL,3252,123,'231','21','21',2,1,13,'3','东风日产985',NULL,NULL,NULL,NULL);

/*Table structure for table `caraffiliation` */

DROP TABLE IF EXISTS `caraffiliation`;

CREATE TABLE `caraffiliation` (
  `caraffiliationid` int(11) NOT NULL COMMENT '车辆归属id',
  `caraffiliation` varchar(50) DEFAULT NULL COMMENT '车辆归属',
  PRIMARY KEY (`caraffiliationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆归属表';

/*Data for the table `caraffiliation` */

/*Table structure for table `carbrand` */

DROP TABLE IF EXISTS `carbrand`;

CREATE TABLE `carbrand` (
  `carcoding` varchar(50) NOT NULL COMMENT '车辆编码',
  `brandname` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `initial` varchar(50) DEFAULT NULL COMMENT '首字母',
  PRIMARY KEY (`carcoding`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆品牌';

/*Data for the table `carbrand` */

insert  into `carbrand`(`carcoding`,`brandname`,`initial`) values ('1','大众','D'),('2','奥迪','A'),('3','奔驰','B');

/*Table structure for table `carheet` */

DROP TABLE IF EXISTS `carheet`;

CREATE TABLE `carheet` (
  `carnum` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆号码',
  `platename` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `carbrandid` varchar(50) DEFAULT NULL COMMENT '车辆品牌id',
  `driver` varchar(50) DEFAULT NULL COMMENT '驾驶员',
  `driverphone` varchar(50) DEFAULT NULL COMMENT '驾驶员电话',
  `birthday` varchar(50) DEFAULT NULL COMMENT '出生日期',
  `caraffiliationid` varchar(50) DEFAULT NULL COMMENT '车辆归属id',
  `driveraddress` varchar(50) DEFAULT NULL COMMENT '驾驶员地址',
  `drivingouttime` varchar(50) DEFAULT NULL COMMENT '驾证到期',
  `framnum` varchar(50) DEFAULT NULL COMMENT '车驾号',
  `enginenum` varchar(50) DEFAULT NULL COMMENT '发动机号',
  `engineid` int(50) DEFAULT NULL COMMENT '发动机id',
  `carnyear` varchar(50) DEFAULT NULL COMMENT '车辆年款',
  `mileage` varchar(50) DEFAULT NULL COMMENT '里程',
  `load` varchar(50) DEFAULT NULL COMMENT '载重',
  `carseries` varchar(50) DEFAULT NULL COMMENT '车系',
  `buytime` varchar(50) DEFAULT NULL COMMENT '购买日期',
  `uptime` varchar(50) DEFAULT NULL COMMENT '上牌日期',
  `carouttime` varchar(50) DEFAULT NULL COMMENT '车险到期',
  `mlicompanyid` varchar(50) DEFAULT NULL COMMENT '交强险保险公司id',
  `mliouttime` varchar(50) DEFAULT NULL COMMENT '交强险到期',
  `cicompanyid` varchar(50) DEFAULT NULL COMMENT '商业险保险公司id',
  `ciouttime` varchar(50) DEFAULT NULL COMMENT '商业险到期',
  `mytoucar` varchar(50) DEFAULT NULL COMMENT '在我投保车',
  `twotime` varchar(50) DEFAULT NULL COMMENT '二维日期',
  `oiltypeid` varchar(50) DEFAULT NULL COMMENT '燃油类别id',
  `nextmileage` varchar(50) DEFAULT NULL COMMENT '下次保养里程',
  `nextupkeeptime` varchar(50) DEFAULT NULL COMMENT '下次保养日期',
  `membernum` varchar(50) DEFAULT NULL COMMENT '会员码',
  `customernum` varchar(50) NOT NULL COMMENT '客户编码',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` int(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`carnum`),
  KEY `carbrandid` (`carbrandid`),
  KEY `caraffiliationid` (`caraffiliationid`),
  KEY `engineid` (`engineid`),
  KEY `mlicompanyid` (`mlicompanyid`),
  KEY `cicompanyid` (`cicompanyid`),
  KEY `oiltypeid` (`oiltypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=22145679 DEFAULT CHARSET=utf8 COMMENT='车辆资料表';

/*Data for the table `carheet` */

insert  into `carheet`(`carnum`,`platename`,`carbrandid`,`driver`,`driverphone`,`birthday`,`caraffiliationid`,`driveraddress`,`drivingouttime`,`framnum`,`enginenum`,`engineid`,`carnyear`,`mileage`,`load`,`carseries`,`buytime`,`uptime`,`carouttime`,`mlicompanyid`,`mliouttime`,`cicompanyid`,`ciouttime`,`mytoucar`,`twotime`,`oiltypeid`,`nextmileage`,`nextupkeeptime`,`membernum`,`customernum`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values (1,'湘B:SE14','1','邓泽玉','1981333','2020-01-10','公司车','上海','2021-07-01','145','4782',1,'2017','2000','1000','1','2021-02-28','2021-03-02','2021-03-02','阳光人寿保险','2021-07-01','阳光人寿保险','1',NULL,NULL,'1',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,1),(2,'湘B:SE15','1','王泽旭','15147575','2021-02-28','公司车','长沙','2021-07-01','4246','424',1,'2017','2000','500','11111','2021-02-28','2021-02-28','2021-02-28','阳光人寿保险','2021-02-28','阳光人寿保险','2021-02-28',NULL,NULL,'111','1111','2021-02-28',NULL,'5',NULL,NULL,NULL,NULL,1),(3,'湘B:SE16','1','阿华','13017175','2021-02-28','公司车','长沙','2021-02-28','142','464',1,'2017','2000','100','11','2021-02-28','2021-02-28','2021-02-28','阳光人寿保险','2021-02-28','阳光人寿保险','2021-02-28',NULL,NULL,'1','111','2021-02-28',NULL,'1',NULL,NULL,NULL,NULL,2),(4,'湘B:SE17','1','阿明','13017175','2021-08-07','公司车','长沙','2021-02-28','242','4242',1,'2018','2000','540','11','2021-02-28','2021-02-28','2021-02-28','阳光人寿保险','','阳光人寿保险','2021-02-28',NULL,NULL,'1','111','2021-02-28',NULL,'1',NULL,NULL,NULL,NULL,1),(12,'湘B:SE18','1','阿孝','13017175','2021-03-02','公司车','长沙','2021-03-02','100','111414',1,'2017','2000','200','德系','2021-03-02','2021-03-02','2021-03-02','阳光人寿保险','2021-03-02','阳光人寿保险','2021-03-02',NULL,'2020-08-07','1','1000','2021-03-02','888888','2',NULL,NULL,NULL,'5',1),(13,'湘B:SE19','1','小何','13017175','2021-03-02','公司车','长沙','2021-03-02','111','157',1,'2017','2500','1000','德系','2021-03-02','2021-03-02','2021-03-02','阳光人寿保险','2021-03-02','阳光人寿保险','2021-03-02',NULL,'2020-08-07','1','1000','2021-03-02','10010','2',NULL,NULL,NULL,'5',1),(14,'湘B:SE12','2','阿孝','13017175','2021-08-07','公司车','长沙','2021-02-28','5724','7578',1,'2017','2000','100','德系','2021-02-28','2021-03-02','2021-03-02','阳光人寿保险','2021-03-02','阳光人寿保险','2021-03-02',NULL,'2020-08-07','3','1000','2021-03-02','11111','9',NULL,NULL,NULL,'5',5),(15,'湘B:SE11','1','阿孝','13017175','2021-08-07','公司车','长沙','2021-03-03','888','445',1,'2019','1000','200','德系','2021-02-28','2021-03-02','2021-03-03','阳光人寿保险','2021-03-02','阳光人寿保险','2021-03-03',NULL,'2020-08-07','2','1000','2021-03-02','1324575','8',NULL,NULL,NULL,'5',1),(17,'湘B:SE13','1','阿孝','13017175','2021-08-07','公司车','长沙','2021-02-28','1246','1212',1,'2017','1000','200','德系','2021-02-28','2021-03-02','2021-03-02','阳光人寿保险','2021-03-02','阳光人寿保险','2021-03-02',NULL,'2020-08-07','4','1000','2021-03-02','75722727','10',NULL,NULL,NULL,'5',1),(55555,'猪9999','1','阿孝','899877','2021-08-07','公司车','长沙','2013-07-08','5555','5555',1,'2017','1000','200','德系','2020-08-07','2020-08-07','2020-08-07','阳光人寿保险','2020-08-07','阳光人寿保险','2020-08-07','无','2020-08-07','2','1000','2020-08-07','1424','88','5','5','5','5',5),(666666,'湘B:SE10','2','阿孝','13017175','2012-03-01','公司车','北京','2012-03-01','2424','888',1,'2017','1000','200','德系','2012-03-01','2012-03-01','2012-03-01','阳光人寿保险','2012-03-01','阳光人寿保险','2012-03-01','怕','2012-03-01','2','1000','2012-03-01','24242','22','6','7','8','6',6),(22145678,'京8888','1','阿孝','13017175','2020-08-09','公司车','株洲','2020-05-08','2525','252',1,'2017','1000','200','德系','2002-05-08','2008-08-08','2013-08-07','阳光人寿保险','2001-05-08','阳光人寿保险','2011-04-08','无','2011-04-08','1','1000','2011-04-08','887575','88','1','1','1','1',1);

/*Table structure for table `cicompany` */

DROP TABLE IF EXISTS `cicompany`;

CREATE TABLE `cicompany` (
  `cicompanyid` int(11) NOT NULL COMMENT '商业保险公司id',
  `cicompany` varchar(50) DEFAULT NULL COMMENT '商业保险公司',
  PRIMARY KEY (`cicompanyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商业保险公司';

/*Data for the table `cicompany` */

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `qcityid` int(11) NOT NULL COMMENT '城市id',
  `qcityname` varchar(50) NOT NULL COMMENT '城市姓名',
  `cityid` int(11) NOT NULL COMMENT '城市id',
  PRIMARY KEY (`qcityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市表';

/*Data for the table `city` */

insert  into `city`(`qcityid`,`qcityname`,`cityid`) values (1,'河北',0),(2,'湖南',0),(3,'河南',0),(4,'郑州',3),(5,'长沙',2),(6,'北京',1);

/*Table structure for table `clearing` */

DROP TABLE IF EXISTS `clearing`;

CREATE TABLE `clearing` (
  `clearingid` int(11) NOT NULL AUTO_INCREMENT COMMENT '结算单id',
  `jieszt` varchar(50) DEFAULT NULL COMMENT '结算状态',
  `hjje` double DEFAULT NULL COMMENT '合计金额',
  `clf` double DEFAULT NULL COMMENT '材料费',
  `goshf` double DEFAULT NULL COMMENT '工时费',
  `jiesdate` date DEFAULT NULL COMMENT '结算时间',
  `jiesr` varchar(50) DEFAULT NULL COMMENT '结算人',
  `xj` double DEFAULT NULL COMMENT '现金',
  `yhk` double DEFAULT NULL COMMENT '银行卡',
  `piaoju` double DEFAULT NULL COMMENT '票据',
  `guazhang` double DEFAULT NULL COMMENT '挂账金额',
  `xuka` double DEFAULT NULL COMMENT '冲储值卡',
  `dj` double DEFAULT NULL COMMENT '冲定金',
  `shuij` double DEFAULT NULL COMMENT '收税金',
  `diyong` double DEFAULT NULL COMMENT '抵用券',
  `mws` double DEFAULT NULL COMMENT '抹尾数',
  `lbuz` double DEFAULT NULL COMMENT '内部帐',
  `jfdk` double DEFAULT NULL COMMENT '积分抵扣',
  `dzyk` double DEFAULT NULL COMMENT '到账盈亏',
  `fpzl` varchar(50) DEFAULT NULL COMMENT '发票种类',
  `fph` varchar(50) DEFAULT NULL COMMENT '发票号',
  `fpje` double DEFAULT NULL COMMENT '发票金额',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`clearingid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='结算信息表';

/*Data for the table `clearing` */

insert  into `clearing`(`clearingid`,`jieszt`,`hjje`,`clf`,`goshf`,`jiesdate`,`jiesr`,`xj`,`yhk`,`piaoju`,`guazhang`,`xuka`,`dj`,`shuij`,`diyong`,`mws`,`lbuz`,`jfdk`,`dzyk`,`fpzl`,`fph`,`fpje`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values (1,'2',2,2,2,'2021-03-02','2',2,2,2,2,2,2,2,2,2,2,2,2,'2','2',2,'2','2','2','2','2');

/*Table structure for table `clearing_form` */

DROP TABLE IF EXISTS `clearing_form`;

CREATE TABLE `clearing_form` (
  `id` int(11) NOT NULL COMMENT '结算方式编号',
  `type` varchar(50) DEFAULT NULL COMMENT '结算方式名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算方式表';

/*Data for the table `clearing_form` */

insert  into `clearing_form`(`id`,`type`) values (1,'会员卡支付'),(2,'支付宝支付'),(3,'未支付');

/*Table structure for table `construction` */

DROP TABLE IF EXISTS `construction`;

CREATE TABLE `construction` (
  `constructionid` int(11) NOT NULL AUTO_INCREMENT,
  `constructian` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`constructionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `construction` */

/*Table structure for table `counselor` */

DROP TABLE IF EXISTS `counselor`;

CREATE TABLE `counselor` (
  `counselorid` int(11) NOT NULL COMMENT '顾问Id',
  `counselorname` varchar(50) DEFAULT NULL COMMENT '顾问名称',
  `counselorphone` varchar(50) DEFAULT NULL COMMENT '顾问电话',
  `bramch` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `jobnum` varchar(50) DEFAULT NULL COMMENT '工号',
  `factoryid` int(11) DEFAULT NULL COMMENT '厂id',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`counselorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾问表';

/*Data for the table `counselor` */

insert  into `counselor`(`counselorid`,`counselorname`,`counselorphone`,`bramch`,`jobnum`,`factoryid`,`reserved1`,`reserved2`,`reserved3`) values (1,'骆华','1','1','1',1,NULL,NULL,NULL);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customernum` varchar(50) NOT NULL COMMENT '客户编码',
  `customername` varchar(50) NOT NULL COMMENT '客户名称',
  `customeraddress` varchar(50) DEFAULT NULL COMMENT '详细地址',
  `linkman` varchar(50) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机',
  `birthday` varchar(50) DEFAULT NULL COMMENT '客户生日',
  `customertypeid` int(50) DEFAULT NULL COMMENT '客户类别id',
  `customernumber` varchar(50) DEFAULT NULL COMMENT '会员卡号',
  `jointime` varchar(50) DEFAULT NULL COMMENT '入会日期',
  `outtime` varchar(50) DEFAULT NULL COMMENT '会员到期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `filing` varchar(50) DEFAULT NULL COMMENT '建档日期',
  `counselorid` int(11) DEFAULT NULL COMMENT '服务顾问id',
  `paytime` int(11) DEFAULT NULL COMMENT '账期',
  `payment` int(11) DEFAULT NULL COMMENT '挂账额度',
  `integral` int(11) DEFAULT NULL COMMENT '累计积分',
  `earnest` float DEFAULT NULL COMMENT '定金金额',
  `paytest` varchar(50) DEFAULT NULL COMMENT '纳税人识别号',
  `registerphone` varchar(50) DEFAULT NULL COMMENT '注册电话',
  `desportbank` int(50) DEFAULT NULL COMMENT '开户银行',
  `bankaccount` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `registeraddress` varchar(50) DEFAULT NULL COMMENT '注册地址',
  `otherone` varchar(50) DEFAULT NULL COMMENT '其他一',
  `othertwo` varchar(50) DEFAULT NULL COMMENT '其他二',
  `otherthree` varchar(50) DEFAULT NULL COMMENT '其他三',
  `otherfour` varchar(50) DEFAULT NULL COMMENT '其他四',
  `photo` varchar(50) DEFAULT NULL COMMENT '相关证照',
  `vipprice` float DEFAULT NULL COMMENT '会员卡余额',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`customernum`),
  KEY `customertypeid` (`customertypeid`),
  KEY `counselorid` (`counselorid`),
  KEY `desportbank` (`desportbank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

/*Data for the table `customer` */

insert  into `customer`(`customernum`,`customername`,`customeraddress`,`linkman`,`phone`,`birthday`,`customertypeid`,`customernumber`,`jointime`,`outtime`,`remark`,`filing`,`counselorid`,`paytime`,`payment`,`integral`,`earnest`,`paytest`,`registerphone`,`desportbank`,`bankaccount`,`registeraddress`,`otherone`,`othertwo`,`otherthree`,`otherfour`,`photo`,`vipprice`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values ('1','阿华','湖南株洲','小红','130171','2020-02-26',1,'164575','2020-02-26','2021-02-26',NULL,'2021-02-26',1,26,10000,1200,NULL,'63433453','198454',3,'9929528656875427','南京',NULL,NULL,NULL,NULL,NULL,100002000,NULL,NULL,NULL,'1',NULL),('10','邓泽玉','湖南株洲','王泽旭','1981333','2020-02-26',1,'486424','2020-02-26','2021-02-26','牛逼','2021-01-26',1,26,10000,1200,NULL,'213546464','13017186',5,'5955959526268995','湖南',NULL,NULL,NULL,NULL,NULL,7766,'上海','上海','长宁区','123123123',NULL),('2','小明','湖南醴陵','小明妈妈','198451','2021-03-02',1,'123456','2020-02-26','2021-02-26','无','2021-02-26',1,3,500,1200,NULL,'65464564','1517575',6,'15618985529562','北京',NULL,NULL,NULL,NULL,NULL,NULL,'广东','广州','越秀区','1',NULL),('3','骆华','湖南株洲','王泽旭','1517333','2021-03-02',1,'124654','2020-02-26','2021-02-26','4214','2021-02-26',1,5,300,1200,NULL,'1114564864','13954452',7,'59599295995959','海南',NULL,NULL,NULL,NULL,NULL,NULL,'上海','上海','黄浦区','1',NULL),('4','小李','北京','王泽旭','13017133','2021-03-02',1,'4565242','2020-02-26','2021-02-26','牛啊','2021-02-26',1,3,900,1200,NULL,'8748387','13457542',1,'22959592955952659','上海',NULL,NULL,NULL,NULL,NULL,NULL,'上海','上海','黄浦区','1',NULL),('5','王泽旭','湖南株洲','王泽旭','1981333','2021-03-02',1,'4524','2020-02-26','2021-02-26','24','2021-02-26',1,2,1400,1200,NULL,'543546','19813333',2,'75758675754238645','天津',NULL,NULL,NULL,NULL,NULL,NULL,'广东','广州','越秀区','1',NULL),('8','阿达不是大V','湖南株洲','王泽旭','1981333','2021-03-02',1,'454247','2020-02-26','2021-02-26','王泽旭','2021-02-26',1,4,100,1200,NULL,'786724','19813333',1,'757546867545757','广州',NULL,NULL,NULL,NULL,NULL,NULL,'安徽','池州','贵池区','1',NULL),('9','阿花','上海','王泽旭','1981333','2020-02-26',1,'782527','2020-02-26','2021-02-26','灌灌灌灌','2021-02-26',1,3,8000,1200,NULL,'489456','19813333',5,'7757675475754575','湖北',NULL,NULL,NULL,NULL,NULL,NULL,'内蒙古','呼和浩特','回民区','1',NULL);

/*Table structure for table `customertype` */

DROP TABLE IF EXISTS `customertype`;

CREATE TABLE `customertype` (
  `customerid` int(11) NOT NULL COMMENT '客户类别id',
  `customertypeid` varchar(50) DEFAULT NULL COMMENT '客户类别',
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户类别';

/*Data for the table `customertype` */

insert  into `customertype`(`customerid`,`customertypeid`) values (1,'中级客户'),(2,'高级客户'),(3,'会员'),(4,'普通客户');

/*Table structure for table `deparment_surface` */

DROP TABLE IF EXISTS `deparment_surface`;

CREATE TABLE `deparment_surface` (
  `bid` int(11) NOT NULL COMMENT '部门编号',
  `bname` varchar(50) NOT NULL COMMENT '部门名称',
  `blei` int(11) NOT NULL COMMENT '部门分类',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `deparment_surface` */

insert  into `deparment_surface`(`bid`,`bname`,`blei`) values (1,'市场部',1),(2,'人事部',1),(3,'技术部',2),(4,'维修部',2);

/*Table structure for table `document_status` */

DROP TABLE IF EXISTS `document_status`;

CREATE TABLE `document_status` (
  `id` int(11) NOT NULL COMMENT '单据状态id',
  `type` varchar(50) DEFAULT NULL COMMENT '单据状态名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据状态表';

/*Data for the table `document_status` */

insert  into `document_status`(`id`,`type`) values (1,'完工'),(2,'未完工'),(3,'误工');

/*Table structure for table `domestic` */

DROP TABLE IF EXISTS `domestic`;

CREATE TABLE `domestic` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进口国产序号',
  `d_name` varchar(20) DEFAULT NULL COMMENT '进口国产名称',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='进口国产';

/*Data for the table `domestic` */

insert  into `domestic`(`d_id`,`d_name`) values (1,'一号国产1'),(2,'二号国产'),(3,'三号国产');

/*Table structure for table `dzw_privilege` */

DROP TABLE IF EXISTS `dzw_privilege`;

CREATE TABLE `dzw_privilege` (
  `pvgid` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
  `pvg_name` varchar(50) NOT NULL COMMENT '权限名称',
  `pvg_verify` varchar(50) DEFAULT NULL COMMENT '权限验证',
  `pvg_type` int(50) NOT NULL COMMENT '类别，1是父级菜单，2是子级菜单，3是功能',
  `pvg_path` varchar(50) DEFAULT NULL COMMENT '路径（是菜单才拥有）',
  `pid` int(11) NOT NULL COMMENT '父级编号',
  `reserved1` int(11) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`pvgid`),
  KEY `reserved1` (`reserved1`),
  CONSTRAINT `dzw_privilege_ibfk_1` FOREIGN KEY (`reserved1`) REFERENCES `factory` (`factory`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COMMENT='权限表';

/*Data for the table `dzw_privilege` */

insert  into `dzw_privilege`(`pvgid`,`pvg_name`,`pvg_verify`,`pvg_type`,`pvg_path`,`pid`,`reserved1`,`reserved2`,`reserved3`) values (1,'服务接待','',1,'',0,NULL,'',''),(2,'结算中心',NULL,1,NULL,0,NULL,NULL,NULL),(3,'客户档案',NULL,1,NULL,0,NULL,NULL,NULL),(4,'基础数据',NULL,1,NULL,0,NULL,NULL,NULL),(5,'行政人事',NULL,1,'',0,NULL,NULL,NULL),(6,'系统设置',NULL,1,NULL,0,NULL,NULL,NULL),(7,'服务接待','',2,'',1,NULL,'',''),(8,'前台结算',NULL,2,'',2,NULL,NULL,NULL),(9,'客服档案',NULL,2,NULL,3,NULL,NULL,NULL),(10,'主数据',NULL,2,NULL,4,NULL,NULL,NULL),(11,'员工资料',NULL,2,NULL,5,NULL,NULL,NULL),(12,'技工管理',NULL,2,NULL,5,NULL,NULL,NULL),(13,'权限控制',NULL,2,NULL,6,NULL,NULL,NULL),(14,'维修接车',NULL,2,'zenglianjun/html/maintenance.html',7,NULL,NULL,NULL),(15,'竣工校验',NULL,2,'zenglianjun/html/jungonjianyan.html',7,NULL,NULL,NULL),(17,'结算中心',NULL,2,'jiesuanzhonxin.html',8,NULL,NULL,NULL),(18,'会员中心',NULL,2,'huiyuancz.html',8,NULL,NULL,NULL),(19,'客户资料',NULL,2,'kehuziliao/kehuziliao.html',9,NULL,NULL,NULL),(20,'车辆资料',NULL,2,'kehuziliao/cheliang.html',9,NULL,NULL,NULL),(21,'发动机品牌',NULL,2,'主数据/EngineBrand.html',10,NULL,NULL,NULL),(22,'车型档案',NULL,2,'主数据/ModelFile.html',10,NULL,NULL,NULL),(23,'维修项目',NULL,2,'主数据/MaintenanceItems.html',10,NULL,NULL,NULL),(24,'商品资料',NULL,2,'主数据/Commodity.html',10,NULL,NULL,NULL),(25,'供货单位',NULL,2,'主数据/Supplier.html',10,NULL,NULL,NULL),(26,'组织机构',NULL,2,'employees/organization.html',11,NULL,NULL,NULL),(27,'岗位定义	\r\n',NULL,2,'employees/gang.html',11,NULL,NULL,NULL),(28,'离职登记',NULL,2,'employees/lizhi.html',11,NULL,NULL,NULL),(29,'通讯名录',NULL,2,'employees/phone.html',11,NULL,NULL,NULL),(30,'技工星级',NULL,2,'jigongguanli/jigongxingji.html',12,NULL,NULL,NULL),(31,'班组技工',NULL,2,'jigongguanli/banzujigong.html',12,NULL,NULL,NULL),(32,'外勤车辆',NULL,2,'jigongguanli/waiqincheliang.html',12,NULL,NULL,NULL),(33,'技工提成比例',NULL,2,'jigongguanli/jigongtichengbili.html',12,NULL,NULL,NULL),(34,'用户权限控制',NULL,2,'userprivilege.html',13,NULL,NULL,NULL),(35,'角色权限控制',NULL,2,'role.html',13,NULL,NULL,NULL),(36,'增加商品资料按钮		\r\n','commodity:goods:add',3,NULL,24,NULL,NULL,NULL),(38,'修改商品资料按钮		\r\n','commodity:goods:update',3,NULL,24,NULL,NULL,NULL),(39,'删除商品资料按钮		\r\n','commodity:goods:remove',3,NULL,24,NULL,NULL,NULL),(40,'搜索商品资料按钮		\r\n','commodity:goods:seek',3,NULL,24,NULL,NULL,NULL),(41,'导出商品资料按钮		\r\n','commodity:goods:export',3,NULL,24,NULL,NULL,NULL),(42,'增加联系人按钮		\r\n','supplier:linkman:add',3,NULL,25,NULL,NULL,NULL),(43,'增加供货商按钮','supplier:supply:add',3,NULL,25,NULL,NULL,NULL),(44,'修改供货商按钮		\r\n','supplier:supply:update',3,NULL,25,NULL,NULL,NULL),(45,'删除供货商按钮		\r\n','supplier:supply:remove',3,NULL,25,NULL,NULL,NULL),(46,'搜索供货商按钮		\r\n','supplier:supply:seek',3,NULL,25,NULL,NULL,NULL),(47,'导出供货商管理数据按钮		\r\n','supplier:supply:export',3,NULL,25,NULL,NULL,NULL),(48,'联系人管理按钮		\r\n','supplier:supply:linkman',3,NULL,25,NULL,NULL,NULL),(49,'保存联系人按钮		\r\n','supplier:linkman:save',3,NULL,25,NULL,NULL,NULL),(50,'删除联系人按钮		\r\n','supplier:linkman:remove',3,NULL,25,NULL,NULL,NULL),(51,'收银','shouying',3,NULL,17,NULL,NULL,NULL),(52,'门店选择','mendianxuaze',3,NULL,17,NULL,NULL,NULL),(53,'查询','jiesuanchaxun',3,NULL,17,NULL,NULL,NULL),(54,'导出','jiesuandaochu',3,NULL,17,NULL,NULL,NULL),(55,'查看单据','chakandanju',3,NULL,17,NULL,NULL,NULL),(56,'查询','huiyuanchaxun',3,NULL,18,NULL,NULL,NULL),(57,'充值','huiyuanchongzhi',3,NULL,18,NULL,NULL,NULL),(58,'客户编辑\r\n','Client',3,NULL,19,NULL,NULL,NULL),(59,'车资料\r\n','Carheet',3,NULL,19,NULL,NULL,NULL),(60,'客户分类\r\n','ClientType',3,NULL,19,NULL,NULL,NULL),(61,'增加发动机品牌按钮		','enginebrand:engine:add',3,NULL,21,NULL,NULL,NULL),(62,'删除发动机品牌按钮		\r\n','enginebrand:engine:remove',3,NULL,21,NULL,NULL,NULL),(63,'保存按钮		\r\n','enginebrand:engine:save',3,NULL,21,NULL,NULL,NULL),(64,'导出按钮		\r\n','enginebrand:engine:export',3,NULL,21,NULL,NULL,NULL),(65,'增加车型品牌按钮		\r\n','modelfile:brand:add',3,NULL,22,NULL,NULL,NULL),(66,'修改车型品牌按钮		\r\n','modelfile:brand:update',3,NULL,22,NULL,NULL,NULL),(67,'删除车型品牌按钮		\r\n','modelfile:brand:remove',3,NULL,22,NULL,NULL,NULL),(68,'搜索车型品牌按钮		\r\n','modelfile:brand:seek',3,NULL,22,NULL,NULL,NULL),(69,'增加车型按钮		\r\n','modelfile:car:add',3,NULL,22,NULL,NULL,NULL),(70,'修改车型按钮		\r\n','modelfile:car:update',3,NULL,22,NULL,NULL,NULL),(71,'删除车型按钮		\r\n','modelfile:car:remove',3,NULL,22,NULL,NULL,NULL),(72,'搜索车型按钮		\r\n','modelfile:car:seek',3,NULL,22,NULL,NULL,NULL),(73,'添加分类按钮		\r\n','maintenanceitems:classify:add',3,NULL,23,NULL,NULL,NULL),(74,'修改分类按钮		\r\n','maintenanceitems:classify:update',3,NULL,23,NULL,NULL,NULL),(75,'删除分类按钮		\r\n','maintenanceitems:classify:remove',3,NULL,23,NULL,NULL,NULL),(76,'搜索维修项目按钮		\r\n','maintenanceitems:items:seek',3,NULL,23,NULL,NULL,NULL),(77,'增加维修项目按钮		\r\n','maintenanceitems:items:add',3,NULL,23,NULL,NULL,NULL),(78,'修改维修项目按钮		\r\n','maintenanceitems:items:update',3,NULL,23,NULL,NULL,NULL),(79,' 删除维修项目按钮		\r\n','maintenanceitems:items:remove',3,NULL,23,NULL,NULL,NULL),(80,'调价按钮		\r\n','maintenanceitems:items:price',3,NULL,23,NULL,NULL,NULL),(81,'导出维修项目数据按钮\n	\r\n','maintenanceitems:items:export',3,NULL,23,NULL,NULL,NULL),(82,'查询\r\n','selectClient',3,NULL,19,NULL,NULL,NULL),(83,'增加\r\n','insertCarheet',3,NULL,20,NULL,NULL,NULL),(84,'修改\r\n','updateCarheet',3,NULL,20,NULL,NULL,NULL),(85,'删除\r\n','deleteCarheet',3,NULL,20,NULL,NULL,NULL),(86,'查询\r\n','selectCarheet',3,NULL,20,NULL,NULL,NULL),(87,'保养\r\n','upKeep',3,NULL,20,NULL,NULL,NULL),(88,'删除门店\r\n','zyfOrganizationdelete',3,NULL,26,NULL,NULL,NULL),(89,'使用门店\r\n','zyfOrganizationinsert',3,NULL,26,NULL,NULL,NULL),(90,'门店编辑\r\n','zyfOrganizationupdate',3,NULL,26,NULL,NULL,NULL),(91,'增加员工\r\n','zyfOrganizationinsert2',3,NULL,26,NULL,NULL,NULL),(92,'修改员工\r\n','zyfOrganizationupdate2',3,NULL,26,NULL,NULL,NULL),(93,'删除门店\r\n','zyfOrganizationdelete2',3,NULL,26,NULL,NULL,NULL),(94,'导出\r\n','zyfOrganizationexport',3,NULL,26,NULL,NULL,NULL),(95,'导入\r\n','zyfOrganizationImport',3,NULL,26,NULL,NULL,NULL),(96,'增加\r\n','zyfjobdefinitioninsert',3,NULL,27,NULL,NULL,NULL),(97,'删除\r\n','zyfjobdefinitiondelete',3,NULL,27,NULL,NULL,NULL),(98,'保存\r\n','zyfjobdefinitionpreservation',3,NULL,27,NULL,NULL,NULL),(99,'导出\r\n','zyfjobdefinitionexport',3,NULL,27,NULL,NULL,NULL),(100,'离职登记\r\n','zyfresignationregistrationquit',3,NULL,28,NULL,NULL,NULL),(101,'回滚\r\n','zyfresignationregistrationrollback',3,NULL,28,NULL,NULL,NULL),(102,'删除\r\n','zyfresignationregistrationdelete',3,NULL,28,NULL,NULL,NULL),(103,'导出\r\n','zyfresignationregistrationexport',3,NULL,28,NULL,NULL,NULL),(104,'门店编辑\r\n','zyfresignationregistrationupdate',3,NULL,28,NULL,NULL,NULL),(105,'导出','zyfmailinglistexport',3,NULL,29,NULL,NULL,NULL),(106,'门店选择\r\n','zyfmailinglistchoice',3,NULL,29,NULL,NULL,NULL),(107,'用户授权','yonghushouquan',3,NULL,34,NULL,NULL,NULL),(108,'角色授权','jueseshouquan',3,NULL,35,NULL,NULL,NULL),(110,'模块管理','mokuai',2,'module.html',13,NULL,NULL,NULL),(111,'模块授权','mokuaishouquan',3,NULL,110,NULL,NULL,NULL),(112,'增加\r\n','MechanicStar:insert',3,NULL,30,NULL,NULL,NULL),(113,'删除\r\n','MechanicStar:delete',3,NULL,30,NULL,NULL,NULL),(114,'保存\r\n','MechanicStar:save',3,NULL,30,NULL,NULL,NULL),(115,'增加员工\r\n','TeamTechnician:insertY',3,NULL,31,NULL,NULL,NULL),(116,'增加班组\r\n','TeamTechnician:insertB',3,NULL,31,NULL,NULL,NULL),(117,'修改班组\r\n','TeamTechnician:updateB',3,NULL,31,NULL,NULL,NULL),(118,'删除班组\r\n','TeamTechnician:deleteB',3,NULL,31,NULL,NULL,NULL),(119,'增加\r\n','fieldvehicles:insert',3,NULL,32,NULL,NULL,NULL),(120,'删除\r\n','fieldvehicles:delete',3,NULL,32,NULL,NULL,NULL),(121,'保存\r\n','fieldvehicles:save',3,NULL,32,NULL,NULL,NULL),(122,'增加\r\n','mechaniccommission:insert',3,NULL,33,NULL,NULL,NULL),(123,'删除\r\n','mechaniccommission:delete',3,NULL,33,NULL,NULL,NULL),(124,'保存\r\n','mechaniccommission:save',3,NULL,33,NULL,NULL,NULL),(125,'查看','chakan',3,NULL,14,NULL,NULL,NULL),(126,'查看','chakan',3,NULL,15,NULL,NULL,NULL),(127,'查看','chakan',3,NULL,16,NULL,NULL,NULL);

/*Table structure for table `dzw_role` */

DROP TABLE IF EXISTS `dzw_role`;

CREATE TABLE `dzw_role` (
  `role_id` int(11) NOT NULL COMMENT '角色唯一编号',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(50) NOT NULL COMMENT '角色描述',
  `status` varchar(10) NOT NULL COMMENT '角色状态，0000：代表有效，0001：代表无效，0002：代表伪删除',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '最近更新时间',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `dzw_role` */

insert  into `dzw_role`(`role_id`,`role_name`,`role_desc`,`status`,`create_date`,`update_date`,`reserved1`,`reserved2`,`reserved3`) values (1,'总经理','超级管理员','0000','2021-02-22','2021-02-22',NULL,NULL,NULL),(2,'人事经理','人事管理','0000','2021-02-25','2021-02-25',NULL,NULL,NULL),(3,'市场经理','客户管理','0000','2021-02-25','2021-02-25',NULL,NULL,NULL),(4,'产品经理','维修管理','0000','2021-02-25','2021-02-25','','',''),(5,'保安队队长','公司保安','0000',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `dzw_user` */

DROP TABLE IF EXISTS `dzw_user`;

CREATE TABLE `dzw_user` (
  `user_id` int(11) NOT NULL COMMENT '用户唯一编号',
  `user_name` varchar(50) NOT NULL COMMENT '用户昵称',
  `user_login` varchar(50) NOT NULL COMMENT '登录账号',
  `user_pwd` varchar(50) NOT NULL COMMENT '登录密码',
  `user_realname` varchar(50) NOT NULL COMMENT '真实姓名',
  `user_sex` varchar(50) DEFAULT NULL COMMENT '用户性别，00：代表女，11：代表男，03：代表未知',
  `user_phone` varchar(50) NOT NULL COMMENT '手机号',
  `user_eamil` varchar(50) NOT NULL COMMENT '邮箱',
  `user_address` varchar(100) DEFAULT NULL COMMENT '地址',
  `status` varchar(10) NOT NULL COMMENT '用户状态，0000：代表有效，0001：代表无效，0002：代表伪删除',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '最近更新时间',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `dzw_user` */

insert  into `dzw_user`(`user_id`,`user_name`,`user_login`,`user_pwd`,`user_realname`,`user_sex`,`user_phone`,`user_eamil`,`user_address`,`status`,`create_date`,`update_date`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values (1,'德召文','admin','0','王泽旭','11','12311112222','123@qq.com','湖南省','0000','2021-02-04','2021-02-04','','','','',''),(2,'一包辣条','admin2','0','单观柏1','11','12322223333','123@qq.com','湖南省','0000','2021-02-25','2021-02-25','','','','','');

/*Table structure for table `education` */

DROP TABLE IF EXISTS `education`;

CREATE TABLE `education` (
  `educationid` int(11) NOT NULL COMMENT '学历编号',
  `name` varchar(50) NOT NULL COMMENT '学历名称',
  PRIMARY KEY (`educationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学历表';

/*Data for the table `education` */

insert  into `education`(`educationid`,`name`) values (1,'小学'),(2,'初中'),(3,'高中'),(4,'大专'),(5,'本科');

/*Table structure for table `engine` */

DROP TABLE IF EXISTS `engine`;

CREATE TABLE `engine` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '发动机品牌编号',
  `e_coder` varchar(20) DEFAULT NULL COMMENT '发动机品牌编码',
  `e_name` varchar(20) DEFAULT NULL COMMENT '发动机品牌名称',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='发动机表';

/*Data for the table `engine` */

insert  into `engine`(`e_id`,`e_coder`,`e_name`) values (1,'11','一号发动机'),(2,'22','二号发动机'),(3,'33','三号发动机'),(4,'44','四号发动机'),(5,'55','小胖发动机'),(6,'66','曾子发动机'),(8,'77','军子发动机'),(10,'2','大胖发动机'),(11,'3','中胖发动机');

/*Table structure for table `factory` */

DROP TABLE IF EXISTS `factory`;

CREATE TABLE `factory` (
  `factory` int(11) NOT NULL COMMENT '厂id',
  `factoryname` varchar(50) DEFAULT NULL COMMENT '厂名',
  PRIMARY KEY (`factory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工厂表';

/*Data for the table `factory` */

insert  into `factory`(`factory`,`factoryname`) values (1,'北京卡修有限公司'),(2,'北京卡修有限公司分部');

/*Table structure for table `field` */

DROP TABLE IF EXISTS `field`;

CREATE TABLE `field` (
  `id` int(11) NOT NULL,
  `width` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `zname` varchar(50) DEFAULT NULL,
  `display` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `field` */

insert  into `field`(`id`,`width`,`name`,`zname`,`display`) values (1,100,'部门代码','a1','0'),(2,100,'部门名称','a1','0'),(3,100,'工号','a1','1'),(4,100,'姓名','a1','1'),(5,100,'性别','a1','1'),(6,100,'岗位名称','a1','0'),(7,100,'身体状况','a1','1'),(8,100,'身高','a1','1'),(9,100,'籍贯','a1','0'),(10,100,'民族','a1','0'),(11,100,'婚姻状况','a1','0'),(12,100,'学历','a1','0'),(13,100,'毕业学校','a1','0'),(14,100,'专业','a1','0'),(15,100,'专业资格','a1','0'),(16,100,'学位','a1','0'),(17,100,'编制','a1','0'),(18,100,'身份证号','a1','1'),(19,100,'户口地址','a1','1'),(20,100,'邮编','a1','1'),(21,100,'现住地址','a1','1'),(22,100,'邮编','a1','0'),(23,100,'联系电话','a1','1'),(24,100,'手机','a1','1'),(25,100,'email','a1','0'),(26,100,'紧急情况联系人','a1','0'),(27,100,'联系电话','a1','0'),(28,100,'现在何处','a1','0'),(29,100,'使用到期','a1','0'),(30,100,'入职日期','a1','0'),(31,100,'出生日期','a1','0'),(32,100,'合同开始日期','a1','0'),(33,100,'合同结束日期','a1','0'),(34,100,'登陆账号','a1','0');

/*Table structure for table `fieldvehicles` */

DROP TABLE IF EXISTS `fieldvehicles`;

CREATE TABLE `fieldvehicles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `licenseplate` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
  `model` varchar(50) DEFAULT NULL COMMENT '车型',
  `currentmileage` varchar(50) DEFAULT NULL COMMENT '当前里程',
  `teamid` varchar(50) DEFAULT NULL COMMENT '班组编号',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`),
  KEY `teamid` (`teamid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='外勤车辆表';

/*Data for the table `fieldvehicles` */

insert  into `fieldvehicles`(`id`,`licenseplate`,`brand`,`model`,`currentmileage`,`teamid`,`reserved1`,`reserved2`,`reserved3`) values (1,'湘B70712','马自达','cx-5','111','1002',NULL,NULL,NULL),(2,'湘B21U53','本田','雅阁','50','1000',NULL,NULL,NULL),(3,'湘BLC212','北京现代','索纳塔','1','1003',NULL,NULL,NULL),(5,'湘B88888','宝马','760','20','1000',NULL,NULL,NULL);

/*Table structure for table `get_material` */

DROP TABLE IF EXISTS `get_material`;

CREATE TABLE `get_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆id',
  `lb` varchar(50) DEFAULT NULL COMMENT '类别',
  `lingliaodate` date DEFAULT NULL COMMENT '领料日期',
  `lingliaor` varchar(50) DEFAULT NULL COMMENT '领料人',
  `wuliao` varchar(50) DEFAULT NULL COMMENT '物料编号',
  `wuliaoname` varchar(50) DEFAULT NULL COMMENT '物料名称',
  `dwei` varchar(50) DEFAULT NULL COMMENT '单位',
  `jialei` varchar(50) DEFAULT NULL COMMENT '价类',
  `shuliao` varchar(50) DEFAULT NULL COMMENT '数量',
  `danjian` double DEFAULT NULL COMMENT '单价',
  `jine` double DEFAULT NULL COMMENT '金额',
  `fuwugw` varchar(50) DEFAULT NULL COMMENT '服务顾问',
  `duiy` varchar(50) DEFAULT NULL COMMENT '对应项目',
  `cid` int(11) DEFAULT NULL COMMENT '车资料id',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `get_material_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `carheet` (`carnum`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='领料情况表';

/*Data for the table `get_material` */

insert  into `get_material`(`id`,`lb`,`lingliaodate`,`lingliaor`,`wuliao`,`wuliaoname`,`dwei`,`jialei`,`shuliao`,`danjian`,`jine`,`fuwugw`,`duiy`,`cid`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values (1,'厉害','2021-03-02','4','4','4','4','4','4',4,4,'4','4',22145678,'1','1','1','1','1');

/*Table structure for table `graduate_school` */

DROP TABLE IF EXISTS `graduate_school`;

CREATE TABLE `graduate_school` (
  `schoolid` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) NOT NULL COMMENT '毕业学校',
  PRIMARY KEY (`schoolid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校表';

/*Data for the table `graduate_school` */

insert  into `graduate_school`(`schoolid`,`name`) values (1,'湖南科技大学'),(2,'武汉体育大学'),(3,'清华大学'),(4,'北京大学'),(5,'国防科技大学');

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `clientid` int(11) NOT NULL COMMENT '历史回访id',
  `huifnr` varchar(50) DEFAULT NULL COMMENT '回访内容',
  `huifdate` date DEFAULT NULL COMMENT '回访时间',
  `kmbm` varchar(50) DEFAULT NULL COMMENT '客户编码',
  `khname` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `dizhi` varchar(50) DEFAULT NULL COMMENT '地址',
  `cph` int(50) DEFAULT NULL COMMENT '车牌号',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机',
  `dh` varchar(50) DEFAULT NULL COMMENT '电话',
  `wxxm` varchar(50) DEFAULT NULL COMMENT '维修项目',
  `djlx` varchar(50) DEFAULT NULL COMMENT '单据类型',
  `huifxg` varchar(50) DEFAULT NULL COMMENT '回访效果',
  `fwugw` varchar(50) DEFAULT NULL COMMENT '服务顾问',
  `xianx` varchar(50) DEFAULT NULL COMMENT '详细说明',
  `kdr` varchar(50) DEFAULT NULL COMMENT '开单人',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`clientid`),
  KEY `cph` (`cph`),
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`cph`) REFERENCES `platenumber` (`plateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='历史回访表';

/*Data for the table `history` */

/*Table structure for table `image` */

DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
  `i_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '照片序号',
  `i_img` varchar(50) DEFAULT NULL COMMENT '照片路径',
  `c_id` int(11) DEFAULT NULL COMMENT '车型编号',
  PRIMARY KEY (`i_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `image_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `car` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车型照片';

/*Data for the table `image` */

/*Table structure for table `image_merchandise` */

DROP TABLE IF EXISTS `image_merchandise`;

CREATE TABLE `image_merchandise` (
  `i_id` varchar(20) NOT NULL COMMENT '商品照片编号',
  `i_imgsrc` varchar(50) DEFAULT NULL COMMENT '照片路径',
  `me_id` varchar(50) DEFAULT NULL COMMENT '商品编号',
  PRIMARY KEY (`i_id`),
  KEY `me_id` (`me_id`),
  CONSTRAINT `image_merchandise_ibfk_1` FOREIGN KEY (`me_id`) REFERENCES `merchandise` (`me_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息图片';

/*Data for the table `image_merchandise` */

/*Table structure for table `img_suppiler` */

DROP TABLE IF EXISTS `img_suppiler`;

CREATE TABLE `img_suppiler` (
  `i_id` varchar(20) DEFAULT NULL COMMENT '供应商照片编号',
  `i_imgsrc` varchar(20) DEFAULT NULL COMMENT '照片路径',
  `p_id` varchar(20) DEFAULT NULL COMMENT '供应商编号',
  KEY `p_id` (`p_id`),
  CONSTRAINT `img_suppiler_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `suppiler` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商图片';

/*Data for the table `img_suppiler` */

/*Table structure for table `income` */

DROP TABLE IF EXISTS `income`;

CREATE TABLE `income` (
  `in_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收入种类编号',
  `in_name` varchar(20) DEFAULT NULL COMMENT '收入种类名称',
  PRIMARY KEY (`in_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='收入种类';

/*Data for the table `income` */

insert  into `income`(`in_id`,`in_name`) values (1,'工时费1'),(2,'燃油费'),(3,'代办费'),(4,'其他');

/*Table structure for table `jcyl` */

DROP TABLE IF EXISTS `jcyl`;

CREATE TABLE `jcyl` (
  `ylid` int(11) NOT NULL COMMENT '油量序号',
  `yl` varchar(50) DEFAULT NULL COMMENT '油量',
  PRIMARY KEY (`ylid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='油量';

/*Data for the table `jcyl` */

insert  into `jcyl`(`ylid`,`yl`) values (1,'2/2'),(2,'3/3'),(3,'4/4');

/*Table structure for table `linkman` */

DROP TABLE IF EXISTS `linkman`;

CREATE TABLE `linkman` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商联系人编号',
  `l_post` varchar(50) DEFAULT NULL COMMENT '供应商联系人职位',
  `l_name` varchar(50) DEFAULT NULL COMMENT '供应商联系人姓名',
  `l_phone` varchar(50) DEFAULT NULL COMMENT '供应商联系人电话',
  `l_mobile` varchar(50) DEFAULT NULL COMMENT '供应商联系人手机',
  `l_emile` varchar(50) DEFAULT NULL COMMENT '供应商联系人Emile',
  `p_id` varchar(20) DEFAULT NULL COMMENT '供应商编号',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`l_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `linkman_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `suppiler` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='联系人\r\n';

/*Data for the table `linkman` */

insert  into `linkman`(`l_id`,`l_post`,`l_name`,`l_phone`,`l_mobile`,`l_emile`,`p_id`,`reserved1`,`reserved2`,`reserved3`) values (2,'副经理','李四','3214122','123432','12311@qq.com','2','0',NULL,NULL),(3,'副经理','李四','123124','123124','12311@qq.com','3','0',NULL,NULL),(4,'副经理','张三','123','123124','12311@qq.com','4','0',NULL,NULL),(5,'副经理','赵六','124124123','12432','12311@qq.com','5','0',NULL,NULL),(6,'总经理','赵六','1231241','12342','12311@qq.com','6','0',NULL,NULL),(7,'总经理','张三','2312412','112312','12311@qq.com','7','0',NULL,NULL),(8,'总经理','赵六','312412','4123','12311@qq.com','8','0',NULL,NULL),(9,'总经理','张三','31421','4213213','12311@qq.com','9','0',NULL,NULL),(10,'总经理','李四1','312412','4324123','12311@qq.com','10','0','',''),(11,'总经理','李四1','31241','123431','12311@qq.com','11','0','',''),(12,'普通员工','李四','31243123','123124','12311@qq.com','12','0',NULL,NULL),(13,'普通员工','李四','124','12412','12311@qq.com','13','0',NULL,NULL),(14,'普通员工','王五12','1231233','12124','12311@qq.com','1','0','',''),(15,'普通员工','王五','4123','12412','12311@qq.com','2','0',NULL,NULL),(16,'普通员工','王五','412','12412','12311@qq.com','3','0',NULL,NULL),(17,'普通员工','王五','3124','123124','12311@qq.com','4','0',NULL,NULL),(18,'普通员工','王五','123124','3124123','12311@qq.com','5','0',NULL,NULL),(19,'普通员工','赵六','123124','124123','12311@qq.com','6','0',NULL,NULL),(20,'普通员工','赵六','123412','12312','12311@qq.com','7','0',NULL,NULL),(27,'普通员工','老八','1313','1313','13','1',NULL,NULL,NULL),(30,'普通员工','刘七','32','31','4','1111',NULL,NULL,NULL),(31,'普通员工','张三','12','23','41','1111','','',''),(32,'不普通员工','刘七','11','112','11','123','','','');

/*Table structure for table `maintenance` */

DROP TABLE IF EXISTS `maintenance`;

CREATE TABLE `maintenance` (
  `m_id` int(11) NOT NULL COMMENT '维修进程编号',
  `m_name` varchar(50) DEFAULT NULL COMMENT '维修进程项目名',
  `m_note` varchar(255) DEFAULT NULL COMMENT '维修进程备注',
  `m_type` varchar(10) DEFAULT NULL COMMENT '维修进程种类',
  `m_normalprice` float DEFAULT NULL COMMENT '维修进程标准价',
  `m_memberprice` float DEFAULT NULL COMMENT '维修进程会员价',
  `m_vipprice` float DEFAULT NULL COMMENT '维修进程vip价',
  `m_detaprice` float DEFAULT NULL COMMENT '维修进程协议价',
  `m_claimprice` float DEFAULT NULL COMMENT '维修进程索赔价',
  `m_safetyprice` float DEFAULT NULL COMMENT '维修进程索赔价',
  `in_id` int(11) DEFAULT NULL COMMENT '收入种类编号',
  `b_id` int(11) DEFAULT NULL COMMENT '车型品牌编号',
  `e_id` int(11) DEFAULT NULL COMMENT '发动机品牌编号',
  `ser_id` int(11) DEFAULT NULL COMMENT '维修项目编号',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  KEY `in_id` (`in_id`),
  KEY `b_id` (`b_id`),
  KEY `ser_id` (`ser_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `maintenance_ibfk_1` FOREIGN KEY (`in_id`) REFERENCES `income` (`in_id`),
  CONSTRAINT `maintenance_ibfk_2` FOREIGN KEY (`b_id`) REFERENCES `brand` (`b_id`),
  CONSTRAINT `maintenance_ibfk_3` FOREIGN KEY (`ser_id`) REFERENCES `service` (`ser_id`),
  CONSTRAINT `maintenance_ibfk_4` FOREIGN KEY (`e_id`) REFERENCES `engine` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='历史维修表';

/*Data for the table `maintenance` */

insert  into `maintenance`(`m_id`,`m_name`,`m_note`,`m_type`,`m_normalprice`,`m_memberprice`,`m_vipprice`,`m_detaprice`,`m_claimprice`,`m_safetyprice`,`in_id`,`b_id`,`e_id`,`ser_id`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values (4,'修矫驾驶室顶棚','好好修',NULL,1100,412,123,123,435,234,1,NULL,5,1002,NULL,NULL,NULL,NULL,NULL),(5,'前一桥前轮保养（碟刹）','1',NULL,532,123,432,432,532,435,4,NULL,5,1002,NULL,NULL,NULL,NULL,NULL),(8,'更换前轮轮胎螺栓（不含拆装轮胎）','1',NULL,234,123,123,12,234,532,2,NULL,2,1001,NULL,NULL,NULL,NULL,NULL),(12,'检查后钢板吊耳及座子','12',NULL,23,234,54,23,34,243,1,NULL,10,1007,NULL,NULL,NULL,NULL,NULL),(13,'紧固中冷水箱增压器等各类抱箍（单个）','12',NULL,21,32,123,321,34,234,2,NULL,8,1007,NULL,NULL,NULL,NULL,NULL),(1322,'检查增压机间隙及进排气叶轮磨损程度','钱喂',NULL,12,12,21,12,12,21,2,NULL,NULL,1003,NULL,NULL,NULL,NULL,NULL),(2134,'检查发动机有无异响或异常','1',NULL,23,2,23,234,32,1,4,NULL,NULL,1007,NULL,NULL,NULL,NULL,NULL),(4545,'检查进排气歧管是否漏气','11',NULL,12,18,144,234,21,22,1,NULL,NULL,1008,NULL,NULL,NULL,NULL,NULL),(1113,'检查蓄电池电量是否充足','没有备注',NULL,12,18,19,43234,21,22,1,NULL,NULL,1001,NULL,NULL,NULL,NULL,NULL),(1,'前一桥前轮保养碟刹','11',NULL,11,435,17,423,19,20,1,NULL,NULL,1001,NULL,NULL,NULL,NULL,NULL),(2,'紧固中冷水箱增压器等各类抱箍（单个）','1',NULL,12,634,234234,2323,2345,123,1,NULL,NULL,1002,NULL,NULL,NULL,NULL,NULL),(3,'检查增压机间隙及进排气叶轮磨损程度','1',NULL,31,4754,243,235,435,43,2,NULL,NULL,1003,NULL,NULL,NULL,NULL,NULL),(4,'检查发动机有无异响或异常','1',NULL,42,346,34,2,3453,23,3,NULL,NULL,1004,NULL,NULL,NULL,NULL,NULL),(5,'检查进排气歧管是否漏气','1',NULL,1,5346,234,23,34,4,1,NULL,NULL,1005,NULL,NULL,NULL,NULL,NULL),(7,'检查制动阀是否漏气','1',NULL,123,23,53,234,5,3,3,NULL,NULL,1007,NULL,NULL,NULL,NULL,NULL),(8,'检查转向系统是否正常',NULL,NULL,4,4523,6,235,2,63,4,NULL,NULL,1008,NULL,NULL,NULL,NULL,NULL),(9,'检查刮水器是否异常','1',NULL,1234,45,346,234,235,6,3,NULL,NULL,1007,NULL,NULL,NULL,NULL,NULL),(12,'检查后钢板吊耳及座子','12',NULL,23,234,54,23,34,243,1,NULL,NULL,1007,NULL,NULL,NULL,NULL,NULL),(13,'紧固中冷水箱增压器等各类抱箍（单个）','12',NULL,21,32,123,321,34,234,2,NULL,NULL,1007,NULL,NULL,NULL,NULL,NULL),(14,'检查蓄电池电量是否充足','1',NULL,4,7345,346,4,234,634,4,NULL,NULL,1005,NULL,NULL,NULL,NULL,NULL),(15,'检查前桥直拉杆球头开口销',NULL,NULL,423,45745,34,23,234,3,1,NULL,NULL,1004,NULL,NULL,NULL,NULL,NULL),(16,'检查发动机是否漏水','1',NULL,523,36,364,4,234,23,2,NULL,NULL,1005,NULL,NULL,NULL,NULL,NULL),(19,'检查前束是否准确',NULL,NULL,125,2342,346,42,234,235,2,NULL,NULL,1006,NULL,NULL,NULL,NULL,NULL),(20,'检查发动机前引进脚','1',NULL,235,234,346,12,23,346346,1,NULL,NULL,1005,NULL,NULL,NULL,NULL,NULL),(21,'检查发动机后引进脚','1',NULL,2522,234,346,345,423,24,2,NULL,NULL,1005,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `maintenance_items` */

DROP TABLE IF EXISTS `maintenance_items`;

CREATE TABLE `maintenance_items` (
  `wxdh` varchar(50) NOT NULL COMMENT '维修单号',
  `jcsj` date DEFAULT NULL COMMENT '接车时间',
  `wgsj` date DEFAULT NULL COMMENT '完工时间',
  `jsdate` date DEFAULT NULL COMMENT '结算时间',
  `xmbh` varchar(50) DEFAULT NULL COMMENT '项目编码',
  `xmname` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `jialei` varchar(50) DEFAULT NULL COMMENT '价类',
  `jiesgs` double DEFAULT NULL COMMENT '结算公时',
  `gshije` double DEFAULT NULL COMMENT '工时金额',
  `zuoyery` varchar(50) DEFAULT NULL COMMENT '作业人员',
  `gzms` varchar(50) DEFAULT NULL COMMENT '故障描述',
  `gzqr` varchar(50) DEFAULT NULL COMMENT '故障确认',
  `gdh` varchar(50) DEFAULT NULL COMMENT '工单号',
  `gwei` varchar(50) DEFAULT NULL COMMENT '工位',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`wxdh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修项目表';

/*Data for the table `maintenance_items` */

insert  into `maintenance_items`(`wxdh`,`jcsj`,`wgsj`,`jsdate`,`xmbh`,`xmname`,`jialei`,`jiesgs`,`gshije`,`zuoyery`,`gzms`,`gzqr`,`gdh`,`gwei`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values ('1','2021-02-23','2021-03-17','2021-03-09','1','1','1',1,9,'1','22','1','1','1','8','1','1','1','1'),('22145678','2021-03-11','2021-03-04','2021-03-10','5252','玛蒂卡','12',123,123,'杀个白','无','电路故障','222','嗡嗡嗡','1','2','3','4','5');

/*Table structure for table `maintenances` */

DROP TABLE IF EXISTS `maintenances`;

CREATE TABLE `maintenances` (
  `maintainid` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修id',
  `danju` varchar(50) DEFAULT NULL COMMENT '单据类型',
  `xiaos` varchar(50) DEFAULT NULL COMMENT '销售单号',
  `chepai` int(50) DEFAULT NULL COMMENT '车牌号	外键关联车资料表carheet-vehicleid列',
  `jincdate` date DEFAULT NULL COMMENT '进厂时间',
  `wangongdate` date DEFAULT NULL COMMENT '完工时间',
  `jiesdate` date DEFAULT NULL COMMENT '结算时间',
  `jiesmone` double DEFAULT NULL COMMENT '结算金额',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`maintainid`),
  KEY `chepai` (`chepai`),
  CONSTRAINT `maintenances_ibfk_1` FOREIGN KEY (`chepai`) REFERENCES `platenumber` (`plateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='历史维修';

/*Data for the table `maintenances` */

/*Table structure for table `marital_status` */

DROP TABLE IF EXISTS `marital_status`;

CREATE TABLE `marital_status` (
  `marriageid` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) NOT NULL COMMENT '婚姻状况',
  PRIMARY KEY (`marriageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='婚姻状态表';

/*Data for the table `marital_status` */

insert  into `marital_status`(`marriageid`,`name`) values (1,'已婚'),(2,'未婚');

/*Table structure for table `mechaniccommission` */

DROP TABLE IF EXISTS `mechaniccommission`;

CREATE TABLE `mechaniccommission` (
  `typeid` int(11) NOT NULL COMMENT '分类编码',
  `typename` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `dayinthestation` double DEFAULT NULL COMMENT '站内白天',
  `nightinthestation` double DEFAULT NULL COMMENT '站内晚上',
  `dayoutthestation` double DEFAULT NULL COMMENT '站外白天',
  `nightoutthestation` double DEFAULT NULL COMMENT '站外晚上',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技工提成比例';

/*Data for the table `mechaniccommission` */

insert  into `mechaniccommission`(`typeid`,`typename`,`dayinthestation`,`nightinthestation`,`dayoutthestation`,`nightoutthestation`,`reserved1`,`reserved2`,`reserved3`) values (10,'工时费',0.5,0.6,0.6,0.7,NULL,NULL,NULL),(20,'保养费',0.1,0.12,0.12,0.15,'','',''),(30,'燃油费',0.15,0.15,0.15,0.15,NULL,NULL,NULL),(40,'代办费',0.15,0.15,0.15,0.15,NULL,NULL,NULL),(50,'其他费',0,0,0,0,NULL,NULL,NULL);

/*Table structure for table `mechanicstar` */

DROP TABLE IF EXISTS `mechanicstar`;

CREATE TABLE `mechanicstar` (
  `code` varchar(50) NOT NULL COMMENT '编码',
  `star` varchar(50) NOT NULL COMMENT '星级',
  `grade` varchar(50) DEFAULT NULL COMMENT '等级',
  `Commissionweight` varchar(50) DEFAULT NULL COMMENT '提成权重',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技工星级表';

/*Data for the table `mechanicstar` */

insert  into `mechanicstar`(`code`,`star`,`grade`,`Commissionweight`) values ('xj001','2星','2','0.4'),('xj002','3星','3','0.8'),('xj003','5星','1','1'),('xj004','专家','5','9.1'),('xj005','大师','6','9.5');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `menuname` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `parentid` int(11) DEFAULT NULL COMMENT '父级编号',
  `teamid` int(50) NOT NULL COMMENT '班组编号',
  `reserved1` int(11) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='树形菜单';

/*Data for the table `menu` */

insert  into `menu`(`id`,`menuname`,`parentid`,`teamid`,`reserved1`,`reserved2`,`reserved3`) values (1,'10-自建',0,10,NULL,'false','1'),(2,'11-联队',0,11,NULL,'false','1'),(3,'12-加盟',0,12,NULL,'false','1'),(4,'13-合伙人',0,13,NULL,'false','1'),(5,'1000-机修一组',1,1000,NULL,'false','1'),(6,'1001-机修二组',1,1001,NULL,'false','1'),(7,'1004-机电一组',1,1004,NULL,'false','1'),(10,'1002-华山队',2,1002,NULL,'false','1'),(11,'1003-武昌队',3,1003,NULL,'false','1');

/*Table structure for table `menu_merchandise` */

DROP TABLE IF EXISTS `menu_merchandise`;

CREATE TABLE `menu_merchandise` (
  `menu_id` int(11) NOT NULL COMMENT '菜单商品信息编号',
  `menu_name` varchar(20) DEFAULT NULL COMMENT '菜单商品信息名称',
  `menu_parent` int(11) DEFAULT NULL COMMENT '父级商品菜单编号',
  `menu_tag` varchar(20) DEFAULT NULL COMMENT '菜单标识',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单商品资料表';

/*Data for the table `menu_merchandise` */

insert  into `menu_merchandise`(`menu_id`,`menu_name`,`menu_parent`,`menu_tag`) values (1,'总',0,NULL),(100,'发动机',1,NULL),(101,'传动装置',1,NULL),(1001,'发动机总成',100,NULL),(1002,'机体组',100,NULL),(1003,'离合器',101,NULL),(1004,'变速器',101,NULL),(10001,'柴油发动机',1001,NULL),(10002,'汽油发动机',1001,NULL),(10003,'燃气轮机',1001,NULL),(10004,'汽缸体',1002,NULL),(10005,'缸盖',1002,NULL),(10006,'缸套',1002,NULL),(10007,'离合器片',1003,NULL),(10008,'离合器压板',1003,NULL),(10009,'离合器总泵',1003,NULL),(10010,'变速轴',1004,NULL),(10011,'同步器',1004,NULL),(10012,'分动器',1004,NULL);

/*Table structure for table `merchandise` */

DROP TABLE IF EXISTS `merchandise`;

CREATE TABLE `merchandise` (
  `me_id` varchar(20) NOT NULL COMMENT '商品信息编号',
  `me_check` varchar(20) DEFAULT NULL COMMENT '登记门店',
  `me_name` varchar(20) DEFAULT NULL COMMENT '商品名称',
  `me_brand` varchar(20) DEFAULT NULL COMMENT '商品品牌',
  `me_adaptable` varchar(20) DEFAULT NULL COMMENT '商品使用车型',
  `me_unit` varchar(20) DEFAULT NULL COMMENT '数量单位',
  `me_income` varchar(20) DEFAULT NULL COMMENT '收入分类',
  `me_mill` varchar(20) DEFAULT NULL COMMENT '原厂副厂',
  `me_grade` varchar(20) DEFAULT NULL COMMENT '商品等级',
  `me_place` varchar(20) DEFAULT NULL COMMENT '商品产地',
  `me_coding` varchar(20) DEFAULT NULL COMMENT '原厂编码',
  `me_code` varchar(20) DEFAULT NULL COMMENT '条形码',
  `me_back` varchar(20) DEFAULT NULL COMMENT '包装规格',
  `me_bulk` varchar(20) DEFAULT NULL COMMENT '体积',
  `me_gross` varchar(20) DEFAULT NULL COMMENT '毛重',
  `me_suttle` varchar(20) DEFAULT NULL COMMENT '净重',
  `me_cost` varchar(20) DEFAULT NULL COMMENT '进货价',
  `me_switch` varchar(20) DEFAULT NULL COMMENT '互换码',
  `me_normalprice` float DEFAULT NULL COMMENT '标准价',
  `me_memberprice` float DEFAULT NULL COMMENT '会员价',
  `me_vipprice` float DEFAULT NULL COMMENT 'Vip价',
  `me_detaprice` float DEFAULT NULL COMMENT '协议价',
  `me_claimprice` float DEFAULT NULL COMMENT '索赔价',
  `me_show` int(11) DEFAULT NULL COMMENT '是否展示',
  `me_safetyprice` float DEFAULT NULL COMMENT '保险价',
  `menu_id` int(11) DEFAULT NULL COMMENT '商品大类	 menu_merchandise表--menu列',
  `p_id` varchar(20) DEFAULT NULL COMMENT '厂商，供货商编号	Suppiler表--p_id列',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`me_id`),
  KEY `menu_id` (`menu_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `merchandise_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu_merchandise` (`menu_id`),
  CONSTRAINT `merchandise_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `suppiler` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单信息图片';

/*Data for the table `merchandise` */

insert  into `merchandise`(`me_id`,`me_check`,`me_name`,`me_brand`,`me_adaptable`,`me_unit`,`me_income`,`me_mill`,`me_grade`,`me_place`,`me_coding`,`me_code`,`me_back`,`me_bulk`,`me_gross`,`me_suttle`,`me_cost`,`me_switch`,`me_normalprice`,`me_memberprice`,`me_vipprice`,`me_detaprice`,`me_claimprice`,`me_show`,`me_safetyprice`,`menu_id`,`p_id`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values ('1','一号门店','氧传感器\\前','宝马','一号发动机','个','燃油费','三号厂','良','北京','1232','123123342dasd2','一号规格','20','15','12','12343','123123',12,23,43,23,12,NULL,123,10002,'1111','照片名','0.00','售价表','0',''),('10','一号门店','怠速马达','别克','一号发动机','件','代办费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10001,'1111','','','','0',''),('11','一号门店','阀门','别克','一号发动机','件','代办费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10003,'1111','','','','0',''),('11313','','1','','','个','','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10005,NULL,'','','','1',''),('1133',NULL,'31',NULL,NULL,'个',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10006,NULL,NULL,NULL,NULL,'1',NULL),('12','一号门店','活性碳罐控制阀','别克','一号发动机','件','代办费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10005,'1111','','','','0',''),('123','','喷油嘴','别克','31','条','燃油费','一号厂','优','湖南','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10007,'23','','','','0',''),('12333','暂无门店','喷油嘴','宝马','','件','燃油费','二号厂','良','湖南','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10010,'23','','','','0',''),('13','一号门店','空气流量计','宝骏','一号发动机','个','代办费','','优','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10002,'1111','','','','0',''),('131','','节气门','东风','东风','条','燃油费','一号厂','优','湖南','13','13','13','31','31','31','13','13',31,13,13,13,31,NULL,13,10010,'1111','','','售价表','0',''),('1311','','电动汽油泵总成','宝马','','个','代办费','二号厂','优','湖南','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10007,NULL,'','','','0',''),('133','','电动汽油泵芯','宝马','1','条','工时费','一号厂','良','湖南','12','12','12','12','12','21','12','12',12,12,12,12,12,NULL,12,10008,'1111','','','售价表','0',''),('14','一号门店','电瓶 92AH','宝骏','二号发动机','只','其他','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1001,NULL,'','','','0',''),('144','','电瓶   110A','宝骏','123','件','工时费','一号厂','优','湖南','123','123','213','12','23','213','23','32',32,12,13,13,23,NULL,123,10002,'23','','','售价表','0',''),('15','一号门店','电瓶/72ah','宝骏','三号发动机','只','其他','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1002,'1111','照片','0.00','加价率','0',''),('16','一号门店','电瓶/95A','宝骏','三号发动机','只','其他','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1003,NULL,'','','','0',''),('17','一号门店','雨刮联动机构','东风','三号发动机','条','其他','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1004,NULL,'','','','0',''),('18','一号门店','汽油滤清器','东风','三号发动机','只','其他','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1001,NULL,'','','','0',''),('19','一号门店','风帆电瓶','宝马','三号发动机','条','其他','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1002,NULL,'','','','0',''),('2','一号门店','火花塞\\白金','宝马','一号发动机','件','代办费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10005,'1111','','','','0',''),('20','一号门店','一号商品','东风','三号发动机','条','其他',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1003,NULL,NULL,NULL,NULL,'0',NULL),('21','','变速箱油  无极','宝马','宝马是','件','其他','一号厂','优','湖南','121','条形码','规格','体积','100','100','100','123123123123123',11,11,11,11,11,NULL,11,10001,'1111','','','售价表','0',''),('231','','换档机构','宝马','123','只','代办费','二号厂','良','湖南','12','21','','21','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1002,'1111','','','','0',''),('3','一号门店','风扇电机','宝马','一号发动机','个','代办费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10009,'1111','','','','0',''),('4','一号门店','空气滤清器','宝马','二号发动机','个','燃油费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10004,'1111','','','','0',''),('5','二号门店','防撞胶条','宝马','二号发动机','个','燃油费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10002,'1111','','','','0',''),('6','二号门店','空调管\\细','宝骏','二号发动机','个','燃油费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10010,'1111','','','','0',''),('7','二号门店','防冻液','宝骏','二号发动机','个','燃油费','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10011,'1111','','','','0',''),('8','一号门店','一号商品','宝骏','二号发动机','个','其他','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10011,'1111','','','','1','');

/*Table structure for table `mlicompany` */

DROP TABLE IF EXISTS `mlicompany`;

CREATE TABLE `mlicompany` (
  `mlicompanyid` int(11) NOT NULL COMMENT '交强险保险公司id',
  `mlicompany` varchar(50) DEFAULT NULL COMMENT '交强险保险公司',
  PRIMARY KEY (`mlicompanyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交强险保险公司表';

/*Data for the table `mlicompany` */

/*Table structure for table `motor` */

DROP TABLE IF EXISTS `motor`;

CREATE TABLE `motor` (
  `mo_id` int(11) NOT NULL COMMENT '发动机编号',
  `mo_name` varchar(20) DEFAULT NULL COMMENT '发动机名称',
  `e_id` int(11) DEFAULT NULL COMMENT '发动机品牌编号	Engine表--e_id列',
  PRIMARY KEY (`mo_id`),
  KEY `e_id` (`e_id`),
  CONSTRAINT `motor_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `engine` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发动机表';

/*Data for the table `motor` */

insert  into `motor`(`mo_id`,`mo_name`,`e_id`) values (1,'柴胡发动机',1);

/*Table structure for table `nation` */

DROP TABLE IF EXISTS `nation`;

CREATE TABLE `nation` (
  `nationid` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) DEFAULT NULL COMMENT '民族',
  PRIMARY KEY (`nationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='民族表';

/*Data for the table `nation` */

insert  into `nation`(`nationid`,`name`) values (1,'汉族'),(2,'土族'),(3,'满族'),(4,'回族');

/*Table structure for table `nativ_place` */

DROP TABLE IF EXISTS `nativ_place`;

CREATE TABLE `nativ_place` (
  `jnativplaceid` int(11) NOT NULL COMMENT '序号',
  `jname` varchar(50) NOT NULL COMMENT '籍贯',
  PRIMARY KEY (`jnativplaceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='籍贯表';

/*Data for the table `nativ_place` */

insert  into `nativ_place`(`jnativplaceid`,`jname`) values (1,'湖南'),(2,'北京'),(3,'河南');

/*Table structure for table `oiltype` */

DROP TABLE IF EXISTS `oiltype`;

CREATE TABLE `oiltype` (
  `oiltypeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '燃油类别id',
  `oiltype` varchar(50) DEFAULT NULL COMMENT '燃油类别',
  PRIMARY KEY (`oiltypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='燃油表';

/*Data for the table `oiltype` */

/*Table structure for table `organization` */

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `organizationid` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) NOT NULL COMMENT '编制',
  PRIMARY KEY (`organizationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编制表';

/*Data for the table `organization` */

insert  into `organization`(`organizationid`,`name`) values (1,'无编制'),(2,'有编制');

/*Table structure for table `organization_surface` */

DROP TABLE IF EXISTS `organization_surface`;

CREATE TABLE `organization_surface` (
  `zid` int(11) NOT NULL COMMENT '机构id',
  `zname` varchar(50) DEFAULT NULL COMMENT '机构姓名',
  `msname` varchar(50) DEFAULT NULL COMMENT '上级门店',
  `mshou` varchar(50) DEFAULT NULL COMMENT '售价权重',
  `mdianid` int(11) DEFAULT NULL COMMENT '门店分类id',
  `mzuishu` varchar(50) DEFAULT NULL COMMENT '最大许可数',
  `mtiao` varchar(50) DEFAULT NULL COMMENT '调拨价类',
  `mcityid` int(11) DEFAULT NULL COMMENT '城市id',
  `mkai` varchar(50) DEFAULT NULL COMMENT '开票单位',
  `maddress` varchar(50) DEFAULT NULL COMMENT '地址',
  `mshui` varchar(50) DEFAULT NULL COMMENT '纳税人识别号',
  `mphone` varchar(50) DEFAULT NULL COMMENT '电话',
  `mlname` varchar(50) DEFAULT NULL COMMENT '联系人',
  `mhang` int(11) DEFAULT NULL COMMENT '开户银行',
  `mzhang` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `mgouid` int(11) DEFAULT NULL COMMENT '横装门店id',
  `mru` varchar(50) DEFAULT NULL COMMENT '入户开单/审核分开',
  `mting` varchar(50) DEFAULT NULL COMMENT '停用',
  `zids` int(11) DEFAULT NULL COMMENT '机构id外键',
  `zyid` int(11) DEFAULT NULL COMMENT '员工表id外键',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`zid`),
  KEY `mdianid` (`mdianid`),
  KEY `mcityid` (`mcityid`),
  KEY `zyid` (`zyid`),
  CONSTRAINT `organization_surface_ibfk_1` FOREIGN KEY (`mdianid`) REFERENCES `store_classificarion` (`mlid`),
  CONSTRAINT `organization_surface_ibfk_2` FOREIGN KEY (`mcityid`) REFERENCES `city` (`qcityid`),
  CONSTRAINT `organization_surface_ibfk_3` FOREIGN KEY (`zyid`) REFERENCES `staff_data` (`yid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构定义表';

/*Data for the table `organization_surface` */

insert  into `organization_surface`(`zid`,`zname`,`msname`,`mshou`,`mdianid`,`mzuishu`,`mtiao`,`mcityid`,`mkai`,`maddress`,`mshui`,`mphone`,`mlname`,`mhang`,`mzhang`,`mgouid`,`mru`,`mting`,`zids`,`zyid`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values (1,'株洲市汽修','a','100',1,'10000','20',5,'毛主席','北京天安门','1433223','13117334216','九某',1,'iogei',1,'没开','否',0,NULL,'1','1','1','1','1'),(2,'总厂','株洲市汽修','100',1,'10000','20',5,'毛主席','北京天安门','1433223','13117334216','九某',1,'iogei',1,'没开','否',1,NULL,'1','1','1','1','1'),(3,'副厂','株洲市汽修',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,'1',NULL,NULL,NULL,NULL),(4,'机电组','总厂','1111',NULL,'','',NULL,'','','','','',NULL,'',NULL,'','',2,NULL,'1','技术部','二部','',''),(5,'维修组','副厂',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,'1','维修部','二部',NULL,NULL),(6,'人事部','总厂',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,'1','人事部','一部',NULL,NULL),(7,'市场部','副厂',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,'1','市场部','一部',NULL,NULL);

/*Table structure for table `pattern` */

DROP TABLE IF EXISTS `pattern`;

CREATE TABLE `pattern` (
  `pa_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '发动机品牌编号',
  `pa_coder` varchar(20) DEFAULT NULL COMMENT '发动机品牌编码',
  `pa_name` varchar(20) DEFAULT NULL COMMENT '发动机品牌名称',
  PRIMARY KEY (`pa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='支付方式表';

/*Data for the table `pattern` */

insert  into `pattern`(`pa_id`,`pa_coder`,`pa_name`) values (1,'22','格力');

/*Table structure for table `platenumber` */

DROP TABLE IF EXISTS `platenumber`;

CREATE TABLE `platenumber` (
  `plateid` int(11) NOT NULL COMMENT '车牌id',
  `platename` varchar(50) DEFAULT NULL COMMENT '车牌名',
  PRIMARY KEY (`plateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车牌表';

/*Data for the table `platenumber` */

insert  into `platenumber`(`plateid`,`platename`) values (1,'京8888'),(2,'猪9999'),(3,'京b555'),(4,'藏');

/*Table structure for table `post_list` */

DROP TABLE IF EXISTS `post_list`;

CREATE TABLE `post_list` (
  `gid` int(11) NOT NULL COMMENT '岗位编码',
  `gname` varchar(100) DEFAULT NULL COMMENT '岗位名称',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位表';

/*Data for the table `post_list` */

insert  into `post_list`(`gid`,`gname`) values (11,'总经理'),(12,'副经理'),(13,'人事经理'),(14,'财务经理'),(15,'小秘'),(16,'市场部经理'),(17,'销售部经理'),(18,'产品部经理'),(19,'技术部经理');

/*Table structure for table `privilege_role` */

DROP TABLE IF EXISTS `privilege_role`;

CREATE TABLE `privilege_role` (
  `pid` int(11) NOT NULL COMMENT '权限表id，外键',
  `rid` int(11) NOT NULL COMMENT '角色表id，外键',
  KEY `pid` (`pid`),
  KEY `rid` (`rid`),
  CONSTRAINT `privilege_role_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `dzw_privilege` (`pvgid`),
  CONSTRAINT `privilege_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `dzw_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限与角色中间表';

/*Data for the table `privilege_role` */

insert  into `privilege_role`(`pid`,`rid`) values (38,3),(24,3),(10,3),(4,3),(38,2),(24,2),(10,2),(4,2),(22,4),(24,4),(36,4),(38,4),(39,4),(40,4),(41,4),(42,4),(43,4),(48,4),(49,4),(50,4),(65,4),(66,4),(67,4),(68,4),(69,4),(70,4),(71,4),(72,4),(10,4),(4,4),(25,4),(1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(38,1),(39,1),(40,1),(41,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(57,1),(58,1),(59,1),(60,1),(61,1),(62,1),(63,1),(64,1),(65,1),(66,1),(67,1),(68,1),(69,1),(70,1),(71,1),(72,1),(73,1),(74,1),(75,1),(76,1),(77,1),(78,1),(79,1),(80,1),(81,1),(82,1),(83,1),(84,1),(85,1),(86,1),(87,1),(88,1),(89,1),(90,1),(91,1),(92,1),(93,1),(94,1),(95,1),(96,1),(97,1),(98,1),(99,1),(100,1),(101,1),(102,1),(103,1),(104,1),(105,1),(106,1),(107,1),(108,1),(110,1),(111,1),(112,1),(113,1),(114,1),(115,1),(116,1),(117,1),(118,1),(119,1),(120,1),(121,1),(122,1),(123,1),(124,1),(125,1),(126,1),(15,5),(126,5),(7,5),(1,5);

/*Table structure for table `professional_qualification` */

DROP TABLE IF EXISTS `professional_qualification`;

CREATE TABLE `professional_qualification` (
  `specialtynid` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) NOT NULL COMMENT '专业',
  PRIMARY KEY (`specialtynid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业资格表';

/*Data for the table `professional_qualification` */

insert  into `professional_qualification`(`specialtynid`,`name`) values (1,'金融'),(2,'历史'),(3,'国学'),(4,'会计');

/*Table structure for table `quit_reason_surface` */

DROP TABLE IF EXISTS `quit_reason_surface`;

CREATE TABLE `quit_reason_surface` (
  `ytime` varchar(50) NOT NULL COMMENT '离职日期',
  `yreason` varchar(50) NOT NULL COMMENT '离职原因',
  `yid` int(11) NOT NULL COMMENT '员工编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='离职原因表';

/*Data for the table `quit_reason_surface` */

/*Table structure for table `rating` */

DROP TABLE IF EXISTS `rating`;

CREATE TABLE `rating` (
  `ra_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品等级编号',
  `ra_coder` varchar(20) DEFAULT NULL COMMENT '商品等级编码',
  `ra_name` varchar(20) DEFAULT NULL COMMENT '商品等级',
  PRIMARY KEY (`ra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品等级';

/*Data for the table `rating` */

/*Table structure for table `relevance` */

DROP TABLE IF EXISTS `relevance`;

CREATE TABLE `relevance` (
  `correlationid` int(11) NOT NULL COMMENT '主键',
  `customernum` varchar(50) NOT NULL COMMENT '客户编码',
  `qcityid` int(11) NOT NULL COMMENT '区id',
  PRIMARY KEY (`correlationid`),
  KEY `qcityid` (`qcityid`),
  CONSTRAINT `relevance_ibfk_1` FOREIGN KEY (`qcityid`) REFERENCES `city` (`qcityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省市区和用户表';

/*Data for the table `relevance` */

/*Table structure for table `repair_bill` */

DROP TABLE IF EXISTS `repair_bill`;

CREATE TABLE `repair_bill` (
  `no` varchar(50) NOT NULL COMMENT '销售单号',
  `documents_type` int(11) NOT NULL COMMENT '单据类型表外键id',
  `balance_type` int(11) DEFAULT NULL COMMENT '结算方式表外键id',
  `documents_state` int(11) DEFAULT NULL COMMENT '单据状态表外键id',
  `balance_state` int(11) NOT NULL COMMENT '结算状态表外键id',
  `jiesuan_time` datetime DEFAULT NULL COMMENT '结算时间',
  `jiesuan_ren` varchar(50) DEFAULT NULL COMMENT '结算人',
  `amount` double DEFAULT NULL COMMENT '结算金额',
  `yewulx` varchar(50) DEFAULT NULL COMMENT '业务类型',
  `keihu_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `chepai_no` int(50) DEFAULT NULL COMMENT '车牌号',
  `chexin` varchar(50) DEFAULT NULL COMMENT '车型',
  `chejiao_no` varchar(50) DEFAULT NULL COMMENT '车架号',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `bx_company` varchar(50) DEFAULT NULL COMMENT '保险公司',
  `pk_company` varchar(50) DEFAULT NULL COMMENT '赔款公司',
  `duifanchepai` varchar(50) DEFAULT NULL COMMENT '对方车牌',
  `counsellor` int(11) DEFAULT NULL COMMENT '服务顾问，外键顾问表id',
  `completion_time` datetime DEFAULT NULL COMMENT '完工时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `motor_id` int(11) DEFAULT NULL COMMENT '发动机号，发动机表外键id',
  `customer_id` int(11) DEFAULT NULL COMMENT '车主id,客户表外键',
  `jiashiyuan` varchar(50) DEFAULT NULL COMMENT '驾驶员',
  `jclichen` varchar(50) DEFAULT NULL COMMENT '进场里程',
  `jcyoulian` varchar(50) DEFAULT NULL COMMENT '进场油量',
  `shancilichen` varchar(50) DEFAULT NULL COMMENT '上次里程',
  `jctime` datetime DEFAULT NULL COMMENT '进场时间',
  `shigonbanci` varchar(50) DEFAULT NULL COMMENT '施工班次',
  `jiecher` varchar(50) DEFAULT NULL COMMENT '接车人',
  `yujitime` datetime DEFAULT NULL COMMENT '预计完工',
  `sctime` datetime DEFAULT NULL COMMENT '上次进场时间',
  `yugujine` double DEFAULT NULL COMMENT '预估金额',
  `chenshu` varchar(50) DEFAULT NULL COMMENT '保修陈述',
  `reserved1` int(50) DEFAULT NULL COMMENT '外键，厂表',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '开单日期',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '误工原因',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '责任人',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '处罚金额',
  PRIMARY KEY (`no`),
  KEY `documents_type` (`documents_type`),
  KEY `balance_type` (`balance_type`),
  KEY `documents_state` (`documents_state`),
  KEY `balance_state` (`balance_state`),
  KEY `chepai_no` (`chepai_no`),
  KEY `counsellor` (`counsellor`),
  KEY `motor_id` (`motor_id`),
  KEY `customer_id` (`customer_id`),
  KEY `reserved1` (`reserved1`),
  CONSTRAINT `repair_bill_ibfk_1` FOREIGN KEY (`documents_type`) REFERENCES `billstype` (`id`),
  CONSTRAINT `repair_bill_ibfk_2` FOREIGN KEY (`balance_type`) REFERENCES `clearing_form` (`id`),
  CONSTRAINT `repair_bill_ibfk_3` FOREIGN KEY (`documents_state`) REFERENCES `settlement_status` (`id`),
  CONSTRAINT `repair_bill_ibfk_4` FOREIGN KEY (`balance_state`) REFERENCES `document_status` (`id`),
  CONSTRAINT `repair_bill_ibfk_5` FOREIGN KEY (`chepai_no`) REFERENCES `platenumber` (`plateid`),
  CONSTRAINT `repair_bill_ibfk_6` FOREIGN KEY (`counsellor`) REFERENCES `counselor` (`counselorid`),
  CONSTRAINT `repair_bill_ibfk_7` FOREIGN KEY (`motor_id`) REFERENCES `motor` (`mo_id`),
  CONSTRAINT `repair_bill_ibfk_8` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customertypeid`),
  CONSTRAINT `repair_bill_ibfk_9` FOREIGN KEY (`reserved1`) REFERENCES `factory` (`factory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修单据表';

/*Data for the table `repair_bill` */

insert  into `repair_bill`(`no`,`documents_type`,`balance_type`,`documents_state`,`balance_state`,`jiesuan_time`,`jiesuan_ren`,`amount`,`yewulx`,`keihu_name`,`chepai_no`,`chexin`,`chejiao_no`,`phone`,`bx_company`,`pk_company`,`duifanchepai`,`counsellor`,`completion_time`,`remark`,`motor_id`,`customer_id`,`jiashiyuan`,`jclichen`,`jcyoulian`,`shancilichen`,`jctime`,`shigonbanci`,`jiecher`,`yujitime`,`sctime`,`yugujine`,`chenshu`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values ('jingnosty0554',1,1,1,1,'2021-02-22 10:00:10','赵信',100,'中国重汽','刘朝阳',1,'QQ汽车','dsnh-iyo022','15678789966','华中金融有限公司','花落jjj公司','京Q8888',1,'2021-03-02 15:12:38','无',1,1,'韩寒','23','32','20','2021-03-04 08:12:38','技工1班','刘欢腾','2021-03-04 08:12:50','2021-03-04 08:13:07',300,'无',2,'2021-3-2','',NULL,NULL),('jingnosty0555',1,3,2,1,'2021-02-23 09:57:21','单观',0,'美国重汽','落霞',2,'九手奥拓','dsnh-iyo022','12312311231','华中金融有限公司','花落jjj公司','京Q8888',1,'2021-03-02 15:12:36','无',1,1,'天机看','32','10','30','2021-03-04 08:12:41','技工1班','李大辉','2021-03-04 08:13:04','2021-03-04 08:13:09',600,'无',2,'2021-3-2','',NULL,NULL),('jingnosty0556',2,3,2,2,'2021-03-03 14:32:51','赵信',0,'美国重汽','卢欧杰',2,'路虎s1','oioi-015','15322468877','天地保险有限公司','花落jjj公司','京Q8888',1,'2021-03-05 14:33:32','无',1,1,'德莱文','晚上','晚上','晚上','2021-03-03 14:34:13','技工2班','曾高达','2021-03-03 14:34:24','2021-03-06 14:34:26',800,'无',1,'2012-08-09','','',''),('jingnosty0557',2,3,2,2,'2021-03-12 14:28:25','李玉兰',0,'中国重汽','韩寒',1,'大众','kk09-6','13117334456','天地保险有限公司','花落jjj公司','京Q8888',1,'2021-03-14 14:29:06','无',1,1,'德莱厄斯','白天','白天','白天','2021-03-10 14:29:40','技工3班','谭罗华','2021-03-05 14:30:21','2021-02-13 14:30:37',300,'无',1,'2010-02-04','员工出车祸了','刘全','500');

/*Table structure for table `role_user` */

DROP TABLE IF EXISTS `role_user`;

CREATE TABLE `role_user` (
  `rid` int(11) NOT NULL COMMENT '角色表id，外键',
  `uid` int(11) NOT NULL COMMENT '用户表id，外键',
  KEY `rid` (`rid`),
  KEY `uid` (`uid`),
  CONSTRAINT `role_user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `dzw_role` (`role_id`),
  CONSTRAINT `role_user_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `dzw_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与用户中间表';

/*Data for the table `role_user` */

insert  into `role_user`(`rid`,`uid`) values (1,1),(5,2);

/*Table structure for table `service` */

DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `ser_id` int(11) NOT NULL COMMENT '维修项目编号',
  `ser_name` varchar(20) DEFAULT NULL COMMENT '维修项目名称',
  `ser_parent` int(11) DEFAULT NULL COMMENT '父级项目编号',
  `ser_img` varchar(50) DEFAULT NULL COMMENT '维修项目图片',
  `ser_tag` varchar(20) DEFAULT NULL COMMENT '维修标识',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`ser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修项目菜单';

/*Data for the table `service` */

insert  into `service`(`ser_id`,`ser_name`,`ser_parent`,`ser_img`,`ser_tag`,`reserved1`,`reserved2`,`reserved3`) values (1,'总',0,NULL,NULL,NULL,NULL,NULL),(100,'车型',1,NULL,NULL,NULL,NULL,NULL),(101,'发动机',1,'','','','',''),(102,'钣喷1',1,'','','','',''),(1001,'中国重汽1',100,NULL,NULL,NULL,NULL,NULL),(1002,'陕汽重卡',100,NULL,NULL,NULL,NULL,NULL),(1003,'中国红旗',100,NULL,NULL,NULL,NULL,NULL),(1004,'一号发动机1',101,NULL,NULL,NULL,NULL,NULL),(1005,'二号发动机',101,NULL,NULL,NULL,NULL,NULL),(1006,'三号发动机',101,NULL,NULL,NULL,NULL,NULL),(1007,'轻度1',102,'','','','',''),(1008,'中度12',102,'','','','',''),(1009,'重度',102,'','','','','');

/*Table structure for table `settlement_status` */

DROP TABLE IF EXISTS `settlement_status`;

CREATE TABLE `settlement_status` (
  `id` int(11) NOT NULL COMMENT '唯一编号',
  `type` varchar(50) DEFAULT NULL COMMENT '状态名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算状态表';

/*Data for the table `settlement_status` */

insert  into `settlement_status`(`id`,`type`) values (1,'已结算'),(2,'未结算');

/*Table structure for table `sgbc` */

DROP TABLE IF EXISTS `sgbc`;

CREATE TABLE `sgbc` (
  `xuhid` int(11) NOT NULL COMMENT '班次序号',
  `banc` varchar(50) DEFAULT NULL COMMENT '施工班次',
  PRIMARY KEY (`xuhid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='施工班次';

/*Data for the table `sgbc` */

insert  into `sgbc`(`xuhid`,`banc`) values (1,'白天'),(2,'晚上');

/*Table structure for table `staff_data` */

DROP TABLE IF EXISTS `staff_data`;

CREATE TABLE `staff_data` (
  `yid` int(11) NOT NULL COMMENT '员工编号',
  `yname` varchar(50) DEFAULT NULL COMMENT '员工姓名',
  `ysex` varchar(10) DEFAULT NULL COMMENT '员工性别',
  `yposition` varchar(20) DEFAULT NULL COMMENT '员工职位',
  `yhealth` varchar(20) DEFAULT NULL COMMENT '身体状况',
  `yloginemp` varchar(10) DEFAULT NULL COMMENT '登录账号',
  `yheigth` int(11) DEFAULT NULL COMMENT '身高',
  `ynativplaceid` int(11) DEFAULT NULL COMMENT '籍贯id',
  `ynationid` int(11) DEFAULT NULL COMMENT '民族id',
  `ymarriageid` int(11) DEFAULT NULL COMMENT '婚姻状况id',
  `yeducationid` int(11) DEFAULT NULL COMMENT '学历id',
  `yschoolid` int(11) DEFAULT NULL COMMENT '毕业学校id',
  `yspecialtyid` int(11) DEFAULT NULL COMMENT '专业id',
  `yspecialtynid` int(11) DEFAULT NULL COMMENT '专业资格id',
  `yattribute` varchar(100) DEFAULT NULL COMMENT '属性',
  `ycollegeid` int(11) DEFAULT NULL COMMENT '学位id',
  `yorganizationid` int(11) DEFAULT NULL COMMENT '编制id',
  `ynumber` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `yaddressh` varchar(50) DEFAULT NULL COMMENT '户口地址',
  `yaddressx` varchar(50) DEFAULT NULL COMMENT '现住地址',
  `yphonenumber` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `yphone` varchar(50) DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT 'Email',
  `ybankid` int(11) DEFAULT NULL COMMENT '开户银行id',
  `ybankphone` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `yjname` varchar(50) DEFAULT NULL COMMENT '紧急联系人',
  `yjphone` varchar(50) DEFAULT NULL COMMENT '紧急联系电话',
  `ystarttime` varchar(50) DEFAULT NULL COMMENT '入职日期',
  `yendtime` varchar(50) DEFAULT NULL COMMENT '试用到期',
  `ydatetime` varchar(50) DEFAULT NULL COMMENT '出生日期',
  `ystarttimeh` varchar(50) DEFAULT NULL COMMENT '合同开始',
  `yendtimeh` varchar(50) DEFAULT NULL COMMENT '合同结束',
  `ytname` varchar(50) DEFAULT NULL COMMENT '推荐人',
  `yratez` float DEFAULT NULL COMMENT '整单折扣权',
  `yrateg` float DEFAULT NULL COMMENT '工时折扣权',
  `yrates` float DEFAULT NULL COMMENT '商品折扣权',
  `yratej` float DEFAULT NULL COMMENT '减免权',
  `ygong` float DEFAULT NULL COMMENT '工作简历',
  `yjiao` float DEFAULT NULL COMMENT '教育经历',
  `yhome` varchar(50) DEFAULT NULL COMMENT '教育经历',
  `yjiang` varchar(50) DEFAULT NULL COMMENT '奖惩记录',
  `yping` varchar(50) DEFAULT NULL COMMENT '聘用记录',
  `gid` int(11) DEFAULT NULL COMMENT '岗位编码',
  `bid` int(11) DEFAULT NULL COMMENT '部门',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved6` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved7` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved8` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved9` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`yid`),
  KEY `ynativplaceid` (`ynativplaceid`),
  KEY `ynationid` (`ynationid`),
  KEY `ymarriageid` (`ymarriageid`),
  KEY `yeducationid` (`yeducationid`),
  KEY `yschoolid` (`yschoolid`),
  KEY `yspecialtyid` (`yspecialtyid`),
  KEY `ycollegeid` (`ycollegeid`),
  KEY `yorganizationid` (`yorganizationid`),
  KEY `ybankid` (`ybankid`),
  KEY `gid` (`gid`),
  KEY `bid` (`bid`),
  CONSTRAINT `staff_data_ibfk_1` FOREIGN KEY (`ynativplaceid`) REFERENCES `nativ_place` (`jnativplaceid`),
  CONSTRAINT `staff_data_ibfk_10` FOREIGN KEY (`gid`) REFERENCES `post_list` (`gid`),
  CONSTRAINT `staff_data_ibfk_11` FOREIGN KEY (`bid`) REFERENCES `deparment_surface` (`bid`),
  CONSTRAINT `staff_data_ibfk_2` FOREIGN KEY (`ynationid`) REFERENCES `nation` (`nationid`),
  CONSTRAINT `staff_data_ibfk_3` FOREIGN KEY (`ymarriageid`) REFERENCES `marital_status` (`marriageid`),
  CONSTRAINT `staff_data_ibfk_4` FOREIGN KEY (`yeducationid`) REFERENCES `education` (`educationid`),
  CONSTRAINT `staff_data_ibfk_5` FOREIGN KEY (`yschoolid`) REFERENCES `graduate_school` (`schoolid`),
  CONSTRAINT `staff_data_ibfk_6` FOREIGN KEY (`yspecialtyid`) REFERENCES `professional_qualification` (`specialtynid`),
  CONSTRAINT `staff_data_ibfk_7` FOREIGN KEY (`ycollegeid`) REFERENCES `academic_degree` (`collegeid`),
  CONSTRAINT `staff_data_ibfk_8` FOREIGN KEY (`yorganizationid`) REFERENCES `organization` (`organizationid`),
  CONSTRAINT `staff_data_ibfk_9` FOREIGN KEY (`ybankid`) REFERENCES `bank` (`bankid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工资料表';

/*Data for the table `staff_data` */

insert  into `staff_data`(`yid`,`yname`,`ysex`,`yposition`,`yhealth`,`yloginemp`,`yheigth`,`ynativplaceid`,`ynationid`,`ymarriageid`,`yeducationid`,`yschoolid`,`yspecialtyid`,`yspecialtynid`,`yattribute`,`ycollegeid`,`yorganizationid`,`ynumber`,`yaddressh`,`yaddressx`,`yphonenumber`,`yphone`,`email`,`ybankid`,`ybankphone`,`yjname`,`yjphone`,`ystarttime`,`yendtime`,`ydatetime`,`ystarttimeh`,`yendtimeh`,`ytname`,`yratez`,`yrateg`,`yrates`,`yratej`,`ygong`,`yjiao`,`yhome`,`yjiang`,`yping`,`gid`,`bid`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`,`reserved6`,`reserved7`,`reserved8`,`reserved9`) values (1,'刘某某','男','秘书','良好','admin1',175,1,1,2,1,5,1,1,'1',1,1,'5252516516526265','湖南省','株洲市','13117334216','5433125','5433125',1,'admin5','没有','13117334217','2019-05-06','2020-05-06','2020-05-06','刘某某','1','1',1,1,1,1,1,1,'没有','没有','没有',11,2,'2064239692@qq.com','有','1','市场部','4','1','2020-12-12','2020-12-12','一部'),(2,'张某某','男','总经理','良好','admin1',175,1,2,2,1,5,3,1,'有',1,2,'5252516516526265','湖南省','株洲市','13117334216','5433125','5433125',3,'admin1','没有','13117334217','2019-05-06','2020-05-06','2020-05-06','刘某某','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9年','没有','没有',11,1,'1651515615@qq.com','有','2','市场部','5','1','','','一部'),(3,'李某某','女','人事经理','优秀','admin3',165,1,1,1,1,1,1,1,'有',1,1,'534345633434534','湖南省','浏阳市','13117334214','5433125','5433125',1,'admin3','没有','13117334217','2019-05-06','2020-05-06','2020-05-06','刘某某','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'7年','没有','没有',15,3,'2641245438@qq.com','有','1','技术部','6','1','2020-12-12','2020-12-12','二部'),(4,'王某某','女','财务经理','优秀','admin4',165,1,1,1,1,1,1,1,'有',1,1,'287258728772872','河南省','株洲市','13117334213','5433125','5433125',2,'admin4','没有','13117334217','2019-05-06','2020-05-06','2020-05-06','刘某某','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'6年','没有','没有',13,4,'1798928221@qq.com','有','2','维修部','7','1','2020-12-12','2020-12-12','二部');

/*Table structure for table `store_classificarion` */

DROP TABLE IF EXISTS `store_classificarion`;

CREATE TABLE `store_classificarion` (
  `mlid` int(11) NOT NULL COMMENT '序号id',
  `mlname` varchar(50) NOT NULL COMMENT '门店分类姓名',
  PRIMARY KEY (`mlid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店分类表';

/*Data for the table `store_classificarion` */

insert  into `store_classificarion`(`mlid`,`mlname`) values (1,'终极门店'),(2,'高级门店'),(3,'中级门店'),(4,'低级门店');

/*Table structure for table `suppiler` */

DROP TABLE IF EXISTS `suppiler`;

CREATE TABLE `suppiler` (
  `p_id` varchar(30) NOT NULL COMMENT '供货商编号',
  `p_name` varchar(20) DEFAULT NULL COMMENT '供货商名称',
  `p_address` varchar(50) DEFAULT NULL COMMENT '供货商地址',
  `p_case` varchar(20) DEFAULT NULL COMMENT '经营情况',
  `p_url` varchar(20) DEFAULT NULL COMMENT '网址',
  `p_bank` int(11) DEFAULT NULL COMMENT '开户行',
  `p_bankaccount` varchar(20) DEFAULT NULL COMMENT '银行账号',
  `pa_id` int(11) DEFAULT NULL COMMENT '付款方式',
  `ra_id` int(20) DEFAULT NULL COMMENT '厂商等级',
  `p_brand` varchar(20) DEFAULT NULL COMMENT '经营品牌',
  `p_linkman` varchar(20) DEFAULT NULL COMMENT '联系人',
  `p_phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `p_mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `p_email` varchar(20) DEFAULT NULL COMMENT 'Email',
  `p_days` varchar(20) DEFAULT NULL COMMENT '账期',
  `p_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `sid` int(11) DEFAULT NULL COMMENT '供货商菜单编号	Suppiler表--p_id列',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`p_id`),
  KEY `pa_id` (`pa_id`),
  KEY `ra_id` (`ra_id`),
  KEY `sid` (`sid`),
  CONSTRAINT `suppiler_ibfk_1` FOREIGN KEY (`pa_id`) REFERENCES `pattern` (`pa_id`),
  CONSTRAINT `suppiler_ibfk_2` FOREIGN KEY (`ra_id`) REFERENCES `rating` (`ra_id`),
  CONSTRAINT `suppiler_ibfk_3` FOREIGN KEY (`sid`) REFERENCES `suppilermenu` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供货商';

/*Data for the table `suppiler` */

insert  into `suppiler`(`p_id`,`p_name`,`p_address`,`p_case`,`p_url`,`p_bank`,`p_bankaccount`,`pa_id`,`ra_id`,`p_brand`,`p_linkman`,`p_phone`,`p_mobile`,`p_email`,`p_days`,`p_remark`,`sid`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values ('1','河南众鑫汽车服务有限公司','湖南省株洲市','月入--10万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','张三','123124214','12432423','565546656@qq.com','1231','无',10001,'按月结算','A','0','',''),('10','优汽在线','广东省佛山市','月入--10万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','2342523','12432423','565546656@qq.com','34','无',10007,'分期付款','B','0','',''),('11','优汽开封站','湖南省株洲市','月入--10万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','423523432','234234','565546656@qq.com','235','无',10008,'按月结算','A','0','',''),('1111','郑州欧意商贸有限公司','湖南省长沙市','月入--200万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','35235235','12432423','565546656@qq.com','234','无',10006,'按月结算','A','0','',''),('12','顺丰物流','湖南省株洲市','月入--200万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','3523523','232342','565546656@qq.com','2352','无',10008,'货到付款','B','0','',''),('123','曾练军无限公司','九郎山家园','月入--200万','123',123,'213',NULL,NULL,'123','123','12','123','12','112','123',1004,'按月结算','A','0','',''),('12343','石峰区厂王曾练军无限公司','荷塘区','月入--200万','222.com',4556,'56565',NULL,NULL,'非常耗的品牌','曾子','3112','1212','3112','13','1313',10004,'货到付款','B','0','',''),('13','石峰区北大青鸟无限公司','广东省佛山市','月入--200万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','2352352352','234234','565546656@qq.com','42352','无',10008,'货到付款','B','0','',''),('1332','建坤养殖场','湖南省株洲市','月入--11000万','www.baidu.com',11111,'1212112',NULL,NULL,'杜蕾斯','刘全','1658554','1755652','232656@qq.com','20','没有备注',10003,'货到付款','B','0','',''),('14','曾练军养殖场','广东省佛山市','月入--11000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','23235235','12432423','565546656@qq.com','423','无',10006,'货到付款','B','0','',''),('15','曾练军养猪场无限公司','广东省佛山市','月入--11000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','23523523','12432423','565546656@qq.com','523','无',1001,'货到付款','C','0','',''),('16','上海天维有限公司','广东省佛山市','月入--11000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','23523523','12432423','565546656@qq.com','4','无',10002,'货到付款','B','0','',''),('17','兴科有限公司','湖南省株洲市','月入--1000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','2352352523','12432423','565546656@qq.com','25','无',10005,'分期付款','B','0','',''),('18','沛权有限公司','广东省佛山市','月入--1000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','235','323423','565546656@qq.com','32','无',1003,'分期付款','B','0','',''),('19','蓝受有限公司','广东省佛山市','月入--1000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','3523523','23423423','5655461656@qq.com','5234','无',1000,'货到付款','C','0','',''),('2','绿瘦有限公司','湖南省株洲市','月入--1000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','张三','123123412','234234','565546656@qq.com','1321','无',10005,'按月结算','A','0','',''),('20','普鲁士有限公司','湖南省株洲市','月入--1000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','5235','12432423','565546656@qq.com','2352','无',10007,'分期付款','B','0','',''),('21','阿萨大有限公司','广东省佛山市','月入--1000万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','235235','12432423','565546656@qq.com','34235','无',10008,'货到付款','B','0',NULL,NULL),('22','迫使有限公司','湖南省株洲市','月入--500万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','23523','12432423','565546656@qq.com','234','无',10005,'按月结算','A','0','',''),('23','破裂有限公司','湖南省株洲市','月入--500万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','2352','12432423','565546656@qq.com','235','无',1001,'分期付款','B','0',NULL,NULL),('24','较的有限公司','湖南省株洲市','月入--500万','5565.com',12321232,'1323213',NULL,NULL,'撒旦','刘全二号','232323','132323','232332','32','232322',10001,'按月结算','B','0',NULL,NULL),('25','圣诞信息有限公司','温州龙湾区','月入--10万','565.com',2332,'23265',NULL,NULL,'232','黄鹤','565265','1265','56565','7255','倒闭了',1004,'按月结算','A','0',NULL,NULL),('3','慢慢有限公司','广东省佛山市','月入--500万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','张三','123123123','234234','565546656@qq.com','4325','无',1001,'货到付款','B','0',NULL,NULL),('311','克丝有限公司','12','月入--500万','21',31,'12',NULL,NULL,'12','21','12','12','12','21','12',10004,'分期付款','A','0',NULL,NULL),('3212','欧升有限公司','123','月入--500万','12',23,'23',NULL,NULL,'123','21','3','321','32','213','123',10003,'按月结算','A','0',NULL,NULL),('4','士大有限公司','广东省佛山市','月入--500万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','张三','43242352','324234','565546656@qq.com','5345','无',1001,'货到付款','C','0',NULL,NULL),('5','大飒信息科技有限公司','湖南省株洲市','月入--500万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','张三','3423414235','4234234','565546656@qq.com','234','无',10004,'按月结算','A','0',NULL,NULL),('6','前外科技有限公司','湖南省株洲市','月入--50万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','张三','25234235','12432423','565546656@qq.com','235','无',10007,'按月结算','A','0',NULL,NULL),('7','卡萨丁有限公司','广东省佛山市','月入--50万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','张三','534634523','2342343','565546656@qq.com','32434235','无',10008,'分期付款','B','0',NULL,NULL),('8','泰隆有限公司','湖南省株洲市','月入--50万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','张三','52563423','12432423','565546656@qq.com','2','无',10003,'按月结算','A','0',NULL,NULL),('9','雷恩加尔科技有限公司','广东省佛山市','月入--50万','www.550.com',12343223,'431231316512',NULL,NULL,'品品牌牌','李四','523523','23423423','565546656@qq.com','52','无',1000,'货到付款','C','0',NULL,NULL);

/*Table structure for table `suppilermenu` */

DROP TABLE IF EXISTS `suppilermenu`;

CREATE TABLE `suppilermenu` (
  `s_id` int(11) NOT NULL COMMENT '供货商菜单编号',
  `s_name` varchar(20) DEFAULT NULL COMMENT '供货商菜单名称',
  `s_parent` int(11) DEFAULT NULL COMMENT '父级供货商菜单编号',
  `s_tag` varchar(20) DEFAULT NULL COMMENT '菜单标识',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供货商菜单';

/*Data for the table `suppilermenu` */

insert  into `suppilermenu`(`s_id`,`s_name`,`s_parent`,`s_tag`) values (1,'总',0,NULL),(100,'湖南',1,NULL),(101,'广东',1,NULL),(102,'浙江',1,NULL),(1000,'株洲',100,NULL),(1001,'佛山',101,NULL),(1003,'长沙',100,NULL),(1004,'温州',102,NULL),(10001,'石峰区',1000,NULL),(10002,'顺德区',1001,NULL),(10003,'芦淞区',1000,NULL),(10004,'荷塘区',1000,NULL),(10005,'北滘区',1001,NULL),(10006,'芙蓉区',1003,NULL),(10007,'开福区',1003,NULL),(10008,'岳麓区',1003,NULL);

/*Table structure for table `teamtechnician` */

DROP TABLE IF EXISTS `teamtechnician`;

CREATE TABLE `teamtechnician` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `teamid` int(11) DEFAULT NULL COMMENT '班组编号',
  `technicianid` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '技工编号',
  `technicianidname` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '技工姓名',
  `sex` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机',
  `address` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址',
  `birthday` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '出生日期',
  `headman` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '组长',
  `loginname` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '登录名',
  `idnumber` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证号',
  `residenceaddress` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '户口地址',
  `bankid` int(11) DEFAULT NULL COMMENT '开户银行id',
  `bankaccount` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '银行账号',
  `code` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '等级编号',
  `type` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '维修工种',
  `maintenancetype` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '维修工种',
  `reserved1` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`),
  KEY `bankid` (`bankid`),
  KEY `code` (`code`),
  KEY `teamtechnician_ibfk_1` (`teamid`),
  CONSTRAINT `teamtechnician_ibfk_2` FOREIGN KEY (`bankid`) REFERENCES `bank` (`bankid`),
  CONSTRAINT `teamtechnician_ibfk_3` FOREIGN KEY (`code`) REFERENCES `mechanicstar` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

/*Data for the table `teamtechnician` */

insert  into `teamtechnician`(`id`,`teamid`,`technicianid`,`technicianidname`,`sex`,`phone`,`address`,`birthday`,`headman`,`loginname`,`idnumber`,`residenceaddress`,`bankid`,`bankaccount`,`code`,`type`,`maintenancetype`,`reserved1`,`reserved2`,`reserved3`,`reserved4`,`reserved5`) values (3,1000,'BCX-001','王泽旭','男','16545835761','株洲市石峰区','2002-07-29','是','wzx','42321432543512353','株洲市醴陵县',1,'2134213543534623','xj001','进出厂检验员','不限','123',NULL,NULL,NULL,NULL),(4,1000,'BCX-002','骆华','女','15424561397','株洲市石峰区','1995-04-21','是','lh','4321423523125324','株洲市醴陵县',2,'45322314325424123','xj002','索赔员','不限','123',NULL,NULL,NULL,NULL),(5,1000,'BCX-003','林子豪','男','17543369233','株洲市芦淞区','1998-11-16','否','lzh','42321423523213523432','株洲市攸县',1,'4231243242351235324','xj001','电工','不限','123',NULL,NULL,NULL,NULL),(6,1001,'BCX-004','张毅丰','男','13742464256','株洲市天元区','2003-05-14','否','zyf','4632214325346343213','株洲市株洲县',3,'4213532453451343','xj004','漆工','不限','123',NULL,NULL,NULL,NULL);

/*Table structure for table `upkeep` */

DROP TABLE IF EXISTS `upkeep`;

CREATE TABLE `upkeep` (
  `upkeepid` int(11) NOT NULL AUTO_INCREMENT COMMENT '保养id',
  `carnum` int(11) DEFAULT NULL COMMENT '车辆号码',
  `upkeepname` varchar(50) DEFAULT NULL COMMENT '保养名称',
  `plantime` varchar(50) DEFAULT NULL COMMENT '计划日期',
  `planmileage` varchar(50) DEFAULT NULL COMMENT '计划里程',
  `facttime` varchar(50) DEFAULT NULL COMMENT '实际日期',
  `factmileage` varchar(50) DEFAULT NULL COMMENT '实际里程',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`upkeepid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='保养表';

/*Data for the table `upkeep` */

insert  into `upkeep`(`upkeepid`,`carnum`,`upkeepname`,`plantime`,`planmileage`,`facttime`,`factmileage`,`reserved1`,`reserved2`,`reserved3`) values (1,1,'1','1','1','1','1','1','1','1');

/*Table structure for table `user_company` */

DROP TABLE IF EXISTS `user_company`;

CREATE TABLE `user_company` (
  `did` int(11) NOT NULL COMMENT '用户公司id',
  `dname` varchar(50) NOT NULL COMMENT '单位名称',
  `daddress` varchar(50) DEFAULT NULL COMMENT '单位地址',
  `djian` varchar(50) DEFAULT NULL COMMENT '单位简称',
  `dphoney` varchar(50) DEFAULT NULL COMMENT '业务电话',
  `dphonej` varchar(50) DEFAULT NULL COMMENT '投诉电话',
  `dwaddress` varchar(50) DEFAULT NULL COMMENT '网址',
  `email` varchar(50) DEFAULT NULL COMMENT 'Email',
  `dhang` int(11) DEFAULT NULL COMMENT '开户银行',
  `dhangz` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `dhangd` varchar(50) DEFAULT NULL COMMENT '短信账号',
  `dmi` varchar(50) DEFAULT NULL COMMENT '短信密码',
  `dshangs` varchar(50) DEFAULT NULL COMMENT '商品编号位数',
  `dchu` varchar(50) DEFAULT NULL COMMENT '初始加价率',
  `dslv` varchar(50) DEFAULT NULL COMMENT '商品税率',
  `dxiao` varchar(50) DEFAULT NULL COMMENT '销售金额满',
  `dzhe` varchar(50) DEFAULT NULL COMMENT '折合税分',
  `djifen` varchar(50) DEFAULT NULL COMMENT '积分/元',
  `dwei` varchar(50) DEFAULT NULL COMMENT '维修看板行数',
  `dsan` varchar(50) DEFAULT NULL COMMENT '三包申报超期(天)',
  `dche` varchar(50) DEFAULT NULL COMMENT '车辆年审提醒(天)',
  `dzhang` varchar(50) DEFAULT NULL COMMENT '账号超期提醒(天)',
  `dban` varchar(50) DEFAULT NULL COMMENT '班组备件超期(天)',
  `dpei` varchar(50) DEFAULT NULL COMMENT '配件库超龄提醒(天)',
  `dneiw` varchar(50) DEFAULT NULL COMMENT '站内晚上系数',
  `dwaib` varchar(50) DEFAULT NULL COMMENT '站外白天系数',
  `dwaiw` varchar(50) DEFAULT NULL COMMENT '站外晚上系数',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`did`),
  KEY `dhang` (`dhang`),
  CONSTRAINT `user_company_ibfk_1` FOREIGN KEY (`dhang`) REFERENCES `bank` (`bankid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户公司定义表';

/*Data for the table `user_company` */

/*Table structure for table `vehicle` */

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `vehicleid` int(11) NOT NULL COMMENT '车型id',
  `vehiclename` varchar(50) DEFAULT NULL COMMENT '车型名称',
  `referenceprice` varchar(50) DEFAULT NULL COMMENT '参考价格',
  `caryear` varchar(50) DEFAULT NULL COMMENT '车辆年款',
  `gasd` varchar(50) DEFAULT NULL COMMENT '排气量',
  `iod` varchar(50) DEFAULT NULL COMMENT '进口国产',
  `oilnum` varchar(50) DEFAULT NULL COMMENT '燃油标号',
  `fourtype` varchar(50) DEFAULT NULL COMMENT '四驱类型',
  `carcoding` varchar(50) DEFAULT NULL COMMENT '车辆编码',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`vehicleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外勤车辆表';

/*Data for the table `vehicle` */

/*Table structure for table `waiqin` */

DROP TABLE IF EXISTS `waiqin`;

CREATE TABLE `waiqin` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `chepai` varchar(50) NOT NULL,
  `guzhang` varchar(50) DEFAULT NULL,
  `adname` varchar(50) NOT NULL,
  `cost` float DEFAULT NULL,
  `distance` float DEFAULT NULL,
  `desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`,`phone`,`chepai`,`adname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `waiqin` */

insert  into `waiqin`(`id`,`name`,`phone`,`chepai`,`guzhang`,`adname`,`cost`,`distance`,`desc`) values ('00000','单观柏','13212341234','湘B10000','漏油','石峰区',20,20,'九郎山家园');

/*Table structure for table `weixdan` */

DROP TABLE IF EXISTS `weixdan`;

CREATE TABLE `weixdan` (
  `weixdanh` varchar(50) NOT NULL COMMENT '维修单号',
  `chepaih` varchar(50) DEFAULT NULL COMMENT '车牌号码',
  `chejiahao` varchar(50) DEFAULT NULL COMMENT '车架号',
  `cheliangxh` varchar(50) DEFAULT NULL COMMENT '车辆型号',
  `clpp` varchar(50) DEFAULT NULL COMMENT '车辆品牌',
  `fdjh` varchar(50) DEFAULT NULL COMMENT '发动机号',
  `fdjpp` int(11) DEFAULT NULL COMMENT '发动机品牌',
  `fuwugw` varchar(50) DEFAULT NULL COMMENT '服务顾问',
  `czname` varchar(50) DEFAULT NULL COMMENT '车主姓名',
  `jsy` varchar(50) DEFAULT NULL COMMENT '驾驶员',
  `lxphone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `jclc` varchar(50) DEFAULT NULL COMMENT '进厂里程',
  `jcyl` int(11) DEFAULT NULL COMMENT '进厂油量',
  `sclc` varchar(50) DEFAULT NULL COMMENT '上次里程',
  `jcsj` date DEFAULT NULL COMMENT '进厂时间',
  `ywlb` int(11) DEFAULT NULL COMMENT '业务类别',
  `sgbc` int(11) DEFAULT NULL COMMENT '施工班次',
  `jcr` varchar(50) DEFAULT NULL COMMENT '接车人',
  `yjwg` date DEFAULT NULL COMMENT '预计完工',
  `jiesfs` varchar(50) DEFAULT NULL COMMENT '结算方式',
  `pkgs` varchar(50) DEFAULT NULL COMMENT '赔款公司',
  `wgsj` date DEFAULT NULL COMMENT '完工时间',
  `scjc` date DEFAULT NULL COMMENT '上次进厂',
  `ygje` double DEFAULT NULL COMMENT '预估金额',
  `jdbz` varchar(50) DEFAULT NULL COMMENT '接待备注',
  `cxms` varchar(50) DEFAULT NULL COMMENT '保修陈述',
  PRIMARY KEY (`weixdanh`),
  KEY `fdjpp` (`fdjpp`),
  KEY `ywlb` (`ywlb`),
  KEY `jcyl` (`jcyl`),
  KEY `sgbc` (`sgbc`),
  CONSTRAINT `weixdan_ibfk_1` FOREIGN KEY (`weixdanh`) REFERENCES `maintenance_items` (`wxdh`),
  CONSTRAINT `weixdan_ibfk_2` FOREIGN KEY (`fdjpp`) REFERENCES `pattern` (`pa_id`),
  CONSTRAINT `weixdan_ibfk_3` FOREIGN KEY (`ywlb`) REFERENCES `businessclass` (`businessid`),
  CONSTRAINT `weixdan_ibfk_4` FOREIGN KEY (`jcyl`) REFERENCES `jcyl` (`ylid`),
  CONSTRAINT `weixdan_ibfk_5` FOREIGN KEY (`sgbc`) REFERENCES `sgbc` (`xuhid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `weixdan` */

insert  into `weixdan`(`weixdanh`,`chepaih`,`chejiahao`,`cheliangxh`,`clpp`,`fdjh`,`fdjpp`,`fuwugw`,`czname`,`jsy`,`lxphone`,`jclc`,`jcyl`,`sclc`,`jcsj`,`ywlb`,`sgbc`,`jcr`,`yjwg`,`jiesfs`,`pkgs`,`wgsj`,`scjc`,`ygje`,`jdbz`,`cxms`) values ('1','22','22','22','2','2',1,'成前','2','2','2','2',2,'2','2021-03-11',2,2,'2','2021-03-03','现金','2','2021-03-16','2021-03-14',2,'2','2'),('22145678','3223','551','啊啊啊','宝马','1231',1,'耶鲁','我','搜索','5555','2',1,'是','2021-03-10',1,1,'25','2021-03-10','微信','858','2021-03-24','2021-03-09',5,'5','5');

/*Table structure for table `weixlis` */

DROP TABLE IF EXISTS `weixlis`;

CREATE TABLE `weixlis` (
  `wxdh` varchar(50) NOT NULL COMMENT '维修单号',
  `jcsj` date DEFAULT NULL COMMENT '接车时间',
  `ywlx` int(50) DEFAULT NULL COMMENT '业务类型',
  `wgsj` date DEFAULT NULL COMMENT '完工时间',
  `khname` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `cph` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `shoji` varchar(50) DEFAULT NULL COMMENT '手机',
  `hykh` varchar(50) DEFAULT NULL COMMENT '会员卡号',
  `jsdate` date DEFAULT NULL COMMENT '结算时间',
  `xfje` double DEFAULT NULL COMMENT '消费金额',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`wxdh`),
  KEY `ywlx` (`ywlx`),
  CONSTRAINT `weixlis_ibfk_1` FOREIGN KEY (`ywlx`) REFERENCES `businessclass` (`businessid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修历史';

/*Data for the table `weixlis` */

insert  into `weixlis`(`wxdh`,`jcsj`,`ywlx`,`wgsj`,`khname`,`cph`,`shoji`,`hykh`,`jsdate`,`xfje`,`reserved1`,`reserved2`,`reserved3`) values ('22145678','2021-03-17',1,'2021-03-03','aa','藏','1122121','555','2021-03-10',55,'2','2','2');

/*Table structure for table `workcar` */

DROP TABLE IF EXISTS `workcar`;

CREATE TABLE `workcar` (
  `id` int(11) NOT NULL COMMENT '车辆id',
  `danjuzt` varchar(50) DEFAULT NULL COMMENT '单据状态',
  `ywlx` varchar(50) DEFAULT NULL COMMENT '业务类型',
  `chepaih` int(50) DEFAULT NULL COMMENT '车牌号',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机',
  `huiykh` varchar(50) DEFAULT NULL COMMENT '会员卡号',
  `wxdh` varchar(50) DEFAULT NULL COMMENT '维修单号',
  `djlx` varchar(50) DEFAULT NULL COMMENT '单据类型',
  `kddate` date DEFAULT NULL COMMENT '开单时间',
  `yujwg` date DEFAULT NULL COMMENT '预计完工',
  `wgdate` date DEFAULT NULL COMMENT '完工时间',
  `jsdate` date DEFAULT NULL COMMENT '结算时间',
  `ygjine` double DEFAULT NULL COMMENT '预估时间',
  `fwugw` varchar(50) DEFAULT NULL COMMENT '服务顾问',
  `jiecr` varchar(50) DEFAULT NULL COMMENT '接车人',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`),
  KEY `wxdh` (`wxdh`),
  KEY `chepaih` (`chepaih`),
  CONSTRAINT `workcar_ibfk_1` FOREIGN KEY (`wxdh`) REFERENCES `maintenance_items` (`wxdh`),
  CONSTRAINT `workcar_ibfk_2` FOREIGN KEY (`chepaih`) REFERENCES `platenumber` (`plateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作中的车辆';

/*Data for the table `workcar` */

insert  into `workcar`(`id`,`danjuzt`,`ywlx`,`chepaih`,`phone`,`huiykh`,`wxdh`,`djlx`,`kddate`,`yujwg`,`wgdate`,`jsdate`,`ygjine`,`fwugw`,`jiecr`,`reserved1`,`reserved2`,`reserved3`) values (1,'接车','陕汽重卡',1,'123456',NULL,'22145678','维修','2021-03-18','2021-03-18','2021-03-12','2021-03-06',555,'耶鲁','超级管理员','沃达丰','沃达丰','沃达丰'),(2,'接车','陕汽重卡',2,'12345678',NULL,'1','救援','2021-03-10','2021-03-11','2021-03-17','2021-03-12',666,'耶律','超级管理员','单观柏',NULL,NULL),(3,'完工','中国重汽',1,'99999',NULL,'1','维修','2021-03-10','2021-03-10','2021-03-03','2021-03-12',7777,'耶鲁','超级管理员','狗子',NULL,NULL),(4,'接车','卡修重汽',4,'88888',NULL,'22145678','维修','2021-03-02','2021-02-10','2021-02-09','2021-01-21',222,'耶鲁','超级管理员','刘全',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
