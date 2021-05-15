package com.github.vsae.web.api.service;

import com.github.vsae.web.model.AddCartParam;
import com.github.vsae.web.model.CartProductDetail;
import com.github.vsae.web.model.DeleteCartParam;
import com.github.vsae.web.model.GetCartItemsParam;

import java.util.List;

public interface CartService {

    public boolean addCart(AddCartParam addCartParam);

    public boolean deleteCart(DeleteCartParam deleteCartParam);

    public List<CartProductDetail> getCartItems(GetCartItemsParam getCartItemsParam);

}
