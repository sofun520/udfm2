package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleConfigController {

	@RequestMapping("/admin/roleConfig")
	public ModelAndView menu() {
		return new ModelAndView("admin/roleConfig");
	}

}
