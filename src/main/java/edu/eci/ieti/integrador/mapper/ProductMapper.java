package edu.eci.ieti.integrador.mapper;

import edu.eci.ieti.integrador.model.DTO.ProductDto;
import edu.eci.ieti.integrador.model.Product;

public class ProductMapper {

    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
