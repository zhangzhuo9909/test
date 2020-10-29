package org.zhangzhuo.service;

import org.zhangzhuo.entity.MemberAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会员配送地址表 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
public interface MemberAddressService extends IService<MemberAddress> {


    void setAddressAdd(MemberAddress memberAddress);

    MemberAddress getAddress(Long memberID);
}
