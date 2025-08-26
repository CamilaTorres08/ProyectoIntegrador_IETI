package edu.eci.ieti.integrador.service;

import edu.eci.ieti.integrador.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(String id);
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(String id);
}
