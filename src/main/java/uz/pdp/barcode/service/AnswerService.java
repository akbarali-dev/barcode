package uz.pdp.barcode.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import uz.pdp.barcode.model.template.AbsEntity;
import uz.pdp.barcode.payload.ApiResponse;

import java.util.List;
import java.util.UUID;


public interface AnswerService {

    HttpEntity<?> answer(String message, boolean isSuccess, Object data, HttpStatus status);

    public <K extends JpaRepository<O, UUID>, O extends AbsEntity> HttpEntity<?> saveObject(K repository, O object, boolean returnObject, List<O> listObject);

    public <K extends JpaRepository<O, UUID>, O extends AbsEntity> HttpEntity<?> deleteObject(K repository, UUID id);

    ResponseEntity<ApiResponse> getError(Errors errors);

    public <K> HttpEntity<?> getAllObject(K object, int size);

}
