package uz.pdp.barcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.NameDto;
import uz.pdp.barcode.model.PaymentType;
import uz.pdp.barcode.payload.ApiResponse;
import uz.pdp.barcode.projection.NameProjection;
import uz.pdp.barcode.repository.PaymentTypeRepository;
import uz.pdp.barcode.service.AnswerService;
import uz.pdp.barcode.service.PaymentTypeService;
import uz.pdp.barcode.service.PaymentTypeService;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

@Autowired
    PaymentTypeRepository paymentTypeRepository;
    @Autowired
    AnswerService answerService;


    @Override
    public HttpEntity<?> getAllPaymentType() {
        List<NameProjection> allPaymentType = paymentTypeRepository.getAllPaymentType();
        return answerService.getAllObject(allPaymentType, allPaymentType.size());
    }

    @Override
    public HttpEntity<?> getPaymentTypeById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity<?> savePaymentType(NameDto paymentTypeDto, Errors error) {
        ResponseEntity<ApiResponse> CONFLICT = answerService.getError(error);
        if (CONFLICT != null) return CONFLICT;

        PaymentType paymentType = new PaymentType();
        if (paymentTypeDto.getId() != null) {
            paymentType.setId(paymentTypeDto.getId());
        }
        paymentType.setName(paymentTypeDto.getName());
        return answerService.saveObject(paymentTypeRepository, paymentType, true, null);
    }

    @Override
    public HttpEntity<?> deletePaymentTypeById(UUID id) {
        return answerService.deleteObject(paymentTypeRepository, id);
    }
}
