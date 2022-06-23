package uz.pdp.barcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.CheckProductDto;
import uz.pdp.barcode.model.Check;
import uz.pdp.barcode.model.CheckProduct;
import uz.pdp.barcode.model.Stock;
import uz.pdp.barcode.payload.ApiResponse;
import uz.pdp.barcode.repository.CheckProductRepository;
import uz.pdp.barcode.repository.CheckRepository;
import uz.pdp.barcode.repository.StockRepository;
import uz.pdp.barcode.service.AnswerService;
import uz.pdp.barcode.service.CheckProductService;

import javax.validation.Valid;
import java.util.*;

@Service
public class CheckProductServiceImpl implements CheckProductService {
    @Autowired
    AnswerService answerService;

    @Autowired
    CheckProductRepository checkProductRepository;

    @Autowired
    CheckRepository checkRepository;

    @Autowired
    StockRepository stockRepository;


    @Override
    public HttpEntity<?> getAllCheckProduct() {
        return null;
    }

    @Override
    public HttpEntity<?> getCheckProductById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity<?> saveCheckProduct(List<CheckProductDto> checkProductDto, Errors error) {
        ResponseEntity<ApiResponse> CONFLICT = answerService.getError(error);
        if (CONFLICT != null) return CONFLICT;

        Check check = checkRepository.save(new Check("no named"));
        List<CheckProduct> checkProducts = new ArrayList<>();
        for (CheckProductDto productDto : checkProductDto) {
            CheckProduct product = new CheckProduct();
            Optional<Stock> stock = stockRepository.findById(productDto.getProduct());
            if (!stock.isPresent())
                return answerService.answer("Not found", false, null, HttpStatus.NOT_FOUND);
            product.setProduct(stock.get());
            product.setPrice(productDto.getPrice());
            product.setQuantity(productDto.getQuantity());
            product.setComment(productDto.getComment());
            product.setCheck(check);
            checkProducts.add(product);
        }
        return answerService.saveObject(checkProductRepository, null, false, checkProducts);
    }

    @Override
    public HttpEntity<?> deleteCheckProductById(UUID id) {
        return answerService.deleteObject(checkRepository, id);
    }
}
