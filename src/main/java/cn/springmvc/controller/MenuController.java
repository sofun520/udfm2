package cn.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.TMenu;
import cn.springmvc.response.ResponseData;
import cn.springmvc.service.TMenuService;
import cn.springmvc.util.Const;

@Controller
public class MenuController {

	@Autowired
	private TMenuService service;

	@RequestMapping("/admin/menu")
	public ModelAndView menu() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> context = new HashMap<String, Object>();
		List<TMenu> list = service.queryAll(map);
		List<TMenu> plist = service.query(map);
		context.put("list", list);
		context.put("plist", plist);

		return new ModelAndView("admin/menu", context);
	}

	@RequestMapping("/admin/menuAdd")
	public ModelAndView add(TMenu menu) {
		try {
			menu.setmDate(new Date());
			service.insert(menu);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/menu.do");
	}

	@RequestMapping("/admin/menuDel")
	public ModelAndView delete(HttpServletRequest request) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			service.delete(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/menu.do");
	}

	@RequestMapping("/api/menu/query")
	@ResponseBody
	public ResponseData getRootMenu(HttpServletRequest request) {
		ResponseData res = new ResponseData();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mType", request.getParameter("mType"));
			map.put("mParent", request.getParameter("mParent"));
			List<TMenu> list = service.query(map);
			res.setSuccess(Const.SUCCESS);
			res.setData(list);
		} catch (Exception ex) {
			ex.printStackTrace();
			res.setSuccess(Const.FAILED);
			res.setErrCode(Const.INNER_ERROR);
			res.setMessage(Const.getErrDes(Const.INNER_ERROR));
		}
		return res;
	}

}
