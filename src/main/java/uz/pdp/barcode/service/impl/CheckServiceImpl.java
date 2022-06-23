package uz.pdp.barcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.CheckDto;
import uz.pdp.barcode.model.Check;
import uz.pdp.barcode.model.Stock;
import uz.pdp.barcode.payload.ApiResponse;
import uz.pdp.barcode.repository.CheckRepository;
import uz.pdp.barcode.repository.StockRepository;
import uz.pdp.barcode.service.AnswerService;
import uz.pdp.barcode.service.CheckService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    AnswerService answerService;

    @Autowired
    CheckRepository checkRepository;

    @Autowired
    StockRepository stockRepository;


    @Override
    public HttpEntity<?> getAllCheck() {
        return null;
    }

    @Override
    public HttpEntity<?> getCheckById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity<?> saveCheck(CheckDto checkDto, Errors error) {
//        ResponseEntity<ApiResponse> CONFLICT = answerService.getError(error);
//        if (CONFLICT != null) return CONFLICT;
//        List<Stock> allById;
//        try {
//            allById = stockRepository.findAllById(checkDto.getProductsId());
//        } catch (Exception e) {
//            return answerService.answer("error", false, null, HttpStatus.CONFLICT);
//        }
//        List<Stock> products = new ArrayList<>(allById);
//        Check check = new Check(products);
//        return answerService.saveObject(checkRepository, check, false);
        return null;
    }

    @Override
    public HttpEntity<?> deleteCheckById(UUID id) {
        return answerService.deleteObject(checkRepository, id);
    }
}
