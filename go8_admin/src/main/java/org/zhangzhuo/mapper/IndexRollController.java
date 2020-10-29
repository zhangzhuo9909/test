package org.zhangzhuo.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.zhangzhuo.entity.IndexRoll;
import org.zhangzhuo.service.IndexRollService;
import org.zhangzhuo.common.service.ServiceResponse;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 首页轮播图 前端控制器
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@RestController
@RequestMapping("/admin/indexroll")
public class IndexRollController {

    @Autowired
    private IndexRollService indexRollService;
    /**
     * 获取indexroll表的全部数据
     * @return
     */
    @GetMapping
    public ServiceResponse getIndexRoll(){
        try {
            List<IndexRoll> list= indexRollService.getIndexRoll();
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 添加方法
     * @param indexRoll
     * @return
     */
    @PostMapping
    public ServiceResponse getSaveIndexRoll(@RequestBody IndexRoll indexRoll){
        if(!Objects.nonNull(indexRoll)){
            return ServiceResponse.illegalArgs();
        }
        try {
            indexRollService.getSaveIndexRoll(indexRoll);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    @PutMapping
    public ServiceResponse getUpdateIndexRoll(@RequestBody IndexRoll indexRoll){
        if(!Objects.nonNull(indexRoll)){
            return ServiceResponse.illegalArgs();
        }
        try {
            indexRollService.getUpdateIndexRoll(indexRoll);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping
    public ServiceResponse getRemoveIndexRoll(@RequestParam("id") Long id){
        if(StringUtils.isEmpty(id) || id < 0){
            return ServiceResponse.illegalArgs();
        }
        try {
            indexRollService.getRemoveIndexRoll(id);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
