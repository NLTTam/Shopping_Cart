package com.shopping.cart.service;

import com.shopping.cart.model.Product;
import com.shopping.cart.payload.ProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);
    List<Product> getAllProduct();
    Product getProductById(long productId);
    Product updateProductById(long productId, ProductRequest productRequest);
    Product deleteProductById(long productId);
}
