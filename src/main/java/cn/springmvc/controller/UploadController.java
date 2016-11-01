package cn.springmvc.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.util.SysConfig;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/api/file")
public class UploadController implements ApplicationContextAware
{

    private ApplicationContext context;

    @RequestMapping("/query")
    @ResponseBody
    public JSONObject query()
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

    @RequestMapping(value = "/upload")
    public ModelAndView upload(@RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request, ModelMap model)
    {
        SysConfig sysconfig = getConfig();

        System.out.println("============" + request.getParameter("dbName"));

        String path1 = System.getProperty("user.dir") + File.separator + sysconfig.getAttachDir();
        File uploadFileDir = new File(path1);
        if (!uploadFileDir.exists())
        {
            uploadFileDir.mkdirs();
        }

        String fName = file.getOriginalFilename();

        File targetFile = new File(uploadFileDir, fName);
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
        return new ModelAndView("redirect:../../mvc/test1/query1.do");
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
}
