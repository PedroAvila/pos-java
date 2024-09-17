package com.pedroavila.pos.operations.mapper;

import com.pedroavila.pos.domain.entity.BranchOffice;
import com.pedroavila.pos.domain.service.dto.BranchOfficeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BranchOfficeMapper {

    BranchOfficeMapper mapper = Mappers.getMapper(BranchOfficeMapper.class);

    BranchOfficeDTO entityToDto(BranchOffice entity);

    BranchOffice dtoToEntity(BranchOfficeDTO dto);

    List<BranchOfficeDTO> entityToDtos(List<BranchOffice> entity);
}
