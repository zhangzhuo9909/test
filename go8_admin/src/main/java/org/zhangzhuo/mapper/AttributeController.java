package org.zhangzhuo.mapper;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.zhangzhuo.VO.AttributeVO;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.entity.Attribute;
import org.zhangzhuo.service.AttributeService;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 商品属性表 前端控制器
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@RestController
@RequestMapping("/admin/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    /**
     * 查询方法
     * @param attributeVO
     * @return
     */
//    @ApiOperation(value = "",consumes = "application/json",produces = "application/json")
    @GetMapping("/list")
    public ServiceResponse getAttributeList(AttributeVO attributeVO){
        if(! Objects.nonNull(attributeVO)){
            return ServiceResponse.illegalArgs();
        }
        try {
            List<AttributeVO> list = attributeService.getAttributeList(attributeVO);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    @PostMapping("/add")
    public ServiceResponse getAddAttribute(@RequestBody Attribute attribute){
        if(!Objects.nonNull(attribute)){
            return ServiceResponse.illegalArgs();
        }
        try {
            attributeService.getAddAttribute(attribute);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }


}
