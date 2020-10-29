package org.zhangzhuo.service.impl;

import org.zhangzhuo.entity.OrderPay;
import org.zhangzhuo.mapper.OrderPayMapper;
import org.zhangzhuo.service.OrderPayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单支付流水表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Service
public class OrderPayServiceImpl extends ServiceImpl<OrderPayMapper, OrderPay> implements OrderPayService {

}
