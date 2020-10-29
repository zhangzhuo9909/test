package org.zhangzhuo.service;

import org.zhangzhuo.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> setCartSync(List<Cart> carts, Long userId);

    List<Cart> setRemove(Long userId, String ids);

    List<Cart> getList(Long userId);
}
