package com.shopping.cart.controller;

import com.shopping.cart.model.Product;
import com.shopping.cart.payload.ProductRequest;
import com.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(){}

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") long productId) {
        return ResponseEntity.ok().body(productService.getProductById(productId));
    }

    @PostMapping("")
    public ResponseEntity<Product> createProduct( @RequestBody ProductRequest product) {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable(value = "id") int productId, @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok().body(productService.updateProductById(productId, productRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable(value = "id") int productId) {
        return ResponseEntity.ok().body(productService.deleteProductById(productId));
    }
}
