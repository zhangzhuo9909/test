package org.zhangzhuo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.StringUtils;
import org.zhangzhuo.VO.AttributeVO;
import org.zhangzhuo.entity.Attribute;
import org.zhangzhuo.entity.AttributeValue;
import org.zhangzhuo.mapper.AttributeMapper;
import org.zhangzhuo.service.AttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 商品属性表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Service
public class AttributeServiceImpl extends ServiceImpl<AttributeMapper, Attribute> implements AttributeService {


    /**
     * 添加属性
     * @param attribute
     */
    @Override
    public void getAddAttribute(Attribute attribute) {
        attribute.setGmtModified(new Date());
        attribute.setGmtCreate(new Date());
        save(attribute);
    }

    /**
     * 查询全部属性数据
     * @param attributeVO
     * @return
     */
    @Override
    public List<AttributeVO> getAttributeList(AttributeVO attributeVO) {
        // 创建条件构造器
        QueryWrapper<AttributeVO> wrapper = new QueryWrapper<>();
        // cid
        Long cid = attributeVO.getCid();
        if(!(StringUtils.isEmpty(cid) && cid <= 0)){
            wrapper.eq("cid",cid);
        }
        // 获取类型
        Integer type = attributeVO.getType();
        if(!(StringUtils.isEmpty(type) && (type != 1 || type != 2))){
            wrapper.eq("type",type);
        }
        // 分组
//        wrapper.groupBy("id");
        return baseMapper.getAttributeList(wrapper);
    }

}
