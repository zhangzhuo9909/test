package org.zhangzhuo.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.common.util.JsonUtils;
import org.zhangzhuo.entity.Cart;
import org.zhangzhuo.service.CartService;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 跳转页面
     * @return
     */
    @GetMapping("/cart.html")
    public String getCart(){
        return "cart";
    }

    /**
     * 合并购物车
     * @param userId
     * @param cart
     * @return
     */
    @PostMapping("/cart/sync")
    @ResponseBody
    public Object setCartSync(Long userId,String cart){
        if(userId <= 0  && StringUtils.isEmpty(cart)){
            return ServiceResponse.illegalArgs();
        }
        try {
            List<Cart> carts = JsonUtils.jsonToList(cart, new TypeReference<List<Cart>>() {});
            List<Cart> list = cartService.setCartSync(carts,userId);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }


    @PostMapping("/cart/remove")
    @ResponseBody
    public ServiceResponse setRemove(Long userId,String ids){
        if(userId <= 0 || StringUtils.isEmpty(ids)){
            return ServiceResponse.illegalArgs();
        }
        try {
            List<Cart> list = cartService.setRemove(userId,ids);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 查询购物车列表
     * @param userId
     * @return
     */
    @GetMapping("/cart/list")
    @ResponseBody
    public ServiceResponse getList(Long userId){
        if(userId <= 0){
            return ServiceResponse.illegalArgs();
        }
        try {
            List<Cart> list = cartService.getList(userId);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
