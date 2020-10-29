package org.zhangzhuo.VO;


import org.zhangzhuo.entity.Order;
import org.zhangzhuo.entity.OrderDetail;
import org.zhangzhuo.entity.OrderShip;

import java.util.List;

/**
 * Auther :${Mr.zhang}
 * Time:2020/9/8
 */
public class OrderVo extends Order {
    private List<OrderDetail> orderDetails;

    private OrderShip orderShip;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrderShip getOrderShip() {
        return orderShip;
    }

    public void setOrderShip(OrderShip orderShip) {
        this.orderShip = orderShip;
    }
}
