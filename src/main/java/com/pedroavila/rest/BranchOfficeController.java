package com.pedroavila.rest;

import com.pedroavila.domain.service.BranchOfficeService;
import com.pedroavila.domain.service.dto.BranchOfficeDTO;
import com.pedroavila.operations.common.BusinessException;
import com.pedroavila.operations.mapper.BranchOfficeMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    @Autowired
    public BranchOfficeController(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping("/branchoffices")
    public ResponseEntity<?> createBranchOffice(@Valid @RequestBody BranchOfficeDTO branchOfficeDTO){
        try {
            var branchOffice = BranchOfficeMapper.mapper.dtoToEntity(branchOfficeDTO);
            var entity = branchOfficeService.save(branchOffice);
            var response = new CustomResponse<BranchOfficeDTO>(HttpStatus.CREATED.value(), BranchOfficeMapper.mapper.entityToDto(entity));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(BusinessException e){
            var errorResponse = new CustomResponse<Object>(e.getStatus(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }
}
