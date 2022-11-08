package com.shopping.cart.service.Implementation;

import com.shopping.cart.model.Cart;
import com.shopping.cart.model.Product;
import com.shopping.cart.model.User;
import com.shopping.cart.payload.CartRequest;
import com.shopping.cart.repository.CartRepository;
import com.shopping.cart.repository.ProductRepository;
import com.shopping.cart.repository.UserRepository;
import com.shopping.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartServiceImpl (CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Cart createCart(CartRequest cartRequest) {
        User user = userRepository.findById(cartRequest.getUserId()).get();
        Product product = productRepository.findById(cartRequest.getProductId()).get();
        Cart cart = new Cart();
        if (product.getAmount() > 0) {
            cart.setUser(user);
            cart.setProduct(product);
            return cartRepository.save(cart);
        } else return null;

    }

    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    public Cart getCartById(long cartId) {
        return cartRepository.findById(cartId).get();
    }

    public Cart deleteCartById(long cartId) {
        Cart cart = cartRepository.findById(cartId).get();
        cartRepository.delete(cart);
        return cart;
    }

    public Cart updateCartById(long cartId, CartRequest cartRequest) {
        User user = userRepository.findById(cartRequest.getUserId()).get();
        Product product = productRepository.findById(cartRequest.getProductId()).get();
        Cart cart = cartRepository.findById(cartId).get();
        cart.setUser(user);
        cart.setProduct(product);
        return cartRepository.save(cart);
    }

}
