package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.TMenuMapper;
import cn.springmvc.model.TMenu;
import cn.springmvc.service.TMenuService;

@Service
public class TMenuServiceImpl implements TMenuService {

	@Autowired
	private TMenuMapper dao;

	@Override
	public int insert(TMenu t) {
		return dao.insert(t);
	}

	@Override
	public void update(TMenu t) {
		dao.update(t);
	}

	@Override
	public List<TMenu> query(Map<String, Object> map) {
		return dao.query(map);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public TMenu find(Integer id) {
		return dao.find(id);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dao.count(map);
	}

	@Override
	public List<TMenu> queryAll(Map<String, Object> map) {
		return dao.queryAll(map);
	}


}
