package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.Goods;
import com.qdu.bean.Page;
import com.qdu.mapper.GoodsMapper;
import com.qdu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public Page<Goods> queryList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsMapper.queryList();
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        Page<Goods> result = new Page<>(pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                pageInfo.getList(),
                pageInfo.getTotal(),
                pageInfo.getPages(),
                pageInfo.getPrePage(),
                pageInfo.getNextPage(),
                pageInfo.isIsFirstPage(),
                pageInfo.isIsLastPage());
        return result;
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int changeStatus(int id, int status) {
        status = status==1?0:1;
        return goodsMapper.changeStatus(id,status);
    }

    @Override
    public Page<Goods> queryListByTag(int pageNum, int pageSize, String category, String name, int status) {
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsMapper.queryListByTag(category,name,status);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        Page<Goods> result = new Page<>(pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                pageInfo.getList(),
                pageInfo.getTotal(),
                pageInfo.getPages(),
                pageInfo.getPrePage(),
                pageInfo.getNextPage(),
                pageInfo.isIsFirstPage(),
                pageInfo.isIsLastPage());
        return result;
    }

    @Override
    public Goods queryGoodsById(int id) {
        return goodsMapper.queryGoodsById(id);
    }
}
