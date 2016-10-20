package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.TAuthUserMapper;
import cn.springmvc.model.TAuthUser;
import cn.springmvc.service.TAuthUserService;

@Service
public class TAuthUserServiceImpl implements TAuthUserService {

	@Autowired
	private TAuthUserMapper dao;

	@Override
	public int insert(TAuthUser t) {
		return dao.insert(t);
	}

	@Override
	public void update(TAuthUser t) {
		dao.update(t);
	}

	@Override
	public List<TAuthUser> query(Map<String, Object> map) {
		return dao.query(map);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public TAuthUser find(Integer id) {
		return dao.find(id);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dao.count(map);
	}

	@Override
	public TAuthUser checkLogin(Map<String, Object> map) {
		return dao.checkLogin(map);
	}

}
