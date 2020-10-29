package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.Discount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 折扣 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface DiscountMapper extends BaseMapper<Discount> {

}
