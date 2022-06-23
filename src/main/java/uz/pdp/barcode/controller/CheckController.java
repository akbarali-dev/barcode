package uz.pdp.barcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.pdp.barcode.dto.CheckDto;
import uz.pdp.barcode.service.CheckService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/check")
public class CheckController {
@Autowired
    CheckService checkService;

    @GetMapping
    public HttpEntity<?> getAllCheck(){
        return checkService.getAllCheck();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCheckById(@PathVariable UUID id){
        return checkService.getCheckById(id);
    }

    @PostMapping
    public HttpEntity<?> saveAndUpdateCheck(@Valid @RequestBody CheckDto checkDto, Errors error){
        return checkService.saveCheck(checkDto, error);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCheckById(@PathVariable UUID id){
        return checkService.deleteCheckById(id);
    }
}
