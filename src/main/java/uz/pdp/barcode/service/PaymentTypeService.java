package uz.pdp.barcode.service;

import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.NameDto;

import java.util.UUID;


public interface PaymentTypeService {

    HttpEntity<?> getAllPaymentType();

    HttpEntity<?> getPaymentTypeById(UUID id);

    HttpEntity<?> savePaymentType(NameDto paymentTypeDto, Errors error);

    HttpEntity<?> deletePaymentTypeById(UUID id);
}
