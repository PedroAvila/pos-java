package com.pedroavila.domain.service.dto;

import com.pedroavila.domain.entity.BranchOffice;

import java.util.List;

public record GetBranchOfficeResult(List<BranchOffice> branchOffices) {
}
