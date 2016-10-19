package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {

	public int insert(T t);

	public void update(T t);

	public List<T> query(Map<String, Object> map);

	public void delete(Integer id);

	public T find(Integer id);

	public int count(Map<String, Object> map);

}
