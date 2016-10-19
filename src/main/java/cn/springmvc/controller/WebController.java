package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
public class WebController {

	@RequestMapping("/login")
	public ModelAndView query2() {

		return new ModelAndView("login");

	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject checkLogin() {
		JSONObject data = new JSONObject();
		try {
			data.put("success", 0);
			data.put("message", "登陆成功");
		} catch (Exception ex) {
			ex.printStackTrace();
			data.put("success", 1);
			data.put("message", "内部程序错误");
		}
		return data;
	}

	@RequestMapping("/home")
	public ModelAndView home() {

		return new ModelAndView("login");

	}

}
