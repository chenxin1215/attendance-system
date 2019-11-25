/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : attendence_cx

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-11-24 14:22:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for approve_info
-- ----------------------------
DROP TABLE IF EXISTS `approve_info`;
CREATE TABLE `approve_info` (
  `approve_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '审批编号',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '员工编号',
  `employee_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '员工姓名',
  `approve_person` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '审批人',
  `approve_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审批时间',
  `approve_reason` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '审批理由',
  `approve_type` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '审批类型 1：请假；2：加班',
  `approve_state` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '审批状态 1：待审核；2：已审核；3：已拒绝',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`approve_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1768 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of approve_info
-- ----------------------------

-- ----------------------------
-- Table structure for attendence_info
-- ----------------------------
DROP TABLE IF EXISTS `attendence_info`;
CREATE TABLE `attendence_info` (
  `record_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '出勤记录编号',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '员工编号',
  `employee_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '员工姓名',
  `onwork_time` datetime NOT NULL COMMENT '上班时间',
  `offwork_time` datetime NOT NULL COMMENT '下班时间',
  `record_year` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '记录年份',
  `record_month` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '记录月份',
  `record_day` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '记录天份',
  `state` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '出勤状态 1：正常；2：缺卡；3：旷工',
  `late_sign` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '迟到标识',
  `early_sign` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '早退标识',
  `wotk_time` int(11) NOT NULL DEFAULT '0' COMMENT '累计工作时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1768 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of attendence_info
-- ----------------------------

-- ----------------------------
-- Table structure for configure_info
-- ----------------------------
DROP TABLE IF EXISTS `configure_info`;
CREATE TABLE `configure_info` (
  `record_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '配置信息表主键',
  `work_hours` datetime NOT NULL COMMENT '规定上班时间',
  `ow_hours` datetime NOT NULL COMMENT '规定下班时间',
  `day_worktime` int(11) NOT NULL DEFAULT '0' COMMENT '每天工作时间 (小时)',
  `break_type` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '休息类型 1：单休；2：双休',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1768 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of configure_info
-- ----------------------------

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info` (
  `employee_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `employee_sn` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '工号',
  `employee_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `age` int(11) NOT NULL COMMENT '年龄',
  `sex` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '性别 1：男；0：女',
  `enter_date` date NOT NULL COMMENT '入职日期',
  `position` tinyint(4) unsigned NOT NULL COMMENT '职位 待定',
  `employee_type` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '员工类型 1：普通员工；2：管理员',
  `password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `tel` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '联系方式',
  `state` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '员工状态 1： 在职； 2：离职',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `employee_sn` (`employee_sn`)
) ENGINE=InnoDB AUTO_INCREMENT=1769 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of employee_info
-- ----------------------------
INSERT INTO `employee_info` VALUES ('1768', 'a001', 'ducx', '100', '1', '2019-11-23', '1', '1', '123456', '13973341321', '1', '2019-11-23 00:11:03', '2019-11-23 21:42:50');

-- ----------------------------
-- Table structure for leave_info
-- ----------------------------
DROP TABLE IF EXISTS `leave_info`;
CREATE TABLE `leave_info` (
  `record_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '请假记录编号',
  `employee_id` bigint(20) NOT NULL COMMENT '员工编号',
  `employee_sn` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '工号',
  `leave_reason` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '请假理由',
  `start_date` date NOT NULL COMMENT '开始时间',
  `end_date` date NOT NULL COMMENT '结束时间',
  `approvel_state` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '审批状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1768 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of leave_info
-- ----------------------------

-- ----------------------------
-- Table structure for log_configure_info
-- ----------------------------
DROP TABLE IF EXISTS `log_configure_info`;
CREATE TABLE `log_configure_info` (
  `log_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '操作人编号',
  `employee_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作人姓名',
  `content` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作内容',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1768 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of log_configure_info
-- ----------------------------

-- ----------------------------
-- Table structure for month_statistics
-- ----------------------------
DROP TABLE IF EXISTS `month_statistics`;
CREATE TABLE `month_statistics` (
  `record_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '每月统计记录表Id',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '员工编号',
  `employee_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '员工姓名',
  `work_day` int(11) NOT NULL DEFAULT '0' COMMENT '出勤天数',
  `lateness_num` int(11) NOT NULL DEFAULT '0' COMMENT '迟到次数',
  `early_num` int(11) NOT NULL DEFAULT '0' COMMENT '早退次数',
  `miss_num` int(11) NOT NULL DEFAULT '0' COMMENT '缺卡次数',
  `overtime_num` int(11) NOT NULL DEFAULT '0' COMMENT '加班次数',
  `absenteeism_day` int(11) NOT NULL DEFAULT '0' COMMENT '旷工天数',
  `leave_day` int(11) NOT NULL DEFAULT '0' COMMENT '请假天数',
  `work_time` int(11) NOT NULL DEFAULT '0' COMMENT '累计工作时间',
  `eave_time` int(11) NOT NULL DEFAULT '0' COMMENT '累计请假时间',
  `over_time` int(11) NOT NULL DEFAULT '0' COMMENT '累计加班时间',
  `remaining_time` int(11) NOT NULL DEFAULT '0' COMMENT '欠缺时间',
  `slack_time` int(11) NOT NULL DEFAULT '0' COMMENT '富余时间',
  `years` int(11) NOT NULL COMMENT '年份',
  `months` int(11) NOT NULL COMMENT '月份',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1768 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of month_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for overtime_info
-- ----------------------------
DROP TABLE IF EXISTS `overtime_info`;
CREATE TABLE `overtime_info` (
  `overtime_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '加班记录编号',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '员工编号',
  `over_starttime` datetime NOT NULL COMMENT '加班开始时间',
  `over_endtime` datetime NOT NULL COMMENT '加班结束时间',
  `over_date` date NOT NULL COMMENT '加班日期',
  `over_reason` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '加班理由',
  `approve_state` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '审批状态 1：待审核；2：已审核；3：已拒绝',
  `approve_id` bigint(20) unsigned DEFAULT NULL COMMENT '审批信息表id',
  `complete_state` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '完成状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`overtime_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1768 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of overtime_info
-- ----------------------------
