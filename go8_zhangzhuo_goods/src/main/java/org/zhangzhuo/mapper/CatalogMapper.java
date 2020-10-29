package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.Catalog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface CatalogMapper extends BaseMapper<Catalog> {

    List<Catalog> getSonById(Long pid);

    String getCode(String code);

    Catalog getToAddCatalogs(Catalog catalog);
}
