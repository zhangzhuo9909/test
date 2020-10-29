package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.HotSearchKeyword;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 搜索热搜关键字 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface HotSearchKeywordMapper extends BaseMapper<HotSearchKeyword> {

}
