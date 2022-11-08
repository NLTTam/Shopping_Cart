package com.shopping.cart.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {

    private long userId;
    private long productId;

}
