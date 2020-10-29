package org.zhangzhuo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zhangzhuo.VO.AttributeVO;
import org.zhangzhuo.entity.Attribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品属性表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface AttributeMapper extends BaseMapper<Attribute> {

    List<AttributeVO> getAttributeList(@Param("ew") QueryWrapper<AttributeVO> wrapper);

}
