package com.github.vsae.web.api.service.impl;

import com.github.vsae.api.resource.system.FmSystemParam;
import com.github.vsae.web.api.mapper.CartMapper;
import com.github.vsae.web.api.service.CartService;
import com.github.vsae.web.model.*;
import com.github.vsae.web.utils.RedisUtils;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    CartMapper cartMapper;

    @Override
    public boolean addCart(AddCartParam addCartParam) {
        redisUtils.hset(FmSystemParam.CART_PREFIX_KEY + addCartParam.getEmail(),
                String.valueOf(addCartParam.getProductSeqno()), String.valueOf(addCartParam.getCount()));
        return true;
    }

    @Override
    public boolean deleteCart(DeleteCartParam deleteCartParam) {
        redisUtils.hdel(FmSystemParam.CART_PREFIX_KEY + deleteCartParam.getEmail(), String.valueOf(deleteCartParam.getProductSeqno()));
        return true;
    }

    @Override
    public List<CartProductDetail> getCartItems(GetCartItemsParam getCartItemsParam) {
        List<Integer> productSeqnoList = getCartItemsParam.getProductSeqnoList();
        String key = FmSystemParam.CART_PREFIX_KEY + getCartItemsParam.getEmail();
        List<CartProductDetail> productList = new ArrayList<>();
        for(int i = 0;i < productSeqnoList.size();i++){
            Object count = redisUtils.hget(key, String.valueOf(productSeqnoList.get(i)));
            CartProductDetail product = cartMapper.getCartProductDetailBySeqno(productSeqnoList.get(i));
            product.setCount(Integer.parseInt(count.toString()));
            productList.add(product);
        }
        return productList;
    }
}
