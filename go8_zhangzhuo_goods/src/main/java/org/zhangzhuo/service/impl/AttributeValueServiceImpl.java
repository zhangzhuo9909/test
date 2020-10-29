package org.zhangzhuo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.zhangzhuo.entity.AttributeValue;
import org.zhangzhuo.mapper.AttributeValueMapper;
import org.zhangzhuo.service.AttributeValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商品属性值表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Service
public class AttributeValueServiceImpl extends ServiceImpl<AttributeValueMapper, AttributeValue> implements AttributeValueService {

    /**
     * 属性值的添加
     * @param value
     */
    @Override
    public void getAddAttributeValue(AttributeValue value) {
        value.setGmtCreate(new Date());
        value.setGmtModified(new Date());
        save(value);
    }

    @Override
    public List<AttributeValue> getAttributeList(Long aid) {
        QueryWrapper<AttributeValue> wrapper = new QueryWrapper<>();
        wrapper.eq("a.id",aid);
        return list(wrapper);
    }
}
