INSERT INTO `t_api` (`A_ID`, `A_NAME`, `A_URL`, `A_REQUEST_TYPE`, `A_PARAM`, `A_COUNT`, `A_DESCRIPTION`, `A_DATE`) VALUES ('2', '获取流水号接口', '/api/code/query.do', '1', 'code', NULL, '获取流水号接口', '2016-10-28 09:56:42');
INSERT INTO `t_api` (`A_ID`, `A_NAME`, `A_URL`, `A_REQUEST_TYPE`, `A_PARAM`, `A_COUNT`, `A_DESCRIPTION`, `A_DATE`) VALUES ('3', '查询角色菜单接口', '/api/roleMenu/query.do', '1', 'roleId,mType,mParent', NULL, '查询角色菜单接口', '2016-10-28 09:59:54');
UPDATE `t_api` SET `A_ID`='1', `A_NAME`='验证用户登录接口', `A_URL`='/api/user/checkLogin.do', `A_REQUEST_TYPE`='2', `A_PARAM`='username,password', `A_COUNT`=NULL, `A_DESCRIPTION`='验证用户登录接口', `A_DATE`='2016-10-21 16:11:42' WHERE (`A_ID`='1');


DROP TABLE IF EXISTS `t_max_code`;
CREATE TABLE `t_max_code` (
  `name` varchar(10) DEFAULT NULL,
  `max` int(5) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


DELIMITER $$
DROP PROCEDURE IF EXISTS `serialno`$$
create PROCEDURE serialno(in prefix char(2),out xcode VARCHAR(15))
BEGIN
DECLARE now_date VARCHAR(8);
DECLARE t_max_code INT;
select DATE_FORMAT(now(),'%Y%m%d') into now_date from dual;
select max into t_max_code from t_max_code where name=prefix and date = now_date;
if t_max_code is null then
    INSERT into t_max_code (name,max,date) values (prefix,1,now_date);
else
    update t_max_code set max = t_max_code+1 where name=prefix and date = now_date;
end if;
    select max into t_max_code from t_max_code where name=prefix and date = now_date;
    select concat(prefix,now_date,LPAD((t_max_code), 4, '0')) as code into xcode;
END