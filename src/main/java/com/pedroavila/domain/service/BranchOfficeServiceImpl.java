package com.pedroavila.domain.service;

import com.pedroavila.domain.entity.BranchOffice;
import com.pedroavila.domain.entity.enums.StatusBranchOffice;
import com.pedroavila.domain.repositoryContract.BranchOfficeRepository;
import com.pedroavila.domain.service.dto.*;
import com.pedroavila.operations.common.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

    private final BranchOfficeRepository branchOfficeRepository;

    public BranchOfficeServiceImpl(BranchOfficeRepository branchOfficeRepository) {
        this.branchOfficeRepository = branchOfficeRepository;
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<GetBranchOfficeResult> getAllAsync(GetBranchOfficeQuery query) {
        return CompletableFuture.supplyAsync(() -> {
            var result = branchOfficeRepository.findByCompanyId(query.id());
            return new GetBranchOfficeResult(result);
        });
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<CreateBranchOfficeResult> saveAsync(CreateBranchOfficeCommand command) {
        return CompletableFuture.supplyAsync(() -> {
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
        });
    }

    @Async("asyncExecutor")
    @Override
    @Transactional
    public CompletableFuture<Void> updateAsync(UpdateBranchOfficeCommandWithId commandWithId) {
        return CompletableFuture.runAsync(()-> {
            var command = commandWithId.command();
            var id = commandWithId.id();

            var branch = branchOfficeRepository.findById(id)
                    .orElseThrow(() -> new BusinessException("La sucursal no existe", HttpStatus.NOT_FOUND.value()));

            branch.setId(id);
            branch.setCompanyId(command.companyId());
            branch.setName(command.name());
            branch.setAddress(command.address());
            branch.setPhone(command.phone());
            branch.setStatus(command.status());

            branchOfficeRepository.save(branch);
        });
    }
}
