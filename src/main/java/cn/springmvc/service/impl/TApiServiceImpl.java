package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.TApiMapper;
import cn.springmvc.model.TApi;
import cn.springmvc.service.TApiService;

@Service
public class TApiServiceImpl implements TApiService {

	@Autowired
	private TApiMapper dao;

	@Override
	public int insert(TApi t) {
		return dao.insert(t);
	}

	@Override
	public void update(TApi t) {
		dao.update(t);
	}

	@Override
	public List<TApi> query(Map<String, Object> map) {
		return dao.query(map);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public TApi find(Integer id) {
		return dao.find(id);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dao.count(map);
	}

}
