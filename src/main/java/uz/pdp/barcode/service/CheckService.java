package uz.pdp.barcode.service;

import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.CheckDto;

import java.util.UUID;

public interface CheckService {

    HttpEntity<?> getAllCheck();

    HttpEntity<?> getCheckById(UUID id);

    HttpEntity<?> saveCheck(CheckDto checkDto, Errors error);

    HttpEntity<?> deleteCheckById(UUID id);
}
