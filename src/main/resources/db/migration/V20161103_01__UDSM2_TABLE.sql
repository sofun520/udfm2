DROP TABLE IF EXISTS `amount`;
CREATE TABLE `amount` (
  `A_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `A_TYPE` char(1) DEFAULT '1' COMMENT '类型：1：收入、2：支出',
  `A_SUM` decimal(8,2) DEFAULT NULL COMMENT '总计',
  `A_WAYS` char(1) DEFAULT NULL COMMENT '方式：1：现金、2：银行卡、3：信用卡',
  `A_CARD_ID` int(10) DEFAULT NULL COMMENT '卡id',
  `A_IMG` int(10) DEFAULT NULL COMMENT '账单图片',
  `A_DATE` datetime DEFAULT NULL COMMENT '录入时间',
  PRIMARY KEY (`A_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `C_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `C_TYPE` char(1) DEFAULT NULL COMMENT '卡类型：1：银行卡、2：信用卡',
  `C_NO` varchar(40) DEFAULT NULL COMMENT '卡号',
  `C_BANK_ID` int(10) DEFAULT NULL COMMENT '银行编号',
  `C_DATE` datetime DEFAULT NULL COMMENT '录入时间',
  PRIMARY KEY (`C_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
