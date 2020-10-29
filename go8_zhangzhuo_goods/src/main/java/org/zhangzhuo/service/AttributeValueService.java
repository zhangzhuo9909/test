package org.zhangzhuo.service;

import org.zhangzhuo.entity.AttributeValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品属性值表 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
public interface AttributeValueService extends IService<AttributeValue> {

    void getAddAttributeValue(AttributeValue value);

    List<AttributeValue> getAttributeList(Long aid);
}
