package com.pedroavila.domain.service;

import com.pedroavila.domain.service.dto.CreateBranchOfficeCommad;
import com.pedroavila.domain.service.dto.CreateBranchOfficeResult;
import com.pedroavila.domain.service.dto.GetBranchOfficeQuery;
import com.pedroavila.domain.service.dto.GetBranchOfficeResult;

public interface BranchOfficeService {

    GetBranchOfficeResult getAll(GetBranchOfficeQuery query);
    CreateBranchOfficeResult save(CreateBranchOfficeCommad command);
}
