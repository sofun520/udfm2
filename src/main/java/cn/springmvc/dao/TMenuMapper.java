package cn.springmvc.dao;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.TMenu;

public interface TMenuMapper extends BaseMapper<TMenu> {

	List<TMenu> queryAll(Map<String, Object> map);
}