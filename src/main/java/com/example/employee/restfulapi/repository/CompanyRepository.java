package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Override
    List<Company> findAll();

    @Override
    Page<Company> findAll(Pageable pageable);

}
