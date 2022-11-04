package com.backend.shoppingCart.payload;

import lombok.*;

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
