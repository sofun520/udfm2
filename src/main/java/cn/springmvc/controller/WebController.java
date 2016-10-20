package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin() {

		return new ModelAndView("adminLogin");

	}

	@RequestMapping("/admin/home")
	public ModelAndView adminHome() {

		return new ModelAndView("admin/home");

	}

}
