package cn.springmvc.dao;

import java.util.Map;

import cn.springmvc.model.MaxCode;

public interface MaxCodeMapper extends BaseMapper<MaxCode> {

	void queryCode(Map<String, Object> map);
}