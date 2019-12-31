package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.Goods;
import com.qdu.bean.OrderVo;
import com.qdu.bean.Orders;
import com.qdu.bean.Page;
import com.qdu.mapper.OrderMapper;
import com.qdu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public int addOrder(Orders orders) {
        return orderMapper.addOrder(orders);
    }

    @Override
    public Page<OrderVo> queryList(int pageNum,int pageSize,int uid) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderVo> list = orderMapper.queryList(uid);
        PageInfo<OrderVo> pageInfo = new PageInfo<>(list);
        Page<OrderVo> result = new Page<>(pageInfo.getPageNum(),
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
    public int updateOrderStatus(int status,int id) {
        return orderMapper.updateOrderStatus(status,id);
    }
}
