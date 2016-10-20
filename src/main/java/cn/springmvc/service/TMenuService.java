package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.TMenu;

public interface TMenuService extends BaseService<TMenu> {

	List<TMenu> queryAll(Map<String, Object> map);

}
