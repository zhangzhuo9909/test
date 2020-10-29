package org.zhangzhuo.service.impl;

import org.zhangzhuo.entity.MemberAddress;
import org.zhangzhuo.mapper.MemberAddressMapper;
import org.zhangzhuo.service.MemberAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会员配送地址表 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Service
public class MemberAddressServiceImpl extends ServiceImpl<MemberAddressMapper, MemberAddress> implements MemberAddressService {

    @Override
    public MemberAddress getAddress(Long memberID) {
        return getById(memberID);
    }

    @Override
    public void setAddressAdd(MemberAddress memberAddress) {
        if(memberAddress.getIsDefault()){

        }
    }
}
