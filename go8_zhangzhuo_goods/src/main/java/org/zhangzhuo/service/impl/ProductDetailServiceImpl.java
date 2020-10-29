package org.zhangzhuo.service.impl;

import org.zhangzhuo.entity.ProductDetail;
import org.zhangzhuo.mapper.ProductDetailMapper;
import org.zhangzhuo.service.ProductDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品详情表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Service
public class ProductDetailServiceImpl extends ServiceImpl<ProductDetailMapper, ProductDetail> implements ProductDetailService {

}
