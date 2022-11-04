package com.backend.shoppingCart.controller;

import com.backend.shoppingCart.Services.ProductService;
import com.backend.shoppingCart.model.Product;
import com.backend.shoppingCart.payload.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/employee")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") int productId) {
        return ResponseEntity.ok().body(productService.getProductById(productId));
    }

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable(value = "id") int productId, @Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok().body(productService.updateProductById(productId, productRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable(value = "id") int productId) {
        return ResponseEntity.ok().body(productService.deleteProductById(productId));
    }
}
