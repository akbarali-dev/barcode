package uz.pdp.barcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.ProductDto;
import uz.pdp.barcode.model.*;
import uz.pdp.barcode.payload.ApiResponse;
import uz.pdp.barcode.repository.*;
import uz.pdp.barcode.service.AnswerService;
import uz.pdp.barcode.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    AnswerService answerService;

    @Autowired
    WeightTypeRepository weightTypeRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BarcodeRepository barcodeRepository;

    @Override
    public HttpEntity<?> getAllProduct() {
        return null;
    }

    @Override
    public HttpEntity<?> getProductById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity<?> saveProduct(ProductDto productDto, Errors error) {
        ResponseEntity<ApiResponse> CONFLICT = answerService.getError(error);
        if (CONFLICT != null) return CONFLICT;

        Product product = new Product();
        if (productDto.getId() != null) {
            product.setId(productDto.getId());
        }

        final HttpEntity<?> checkedData = checkAllData(productDto, product);
        if (checkedData != null)
            return checkedData;

        product.setName(productDto.getName());
        product.setWeight(productDto.getWeight());
        try {
            product = productRepository.save(product);
        } catch (DataIntegrityViolationException e) {
            return answerService.answer("ALREADY EXISTS", false, null, HttpStatus.ALREADY_REPORTED);
        } catch (Exception e) {
            return answerService.answer("ERROR", false, null, HttpStatus.CONFLICT);
        }

        Barcode barcode = new Barcode(productDto.getBarcode(), product);

        return answerService.saveObject(barcodeRepository, barcode, false, null);
    }


    @Override
    public HttpEntity<?> deleteProductById(UUID id) {
        return answerService.deleteObject(productRepository, id);
    }

    public HttpEntity<?> checkAllData(ProductDto productDto, Product product) {
//        try {
//            Barcode barcode = barcodeRepository.save(new Barcode(productDto.getBarcode()));
//        } catch (DataIntegrityViolationException e) {
//            return answerService.answer("USED BEFORE", false, null, HttpStatus.FORBIDDEN);
//        }

        Optional<Category> category = categoryRepository.findById(productDto.getCategoryId());
        if (!category.isPresent()) {
            return answerService.answer("Category not found", false, null, HttpStatus.CONFLICT);
        }
        Optional<Brand> brand = brandRepository.findById(productDto.getBrandId());
        if (!brand.isPresent()) {
            return answerService.answer("Brand not found", false, null, HttpStatus.CONFLICT);
        }
        Optional<WeightType> weightType = weightTypeRepository.findById(productDto.getWeightTypeId());
        if (!weightType.isPresent()) {
            return answerService.answer("WeightType not found", false, null, HttpStatus.CONFLICT);
        }
        product.setBrand(brand.get());
        product.setWeightType(weightType.get());
        product.setCategory(category.get());
        return null;
    }
}
