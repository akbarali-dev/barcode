package uz.pdp.barcode.service;

import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.NameDto;

import java.util.UUID;


public interface WeightTypeService {

    HttpEntity<?> getAllWeightType();

    HttpEntity<?> getWeightTypeById(UUID id);

    HttpEntity<?> saveWeightType(NameDto weightTypeDto, Errors error);

    HttpEntity<?> deleteWeightTypeById(UUID id);
}
