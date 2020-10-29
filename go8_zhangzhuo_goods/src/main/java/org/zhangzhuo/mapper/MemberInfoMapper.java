package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.MemberInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员基本信息表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Mapper
public interface MemberInfoMapper extends BaseMapper<MemberInfo> {

}
