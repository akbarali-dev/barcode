package uz.pdp.barcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.pdp.barcode.dto.NameDto;
import uz.pdp.barcode.service.BrandService;
import uz.pdp.barcode.service.CategoryService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    BrandService brandService;


    @GetMapping
    public HttpEntity<?> getAllBrand(){
        return brandService.getAllBrand();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getBrandById(@PathVariable UUID id){
        return brandService.getBrandById(id);
    }

    @PostMapping
    public HttpEntity<?> saveAndUpdateBrand(@Valid @RequestBody NameDto brandDto, Errors error){
        return brandService.saveBrand(brandDto, error);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteBrandById(@PathVariable UUID id){
        return brandService.deleteBrandById(id);
    }



}
