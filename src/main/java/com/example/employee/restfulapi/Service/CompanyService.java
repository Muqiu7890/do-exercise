package com.example.employee.restfulapi.Service;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List findCompanies() {
        return companyRepository.findAll();
    }

    public Company findCompanyById(Long companyId) {
        return companyRepository.findOne(companyId);
    }

    public List<Employee> findEmployeesByCompanyId(Long companyId) {
        return companyRepository.findOne(companyId).getEmployees();
    }

    public Page<Company> findEmployeesByPageByPageSize(int page, int pageSize) {
        return companyRepository.findAll(new PageRequest(page-1,pageSize));
    }

    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteCompany(Long CompanyId) {
        companyRepository.delete(CompanyId);
    }
}
