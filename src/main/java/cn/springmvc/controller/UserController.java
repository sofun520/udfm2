package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/query")
	@ResponseBody
	public JSONObject query() {

		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject data = new JSONObject();
		List<User> list = service.query(map);

		data.put("datas", list);

		return data;

	}

	@RequestMapping("/query2")
	public ModelAndView query2() {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> model = new HashMap<String, Object>();
		List<User> list = service.query(map);

		model.put("datas", list);
		model.put("name", "test");

		return new ModelAndView("query", model);

	}

	public static void main(String[] args) {

		String a = "{\"name\": \"qw\",\"id\": \"1\",\"sex\": \"3\",\"tel\": \"sdfdfwe3243\",\"fuck\": \"sdfd\"}";

		User u = JSONObject.toJavaObject(JSONObject.parseObject(a), User.class);

		System.out.println(u);

		int rows = 22;
		int pageSize = 5;
		int pageCount = (rows + pageSize - 1) / pageSize;
		System.out.println(pageCount);
		
		System.out.println(26/5);

	}
}
