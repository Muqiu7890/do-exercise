package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.Service.EmployeeService;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class EmployeeController {
    //在此处完成Employee API
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity findEmployees() {
        return new ResponseEntity<>(employeeService.findEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity findEmployeeById(@PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.findEmployeeById(employeeId),HttpStatus.OK);
    }

    @GetMapping("/employees/page/{page}/pageSize/{pageSize}")
    public ResponseEntity findEmployeesByPageByPageSize(@PathVariable int page,@PathVariable int pageSize) {
        return new ResponseEntity<>(employeeService.findEmployeesByPageByPageSize(page,pageSize),HttpStatus.OK);
    }

    @GetMapping("/employees/male")
    public ResponseEntity findEmployeeByMale() {
        return new ResponseEntity<>(employeeService.findEmployeeByMale(),HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity updateEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
