package uz.pdp.barcode.service;

import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.CheckProductDto;

import java.util.List;
import java.util.UUID;

public interface CheckProductService {

    HttpEntity<?> getAllCheckProduct();

    HttpEntity<?> getCheckProductById(UUID id);

    HttpEntity<?> saveCheckProduct(List<CheckProductDto> checkDto, Errors error);

    HttpEntity<?> deleteCheckProductById(UUID id);
}
