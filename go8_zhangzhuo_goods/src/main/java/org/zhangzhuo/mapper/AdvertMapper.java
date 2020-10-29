package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.Advert;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 广告表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface AdvertMapper extends BaseMapper<Advert> {

}
