package com.pedroavila.rest;

import com.pedroavila.domain.service.BranchOfficeService;
import com.pedroavila.domain.service.dto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branchoffices")
public class BranchOfficeController {

    private final BranchOfficeService service;

    @Autowired
    public BranchOfficeController(BranchOfficeService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAllById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new CustomResponse<GetBranchOfficeResult>(HttpStatus.OK.value(), service.getAllAsync(new GetBranchOfficeQuery(id)).join()));
    }

    @PostMapping
    public ResponseEntity<?> createBranchOffice(@Valid @RequestBody CreateBranchOfficeCommand dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomResponse<CreateBranchOfficeResult>(HttpStatus.CREATED.value(), service.saveAsync(dto).join()));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBranchOffice(@Valid @PathVariable Long id, @RequestBody UpdateBranchOfficeCommand dto){
        var command = new UpdateBranchOfficeCommandWithId(id, dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new CustomResponse<>(HttpStatus.NO_CONTENT.value(), service.updateAsync(command).join()));
    }
}
