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

import cn.springmvc.model.Amount;
import cn.springmvc.model.Card;
import cn.springmvc.model.TEnum;
import cn.springmvc.response.ResponseData;
import cn.springmvc.service.AmountService;
import cn.springmvc.service.CardService;
import cn.springmvc.service.TEnumService;
import cn.springmvc.util.Const;

@Controller
public class AmountController
{
    @Autowired
    private AmountService service;

    @Autowired
    private TEnumService enumService;

    @Autowired
    private CardService cardService;

    @RequestMapping("/mvc/finance/amount")
    public ModelAndView query()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> context = new HashMap<String, Object>();

        map.put("eCode", "AMOUNTTYPE");
        List<TEnum> enumList = enumService.query(map);

        map.put("eCode", "PAYWAYS");
        List<TEnum> enumList2 = enumService.query(map);

        List<Card> cardList = cardService.query(map);

        List<Amount> list = service.query(map);
        context.put("list", list);
        context.put("enumList", enumList);
        context.put("enumList2", enumList2);
        context.put("cardList", cardList);
        return new ModelAndView("finance/amount", context);
    }

    @RequestMapping("/mvc/finance/amountInsert")
    public ModelAndView insert(Amount amount)
    {
        if (!StringUtils.isEmpty(amount.getaId()))
        {
            service.update(amount);
        }
        else
        {
            amount.setaDate(new Date());
            service.insert(amount);
        }
        return new ModelAndView("redirect:amount.do");
    }

    @RequestMapping("/mvc/finance/amountDel")
    public ModelAndView amountDel(HttpServletRequest request)
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
        return new ModelAndView("redirect:amount.do");
    }

    // ==================api=========
    @RequestMapping("/api/finance/update")
    @ResponseBody
    public ResponseData apiInsert(Amount amount)
    {
        ResponseData re = new ResponseData();
        try
        {
            if (!StringUtils.isEmpty(amount.getaId()))
            {
                service.update(amount);
            }
            else
            {
                amount.setaDate(new Date());
                service.insert(amount);
            }
            re.setData(null);
            re.setSuccess(0);
            re.setMessage("操作成功");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            re.setData(null);
            re.setSuccess(1);
            re.setErrCode(Const.INNER_ERROR);
            re.setMessage(Const.getErrDes(Const.INNER_ERROR));
        }
        return re;
    }

    @RequestMapping("/api/finance/query")
    @ResponseBody
    public ResponseData apiQuery()
    {
        ResponseData re = new ResponseData();
        try
        {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Amount> list = service.query(map);
            re.setData(list);
            re.setSuccess(0);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            re.setData(null);
            re.setSuccess(1);
            re.setErrCode(Const.INNER_ERROR);
            re.setMessage(Const.getErrDes(Const.INNER_ERROR));
        }
        return re;
    }
}
