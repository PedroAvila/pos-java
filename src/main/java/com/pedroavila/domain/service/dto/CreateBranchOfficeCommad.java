package com.pedroavila.domain.service.dto;

import jakarta.validation.constraints.*;

public record CreateBranchOfficeCommad(

        @Min(value = 1, message = "El ID de la compañía debe ser mayor que 0")
        int companyId,

        @NotBlank
        String name,

        @NotBlank
        String address,

        @NotBlank
        @Size(max = 10, message = "El número de teléfono no puede tener más de 10 caracteres")
        String phone

){}

