UPDATE `t_menu`
SET `M_ID` = '8',
 `M_NAME` = '枚举信息管理',
 `M_URL` = '',
 `M_PARENT` = NULL,
 `M_TYPE` = '1',
 `M_DATE` = '2016-10-25 17:17:56'
WHERE
	(`M_ID` = '8');

UPDATE `t_menu`
SET `M_ID` = '9',
 `M_NAME` = '短信组件枚举管理',
 `M_URL` = 'sms.do',
 `M_PARENT` = '8',
 `M_TYPE` = '1',
 `M_DATE` = '2016-10-25 17:18:13'
WHERE
	(`M_ID` = '9');

UPDATE `t_menu`
SET `M_ID` = '10',
 `M_NAME` = 'Email组件枚举管理',
 `M_URL` = 'email.do',
 `M_PARENT` = '8',
 `M_TYPE` = '1',
 `M_DATE` = '2016-10-25 17:18:36'
WHERE
	(`M_ID` = '10');
