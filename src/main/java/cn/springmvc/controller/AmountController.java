package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.Amount;
import cn.springmvc.service.AmountService;

@Controller
@RequestMapping("/mvc/finance")
public class AmountController
{
    @Autowired
    private AmountService service;

    @RequestMapping("/amount")
    public ModelAndView query()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> context = new HashMap<String, Object>();
        List<Amount> list = service.query(map);
        context.put("list", list);
        return new ModelAndView("finance/amount", context);
    }
}
