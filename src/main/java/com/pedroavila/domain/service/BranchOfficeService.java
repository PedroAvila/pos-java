package com.pedroavila.domain.service;

import com.pedroavila.domain.service.dto.CreateBranchOfficeCommad;
import com.pedroavila.domain.service.dto.CreateBranchOfficeResult;
import com.pedroavila.domain.service.dto.GetBranchOfficeQuery;
import com.pedroavila.domain.service.dto.GetBranchOfficeResult;

import java.util.concurrent.CompletableFuture;

public interface BranchOfficeService {

    CompletableFuture<GetBranchOfficeResult> getAllAsync(GetBranchOfficeQuery query);
    CompletableFuture<CreateBranchOfficeResult> saveAsync(CreateBranchOfficeCommad command);
}
