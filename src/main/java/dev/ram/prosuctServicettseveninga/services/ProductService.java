package dev.ram.prosuctServicettseveninga.services;

import dev.ram.prosuctServicettseveninga.dtos.ProductDto;
import dev.ram.prosuctServicettseveninga.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product addNewProduct(ProductDto product);
    Product updateProduct(Long productId, Product product);
    boolean deleteProduct(Long productId);
}
