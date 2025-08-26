package edu.eci.ieti.integrador.controller;


import edu.eci.ieti.integrador.exception.NotFoundException;
import edu.eci.ieti.integrador.model.DTO.ProductDto;
import edu.eci.ieti.integrador.model.Product;
import edu.eci.ieti.integrador.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static edu.eci.ieti.integrador.mapper.ProductMapper.toProduct;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        if(!product.isPresent()){
            throw new NotFoundException(id);
        }
        return ResponseEntity.ok(product.get());
    }
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        URI uri = URI.create("");
        Product p = productService.addProduct(toProduct(productDto));
        return ResponseEntity.created(uri).body(p);
    }
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody ProductDto dto){
        Optional<Product> p = productService.getProductById(id);
        if(!p.isPresent()){
            throw new NotFoundException(id);
        }
        return ResponseEntity.ok(productService.updateProduct(toProduct(dto)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        Optional<Product> p = productService.getProductById(id);
        if(!p.isPresent()){
            throw new NotFoundException(id);
        }
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
