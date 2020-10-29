package org.zhangzhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.zhangzhuo.VO.OrderVo;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.entity.Order;
import org.zhangzhuo.entity.OrderDetail;

/**
 * Auther :${Mr.zhang}
 * Time:2020/9/8
 */
@Controller
public class OrderController {
    @Autowired
    private org.zhangzhuo.service.OrderService OrderService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据id获取订单的信息
     * @param id
     * @return
     */
    @GetMapping("/order/{id}")
    public Object getById(@PathVariable Long id){
        try {
            Order order = OrderService.getByOrderId(id);
            return ServiceResponse.ok(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 根据接口传入的orderid 获取订单的详细信息
     * @param orderId
     * @return
     */
    @GetMapping("/order/{orderId}/detail")
    public Object getDetailById(@PathVariable Long orderId){
        try {
            OrderDetail orderDetail = OrderService.getDetailById(orderId);
            return ServiceResponse.ok(orderDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    @PostMapping("/order/add")
    public Object getAdd(@RequestBody OrderVo order){
        try {
            OrderService.getAdd(order);
            return ServiceResponse.ok(order.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
