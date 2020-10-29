package org.zhangzhuo.service;

import org.zhangzhuo.entity.Catalog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
public interface CatalogService extends IService<Catalog> {

    //查询所有的数据
    List<Catalog> getCataLogList();

    //根据id查找catalog里面的数据
    List<Catalog> getSonById(Long pid);

    //查找 code
    String getCode(String code);

    void getToAddCatalogs(Catalog catalog);

    void getToUpdate(Catalog catalog);

    void getRemoveById(long id);

    List<Catalog> getCatalogsAll(Long pid);
}
