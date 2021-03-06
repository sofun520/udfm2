package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.RoleMenuApi;
import cn.springmvc.model.TMenu;
import cn.springmvc.model.TRoleMenu;

public interface TRoleMenuMapper extends BaseMapper<TRoleMenu> {

	List<RoleMenuApi> queryMenu(Map<String, Object> map);

	void deleteByMap(Map<String, Object> map);

	void insertList(Map<String, Object> map);

	List<TMenu> roleMenu(Map<String, Object> map);
}