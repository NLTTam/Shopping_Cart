package com.backend.shoppingCart.Services;

import com.backend.shoppingCart.model.Product;
import com.backend.shoppingCart.payload.ProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);
    List<Product> getAllProduct();
    Product getProductById(int productId);
    Product updateProductById(int productId, ProductRequest productRequest);
    Product deleteProductById(int productId);
}
