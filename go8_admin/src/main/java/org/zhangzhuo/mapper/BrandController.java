package org.zhangzhuo.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.zhangzhuo.common.MysqlPageWrapper;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.config.PageResult;
import org.zhangzhuo.entity.Brand;
import org.zhangzhuo.service.BrandService;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 商品品牌表 前端控制器
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@RestController
@RequestMapping("/admin/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 分页查询方法加上模糊查询
     * @param page
     * @param size
     * @param brand
     * @return
     */
    @GetMapping
    public Object getBrandByPage(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "size",defaultValue = "10") Integer size,  Brand brand){
        //对传入的值直接进行判断 如果不和发直接返回一个参数异常
        if(page < 0 || size < 0 || page == null || size == null){
            return ServiceResponse.illegalArgs();
        }
        try {
            //封装一个page 对象
            MysqlPageWrapper<Brand> brandMysqlPageWrapper = new MysqlPageWrapper<>(page, size, brand);
            //传入到service层
            PageResult<Brand> brandByPage = brandService.getBrandByPage(brandMysqlPageWrapper);
            HashMap map = new HashMap<>();
            map.put("rows",brandByPage.getRecords());
            map.put("total",brandByPage.getTotal());
            return ServiceResponse.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 修改前的回显方法
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ServiceResponse<Brand> getReturenBrand(@PathVariable Long id){
        if (id == 0 || id == null){
            return ServiceResponse.illegalArgs();
        }
        try {
            Brand brand = brandService.getByBrandId(id);
            return ServiceResponse.ok(brand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 添加方法
     * @param brand
     * @return
     */
    @PostMapping
    public ServiceResponse<Object> getAddBrand(@RequestBody(required = true) Brand brand){
        if (Objects.nonNull(brand)){
            return ServiceResponse.illegalArgs();
        }
        try {
            brandService.getAddBrand(brand);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 真正的修改方法
     * @param brand
     * @return
     */
    @PutMapping("/{id}")
    public ServiceResponse<Object> getUpdateBrand(@RequestBody Brand brand){
        if(Objects.nonNull(brand)){
            return ServiceResponse.illegalArgs();
        }
        try {
            boolean updateBrand = brandService.getUpdateBrand(brand);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ServiceResponse.error();

        }
    }

    /**
     * 删除方法
     * @param ids
     * @return
     */
    @DeleteMapping
    public ServiceResponse getRemoveBrand(@RequestParam("ids") Integer[] ids){
//        for (Integer id : ids) {
//            System.out.println("id = " + id);
//        }
        if (ids.equals(null) || ids.length == 0){
            return ServiceResponse.illegalArgs();
        }
        try {
            brandService.getRemoveBrand(ids);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    @GetMapping("/select")
    public ServiceResponse getBrand(@RequestParam(value = "cid", required = false)Integer cid){
        try {
            List<Brand> list = brandService.getBrand(cid);
//            System.out.println(list);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
