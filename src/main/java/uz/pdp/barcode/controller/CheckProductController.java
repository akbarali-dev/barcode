package uz.pdp.barcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.pdp.barcode.dto.CheckProductDto;
import uz.pdp.barcode.dto.StockDto;
import uz.pdp.barcode.service.CheckProductService;
import uz.pdp.barcode.service.StockService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/check-product")
public class CheckProductController {
    @Autowired
    CheckProductService checkProductService;

    @GetMapping
    public HttpEntity<?> getAllCheckProduct(){
        return checkProductService.getAllCheckProduct();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCheckProductById(@PathVariable UUID id){
        return checkProductService.getCheckProductById(id);
    }

    @PostMapping
    public HttpEntity<?> saveAndUpdateCheckProduct(@Valid @RequestBody List<CheckProductDto> stockDto, Errors error){
        return checkProductService.saveCheckProduct(stockDto, error);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCheckProductById(@PathVariable UUID id){
        return checkProductService.deleteCheckProductById(id);
    }

}
