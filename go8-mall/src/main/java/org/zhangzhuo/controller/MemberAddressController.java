package org.zhangzhuo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.entity.MemberAddress;
import org.zhangzhuo.service.MemberAddressService;

import java.util.Objects;

/**
 * <p>
 * 会员配送地址表 前端控制器
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Controller
public class MemberAddressController {

    @Autowired
    private MemberAddressService memberAddressService;

    @GetMapping("/address")
    @ResponseBody
    public Object getAddress(Long memberID){
        try {
            MemberAddress memberAddress = memberAddressService.getAddress(memberID);
            return ServiceResponse.ok(memberAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    @ResponseBody
    @PostMapping("/address/add")
    public Object setAddressAdd(MemberAddress memberAddress){
        if(Objects.isNull(memberAddress)){
            return ServiceResponse.illegalArgs();
        }
        try {
            memberAddressService.setAddressAdd(memberAddress);
            return ServiceResponse.ok(memberAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
