package cn.springmvc.dao;

import java.util.Map;

import cn.springmvc.model.TAuthUser;

public interface TAuthUserMapper extends BaseMapper<TAuthUser> {

	TAuthUser checkLogin(Map<String, Object> map);
}