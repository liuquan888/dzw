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

/*Table structure for table `bank` */

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `bankid` int(11) NOT NULL AUTO_INCREMENT COMMENT '银行编号',
  `bankname` varchar(50) DEFAULT NULL COMMENT '银行名称',
  PRIMARY KEY (`bankid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行表';

/*Data for the table `bank` */

/*Table structure for table `billstype` */

DROP TABLE IF EXISTS `billstype`;

CREATE TABLE `billstype` (
  `id` int(11) NOT NULL COMMENT '单据类型编号',
  `type` varchar(50) DEFAULT NULL COMMENT '单据类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据类型';

/*Data for the table `billstype` */

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `b_id` int(11) NOT NULL COMMENT '车型品牌编号',
  `b_name` varchar(20) DEFAULT NULL COMMENT '车型品牌名称',
  `b_inital` varchar(20) DEFAULT NULL COMMENT '品牌首字母',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车型品牌';

/*Data for the table `brand` */

/*Table structure for table `businessclass` */

DROP TABLE IF EXISTS `businessclass`;

CREATE TABLE `businessclass` (
  `businessid` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务类别编号',
  `businessleb` varchar(50) DEFAULT NULL COMMENT '业务类别名称',
  PRIMARY KEY (`businessid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务类别表';

/*Data for the table `businessclass` */

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
  KEY `p_id` (`p_id`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `engine` (`e_id`),
  CONSTRAINT `car_ibfk_2` FOREIGN KEY (`d_id`) REFERENCES `domestic` (`d_id`),
  CONSTRAINT `car_ibfk_3` FOREIGN KEY (`b_id`) REFERENCES `brand` (`b_id`),
  CONSTRAINT `car_ibfk_4` FOREIGN KEY (`p_id`) REFERENCES `suppiler` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车型表';

/*Data for the table `car` */

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

/*Table structure for table `carheet` */

DROP TABLE IF EXISTS `carheet`;

CREATE TABLE `carheet` (
  `carnum` int(11) NOT NULL COMMENT '车辆号码',
  `platename` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `carbrandid` varchar(50) DEFAULT NULL COMMENT '车辆品牌id',
  `driver` varchar(50) DEFAULT NULL COMMENT '驾驶员',
  `driverphone` varchar(50) DEFAULT NULL COMMENT '驾驶员电话',
  `birthday` varchar(50) DEFAULT NULL COMMENT '出生日期',
  `caraffiliationid` int(11) DEFAULT NULL COMMENT '车辆归属id',
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
  `mlicompanyid` int(11) DEFAULT NULL COMMENT '交强险保险公司id',
  `mliouttime` varchar(50) DEFAULT NULL COMMENT '交强险到期',
  `cicompanyid` int(11) DEFAULT NULL COMMENT '商业险保险公司id',
  `ciouttime` varchar(50) DEFAULT NULL COMMENT '商业险到期',
  `mytoucar` varchar(50) DEFAULT NULL COMMENT '在我投保车',
  `twotime` varchar(50) DEFAULT NULL COMMENT '二维日期',
  `oiltypeid` int(11) DEFAULT NULL COMMENT '燃油类别id',
  `nextmileage` varchar(50) DEFAULT NULL COMMENT '下次保养里程',
  `nextupkeeptime` varchar(50) DEFAULT NULL COMMENT '下次保养日期',
  `membernum` varchar(50) DEFAULT NULL COMMENT '会员码',
  `customernum` varchar(50) NOT NULL COMMENT '客户编码',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`carnum`),
  KEY `carbrandid` (`carbrandid`),
  KEY `caraffiliationid` (`caraffiliationid`),
  KEY `engineid` (`engineid`),
  KEY `mlicompanyid` (`mlicompanyid`),
  KEY `cicompanyid` (`cicompanyid`),
  KEY `oiltypeid` (`oiltypeid`),
  CONSTRAINT `carheet_ibfk_1` FOREIGN KEY (`carbrandid`) REFERENCES `carbrand` (`carcoding`),
  CONSTRAINT `carheet_ibfk_2` FOREIGN KEY (`caraffiliationid`) REFERENCES `caraffiliation` (`caraffiliationid`),
  CONSTRAINT `carheet_ibfk_3` FOREIGN KEY (`engineid`) REFERENCES `engine` (`e_id`),
  CONSTRAINT `carheet_ibfk_4` FOREIGN KEY (`mlicompanyid`) REFERENCES `mlicompany` (`mlicompanyid`),
  CONSTRAINT `carheet_ibfk_5` FOREIGN KEY (`cicompanyid`) REFERENCES `cicompany` (`cicompanyid`),
  CONSTRAINT `carheet_ibfk_6` FOREIGN KEY (`oiltypeid`) REFERENCES `oiltype` (`oiltypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆资料表';

/*Data for the table `carheet` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算信息表';

/*Data for the table `clearing` */

/*Table structure for table `clearing_form` */

DROP TABLE IF EXISTS `clearing_form`;

CREATE TABLE `clearing_form` (
  `id` int(11) NOT NULL COMMENT '结算方式编号',
  `type` varchar(50) DEFAULT NULL COMMENT '结算方式名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算方式表';

/*Data for the table `clearing_form` */

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
  KEY `desportbank` (`desportbank`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customertypeid`) REFERENCES `customertype` (`customerid`),
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`counselorid`) REFERENCES `counselor` (`counselorid`),
  CONSTRAINT `customer_ibfk_3` FOREIGN KEY (`desportbank`) REFERENCES `bank` (`bankid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

/*Data for the table `customer` */

/*Table structure for table `customertype` */

DROP TABLE IF EXISTS `customertype`;

CREATE TABLE `customertype` (
  `customerid` int(11) NOT NULL COMMENT '客户类别id',
  `customertypeid` varchar(50) DEFAULT NULL COMMENT '客户类别',
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户类别';

/*Data for the table `customertype` */

/*Table structure for table `deparment_surface` */

DROP TABLE IF EXISTS `deparment_surface`;

CREATE TABLE `deparment_surface` (
  `bid` int(11) NOT NULL COMMENT '部门编号',
  `bname` varchar(50) NOT NULL COMMENT '部门名称',
  `blei` int(11) NOT NULL COMMENT '部门分类',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `deparment_surface` */

/*Table structure for table `document_status` */

DROP TABLE IF EXISTS `document_status`;

CREATE TABLE `document_status` (
  `id` int(11) NOT NULL COMMENT '单据状态id',
  `type` varchar(50) DEFAULT NULL COMMENT '单据状态名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据状态表';

/*Data for the table `document_status` */

/*Table structure for table `domestic` */

DROP TABLE IF EXISTS `domestic`;

CREATE TABLE `domestic` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进口国产序号',
  `d_name` varchar(20) DEFAULT NULL COMMENT '进口国产名称',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进口国产';

/*Data for the table `domestic` */

/*Table structure for table `dzw_privilege` */

DROP TABLE IF EXISTS `dzw_privilege`;

CREATE TABLE `dzw_privilege` (
  `pvgid` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
  `pvg_name` varchar(50) NOT NULL COMMENT '权限名称',
  `pvg_verify` varchar(50) DEFAULT NULL COMMENT '权限验证',
  `pvg_type` int(11) NOT NULL COMMENT '类别，0是父级菜单，1是子级菜单，2是功能',
  `pvg_path` varchar(50) DEFAULT NULL COMMENT '路径（是菜单才拥有）',
  `pid` int(11) NOT NULL COMMENT '父级编号',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`pvgid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='权限表';

/*Data for the table `dzw_privilege` */

insert  into `dzw_privilege`(`pvgid`,`pvg_name`,`pvg_verify`,`pvg_type`,`pvg_path`,`pid`,`reserved1`,`reserved2`,`reserved3`) values (1,'服务接待',NULL,1,NULL,0,NULL,NULL,NULL),(2,'结算中心',NULL,1,NULL,0,NULL,NULL,NULL),(3,'客户档案',NULL,1,NULL,0,NULL,NULL,NULL),(4,'基础数据',NULL,1,NULL,0,NULL,NULL,NULL),(5,'行政人事',NULL,1,'',0,NULL,NULL,NULL),(6,'系统设置',NULL,1,NULL,0,NULL,NULL,NULL),(7,'服务接待',NULL,1,NULL,1,NULL,NULL,NULL),(8,'前台结算',NULL,1,NULL,2,NULL,NULL,NULL),(9,'客服档案',NULL,1,NULL,3,NULL,NULL,NULL),(10,'主数据',NULL,1,NULL,4,NULL,NULL,NULL),(11,'员工资料',NULL,1,NULL,5,NULL,NULL,NULL),(12,'技工管理',NULL,1,NULL,5,NULL,NULL,NULL),(13,'权限控制',NULL,1,NULL,6,NULL,NULL,NULL),(14,'维修接车',NULL,1,NULL,7,NULL,NULL,NULL),(15,'竣工校验',NULL,1,NULL,7,NULL,NULL,NULL),(16,'保险对价',NULL,1,NULL,7,NULL,NULL,NULL),(17,'结算中心',NULL,1,NULL,8,NULL,NULL,NULL),(18,'会员充值',NULL,1,NULL,8,NULL,NULL,NULL),(19,'客户资料',NULL,1,NULL,9,NULL,NULL,NULL),(20,'车辆资料',NULL,1,NULL,9,NULL,NULL,NULL),(21,'发动机品牌',NULL,1,NULL,10,NULL,NULL,NULL),(22,'车型档案',NULL,1,NULL,10,NULL,NULL,NULL),(23,'维修项目',NULL,1,NULL,10,NULL,NULL,NULL),(24,'商品资料',NULL,1,NULL,10,NULL,NULL,NULL),(25,'供货单位',NULL,1,NULL,10,NULL,NULL,NULL),(26,'组织机构',NULL,1,NULL,11,NULL,NULL,NULL),(27,'岗位定义',NULL,1,NULL,11,NULL,NULL,NULL),(28,'离职登记',NULL,1,NULL,11,NULL,NULL,NULL),(29,'通讯名录',NULL,1,NULL,11,NULL,NULL,NULL),(30,'技工星级',NULL,1,NULL,12,NULL,NULL,NULL),(31,'班组技工',NULL,1,NULL,12,NULL,NULL,NULL),(32,'外勤车辆',NULL,1,NULL,12,NULL,NULL,NULL),(33,'技工提成比例',NULL,1,NULL,12,NULL,NULL,NULL),(34,'员工权限控制',NULL,1,NULL,13,NULL,NULL,NULL),(35,'角色权限控制',NULL,1,NULL,13,NULL,NULL,NULL);

/*Table structure for table `dzw_role` */

DROP TABLE IF EXISTS `dzw_role`;

CREATE TABLE `dzw_role` (
  `role_id` int(11) NOT NULL COMMENT '角色唯一编号',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(50) NOT NULL COMMENT '角色描述',
  `status` varchar(10) NOT NULL COMMENT '角色状态，0000：代表有效，0001：代表无效，0002：代表伪删除',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` date NOT NULL COMMENT '最近更新时间',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `dzw_role` */

/*Table structure for table `dzw_user` */

DROP TABLE IF EXISTS `dzw_user`;

CREATE TABLE `dzw_user` (
  `user_id` int(11) NOT NULL COMMENT '用户唯一编号',
  `user_name` varchar(50) NOT NULL COMMENT '用户昵称',
  `user_login` varchar(50) NOT NULL COMMENT '登录账号',
  `user_pwd` varchar(50) NOT NULL COMMENT '登录密码',
  `user_realname` varchar(50) NOT NULL COMMENT '真实姓名',
  `user_sex` varchar(50) NOT NULL COMMENT '用户性别，00：代表女，11：代表男，03：代表未知',
  `user_phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `user_eamil` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_address` varchar(100) DEFAULT NULL COMMENT '地址',
  `status` varchar(10) NOT NULL COMMENT '用户状态，0000：代表有效，0001：代表无效，0002：代表伪删除',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` date NOT NULL COMMENT '最近更新时间',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `dzw_user` */

/*Table structure for table `education` */

DROP TABLE IF EXISTS `education`;

CREATE TABLE `education` (
  `educationid` int(11) NOT NULL COMMENT '学历编号',
  `name` varchar(50) NOT NULL COMMENT '学历名称',
  PRIMARY KEY (`educationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学历表';

/*Data for the table `education` */

/*Table structure for table `engine` */

DROP TABLE IF EXISTS `engine`;

CREATE TABLE `engine` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '发动机品牌编号',
  `e_coder` varchar(20) DEFAULT NULL COMMENT '发动机品牌编码',
  `e_name` varchar(20) DEFAULT NULL COMMENT '发动机品牌名称',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发动机表';

/*Data for the table `engine` */

/*Table structure for table `factory` */

DROP TABLE IF EXISTS `factory`;

CREATE TABLE `factory` (
  `factory` int(11) NOT NULL COMMENT '厂id',
  `factoryname` varchar(50) DEFAULT NULL COMMENT '厂名',
  PRIMARY KEY (`factory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工厂表';

/*Data for the table `factory` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外勤车辆表';

/*Data for the table `fieldvehicles` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领料情况表';

/*Data for the table `get_material` */

/*Table structure for table `graduate_school` */

DROP TABLE IF EXISTS `graduate_school`;

CREATE TABLE `graduate_school` (
  `schoolid` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) NOT NULL COMMENT '毕业学校',
  PRIMARY KEY (`schoolid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校表';

/*Data for the table `graduate_school` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收入种类';

/*Data for the table `income` */

/*Table structure for table `linkman` */

DROP TABLE IF EXISTS `linkman`;

CREATE TABLE `linkman` (
  `l_id` int(11) NOT NULL COMMENT '供应商联系人编号',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='联系人\r\n';

/*Data for the table `linkman` */

/*Table structure for table `maintenance` */

DROP TABLE IF EXISTS `maintenance`;

CREATE TABLE `maintenance` (
  `m_id` int(11) NOT NULL COMMENT '维修进程编号',
  `m_name` varchar(10) DEFAULT NULL COMMENT '维修进程项目名',
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

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `menuname` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `parentid` int(11) DEFAULT NULL COMMENT '父级编号',
  `teamid` varchar(50) NOT NULL COMMENT '班组编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='树形菜单';

/*Data for the table `menu` */

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

/*Table structure for table `nation` */

DROP TABLE IF EXISTS `nation`;

CREATE TABLE `nation` (
  `nationid` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) DEFAULT NULL COMMENT '民族',
  PRIMARY KEY (`nationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='民族表';

/*Data for the table `nation` */

/*Table structure for table `nativ_place` */

DROP TABLE IF EXISTS `nativ_place`;

CREATE TABLE `nativ_place` (
  `jnativplaceid` int(11) NOT NULL COMMENT '序号',
  `jname` varchar(50) NOT NULL COMMENT '籍贯',
  PRIMARY KEY (`jnativplaceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='籍贯表';

/*Data for the table `nativ_place` */

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

/*Table structure for table `organization_surface` */

DROP TABLE IF EXISTS `organization_surface`;

CREATE TABLE `organization_surface` (
  `zid` int(11) NOT NULL COMMENT '机构id',
  `zname` varchar(50) NOT NULL COMMENT '机构姓名',
  `msname` varchar(50) DEFAULT NULL COMMENT '上级门店',
  `mshou` varchar(50) NOT NULL COMMENT '售价权重',
  `mdianid` int(11) NOT NULL COMMENT '门店分类id',
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
  `zids` int(11) NOT NULL COMMENT '机构id外键',
  `zyid` int(11) NOT NULL COMMENT '员工表id外键',
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

/*Table structure for table `pattern` */

DROP TABLE IF EXISTS `pattern`;

CREATE TABLE `pattern` (
  `pa_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '发动机品牌编号',
  `pa_coder` varchar(20) DEFAULT NULL COMMENT '发动机品牌编码',
  `pa_name` varchar(20) DEFAULT NULL COMMENT '发动机品牌名称',
  PRIMARY KEY (`pa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付方式表';

/*Data for the table `pattern` */

/*Table structure for table `platenumber` */

DROP TABLE IF EXISTS `platenumber`;

CREATE TABLE `platenumber` (
  `plateid` int(11) NOT NULL COMMENT '车牌id',
  `platename` varchar(50) DEFAULT NULL COMMENT '车牌名',
  PRIMARY KEY (`plateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车牌表';

/*Data for the table `platenumber` */

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

/*Table structure for table `professional_qualification` */

DROP TABLE IF EXISTS `professional_qualification`;

CREATE TABLE `professional_qualification` (
  `specialtynid` int(11) NOT NULL COMMENT '序号',
  `name` varchar(50) NOT NULL COMMENT '专业',
  PRIMARY KEY (`specialtynid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业资格表';

/*Data for the table `professional_qualification` */

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
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`no`),
  KEY `documents_type` (`documents_type`),
  KEY `balance_type` (`balance_type`),
  KEY `documents_state` (`documents_state`),
  KEY `balance_state` (`balance_state`),
  KEY `chepai_no` (`chepai_no`),
  KEY `counsellor` (`counsellor`),
  KEY `motor_id` (`motor_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `repair_bill_ibfk_1` FOREIGN KEY (`documents_type`) REFERENCES `billstype` (`id`),
  CONSTRAINT `repair_bill_ibfk_2` FOREIGN KEY (`balance_type`) REFERENCES `clearing_form` (`id`),
  CONSTRAINT `repair_bill_ibfk_3` FOREIGN KEY (`documents_state`) REFERENCES `settlement_status` (`id`),
  CONSTRAINT `repair_bill_ibfk_4` FOREIGN KEY (`balance_state`) REFERENCES `document_status` (`id`),
  CONSTRAINT `repair_bill_ibfk_5` FOREIGN KEY (`chepai_no`) REFERENCES `platenumber` (`plateid`),
  CONSTRAINT `repair_bill_ibfk_6` FOREIGN KEY (`counsellor`) REFERENCES `counselor` (`counselorid`),
  CONSTRAINT `repair_bill_ibfk_7` FOREIGN KEY (`motor_id`) REFERENCES `motor` (`mo_id`),
  CONSTRAINT `repair_bill_ibfk_8` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customertypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修单据表';

/*Data for the table `repair_bill` */

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

/*Table structure for table `settlement_status` */

DROP TABLE IF EXISTS `settlement_status`;

CREATE TABLE `settlement_status` (
  `id` int(11) NOT NULL COMMENT '唯一编号',
  `type` varchar(50) DEFAULT NULL COMMENT '状态名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算状态表';

/*Data for the table `settlement_status` */

/*Table structure for table `staff_data` */

DROP TABLE IF EXISTS `staff_data`;

CREATE TABLE `staff_data` (
  `yid` int(11) NOT NULL COMMENT '员工编号',
  `yname` varchar(50) NOT NULL COMMENT '员工姓名',
  `ysex` varchar(10) NOT NULL COMMENT '员工性别',
  `yposition` varchar(20) NOT NULL COMMENT '员工职位',
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
  `gid` int(11) NOT NULL COMMENT '岗位编码',
  `bid` int(11) NOT NULL COMMENT '部门',
  `reserved1` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved2` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved3` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved4` varchar(50) DEFAULT NULL COMMENT '预留字段',
  `reserved5` varchar(50) DEFAULT NULL COMMENT '预留字段',
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

/*Table structure for table `store_classificarion` */

DROP TABLE IF EXISTS `store_classificarion`;

CREATE TABLE `store_classificarion` (
  `mlid` int(11) NOT NULL COMMENT '序号id',
  `mlname` varchar(50) NOT NULL COMMENT '门店分类姓名',
  PRIMARY KEY (`mlid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店分类表';

/*Data for the table `store_classificarion` */

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
  KEY `teamid` (`teamid`),
  KEY `bankid` (`bankid`),
  KEY `code` (`code`),
  CONSTRAINT `teamtechnician_ibfk_1` FOREIGN KEY (`teamid`) REFERENCES `menu_merchandise` (`menu_id`),
  CONSTRAINT `teamtechnician_ibfk_2` FOREIGN KEY (`bankid`) REFERENCES `bank` (`bankid`),
  CONSTRAINT `teamtechnician_ibfk_3` FOREIGN KEY (`code`) REFERENCES `mechanicstar` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

/*Data for the table `teamtechnician` */

/*Table structure for table `upkeep` */

DROP TABLE IF EXISTS `upkeep`;

CREATE TABLE `upkeep` (
  `upkeepid` int(11) NOT NULL COMMENT '保养id',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保养表';

/*Data for the table `upkeep` */

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
