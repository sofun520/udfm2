package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.TRoleMenuMapper;
import cn.springmvc.model.RoleMenuApi;
import cn.springmvc.model.TRoleMenu;
import cn.springmvc.service.TRoleMenuService;

@Service
public class TRoleMenuServiceImpl implements TRoleMenuService {

	@Autowired
	private TRoleMenuMapper dao;

	@Override
	public int insert(TRoleMenu t) {
		return dao.insert(t);
	}

	@Override
	public void update(TRoleMenu t) {
		dao.update(t);
	}

	@Override
	public List<TRoleMenu> query(Map<String, Object> map) {
		return dao.query(map);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public TRoleMenu find(Integer id) {
		return dao.find(id);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dao.count(map);
	}

	@Override
	public List<RoleMenuApi> queryMenu(Map<String, Object> map) {
		return dao.queryMenu(map);
	}

	@Override
	public void deleteByMap(Map<String, Object> map) {
		dao.deleteByMap(map);
	}

	@Override
	public void insertList(Map<String, Object> map) {
		dao.insertList(map);
	}

}
