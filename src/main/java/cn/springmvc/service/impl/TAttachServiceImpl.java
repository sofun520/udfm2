package cn.springmvc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.TAttachMapper;
import cn.springmvc.model.TAttach;
import cn.springmvc.service.TAttachService;

@Service
public class TAttachServiceImpl implements TAttachService
{

    @Autowired
    private TAttachMapper dao;

    @Override
    public int insert(TAttach t)
    {
        t.settDate(new Date());
        return dao.insert(t);
    }

    @Override
    public void update(TAttach t)
    {
        dao.update(t);
    }

    @Override
    public List<TAttach> query(Map<String, Object> map)
    {
        return dao.query(map);
    }

    @Override
    public void delete(Integer id)
    {
        dao.delete(id);
    }

    @Override
    public TAttach find(Integer id)
    {
        return dao.find(id);
    }

    @Override
    public int count(Map<String, Object> map)
    {
        return dao.count(map);
    }

}
