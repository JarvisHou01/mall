package com.qdu.controller;

import com.qdu.bean.OrderVo;
import com.qdu.bean.Page;
import com.qdu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("to_list")
    public String to_list(){
        return "order/list";
    }

    /**
     * 查询订单
     * @param pageNum
     * @param pageSize
     * @param uid
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Page<OrderVo> list(@RequestParam(required = false,defaultValue = "1") int pageNum,
                              @RequestParam(required = false,defaultValue = "3") int pageSize,
                              @RequestParam int uid){
        //uid  为空的状态下，就是后台传过来的
        //     不为空的状态下，就是前台查询，也就是某个用户的订单
        return orderService.queryList(pageNum,pageSize,uid);
    }

    /**
     * 修改订单状态
     * 1.支付成功
     * 2.发货成功
     * 3.收货成功
     * @param status
     * @param id
     * @return
     */
    @RequestMapping("update")
    public String updateOrder(@RequestParam int status,@RequestParam int id){
        int res = orderService.updateOrderStatus(status,id);
        return "order/list";
    }

}