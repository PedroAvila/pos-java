package com.pedroavila.domain.service;

import com.pedroavila.domain.entity.BranchOffice;
import com.pedroavila.domain.entity.enums.StatusBranchOffice;
import com.pedroavila.domain.repositoryContract.BranchOfficeRepository;
import com.pedroavila.domain.service.dto.CreateBranchOfficeCommad;
import com.pedroavila.domain.service.dto.CreateBranchOfficeResult;
import com.pedroavila.domain.service.dto.GetBranchOfficeQuery;
import com.pedroavila.domain.service.dto.GetBranchOfficeResult;
import com.pedroavila.operations.common.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

    private BranchOfficeRepository branchOfficeRepository;

    @Autowired
    public BranchOfficeServiceImpl(BranchOfficeRepository branchOfficeRepository) {
        this.branchOfficeRepository = branchOfficeRepository;
    }

    @Override
    public GetBranchOfficeResult getAll(GetBranchOfficeQuery query) {
        var result = branchOfficeRepository.findByCompanyId(query.id());
        return new GetBranchOfficeResult(result);
    }

    @Override
    @Transactional
    public CreateBranchOfficeResult save(CreateBranchOfficeCommad command) {

        var branch = new BranchOffice();
        branch.setCompanyId(command.companyId());
        branch.setName(command.name());
        branch.setAddress(command.address());
        branch.setPhone(command.phone());
        branch.setCode(branchOfficeRepository.generarCodigo(branch.getCompanyId()));
        branch.setStatus(StatusBranchOffice.ENABLED.getValue());
        branch.setCreationDate(new Date());

        boolean existName = branchOfficeRepository.existsByCompanyIdAndName(branch.getCompanyId(), branch.getName());
        if (existName)
            throw new BusinessException("El nombre de la sucursal ya existe", HttpStatus.BAD_REQUEST.value());

        branchOfficeRepository.save(branch);
        return new CreateBranchOfficeResult(branch.getId(), branch.getCompanyId(), branch.getCode(),
                branch.getName(), branch.getAddress(), branch.getPhone(), branch.getStatus(), branch.getCreationDate());
    }
}
