package uz.pdp.barcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.NameDto;
import uz.pdp.barcode.model.Brand;
import uz.pdp.barcode.payload.ApiResponse;
import uz.pdp.barcode.projection.NameProjection;
import uz.pdp.barcode.repository.BrandRepository;
import uz.pdp.barcode.service.AnswerService;
import uz.pdp.barcode.service.BrandService;

import java.util.List;
import java.util.UUID;

@Service
public class BrandServiceImpl implements BrandService {

@Autowired
    BrandRepository brandRepository;
    @Autowired
    AnswerService answerService;


    @Override
    public HttpEntity<?> getAllBrand() {
        List<NameProjection> allBrand = brandRepository.getAllBrand();
        return answerService.getAllObject(allBrand, allBrand.size());
    }

    @Override
    public HttpEntity<?> getBrandById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity<?> saveBrand(NameDto brandDto, Errors error) {
        ResponseEntity<?> CONFLICT = answerService.getError(error);
        if (CONFLICT != null) return CONFLICT;

//salom sdfiesdf 9feyes
//        scsdlxkz
        Brand brand = new Brand();
        if (brandDto.getId() != null) {
            brand.setId(brandDto.getId());
        }
        brand.setName(brandDto.getName());
        return answerService.saveObject(brandRepository, brand, true, null);
    }

    @Override
    public HttpEntity<?> deleteBrandById(UUID id) {
        return answerService.deleteObject(brandRepository, id);
    }
}
