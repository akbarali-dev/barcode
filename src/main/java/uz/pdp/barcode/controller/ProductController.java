package uz.pdp.barcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.pdp.barcode.dto.ProductDto;
import uz.pdp.barcode.service.ProductService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public HttpEntity<?> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getProductById(@PathVariable UUID id){
        return productService.getProductById(id);
    }

    @PostMapping
    public HttpEntity<?> saveAndUpdateProduct(@Valid @RequestBody ProductDto productDto, Errors error){
        return productService.saveProduct(productDto, error);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteProductById(@PathVariable UUID id){
        return productService.deleteProductById(id);
    }
}
