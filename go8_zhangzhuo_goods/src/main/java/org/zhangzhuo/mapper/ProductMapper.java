package org.zhangzhuo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zhangzhuo.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.zhangzhuo.entity.ProductSku;

import java.util.List;

/**
 * <p>
 * 商品基本信息表（spu) Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    List<ProductSku> getProductSkulById(QueryWrapper<ProductSku> wrapper);
}
