package cn.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.TEnum;
import cn.springmvc.response.ResponseData;
import cn.springmvc.service.TEnumService;
import cn.springmvc.util.Const;

@Controller
public class EnumController {

	@Autowired
	private TEnumService service;

	@RequestMapping("/admin/enum")
	public ModelAndView sms() {
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("eCode", "SMS");
		List<TEnum> list = service.query(map);
		context.put("list", list);
		return new ModelAndView("admin/enum", context);
	}

	@RequestMapping("/admin/enumAdd")
	public ModelAndView enumAdd(TEnum tenum) {
		try {
			if (!StringUtils.isEmpty(tenum.geteId())) {
				service.update(tenum);
			} else {
				tenum.seteDate(new Date());
				service.insert(tenum);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/enum.do");
	}

	@RequestMapping("/admin/enumDel")
	public ModelAndView enumDel(HttpServletRequest request) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			service.delete(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/enum.do");
	}

	@RequestMapping("/api/enum/find")
	@ResponseBody
	public ResponseData apifind(HttpServletRequest request) {
		ResponseData rd = new ResponseData();
		try {
			TEnum tenum = service.find(Integer.parseInt(request
					.getParameter("id")));
			rd.setSuccess(0);
			rd.setData(tenum);
		} catch (Exception ex) {
			ex.printStackTrace();
			rd.setSuccess(1);
			rd.setErrCode(Const.INNER_ERROR);
			rd.setMessage(Const.getErrDes(Const.INNER_ERROR));
		}
		return rd;
	}

}
