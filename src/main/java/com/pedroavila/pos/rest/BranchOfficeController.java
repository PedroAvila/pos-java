package com.pedroavila.pos.rest;

import com.pedroavila.pos.domain.service.BranchOfficeService;
import com.pedroavila.pos.domain.service.dto.BranchOfficeDTO;
import com.pedroavila.pos.operations.common.CustomException;
import com.pedroavila.pos.operations.mapper.BranchOfficeMapper;
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
    public ResponseEntity<?> createBranchOffice(@RequestBody BranchOfficeDTO branchOfficeDTO){
        try {
            var branchOffice = BranchOfficeMapper.mapper.dtoToEntity(branchOfficeDTO);
            var entity = branchOfficeService.save(branchOffice);
            var response = new CustomResponse<BranchOfficeDTO>(HttpStatus.OK.value(), BranchOfficeMapper.mapper.entityToDto(entity));
            return ResponseEntity.ok(response);
        }catch(CustomException e){
            var errorResponse = new CustomResponse<Object>(e.getStatus(), e.getMessage());
            return ResponseEntity.status(e.getStatus()).body(errorResponse);
        }
    }
}
