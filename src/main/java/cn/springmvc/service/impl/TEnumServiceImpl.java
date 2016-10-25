package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.TEnumMapper;
import cn.springmvc.model.TEnum;
import cn.springmvc.service.TEnumService;

@Service
public class TEnumServiceImpl implements TEnumService {

	@Autowired
	private TEnumMapper dao;

	@Override
	public int insert(TEnum t) {
		return dao.insert(t);
	}

	@Override
	public void update(TEnum t) {
		dao.update(t);
	}

	@Override
	public List<TEnum> query(Map<String, Object> map) {
		return dao.query(map);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public TEnum find(Integer id) {
		return dao.find(id);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dao.count(map);
	}

}
