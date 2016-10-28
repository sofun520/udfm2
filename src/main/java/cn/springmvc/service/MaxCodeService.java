package cn.springmvc.service;

import java.util.Map;

import cn.springmvc.model.MaxCode;

public interface MaxCodeService extends BaseService<MaxCode> {

	void queryCode(Map<String, Object> map);

	public String getCode(String prefix);

}
