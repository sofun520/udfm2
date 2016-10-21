package cn.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cn.springmvc.model.TApi;
import cn.springmvc.service.TApiService;

@Controller
public class ApiController {

	@Autowired
	private TApiService service;

	@RequestMapping("/admin/api")
	public ModelAndView menu() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> context = new HashMap<String, Object>();
		try {
			List<TApi> list = service.query(map);
			context.put("list", list);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("admin/api", context);
	}

	@RequestMapping("/admin/apiAdd")
	public ModelAndView add(TApi api) {
		try {
			api.setaDate(new Date());
			service.insert(api);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/api.do");
	}

}
