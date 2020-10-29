package org.zhangzhuo.service;

import org.zhangzhuo.VO.AttributeVO;
import org.zhangzhuo.entity.Attribute;
import com.baomidou.mybatisplus.extension.service.IService;
import org.zhangzhuo.entity.AttributeValue;

import java.util.List;


/**
 * <p>
 * 商品属性表 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
public interface AttributeService extends IService<Attribute> {


    void getAddAttribute(Attribute attribute);

    List<AttributeVO> getAttributeList(AttributeVO attributeVO);
}
