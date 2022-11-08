package com.shopping.cart.service;

import com.shopping.cart.model.Cart;
import com.shopping.cart.payload.CartRequest;

import java.util.List;

public interface CartService {

    List<Cart> getAllCart();
    Cart getCartById(long cartId);
    Cart updateCartById(long cartId, CartRequest cartRequest);
    Cart deleteCartById(long cartId);
    Cart createCart(CartRequest cartRequest);
}
