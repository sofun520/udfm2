package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.TEnum;
import cn.springmvc.service.TEnumService;

@Controller
public class MsgComponent {

	@Autowired
	private TEnumService service;

	@RequestMapping("/admin/sms")
	public ModelAndView sms() {
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eCode", "SMS");
		List<TEnum> list = service.query(map);
		context.put("list", list);
		return new ModelAndView("admin/sms", context);
	}

	@RequestMapping("/admin/email")
	public ModelAndView email() {
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eCode", "EMAIL");
		List<TEnum> list = service.query(map);
		context.put("list", list);
		return new ModelAndView("admin/email", context);
	}

}
