package dev.ram.prosuctServicettseveninga.controllers;

import dev.ram.prosuctServicettseveninga.dtos.ErrorResponseDto;
import dev.ram.prosuctServicettseveninga.dtos.GetSingleProductResponseDto;
import dev.ram.prosuctServicettseveninga.dtos.ProductDto;
import dev.ram.prosuctServicettseveninga.exeptions.NotFoundException;
import dev.ram.prosuctServicettseveninga.models.Category;
import dev.ram.prosuctServicettseveninga.models.Product;
import dev.ram.prosuctServicettseveninga.repostories.ProductRepository;
import dev.ram.prosuctServicettseveninga.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        Optional<Product> productOptional = productService.getSingleProduct(productId);
        if(productOptional.isEmpty()){
            throw new NotFoundException("No Product with product id:" + productId);
        }
        ResponseEntity<Product> response = new ResponseEntity(
                productService.getSingleProduct(productId),
                HttpStatus.OK
        );
        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){
//        Product newProduct = productService.addNewProduct(product);

        Product newProduct = new Product();
        newProduct.setDescription(product.getDescription());
        newProduct.setImageUrl(product.getImage());
        newProduct.setTitle(product.getTitle());
        newProduct.setPrice(product.getPrice());

        newProduct = productRepository.save(newProduct);

        ResponseEntity<Product> response = new ResponseEntity<>(newProduct, HttpStatus.OK);
        return response;
    }

    @PatchMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());

        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting product id: "+productId;
    }

}
