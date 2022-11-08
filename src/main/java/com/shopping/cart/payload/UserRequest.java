package com.shopping.cart.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String password;
    private String username;
    private String phone;
    private String gender;
    private String email;
}
