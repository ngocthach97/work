package com.example.traning.Web.rest;

import com.example.traning.Common.Payload.Request.Search;
import com.example.traning.Model.Entity.Employee;
import com.example.traning.Repository.Repository.EmployeeRepository;
import com.example.traning.Repository.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeAPI {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProductRepository productRepository;
    @PostMapping(value = "/update")
    public ResponseEntity<Boolean> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Boolean>(employeeRepository.updateEmployee(employee), HttpStatus.OK);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<Object>> searchEmployee(@RequestBody Search search) {
        List<Object> list = employeeRepository.getOrSearchEmployee(search);
        return new ResponseEntity<List<Object>>(list, HttpStatus.OK);
    }
}
