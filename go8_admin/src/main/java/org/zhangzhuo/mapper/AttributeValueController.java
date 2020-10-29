package org.zhangzhuo.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.entity.AttributeValue;
import org.zhangzhuo.service.AttributeValueService;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 商品属性值表 前端控制器
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@RestController
@RequestMapping("/admin/attribute/value")
public class AttributeValueController {

    @Autowired
    private AttributeValueService attributeValueService;

    /**
     * 属性值的添加方法
     * @param value
     * @return
     */
    @PostMapping("/add")
    public ServiceResponse getAddAttributeValue(@RequestBody AttributeValue value){
        if(!Objects.nonNull(value)){
            return ServiceResponse.illegalArgs();
        }
        try {
            attributeValueService.getAddAttributeValue(value);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    @GetMapping("/list")
    public ServiceResponse getAttributeList(@RequestParam("aid") Long aid){
        if(aid == null && aid <= 0 ){
            return ServiceResponse.illegalArgs();
        }
        try {
            List<AttributeValue> list = attributeValueService.getAttributeList(aid);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
