package dev.ram.prosuctServicettseveninga.controllers;

import dev.ram.prosuctServicettseveninga.dtos.ProductDto;
import dev.ram.prosuctServicettseveninga.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProducts(){
        return "get All Products";
    }

    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "Return Single Product id: "+productId;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Adding new Product" +productDto;
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
