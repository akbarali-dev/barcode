package uz.pdp.barcode.service;

import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.StockDto;

import java.util.UUID;

public interface StockService {

    HttpEntity<?> getAllStock();

    HttpEntity<?> getStockById(UUID id);

    HttpEntity<?> saveStock(StockDto stockDto, Errors error);

    HttpEntity<?> deleteStockById(UUID id);
}
