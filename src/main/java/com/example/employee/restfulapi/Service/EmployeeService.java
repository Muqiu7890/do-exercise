package com.example.employee.restfulapi.Service;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List findEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    public List<Employee> findEmployeeByMale() {
        return employeeRepository.findByGender("male");
    }

    public Page<Employee> findEmployeesByPageByPageSize(int page, int pageSize) {
        return employeeRepository.findAll(new PageRequest(page-1,pageSize));
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.delete(employeeId);
    }

}
