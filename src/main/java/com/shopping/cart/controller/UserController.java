package com.shopping.cart.controller;

import com.shopping.cart.model.User;
import com.shopping.cart.payload.UserRequest;
import com.shopping.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(userService.createUser(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") long userId, @Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(userService.updateUserById(userId, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable(value = "id") long userId) {
        return ResponseEntity.ok().body(userService.deleteUserById(userId));
    }

}
