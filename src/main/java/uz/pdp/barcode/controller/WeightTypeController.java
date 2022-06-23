package uz.pdp.barcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.pdp.barcode.dto.NameDto;
import uz.pdp.barcode.service.BrandService;
import uz.pdp.barcode.service.WeightTypeService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/weigh-type")
public class WeightTypeController {
    @Autowired
    WeightTypeService weightTypeService;


    @GetMapping
    public HttpEntity<?> getAllWeightType(){
        return weightTypeService.getAllWeightType();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getWeightTypeById(@PathVariable UUID id){
        return weightTypeService.getWeightTypeById(id);
    }

    @PostMapping
    public HttpEntity<?> saveAndUpdateWeightType(@Valid @RequestBody NameDto weightTypeDto, Errors error){
        return weightTypeService.saveWeightType(weightTypeDto, error);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteWeightTypeById(@PathVariable UUID id){
        return weightTypeService.deleteWeightTypeById(id);
    }



}
