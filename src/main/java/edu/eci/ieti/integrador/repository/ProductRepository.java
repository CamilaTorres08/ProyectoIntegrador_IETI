package edu.eci.ieti.integrador.repository;

import edu.eci.ieti.integrador.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
