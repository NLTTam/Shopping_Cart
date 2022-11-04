package com.backend.shoppingCart.Services.Implementation;

import com.backend.shoppingCart.Services.ProductService;
import com.backend.shoppingCart.model.Product;
import com.backend.shoppingCart.payload.ProductRequest;
import com.backend.shoppingCart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setAmount(productRequest.getAmount());
        product.setColor(productRequest.getColor());
        product.setBrand(productRequest.getBrand());
        product.setName(productRequest.getName());
        product.setWeight(productRequest.getWeight());
        product.setInformation(productRequest.getInformation());
        return productRepository.save(product);
    }

    @Override
    public Product updateProductById(int productId, ProductRequest productRequest){
        Product product = productRepository.findById(productId).get();
        product.setInformation(productRequest.getInformation());
        product.setAmount(productRequest.getAmount());
        product.setColor(productRequest.getColor());
        product.setBrand(productRequest.getBrand());
        product.setName(productRequest.getName());
        product.setWeight(productRequest.getWeight());
        return productRepository.save(product);
    }

    @Override
    public Product deleteProductById(int productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
        return product;
    }
}
