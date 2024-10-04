package com.pedroavila.domain.service;

import com.pedroavila.domain.service.dto.*;

import java.util.concurrent.CompletableFuture;

public interface BranchOfficeService {

    CompletableFuture<GetBranchOfficeResult> getAllAsync(GetBranchOfficeQuery query);
    CompletableFuture<CreateBranchOfficeResult> saveAsync(CreateBranchOfficeCommand command);
    CompletableFuture<Void> updateAsync(UpdateBranchOfficeCommandWithId commandWithId);
}
