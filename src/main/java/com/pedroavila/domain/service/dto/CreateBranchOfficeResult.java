package com.pedroavila.domain.service.dto;

import java.util.Date;

public record CreateBranchOfficeResult(Long id, int companyId, int code, String name, String address, String phone, int status, Date creationDate) {
}
