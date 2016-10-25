package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.RoleMenuApi;
import cn.springmvc.model.TMenu;
import cn.springmvc.model.TRoleMenu;
import cn.springmvc.response.ResponseData;
import cn.springmvc.service.TRoleMenuService;
import cn.springmvc.util.Const;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class RoleMenuController {

	@Autowired
	private TRoleMenuService service;

	@RequestMapping("/admin/roleConfig")
	public ModelAndView menu() {
		return new ModelAndView("admin/roleConfig");
	}

	@RequestMapping(value = "/admin/roleMenu", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryMenu(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("roleId", request.getParameter("roleId"));
			List<RoleMenuApi> list = service.queryMenu(map);
			data.put("data", list);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

	@RequestMapping(value = "/admin/addRoleMenu", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addRoleMenu(HttpServletRequest request) {

		JSONObject data = new JSONObject();
		try {
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			String rmMenuIds = request.getParameter("rmMenuIds");
			System.out.println(rmMenuIds);
			String[] menuIds = rmMenuIds.split(",");
			JSONArray roleMenuLsit = new JSONArray();
			TRoleMenu menu = null;
			if (StringUtils.isEmpty(rmMenuIds)) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("roleId", roleId);
				map.put("roleMenuLsit", roleMenuLsit);
				service.deleteByMap(map);
			} else {
				if (menuIds.length > 0) {
					for (String s : menuIds) {
						menu = new TRoleMenu();
						menu.setRaRoleId(roleId);
						menu.setRaMenuId(Integer.parseInt(s));
						roleMenuLsit.add(menu);
					}
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("roleId", roleId);
				map.put("roleMenuLsit", roleMenuLsit);

				service.deleteByMap(map);
				service.insertList(map);
			}

			data.put("success", "0");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

	@RequestMapping("/api/roleMenu/query")
	@ResponseBody
	public ResponseData getRootMenu(HttpServletRequest request) {
		ResponseData res = new ResponseData();
		try {
			if (!StringUtils.isEmpty(request.getParameter("roleId"))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("mType", request.getParameter("mType"));
				map.put("mParent", request.getParameter("mParent"));
				map.put("roleId", request.getParameter("roleId"));
				List<TMenu> list = service.roleMenu(map);
				res.setSuccess(Const.SUCCESS);
				res.setData(list);
			} else {
				res.setSuccess(Const.FAILED);
				res.setErrCode(Const.INNER_ERROR);
				res.setMessage(Const.getErrDes(Const.INNER_ERROR));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			res.setSuccess(Const.FAILED);
			res.setErrCode(Const.INNER_ERROR);
			res.setMessage(Const.getErrDes(Const.INNER_ERROR));
		}
		return res;
	}
}
