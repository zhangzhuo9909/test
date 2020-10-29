package org.zhangzhuo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.entity.Member;
import org.zhangzhuo.service.MemberService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-09-01
 */
@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 注册方法
     * @param member
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public Object register(Member member){
        if(! Objects.nonNull(member)){
            return ServiceResponse.illegalArgs();
        }
        try {
            String token = memberService.register(member);
            Map<String, Object> map = new HashMap<>();
            map.put("token",token);
            return ServiceResponse.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }


    /**
     * 登录方法
     * @param member
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Object login(Member member){
        if(! Objects.nonNull(member)){
            return ServiceResponse.illegalArgs();
        }
        try {
            String token = memberService.login(member);
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            return ServiceResponse.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    @GetMapping("/info")
    public Object getInfo(String token){
        try {
            Member memberInfo = memberService.getMemberInfo(token);
            return ServiceResponse.ok(memberInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return ServiceResponse.error();
    }

    /**
     * 根据前台传入的id获取值并返回
     * @param member
     * @return
     */
    @GetMapping("/check")
    @ResponseBody
    public Object getCheck(Member member){
        if(!Objects.nonNull(member)){
            return ServiceResponse.illegalArgs();
        }
        try {
            Member mem = memberService.getCheck(member);
            return ServiceResponse.ok(mem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    @PostMapping("/logout")
    @ResponseBody
    public Object getLogout(String token){
        try {
            memberService.getLogout(token);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
