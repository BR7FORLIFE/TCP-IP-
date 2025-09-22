package com.archives.__basic_crud.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.__basic_crud.DTOs.CustomerDto;
import com.archives.__basic_crud.models.CustomersEntity;
import com.archives.__basic_crud.services.CustomerServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerServices customerServices;

    @PostMapping("/register")
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody @Valid CustomersEntity customerEntity) {
        CustomerDto customer = customerServices.registerUser(customerEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerServices.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @PostMapping("/get")
    public ResponseEntity<CustomerDto> getCustomer(@RequestBody Integer id) {
        CustomerDto customerDto = customerServices.getCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
}
