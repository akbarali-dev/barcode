package uz.pdp.barcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import uz.pdp.barcode.dto.NameDto;
import uz.pdp.barcode.model.WeightType;
import uz.pdp.barcode.payload.ApiResponse;
import uz.pdp.barcode.projection.NameProjection;
import uz.pdp.barcode.repository.WeightTypeRepository;
import uz.pdp.barcode.service.AnswerService;
import uz.pdp.barcode.service.WeightTypeService;

import java.util.List;
import java.util.UUID;

@Service
public class WeightTypeServiceImpl implements WeightTypeService {
    @Autowired
    WeightTypeRepository weightTypeRepository;

    @Autowired
    AnswerService answerService;


    @Override
    public HttpEntity<?> getAllWeightType() {
        final List<NameProjection> allWeightType = weightTypeRepository.getAllWeightType();
        return answerService.getAllObject(allWeightType, allWeightType.size());
    }

    @Override
    public HttpEntity<?> getWeightTypeById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity<?> saveWeightType(NameDto weightTypeDto, Errors error) {
        ResponseEntity<ApiResponse> CONFLICT = answerService.getError(error);
        if (CONFLICT != null) return CONFLICT;

        WeightType weightType = new WeightType();
        if (weightTypeDto.getId() != null) {
            weightType.setId(weightTypeDto.getId());
        }
        weightType.setName(weightTypeDto.getName());
        return answerService.saveObject(weightTypeRepository, weightType, true, null);
    }

    @Override
    public HttpEntity<?> deleteWeightTypeById(UUID id) {
        return answerService.deleteObject(weightTypeRepository, id);
    }
}
