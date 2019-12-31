package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.OrderVo;
import com.qdu.bean.Page;
import com.qdu.bean.ShopCarVo;
import com.qdu.mapper.ShopCarMapper;
import com.qdu.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    ShopCarMapper shopCarMapper;

    @Override
    public int add(int gid, int uid, int count) {
        return shopCarMapper.add(gid,uid,count);
    }

    @Override
    public Page<ShopCarVo> queryList(int pageNum, int pageSize, int uid) {
        PageHelper.startPage(pageNum,pageSize);
        List<ShopCarVo> list = shopCarMapper.queryList(uid);
        PageInfo<ShopCarVo> pageInfo = new PageInfo<>(list);
        Page<ShopCarVo> result = new Page<>(pageInfo.getPageNum(),
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
    public int delById(int carId) {
        return shopCarMapper.delById(carId);
    }
}
