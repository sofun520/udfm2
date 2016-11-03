package cn.springmvc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.Card;
import cn.springmvc.model.TEnum;
import cn.springmvc.service.CardService;
import cn.springmvc.service.TEnumService;

@Controller
@RequestMapping("/mvc/finance")
public class CardController
{
    @Autowired
    private CardService service;

    @Autowired
    private TEnumService enumService;

    @RequestMapping("/card")
    public ModelAndView query()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> context = new HashMap<String, Object>();
        map.put("eCode", "CARDTYPE");
        List<TEnum> enumList = enumService.query(map);
        map.put("eCode", "BANK");
        List<TEnum> enumList2 = enumService.query(map);
        List<Card> list = service.query(map);
        context.put("list", list);
        context.put("enumList", enumList);
        context.put("enumList2", enumList2);
        return new ModelAndView("finance/card", context);
    }

    @RequestMapping("/cardInsert")
    public ModelAndView insert(Card card)
    {
        if (!StringUtils.isEmpty(card.getcId()))
        {
            service.update(card);
        }
        else
        {
            card.setcDate(new Date());
            service.insert(card);
        }
        return new ModelAndView("redirect:card.do");
    }
}
