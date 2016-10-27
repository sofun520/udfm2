
DELIMITER $$
DROP PROCEDURE IF EXISTS `serialno`$$
create PROCEDURE serialno(in prefix char(2),out xcode VARCHAR(13))
BEGIN
DECLARE now_date VARCHAR(8);
DECLARE max_code INT;
select DATE_FORMAT(now(),'%Y%m%d') into now_date from dual;
select max into max_code from max_code where name=prefix and date = now_date;
if max_code is null then
    INSERT into max_code (name,max,date) values (prefix,1,now_date);
else
    update max_code set max = max_code+1 where name=prefix and date = now_date;
end if;
    select max into max_code from max_code where name=prefix and date = now_date;
    select concat(prefix,now_date,LPAD((max_code), 3, '0')) as code into xcode;
END