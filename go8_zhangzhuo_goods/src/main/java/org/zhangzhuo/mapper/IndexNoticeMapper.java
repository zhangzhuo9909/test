package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.IndexNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 首页公告表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface IndexNoticeMapper extends BaseMapper<IndexNotice> {

}
