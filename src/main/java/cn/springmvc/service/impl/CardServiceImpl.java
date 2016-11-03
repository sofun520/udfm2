package cn.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.CardMapper;
import cn.springmvc.model.Card;
import cn.springmvc.service.CardService;

@Service
public class CardServiceImpl implements CardService
{

    @Autowired
    private CardMapper dao;

    @Override
    public int insert(Card t)
    {
        return dao.insert(t);
    }

    @Override
    public void update(Card t)
    {
        dao.update(t);
    }

    @Override
    public List<Card> query(Map<String, Object> map)
    {
        return dao.query(map);
    }

    @Override
    public void delete(Integer id)
    {
        dao.delete(id);
    }

    @Override
    public Card find(Integer id)
    {
        return dao.find(id);
    }

    @Override
    public int count(Map<String, Object> map)
    {
        return dao.count(map);
    }

}
