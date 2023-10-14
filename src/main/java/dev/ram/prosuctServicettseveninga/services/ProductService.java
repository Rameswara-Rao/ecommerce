package dev.ram.prosuctServicettseveninga.services;

import dev.ram.prosuctServicettseveninga.dtos.ProductDto;
import dev.ram.prosuctServicettseveninga.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getSingleProduct(Long productId);
    Product addNewProduct(ProductDto product);
    Product updateProduct(Long productId, Product product);
    Product replaceProduct(Long productId, Product product);
    Product deleteProduct(Long productId);
}
