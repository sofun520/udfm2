package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mvc/test1")
public class Test1Controller {

	@RequestMapping("/query1")
	public ModelAndView query1() {
		return new ModelAndView("test1/query1");
	}

	@RequestMapping("/query2")
	public ModelAndView query2() {
		return new ModelAndView("test1/query2");
	}
}
