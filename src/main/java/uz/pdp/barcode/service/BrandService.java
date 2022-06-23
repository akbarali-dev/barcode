package uz.pdp.barcode.service;

import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.NameDto;

import java.util.UUID;


public interface BrandService {

    HttpEntity<?> getAllBrand();

    HttpEntity<?> getBrandById(UUID id);

    HttpEntity<?> saveBrand(NameDto brandDto, Errors error);

    HttpEntity<?> deleteBrandById(UUID id);
}
