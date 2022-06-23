package uz.pdp.barcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.pdp.barcode.dto.NameDto;
import uz.pdp.barcode.service.BrandService;
import uz.pdp.barcode.service.PaymentTypeService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment-type")
public class PaymentTypeController {
    @Autowired
    PaymentTypeService paymentTypeService;

    @GetMapping
    public HttpEntity<?> getAllPaymentType(){
        return paymentTypeService.getAllPaymentType();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getPaymentTypeById(@PathVariable UUID id){
        return paymentTypeService.getPaymentTypeById(id);
    }

    @PostMapping
    public HttpEntity<?> saveAndUpdatePaymentType(@Valid @RequestBody NameDto paymentTypeDto, Errors error){
        return paymentTypeService.savePaymentType(paymentTypeDto, error);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePaymentTypeById(@PathVariable UUID id){
        return paymentTypeService.deletePaymentTypeById(id);
    }



}
