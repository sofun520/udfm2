package cn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.TAuthUser;

@Controller
public class WebController {

	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin() {

		return new ModelAndView("adminLogin");

	}

	@RequestMapping("/admin/home")
	public ModelAndView adminHome(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		TAuthUser user = (TAuthUser) session.getAttribute("user");
		map.put("authUser", user);
		return new ModelAndView("admin/home", map);
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/mvc/home")
	public ModelAndView home(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		TAuthUser user = (TAuthUser) session.getAttribute("user");
		map.put("authUser", user);
		return new ModelAndView("home", map);
	}

}
