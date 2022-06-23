package uz.pdp.barcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.NameDto;
import uz.pdp.barcode.model.Category;
import uz.pdp.barcode.payload.ApiResponse;
import uz.pdp.barcode.projection.NameProjection;
import uz.pdp.barcode.repository.CategoryRepository;
import uz.pdp.barcode.service.AnswerService;
import uz.pdp.barcode.service.CategoryService;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AnswerService answerService;

    @Override
    public HttpEntity<?> getAllCategory() {
        List<NameProjection> allCategory = categoryRepository.getAllCategory();
        return answerService.getAllObject(allCategory, allCategory.size());
    }


    @Override
    public HttpEntity<?> getCategoryById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity<?> saveCategory(NameDto categoryDto, Errors error) {

        ResponseEntity<ApiResponse> CONFLICT = answerService.getError(error);
        if (CONFLICT != null) return CONFLICT;

        Category category = new Category();
        if (categoryDto.getId() != null) {
            category.setId(categoryDto.getId());
        }
        category.setName(categoryDto.getName());
        return answerService.saveObject(categoryRepository, category, true, null);
//        try {
//            categoryRepository.save(category);
//            return answerService.answer("success", true, null, HttpStatus.OK);
//
//        } catch (Exception e) {
//            return answerService.answer("ERROR", false, null, HttpStatus.CONFLICT);
//        }

    }

    @Override
    public HttpEntity<?> deleteCategoryById(UUID id) {
        return answerService.deleteObject(categoryRepository, id);
    }
}
