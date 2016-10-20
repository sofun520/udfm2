package cn.springmvc.service;

import java.util.Map;

import cn.springmvc.model.TAuthUser;

public interface TAuthUserService extends BaseService<TAuthUser> {

	TAuthUser checkLogin(Map<String, Object> map);


}
