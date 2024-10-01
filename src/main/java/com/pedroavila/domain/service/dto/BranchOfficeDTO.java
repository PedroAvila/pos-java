package com.pedroavila.domain.service.dto;

import com.pedroavila.domain.entity.enums.StatusBranchOffice;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record BranchOfficeDTO(
        int companyId,

        @NotNull
        @NotEmpty
        String name,

        @NotNull
        @NotEmpty
        String address,

        @Size(max = 10, message = "El número de teléfono no puede tener más de 10 caracteres")
        String phone
        //int status
){} /*{
    public BranchOfficeDTO {
        if (status == 0) {
            status = StatusBranchOffice.ENABLED.getValue();
        }
    }
}*/

