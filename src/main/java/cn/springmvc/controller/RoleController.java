package cn.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.TRole;
import cn.springmvc.service.TRoleService;
import cn.springmvc.util.PageComponent;

@Controller
public class RoleController
{

    @Autowired
    private TRoleService service;

    @RequestMapping("/admin/role")
    public ModelAndView menu(HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> context = new HashMap<String, Object>();

        int pageSize = 10;
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int total = service.count(map);
        PageComponent pc = new PageComponent(page, total);
        map.put("startIndex", (page - 1) * pageSize);
        map.put("pageSize", pageSize);

        List<TRole> list = service.query(map);
        context = pc.getContext();
        context.put("list", list);
        return new ModelAndView("admin/role", context);
    }

    @RequestMapping("/admin/roleAdd")
    public ModelAndView add(TRole role)
    {
        try
        {
            role.setrDate(new Date());
            service.insert(role);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return new ModelAndView("redirect:/admin/role.do");
    }

    @RequestMapping("/admin/roleDel")
    public ModelAndView roleDel(HttpServletRequest request)
    {
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            service.delete(id);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return new ModelAndView("redirect:/admin/role.do");
    }

}
