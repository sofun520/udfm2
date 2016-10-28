package cn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.service.MaxCodeService;

import com.alibaba.fastjson.JSONObject;

@Controller
public class MaxCodeController {

	@Autowired
	private MaxCodeService service;

	@RequestMapping(value = "/api/code/query", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject apiquery(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prefix", request.getParameter("code"));
		map.put("xcode", "");
		service.queryCode(map);
		data.put("code", map.get("xcode"));
		return data;
	}

}
