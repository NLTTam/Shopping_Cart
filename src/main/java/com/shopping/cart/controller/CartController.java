package com.shopping.cart.controller;

import com.shopping.cart.model.Cart;
import com.shopping.cart.payload.CartRequest;
import com.shopping.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("")
    public ResponseEntity<List<Cart>> getAllCart() {
        return ResponseEntity.ok().body(cartService.getAllCart());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable(value = "id") long userId) {
        return ResponseEntity.ok().body(cartService.getCartById(userId));
    }

    @PostMapping("")
    public ResponseEntity<Cart> createUser(@Valid @RequestBody CartRequest cartRequest) {
        return ResponseEntity.ok().body(cartService.createCart(cartRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable(value = "id") long cartId, @Valid @RequestBody CartRequest cartRequest) {
        return ResponseEntity.ok().body(cartService.updateCartById(cartId, cartRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cart> deleteUserById(@PathVariable(value = "id") long cartId) {
        return ResponseEntity.ok().body(cartService.deleteCartById(cartId));
    }
}
