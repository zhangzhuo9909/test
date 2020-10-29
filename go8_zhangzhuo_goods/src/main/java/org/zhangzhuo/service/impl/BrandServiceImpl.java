package org.zhangzhuo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;
import org.zhangzhuo.common.MysqlPageWrapper;
import org.zhangzhuo.config.PageResult;
import org.zhangzhuo.entity.Brand;
import org.zhangzhuo.mapper.BrandMapper;
import org.zhangzhuo.service.BrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 商品品牌表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {
    /**
     * 分页查询加模糊查询的实现方法
     * @param brandMysqlPageWrapper
     * @return
     */
    @Override
    public PageResult<Brand> getBrandByPage(MysqlPageWrapper<Brand> brandMysqlPageWrapper) {
        Page<Brand> page = new Page<>(brandMysqlPageWrapper.getPage(), brandMysqlPageWrapper.getSize());
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        if(Objects.nonNull(brandMysqlPageWrapper.getT())){
            //从前台获取到cid 的值
            Long cid = brandMysqlPageWrapper.getT().getCid();
            if(cid != null){
                wrapper.eq("cid",cid);
            }
            //从前台获取cname 的值
            String cname = brandMysqlPageWrapper.getT().getCname();
            if(!StringUtils.isEmpty(cname)){
                wrapper.like("cname",cname);
            }
            //丛前台获取到ename 的值
            String ename = brandMysqlPageWrapper.getT().getEname();
            if(!StringUtils.isEmpty(ename)){
                wrapper.like("ename",ename);
            }
        }
        Page<Brand> brandPage = page(page, wrapper);
        return new PageResult<>(page.getRecords(),page.getTotal());
    }

    /**
     * 添加方法 无业务逻辑
     * @param brand
     */
    @Override
    public void getAddBrand(Brand brand) {
        brand.setGmtCreate(new Date());
        brand.setGmtModified(new Date());
        save(brand);
    }




    /**
     * 真正的的修改方法
     * @param brand
     * @return
     */
    @Override
    public boolean getUpdateBrand(Brand brand) {
        brand.setGmtModified(new Date());
        return updateById(brand);
    }

    /**
     * 修改的回显
     * @param id
     * @return
     */
    @Override
    public Brand getByBrandId(Long id) {
        Brand brand = getById(id);
        return brand;
    }

    /**
     * 删除的真正方法
     * @param ids
     * @return
     */
    @Override
    public boolean getRemoveBrand(Integer[] ids) {
        List<Integer> list = new ArrayList<>();
        for (Integer id : ids) {
            list.add(id);
        }
        return removeByIds(list);
    }

    /**
     * 品牌添加用户回显品牌列表
     * @param cid
     * @return
     */
    @Override
    public List<Brand> getBrand(Integer cid) {
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        wrapper.eq("cid",cid);
        return list(wrapper);
    }
}
