package org.zhangzhuo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.springframework.util.StringUtils;
import org.zhangzhuo.entity.Catalog;
import org.zhangzhuo.mapper.CatalogMapper;
import org.zhangzhuo.service.CatalogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Service
public class CatalogServiceImpl extends ServiceImpl<CatalogMapper, Catalog> implements CatalogService {

    @Override
    public List<Catalog> getCataLogList() {
        return list();
    }

    /**
     *
     * @param pid
     * @return
     */
    @Override
    public List<Catalog> getSonById(Long pid) {
        return this.baseMapper.getSonById(pid);
    }

    @Override
    public String getCode(String code) {
        String catalog = this.baseMapper.getCode(code);
        return catalog;
    }

    @Override
    public void getToAddCatalogs(Catalog catalog) {
        Catalog catlog = getById(catalog.getPid());
        catalog.setGmtCreate(new Date());
        catalog.setGmtModified(new Date());
        if(Objects.nonNull(catlog)){
            //是否是父亲
            catlog.setIsParent(true);
            updateById(catlog);
        }
        //保存方法
        save(catalog);
    }

    /**
     * 真正的修改方法
     * @param catalog
     */
    @Override
    public void getToUpdate(Catalog catalog) {
            catalog.setGmtModified(new Date());
            catalog.setGmtCreate(new Date());
            catalog.setIsParent(true);
            updateById(catalog);
    }

    /**
     * 删除方法实现类
     * @param id
     */
    @Override
    public void getRemoveById(long id) {
        //创建一个空的long类型list  用户存放前台传进来的数据
        ArrayList<Long> list = new ArrayList<>();
        //先把前台传进来的id放进list
        list.add(id);
        //获取这个id 的一条数据
        Catalog catalog = getById(id);
        //判断是否是父节点
        if(catalog.getIsParent()){
            //调用递归方法 把父节点和子节点的id放进去
            getReturn(list,id);
        }
        //通过遍历的方式 将id遍历并删除
        list.forEach(cartId->{
            removeById(cartId);
        });
        //接下来要判断是否是父节点
        Catalog cat = getById(catalog.getPid());
        //如果不为空就是父节点了
        if(Objects.nonNull(cat)){
            //获取到这条数据的id
            Long pid = cat.getId();
            //根据id获取到这条数据
            List<Catalog> catalogList = getSonById(pid.longValue());
            //如果这条数据存在
            if(Objects.nonNull(catalogList)){
                //把这条数据的父节点设置为false
                cat.setIsParent(false);
                //把他修改到数据库,也就是让这条数据不再是父节点数据
                updateById(cat);
            }
        }
    }

    @Override
    public List<Catalog> getCatalogsAll(Long pid) {
        List<Catalog> sonById = getSonById(pid);
        for (Catalog catalog : sonById) {
            if(catalog.getIsParent()){
                //递归调用
                List<Catalog> list = getCatalogsAll(catalog.getId());
                catalog.setChildren(list);
            }
        }
        return sonById;
    }

    /**
     * 递归方法用于删除
     * @param list
     * @param id
     */
    private void getReturn(ArrayList<Long> list,long id){
        //首先是根据传进来的数据去查询数据库  并放进去list里面
        List<Catalog> catalogList = getSonById(id);
        //如果这条数据存在
        if(Objects.nonNull(catalogList)){
            //就将数据遍历出来
            catalogList.forEach(catalog -> {
                //获取到id
                long ids = catalog.getId();
                //将它放进list里面
                list.add(ids);
                //调用自身
                getReturn(list,ids);
            });
        }
    }
}