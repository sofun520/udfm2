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

import cn.springmvc.model.TApi;
import cn.springmvc.service.TApiService;
import cn.springmvc.util.PageComponent;

@Controller
public class ApiController
{

    @Autowired
    private TApiService service;

    @RequestMapping("/admin/api")
    public ModelAndView menu(HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> context = new HashMap<String, Object>();
        try
        {
            int pageSize = 10;
            int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
            int total = service.count(map);
            PageComponent pc = new PageComponent(page, total);
            map.put("startIndex", (page - 1) * pageSize);
            map.put("pageSize", pageSize);

            List<TApi> list = service.query(map);
            context = pc.getContext();
            context.put("list", list);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return new ModelAndView("admin/api", context);
    }

    @RequestMapping("/admin/apiAdd")
    public ModelAndView add(TApi api)
    {
        try
        {
            api.setaDate(new Date());
            service.insert(api);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return new ModelAndView("redirect:/admin/api.do");
    }

}
