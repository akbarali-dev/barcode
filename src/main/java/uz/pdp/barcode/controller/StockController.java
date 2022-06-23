package uz.pdp.barcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.pdp.barcode.dto.StockDto;
import uz.pdp.barcode.service.StockService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping
    public HttpEntity<?> getAllStock(){
        return stockService.getAllStock();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getStockById(@PathVariable UUID id){
        return stockService.getStockById(id);
    }

    @PostMapping
    public HttpEntity<?> saveAndUpdateStock(@Valid @RequestBody StockDto stockDto, Errors error){
        return stockService.saveStock(stockDto, error);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteStockById(@PathVariable UUID id){
        return stockService.deleteStockById(id);
    }

}
