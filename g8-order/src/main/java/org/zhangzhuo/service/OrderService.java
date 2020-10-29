package org.zhangzhuo.service;

import org.zhangzhuo.VO.OrderVo;
import org.zhangzhuo.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import org.zhangzhuo.entity.OrderDetail;

/**
 * <p>
 * 订单主表 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
public interface OrderService extends IService<Order> {

    Order getByOrderId(Long id);

    OrderDetail getDetailById(Long orderId);

    void getAdd(OrderVo order);

}
