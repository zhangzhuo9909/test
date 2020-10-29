package org.zhangzhuo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.zhangzhuo.common.util.UUIDUtils;
import org.zhangzhuo.entity.Member;
import org.zhangzhuo.mapper.MemberMapper;
import org.zhangzhuo.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zhangzhuo.token.TokenCache;

import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private TokenCache tokenCache;


    /**
     * 登录的实现类
     * @param member
     * @return
     */
    @Override
    public String register(Member member) {
        member.setGmtCreate(new Date());
        member.setGmtModified(new Date());
        boolean save = save(member);
        if(save){
            String uuid = UUIDUtils.getUUID();
            tokenCache.getTokens().put(uuid, member);
            return uuid;
        }
        return null;

    }

    /**
     * 登录实现类
     * @param member
     * @return
     */
    @Override
    public String login(Member member) {
        Member mem = this.baseMapper.getUserNameAndPassword(member);
        //不为空则进行
        if(! Objects.nonNull(mem)){
            String uuid = UUIDUtils.getUUID();
            tokenCache.getTokens().put(uuid, mem);
            System.out.println(uuid);
            return uuid;
        }else {
            return null;
        }
    }

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    @Override
    public Member getMemberInfo(String token) {
        Object member = tokenCache.getTokens().get(token);
        if(! Objects.nonNull(member)){
            return (Member) member;
        }
        return null;
    }

    /**
     * 根据id获取
     * @param member
     * @return
     */
    @Override
    public Member getCheck(Member member) {
        return getById(member.getId());
    }
    @Override
    public void getLogout(String token) {
        tokenCache.getTokens().get(token);
    }
}
