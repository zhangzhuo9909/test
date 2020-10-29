package org.zhangzhuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.zhangzhuo.CartCache;
import org.zhangzhuo.entity.Cart;
import org.zhangzhuo.service.CartService;
import org.zhangzhuo.service.CatalogService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartCache cartCache;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 合并购物车
     * @param carts
     * @param userId
     * @return
     */
    @Override
    public List<Cart> setCartSync(List<Cart> carts, Long userId) {
        List<Cart> cartList = cartCache.getCarts().get(userId);

        //有的话就合并
        if(cartList == null || cartList.size() == 0){
            cartList = carts;
        }else{
            //没有的话就添加
            for (Cart cart : carts) {
                boolean flag = false;
                long id = cart.getId();
                for (int i = 0 ;i < cartList.size() ;i++){
                    if(cartList.get(i).getId() == id){
                        flag = true;
                        cartList.set(i,cart);
                    }
                }
                //新的商品
                if(! flag){
                    cartList.add(cart);
                }
            }
        }

        //添加进缓存中
        cartCache.getCarts().put(userId,cartList);

        //返回集合
        return cartList;
    }

    /**
     * 删除客户端商品，同时删除服务端
     * @param userId
     * @param ids
     * @return
     */
    @Override
    public List<Cart> setRemove(Long userId, String ids) {
        //去掉符号
        String[] split = ids.split(",");
        List<Cart> cartList = cartCache.getCarts().get(userId);

        if(cartList == null){
            return new ArrayList<>();
        }

        Iterator<Cart> iterator = cartList.iterator();


        for (int i = 0;i < split.length ;i++){
            Long id = new Long(split[i]);

            while (iterator.hasNext()){
                Cart next = iterator.next();
                if(id == next.getId()){
                    iterator.remove();
                    break;
                }
            }
        }
        cartCache.getCarts().put(userId,cartList);
        return cartList;
    }

    /**
     * 查询 购物车
     * @param userId
     * @return
     */
    @Override
    public List<Cart> getList(Long userId) {
        return cartCache.getCarts().get(userId);
    }
}
