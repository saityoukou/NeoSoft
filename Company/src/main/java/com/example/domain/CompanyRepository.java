package com.example.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByTel(@Param("tel") String telNum);
    
    List<Company> findByCompanyName(@Param("companyName") String companyName);
}