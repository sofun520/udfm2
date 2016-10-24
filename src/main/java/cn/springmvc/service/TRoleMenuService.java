package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.RoleMenuApi;
import cn.springmvc.model.TRoleMenu;

public interface TRoleMenuService extends BaseService<TRoleMenu> {

	List<RoleMenuApi> queryMenu(Map<String, Object> map);

	void deleteByMap(Map<String, Object> map);

	void insertList(Map<String, Object> map);

}
