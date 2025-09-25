package com.archives.__basic_crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archives.__basic_crud.DTOs.CustomerDto;
import com.archives.__basic_crud.models.CustomersEntity;
import com.archives.__basic_crud.repository.CustomerRepo;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepo customerRepo;

    public CustomerDto registerUser(CustomersEntity customersEntity) {
        CustomersEntity customer = customerRepo.save(customersEntity);
        return new CustomerDto(customer.getEmail(), customer.getEmail());
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepo.findAll()
                .stream()
                .map(customer -> new CustomerDto(customer.getName(), customer.getEmail())).toList();
    }

    public CustomerDto getCustomer(Integer id) {
        return customerRepo.findById(id)
                .map(customer -> new CustomerDto(customer.getName(), customer.getEmail()))
                .orElseThrow();
    }

}
