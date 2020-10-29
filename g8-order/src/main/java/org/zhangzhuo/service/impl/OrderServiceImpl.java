package org.zhangzhuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.zhangzhuo.VO.OrderVo;
import org.zhangzhuo.entity.Order;
import org.zhangzhuo.entity.OrderDetail;
import org.zhangzhuo.mapper.OrderMapper;
import org.zhangzhuo.service.OrderDetailService;
import org.zhangzhuo.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 订单主表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderDetailService orderDetailService;

    //根据id获取订单信息
    @Override
    public Order getByOrderId(Long id) {
        return getById(id);
    }

    //根据orderid获取详细信息
    @Override
    public OrderDetail getDetailById(Long orderId) {
        return orderDetailService.getById(orderId);
    }

    //添加订单信息
    @Override
    public void getAdd(OrderVo orderVo) {
        orderVo.setGmtCreate(new Date());
        orderVo.setGmtModified(new Date());
        orderVo.setStatus(1);
        save(orderVo);

        List<OrderDetail> orderDetails = orderVo.getOrderDetails();

        for (int i = 0 ;i < orderDetails.size(); i++){
            orderDetails.get(i).setOrderId(orderVo.getId());
            save(orderDetails.get(i));
        }
        orderVo.getOrderShip().setOrderId(orderVo.getId());
        orderVo.getOrderShip().setGmtCreate(new Date());
        orderVo.getOrderShip().setGmtModified(new Date());
        save(orderVo.getOrderShip());
    }
}
