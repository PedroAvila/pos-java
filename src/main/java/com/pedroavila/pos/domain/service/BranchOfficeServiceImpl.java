package com.pedroavila.pos.domain.service;

import com.pedroavila.pos.domain.entity.BranchOffice;
import com.pedroavila.pos.domain.repositorycontrac.BranchOfficeRepository;
import com.pedroavila.pos.operations.common.CustomException;
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
    @Transactional
    public BranchOffice save(BranchOffice entity) {

        boolean existName = branchOfficeRepository.existsByCompanyIdAndName(entity.getCompanyId(), entity.getName());
        if (existName)
            throw new CustomException("El nombre de la sucursal ya existe", HttpStatus.BAD_REQUEST.value());

        entity.setCode(branchOfficeRepository.generarCodigo(entity.getCompanyId()));
        entity.setCreationDate(new Date());
        return branchOfficeRepository.save(entity);
    }
}
