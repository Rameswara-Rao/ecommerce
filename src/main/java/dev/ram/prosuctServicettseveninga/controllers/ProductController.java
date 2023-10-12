package dev.ram.prosuctServicettseveninga.controllers;

import dev.ram.prosuctServicettseveninga.dtos.GetSingleProductResponseDto;
import dev.ram.prosuctServicettseveninga.dtos.ProductDto;
import dev.ram.prosuctServicettseveninga.models.Product;
import dev.ram.prosuctServicettseveninga.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){
        ResponseEntity<Product> response = new ResponseEntity(
                productService.getSingleProduct(productId),
                HttpStatus.OK
        );
        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product newProduct = productService.addNewProduct(productDto);
        ResponseEntity<Product> response = new ResponseEntity<>(newProduct, HttpStatus.OK);
        return response;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
        return "Updating Product "+productId +" "+ productDto;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting product id: "+productId;
    }
}
