package edu.eci.ieti.integrador.service;

import edu.eci.ieti.integrador.model.Product;
import edu.eci.ieti.integrador.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(String id){
        return this.productRepository.findById(id);
    }
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
    public Product addProduct(Product product){
        return this.productRepository.save(product);
    }
    public Product updateProduct(Product product){
        return this.productRepository.save(product);
    }
    public void deleteProduct(String id){
        this.productRepository.deleteById(id);
    }
}
