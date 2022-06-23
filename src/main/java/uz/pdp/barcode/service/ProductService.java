package uz.pdp.barcode.service;

import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.ProductDto;

import java.util.UUID;

public interface ProductService {

    HttpEntity<?> getAllProduct();

    HttpEntity<?> getProductById(UUID id);

    HttpEntity<?> saveProduct(ProductDto productDto, Errors error);

    HttpEntity<?> deleteProductById(UUID id);
}
