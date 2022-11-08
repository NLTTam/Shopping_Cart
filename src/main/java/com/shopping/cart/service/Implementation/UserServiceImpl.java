package com.shopping.cart.service.Implementation;

import com.shopping.cart.model.Product;
import com.shopping.cart.model.User;
import com.shopping.cart.payload.ProductRequest;
import com.shopping.cart.payload.UserRequest;
import com.shopping.cart.repository.UserRepository;
import com.shopping.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setGender(userRequest.getGender());
        user.setPhone(userRequest.getPhone());
        user.setPassword(userRequest.getPassword());
        user.setUsername(userRequest.getUsername());
        return userRepository.save(user);
    }

    @Override
    public User updateUserById(long userId, UserRequest userRequest){
        User user = new User();
        user.setGender(userRequest.getGender());
        user.setPhone(userRequest.getPhone());
        user.setPassword(userRequest.getPassword());
        user.setUsername(userRequest.getUsername());
        return userRepository.save(user);
    }

    @Override
    public User deleteUserById(long userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId).get();
    }


}
