package com.pedroavila.pos.domain.repositorycontrac;

import com.pedroavila.pos.domain.entity.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Integer> {

    @Query(value = "SELECT COALESCE(MAX(b.code), 0) + 1 FROM BranchOffice b WHERE b.companyId = :companyId")
    Integer generarCodigo(@Param("companyId") Integer companyId);

    /*@Query(value = "SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM BranchOffice b WHERE b.companyId = :companyId AND b.name = :name")
    Boolean existsNombreByCompany(@Param("companyId") Integer companyId, @Param("name") String name);*/

    Boolean existsByCompanyIdAndName(Integer companyId, String name);
}
