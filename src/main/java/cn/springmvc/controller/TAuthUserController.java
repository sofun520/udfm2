package cn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.TAuthUser;
import cn.springmvc.service.TAuthUserService;
import cn.springmvc.util.Const;
import cn.springmvc.util.MD5Util;

import com.alibaba.fastjson.JSONObject;

@Controller
public class TAuthUserController {

	@Autowired
	private TAuthUserService service;

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject adminCheckLogin(TAuthUser user, HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("username", user.getUsername());
			map.put("password", MD5Util.md5(user.getPassword()));
			TAuthUser auser = service.checkLogin(map);
			if (auser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", auser);
				data.put("success", 0);
				data.put("message", "登陆成功");
			} else {
				data.put("success", 1);
				data.put("errCode", Const.WRONG_USER_OR_PASS);
				data.put("message", Const.getErrDes(Const.WRONG_USER_OR_PASS));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			data.put("errCode", Const.INNER_ERROR);
			data.put("message", Const.getErrDes(Const.INNER_ERROR));
		}
		return data;
	}

	@RequestMapping("/logout")
	public ModelAndView adminLogout(HttpServletRequest request) {
		String redirectUrl = request.getParameter("url");
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		session.invalidate();
		return new ModelAndView("redirect:" + redirectUrl);
	}

}
