package org.zhangzhuo.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.zhangzhuo.VO.CataLogsVO;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.config.Result;
import org.zhangzhuo.entity.Catalog;
import org.zhangzhuo.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商品分类表 前端控制器
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@RestController
@RequestMapping("/admin")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;
    /*
        直接查询全部分类的全部内容
     */
    @GetMapping("/catalogs/all")
    public List<Catalog> getCataLogList(){
        return catalogService.getCataLogList();
    }

    /**
     * 查找节点 ,也就是查找catalog表里面pid为0,1,2的数据
     * @return
     */
    @GetMapping("/catalogs/sons")
    public Object getSons(Long pid){
        //传入数据进行判断 ,放置恶意攻击
        if(pid == null && pid < 0){
            return Result.error("参数异常,请重新尝试");
        }
        try {
            List<Catalog> catalogList = catalogService.getSonById(pid);
            ArrayList<CataLogsVO> cataLogsVOS = new ArrayList<>();
            catalogList.forEach(catalog->{
                CataLogsVO cataLogsVO = new CataLogsVO();
                cataLogsVO.setId(catalog.getId());
                cataLogsVO.setPid(catalog.getPid());

                cataLogsVO.setParent(catalog.getIsParent());
                cataLogsVO.setTitle(catalog.getName());
                cataLogsVOS.add(cataLogsVO);
            });
//            System.out.println(cataLogsVOS);
//            System.out.println(catalogList);
            return ServiceResponse.ok(cataLogsVOS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 判断code 的唯一性 ,就是在数据库查找前台传进来的数据是否存在
     */
    @GetMapping("/catalogs/code")
    public Object getCode(String code){
//        System.out.println(code);
        if(StringUtils.isEmpty(code)){
            return ServiceResponse.illegalArgs();
        }
        //进行查找code
        try {
            //获取到查询的 code
            code = catalogService.getCode(code);
//            System.out.println(code);
            return ServiceResponse.ok(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }


    /**
     * 真正的添加方法
     * 根据pid进行判断是否是父亲
     * 是父亲就修改
     * 然后保存
     * @param catalog
     * @return
     */
    @PostMapping("/catalogs")
    public ServiceResponse<Object> toAddCatalogs(@RequestBody Catalog catalog){

        try {
            catalogService.getToAddCatalogs(catalog);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }


    /**
     * 修改数据
     * @param catalog
     * @return
     */
    @PutMapping("/catalogs/{id}")
    public ServiceResponse getUpdateCatalog(@RequestBody Catalog catalog){
        try {
            catalogService.getToUpdate(catalog);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 修改回显方法
     * @return
     */
    @GetMapping("/catalogs/{id}")
    public ServiceResponse getUpdateBack(@PathVariable long id){
        try {
            Catalog catalog = catalogService.getById(id);
            return ServiceResponse.ok(catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 删除方法
     * @param id
     * @return
     */
    @DeleteMapping("/catalogs/{id}")
    public ServiceResponse<Object> getRemoveById(@PathVariable long id){
        try {
            catalogService.getRemoveById(id);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
