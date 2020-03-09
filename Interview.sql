/*
 Navicat Premium Data Transfer

 Source Server         : itv_tencent
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : cdb-45mi9oeg.cd.tencentcdb.com:10111
 Source Schema         : Interview

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 09/03/2020 14:32:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ITV_D_Education
-- ----------------------------
DROP TABLE IF EXISTS `ITV_D_Education`;
CREATE TABLE `ITV_D_Education` (
  `Education_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Interviewer_FK` bigint(20) NOT NULL,
  `School` varchar(40) DEFAULT '',
  `Area` varchar(60) DEFAULT '',
  `RegDate` date DEFAULT NULL,
  `GraDate` datetime DEFAULT NULL,
  `Profession` varchar(40) DEFAULT '',
  `Degree` varchar(20) DEFAULT '',
  `EduType` varchar(20) DEFAULT '',
  `EduSort` varchar(10) DEFAULT '',
  `ValidFlag` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`Education_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=276 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ITV_D_Education
-- ----------------------------
BEGIN;
INSERT INTO `ITV_D_Education` VALUES (185, 11, '', '', NULL, NULL, '', '', '', '1', 1);
INSERT INTO `ITV_D_Education` VALUES (244, 13, '苏州', '江苏省-苏州市-相城区', '1960-01-21', '1960-01-26 08:00:00', '管理', '大专', '统招', '1', 1);
INSERT INTO `ITV_D_Education` VALUES (251, 1, '23', '北京市-北京市-东城区', '2020-02-06', '2020-03-19 08:00:00', '12312', '高职', '统招', '1', 1);
INSERT INTO `ITV_D_Education` VALUES (269, 10, '111', '北京市-北京市-东城区', '1960-01-14', '1971-04-30 08:00:00', '111', '本科', '统招', '1', 1);
INSERT INTO `ITV_D_Education` VALUES (275, 9, '123', '北京市-北京市-东城区', '2020-01-31', '2020-02-21 08:00:00', '123', '本科', '统招', '1', 1);
COMMIT;

-- ----------------------------
-- Table structure for ITV_D_Experience
-- ----------------------------
DROP TABLE IF EXISTS `ITV_D_Experience`;
CREATE TABLE `ITV_D_Experience` (
  `Experience_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工作经历主键',
  `Interviewer_FK` bigint(20) NOT NULL COMMENT 'Interviewer表外建',
  `Company` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `City` varchar(100) DEFAULT NULL COMMENT '地点',
  `JobTitle` varchar(100) DEFAULT NULL COMMENT '职称',
  `Salary` varchar(20) DEFAULT '' COMMENT '薪资',
  `FromDate` date DEFAULT NULL COMMENT '入职时间',
  `ToDate` datetime DEFAULT NULL COMMENT '离职时间',
  `Supervior` varchar(40) DEFAULT '' COMMENT '直属主管姓名/职称',
  `Telephone` varchar(20) DEFAULT '' COMMENT '联系方式',
  `ResignReason` varchar(255) DEFAULT '' COMMENT '离职原因',
  `ValidFlag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`Experience_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ITV_D_Experience
-- ----------------------------
BEGIN;
INSERT INTO `ITV_D_Experience` VALUES (235, 13, '昆山', '昆山', '人事', '3000', '1990-01-17', '1990-01-24 08:00:00', '李', '13776365283', '个人', 1);
INSERT INTO `ITV_D_Experience` VALUES (236, 13, '昆山', '昆山', '人事', '3000', '1990-01-24', '1990-01-31 08:00:00', '李', '13776365283', '个人', 1);
INSERT INTO `ITV_D_Experience` VALUES (254, 9, '123', '123', '123', '123', '1990-01-15', '1990-01-26 08:00:00', '123', '15051976322', '123', 1);
COMMIT;

-- ----------------------------
-- Table structure for ITV_D_Relative
-- ----------------------------
DROP TABLE IF EXISTS `ITV_D_Relative`;
CREATE TABLE `ITV_D_Relative` (
  `Relative_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Relative主键',
  `Interviewer_FK` bigint(20) NOT NULL COMMENT 'Interviewer外建',
  `Relationship` varchar(20) DEFAULT NULL COMMENT '亲属关系',
  `Name` varchar(20) DEFAULT NULL COMMENT '亲属姓名',
  `Age` varchar(10) DEFAULT NULL COMMENT '年龄',
  `Job` varchar(40) DEFAULT NULL COMMENT '职业',
  `Workplace` varchar(255) DEFAULT NULL COMMENT '工作地点',
  `HomeAddress` varchar(255) DEFAULT NULL COMMENT '家庭地址',
  `Telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `Emergency` varchar(10) DEFAULT NULL COMMENT '是否为紧急联络人',
  `ValidFlag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效 ',
  PRIMARY KEY (`Relative_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=315 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ITV_D_Relative
-- ----------------------------
BEGIN;
INSERT INTO `ITV_D_Relative` VALUES (287, 13, '配偶', '李', '34', '职员', '公交', '昆山', '13776365283', '1', 1);
INSERT INTO `ITV_D_Relative` VALUES (300, 1, '父亲', '123', '123', '123', '123', '123', '15051976322', '1', 1);
INSERT INTO `ITV_D_Relative` VALUES (301, 1, '母亲', '123', '123', '123', '1231', '23', '15051976322', '1', 1);
INSERT INTO `ITV_D_Relative` VALUES (314, 9, '配偶', '123', '123', '3', '123', '123', '15051976322', '1', 1);
COMMIT;

-- ----------------------------
-- Table structure for ITV_M_Interviewer
-- ----------------------------
DROP TABLE IF EXISTS `ITV_M_Interviewer`;
CREATE TABLE `ITV_M_Interviewer` (
  `Interviewer_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `InterviewerName` varchar(20) DEFAULT '' COMMENT '面试者姓名',
  `IdNumber` varchar(30) DEFAULT '' COMMENT '身份证号',
  `BirthDate` datetime DEFAULT NULL COMMENT '出生日期',
  `NativePlace` varchar(100) DEFAULT '' COMMENT '籍贯',
  `Gender` varchar(10) DEFAULT '' COMMENT '性别',
  `Ethnic` varchar(20) DEFAULT '' COMMENT '民族',
  `PoliticalStatus` varchar(20) DEFAULT '' COMMENT '政治面貌',
  `MarriageStatus` varchar(20) DEFAULT '' COMMENT '婚姻',
  `SpouseName` varchar(20) DEFAULT '' COMMENT '配偶姓名',
  `SpouseIdNumber` varchar(30) DEFAULT '' COMMENT '配偶身份证号',
  `NativeAddress` varchar(255) DEFAULT '' COMMENT '户籍地址',
  `FamilyAddress` varchar(255) DEFAULT '' COMMENT '家庭地址',
  `NowAddress` varchar(255) DEFAULT '' COMMENT '现居住地',
  `Phone` varchar(30) DEFAULT '' COMMENT '手机号码',
  `Email` varchar(255) DEFAULT '' COMMENT '邮箱',
  `Source` varchar(30) DEFAULT '' COMMENT '应聘来源',
  `AdditionInternet` varchar(255) DEFAULT '' COMMENT '补充-网络',
  `AdditionEmp` varchar(255) DEFAULT '' COMMENT '补充-同仁介绍',
  `AdditionOther` varchar(255) DEFAULT '' COMMENT '补充-其他',
  `Hospitalized` varchar(20) DEFAULT '' COMMENT '是否在近6个月内在医院住院治疗?',
  `Respiratory` varchar(20) DEFAULT '' COMMENT '是否患有传染性呼吸系统疾病？',
  `Asthma` varchar(20) DEFAULT '' COMMENT '是否有哮喘？',
  `Heart` varchar(20) DEFAULT '' COMMENT '是否有心脏病？',
  `Skin` varchar(20) DEFAULT '' COMMENT '是否患有传染性皮肤病？',
  `Excited` varchar(20) DEFAULT '' COMMENT '是否经常性情绪波动较大，易激动？',
  `Drunk` varchar(20) DEFAULT '' COMMENT '是否酗酒？',
  `Genetic` varchar(20) DEFAULT '' COMMENT '家族是否有遗传病史？',
  `Epilepsy` varchar(20) DEFAULT '' COMMENT '是否有癫痫病史？',
  `Hear` varchar(20) DEFAULT '' COMMENT '是否有听力障碍？',
  `Other` varchar(20) DEFAULT '' COMMENT '是否有其他可能对健康造成严重影响的疾病，或有可能给工作造成不便的疾病？',
  `Unlawful` varchar(20) DEFAULT '' COMMENT '是否曾参加非法集会？',
  `ExpectedSalary` varchar(20) DEFAULT '' COMMENT '期望待遇(税前)',
  `RegDate` datetime DEFAULT NULL COMMENT '到职日期',
  `DormFlag` varchar(20) DEFAULT '' COMMENT '是否住宿？',
  `Creator` varchar(30) DEFAULT '' COMMENT '创建者',
  `DateOfCreate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `Updater` varchar(20) DEFAULT '' COMMENT '修改者',
  `DateOfUpdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `Memo` varchar(255) DEFAULT '' COMMENT '备注',
  `ValidFlag` tinyint(1) DEFAULT '1' COMMENT '是否有效',
  `ExperienceFlag` varchar(10) DEFAULT NULL COMMENT '是否有工作经历',
  `RelatedFlag` varchar(20) DEFAULT '' COMMENT '是否有亲属在本公司服务',
  `RelatedName` varchar(20) DEFAULT '' COMMENT '在职亲属姓名',
  `RelatedEmployee_ID` varchar(20) DEFAULT '' COMMENT '在职亲属工号',
  `RelatedRelationship` varchar(20) DEFAULT '' COMMENT '在职亲属关系',
  PRIMARY KEY (`Interviewer_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ITV_M_Interviewer
-- ----------------------------
BEGIN;
INSERT INTO `ITV_M_Interviewer` VALUES (1, '杨晨123', '320283199411105518', '2020-02-27 08:00:00', '北京市-北京市-东城区', '1', '1', '101', '0', '', '', '123123', '12412412', '123123124', '15051976322', '408825673@qq.com', '学校', NULL, NULL, NULL, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '123', '2020-03-20 08:00:00', '0', 'sys', '2020-02-23 22:13:22', 'sys', '2020-02-23 22:13:22', '', 1, '0', '1', '312', '312', '1');
INSERT INTO `ITV_M_Interviewer` VALUES (8, NULL, '321088198911276564', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'sys', '2020-02-27 12:37:59', 'sys', '2020-02-27 12:37:59', '', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ITV_M_Interviewer` VALUES (9, '杨晨', '320283199411105517', '2020-02-11 08:00:00', '北京市-北京市-东城区', '2', '汉族', '101', '1', '123', '123', '123', '123', '12312', '15051976322', '408825673@qq.com', '公司同仁介绍', NULL, 'C1707942', NULL, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '213', '2020-08-13 08:00:00', '1', 'sys', '2020-02-28 14:00:48', 'sys', '2020-02-28 14:00:48', '', 1, '1', '1', '123', '123', '弟弟');
INSERT INTO `ITV_M_Interviewer` VALUES (10, '陈彦廷', '320282199404152571', '1960-01-08 08:00:00', '吉林省-四平市-梨树县', '1', '汉族', '000', '0', NULL, NULL, '1111111', '1111', '2222', '18261651351', 'chenyanting@666.com', '人才市场', NULL, NULL, NULL, '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', NULL, NULL, NULL, NULL, 'sys', '2020-02-28 16:17:01', 'sys', '2020-02-28 16:17:01', '', 1, '0', '0', NULL, NULL, NULL);
INSERT INTO `ITV_M_Interviewer` VALUES (11, NULL, '320922198109020346', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'sys', '2020-02-28 16:18:23', 'sys', '2020-02-28 16:18:23', '', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ITV_M_Interviewer` VALUES (12, '杨晨', '320283199411105516', '1960-01-29 08:00:00', '北京市-北京市-海淀区', '2', '门巴族', '102', '0', NULL, NULL, '786', '4555', '98545', '15051976322', '408825673@qq.com', '人才市场', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'sys', '2020-02-28 17:11:10', 'sys', '2020-02-28 17:11:10', '', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ITV_M_Interviewer` VALUES (13, '李', '32058319861028942X', '1965-10-21 08:00:00', '江苏省-苏州市-昆山市', '2', '汉族', '000', '1', '李', '32058319861028942X', '昆山', '昆山', '昆山', '13776365283', 'lingyanli@ivo.com.cn', '网络', '前程无忧', NULL, NULL, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', NULL, NULL, NULL, NULL, 'sys', '2020-02-28 17:41:48', 'sys', '2020-02-28 17:41:48', '', 1, '1', '0', NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
