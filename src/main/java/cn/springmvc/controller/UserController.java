package cn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/query")
	@ResponseBody
	public JSONObject query() {

		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject data = new JSONObject();

		return data;

	}

	@RequestMapping("/query2")
	public ModelAndView query2() {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("name", "test");

		return new ModelAndView("query", model);

	}

	public static void main(String[] args) {

		String a = "{\"name\": \"qw\",\"id\": \"1\",\"sex\": \"3\",\"tel\": \"sdfdfwe3243\",\"fuck\": \"sdfd\"}";

		int rows = 22;
		int pageSize = 5;
		int pageCount = (rows + pageSize - 1) / pageSize;
		System.out.println(pageCount);

		System.out.println(26 / 5);

	}
}
