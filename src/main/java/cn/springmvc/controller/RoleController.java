package cn.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.TRole;
import cn.springmvc.service.TRoleService;

@Controller
public class RoleController {

	@Autowired
	private TRoleService service;

	@RequestMapping("/admin/role")
	public ModelAndView menu() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> context = new HashMap<String, Object>();
		List<TRole> list = service.query(map);
		context.put("list", list);
		return new ModelAndView("admin/role", context);
	}

	@RequestMapping("/admin/roleAdd")
	public ModelAndView add(TRole role) {
		try {
			role.setrDate(new Date());
			service.insert(role);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/role.do");
	}

}
