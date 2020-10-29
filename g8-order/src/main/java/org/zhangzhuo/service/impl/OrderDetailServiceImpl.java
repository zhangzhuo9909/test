package org.zhangzhuo.service.impl;

import org.zhangzhuo.entity.OrderDetail;
import org.zhangzhuo.mapper.OrderDetailMapper;
import org.zhangzhuo.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
