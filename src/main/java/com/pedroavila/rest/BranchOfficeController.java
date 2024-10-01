package com.pedroavila.rest;

import com.pedroavila.domain.service.BranchOfficeService;
import com.pedroavila.domain.service.dto.CreateBranchOfficeCommad;
import com.pedroavila.domain.service.dto.CreateBranchOfficeResult;
import com.pedroavila.domain.service.dto.GetBranchOfficeQuery;
import com.pedroavila.domain.service.dto.GetBranchOfficeResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

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
    public ResponseEntity<?> createBranchOffice(@Valid @RequestBody CreateBranchOfficeCommad dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomResponse<CreateBranchOfficeResult>(HttpStatus.CREATED.value(), service.saveAsync(dto).join()));
    }
}
