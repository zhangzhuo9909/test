package org.zhangzhuo.service;

import org.zhangzhuo.common.MysqlPageWrapper;
import org.zhangzhuo.config.PageResult;
import org.zhangzhuo.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品品牌表 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
public interface BrandService extends IService<Brand> {

    PageResult<Brand> getBrandByPage(MysqlPageWrapper<Brand> brandMysqlPageWrapper);

    void getAddBrand(Brand brand);

    boolean getUpdateBrand(Brand brand);

    Brand getByBrandId(Long id);

    boolean getRemoveBrand(Integer[] ids);

    List<Brand> getBrand(Integer cid);
}
