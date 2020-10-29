package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.MemberAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员配送地址表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Mapper
public interface MemberAddressMapper extends BaseMapper<MemberAddress> {

}
