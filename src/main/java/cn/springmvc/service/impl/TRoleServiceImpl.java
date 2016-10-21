package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.TRoleMapper;
import cn.springmvc.model.TRole;
import cn.springmvc.service.TRoleService;

@Service
public class TRoleServiceImpl implements TRoleService {

	@Autowired
	private TRoleMapper dao;

	@Override
	public int insert(TRole t) {
		return dao.insert(t);
	}

	@Override
	public void update(TRole t) {
		dao.update(t);
	}

	@Override
	public List<TRole> query(Map<String, Object> map) {
		return dao.query(map);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public TRole find(Integer id) {
		return dao.find(id);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dao.count(map);
	}

}
