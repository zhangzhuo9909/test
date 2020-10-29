package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.OrderShip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 订单配送表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface OrderShipMapper extends BaseMapper<OrderShip> {

}
