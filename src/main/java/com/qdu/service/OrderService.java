package com.qdu.service;

import com.qdu.bean.OrderVo;
import com.qdu.bean.Orders;
import com.qdu.bean.Page;

public interface OrderService {
    int addOrder(Orders order);

    Page<OrderVo> queryList(int pageNum,int pageSize,int uid);

    int updateOrderStatus(int status,int id);
}
