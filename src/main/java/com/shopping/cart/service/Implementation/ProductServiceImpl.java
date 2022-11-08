package com.shopping.cart.service.Implementation;

import com.shopping.cart.model.Product;
import com.shopping.cart.payload.ProductRequest;
import com.shopping.cart.repository.ProductRepository;
import com.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
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
    public Product updateProductById(long productId, ProductRequest productRequest){
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
    public Product deleteProductById(long productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
        return product;
    }
}
