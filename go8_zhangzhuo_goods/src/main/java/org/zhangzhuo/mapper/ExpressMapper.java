package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.Express;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 快递配送表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface ExpressMapper extends BaseMapper<Express> {

}
