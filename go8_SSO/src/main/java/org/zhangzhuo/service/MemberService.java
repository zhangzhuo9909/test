package org.zhangzhuo.service;

import org.zhangzhuo.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
public interface MemberService extends IService<Member> {

    //注册
    String register(Member member);
    //登录
    String login(Member member);

    Member getMemberInfo(String token);

    Member getCheck(Member member);

    void getLogout(String token);
}
