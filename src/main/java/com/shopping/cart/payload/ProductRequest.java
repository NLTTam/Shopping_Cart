package com.shopping.cart.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private String brand;
    private String color;
    private double weight;
    private String information;
    private int amount;
}
