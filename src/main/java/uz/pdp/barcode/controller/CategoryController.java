package uz.pdp.barcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.pdp.barcode.dto.NameDto;
import uz.pdp.barcode.service.CategoryService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping
    public HttpEntity<?> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCategoryById(@PathVariable UUID id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public HttpEntity<?> saveAndUpdateCategory(@Valid @RequestBody NameDto categoryDto, Errors error){
        return categoryService.saveCategory(categoryDto, error);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCategoryById(@PathVariable UUID id){
        return categoryService.deleteCategoryById(id);
    }



}
