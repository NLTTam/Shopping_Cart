package com.shopping.cart.service;

import com.shopping.cart.model.User;
import com.shopping.cart.payload.UserRequest;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(long userId);
    User createUser(UserRequest userRequest);
    User deleteUserById(long userId);
    User updateUserById(long userId, UserRequest userRequest);
}
