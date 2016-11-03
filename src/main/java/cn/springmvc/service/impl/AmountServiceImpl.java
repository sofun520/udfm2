package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.AmountMapper;
import cn.springmvc.model.Amount;
import cn.springmvc.service.AmountService;

@Service
public class AmountServiceImpl implements AmountService
{

    @Autowired
    private AmountMapper dao;

    @Override
    public int insert(Amount t)
    {
        return dao.insert(t);
    }

    @Override
    public void update(Amount t)
    {
        dao.update(t);
    }

    @Override
    public List<Amount> query(Map<String, Object> map)
    {
        return dao.query(map);
    }

    @Override
    public void delete(Integer id)
    {
        dao.delete(id);
    }

    @Override
    public Amount find(Integer id)
    {
        return dao.find(id);
    }

    @Override
    public int count(Map<String, Object> map)
    {
        return dao.count(map);
    }

}
