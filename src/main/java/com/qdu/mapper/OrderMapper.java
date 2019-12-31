package com.qdu.mapper;

import com.qdu.bean.OrderVo;
import com.qdu.bean.Orders;

import java.util.List;

public interface OrderMapper {
    int addOrder(Orders order);

    List<OrderVo> queryList(int uid);

    int updateOrderStatus(int status,int id);
}
