package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.Service.CompanyService;
import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class CompanyController {
    //在此处完成Company API
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/companies")
    public ResponseEntity findCompanies() {
        return new ResponseEntity<>(companyService.findCompanies(), HttpStatus.OK);
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity findCompanyById(@PathVariable Long companyId) {
        return new ResponseEntity<>(companyService.findCompanyById(companyId),HttpStatus.OK);
    }

    @GetMapping("/companies/{companyId}/employees")
    public ResponseEntity findEmployeesByCompanyId(@PathVariable Long companyId) {
        return new ResponseEntity<>(companyService.findEmployeesByCompanyId(companyId),HttpStatus.OK);
    }

    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public ResponseEntity findEmployeesByPageByPageSize(@PathVariable int page,@PathVariable int pageSize) {
        return new ResponseEntity<>(companyService.findEmployeesByPageByPageSize(page,pageSize),HttpStatus.OK);
    }

    @PostMapping("/companies")
    public ResponseEntity addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/companies/{companyId}")
    public ResponseEntity updateCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/companies/{companyId}")
    public ResponseEntity deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
