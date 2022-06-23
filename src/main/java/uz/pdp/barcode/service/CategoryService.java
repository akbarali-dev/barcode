package uz.pdp.barcode.service;

import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.NameDto;

import java.util.UUID;


public interface CategoryService {

    HttpEntity<?> getAllCategory();

    HttpEntity<?> getCategoryById(UUID id);

    HttpEntity<?> saveCategory(NameDto categoryDto, Errors error);

    HttpEntity<?> deleteCategoryById(UUID id);
}
