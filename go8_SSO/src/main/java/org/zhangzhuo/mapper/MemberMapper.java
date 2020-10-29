package org.zhangzhuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhangzhuo.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {


    Member getUserNameAndPassword(Member member);
}
