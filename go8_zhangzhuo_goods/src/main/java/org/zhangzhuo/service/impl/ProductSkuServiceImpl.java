package org.zhangzhuo.service.impl;

import org.zhangzhuo.entity.ProductSku;
import org.zhangzhuo.entity.Sku;
import org.zhangzhuo.mapper.ProductSkuMapper;
import org.zhangzhuo.service.ProductSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品sku基本信息表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Service
public class ProductSkuServiceImpl extends ServiceImpl<ProductSkuMapper, ProductSku> implements ProductSkuService {

}
