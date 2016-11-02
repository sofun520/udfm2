package cn.springmvc.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.model.TAttach;
import cn.springmvc.model.TEnum;
import cn.springmvc.service.MaxCodeService;
import cn.springmvc.service.TAttachService;
import cn.springmvc.service.TEnumService;
import cn.springmvc.util.DateUtils;
import cn.springmvc.util.SysConfig;

import com.alibaba.fastjson.JSONObject;

@Controller
public class AttachController implements ApplicationContextAware
{

    private ApplicationContext context;

    @Autowired
    private TAttachService service;

    @Autowired
    private MaxCodeService codeService;

    @Autowired
    private TEnumService enumService;

    public JSONObject query1()
    {
        JSONObject obj = new JSONObject();
        String path1 = System.getProperty("user.dir") + File.separator + "../webapps/upload/";
        File uploadFileDir = new File(path1);
        if (!uploadFileDir.exists())
        {
            uploadFileDir.mkdirs();
        }
        obj.put("path1", uploadFileDir);
        obj.put("fileExist", uploadFileDir.exists());

        return obj;
    }

    @RequestMapping("/admin/attach")
    public ModelAndView query()
    {
        Map<String, Object> context = new HashMap<String, Object>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eCode", "attachHost");
        TEnum tenum = enumService.query(map).get(0);
        List<TAttach> list = service.query(map);
        context.put("list", list);
        context.put("tenum", tenum);
        return new ModelAndView("admin/attach", context);
    }

    @RequestMapping(value = "/api/attach/upload")
    public ModelAndView upload(@RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request, ModelMap model)
    {
        SysConfig sysconfig = getConfig();
        String url = request.getParameter("url");
        String nowDate = DateUtils.getNowDate();

        // upload/20161101/IMG201611010001.jpg
        String path1 = System.getProperty("user.dir") + File.separator + sysconfig.getAttachDir() + File.separator
                + nowDate;
        File uploadFileDir = new File(path1);
        if (!uploadFileDir.exists())
        {
            uploadFileDir.mkdirs();
        }

        String fName = file.getOriginalFilename();
        String suffix = fName.substring(fName.lastIndexOf("."));
        String code = codeService.getCode("IM");
        TAttach tattach = new TAttach();
        tattach.settPath(nowDate);
        tattach.settName(code + suffix);
        service.insert(tattach);

        File targetFile = new File(uploadFileDir, code + suffix);
        if (!targetFile.exists())
        {
            targetFile.mkdirs();
        }
        else
        {
            System.out.println("存在");
            System.out.println(targetFile.delete());
            // targetFile.mkdirs();
        }
        // 保存
        try
        {
            file.transferTo(targetFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:" + url);
    }

    public SysConfig getConfig()
    {
        return context.getBean(SysConfig.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException
    {
        this.context = context;
    }

    public static void main(String[] args)
    {
        String fName = "231232.txt";
        String suffix = fName.substring(fName.lastIndexOf("."));
        System.out.println(suffix);
    }
}
