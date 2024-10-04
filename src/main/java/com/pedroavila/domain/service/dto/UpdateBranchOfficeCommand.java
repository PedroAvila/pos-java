package com.pedroavila.domain.service.dto;

public record UpdateBranchOfficeCommand(
        int companyId,
        String name,
        String address,
        String phone,
        int status
) {
}
