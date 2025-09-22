package com.archives.__basic_crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archives.__basic_crud.repository.ProductsRepo;

@Service
public class ProductServices {
    
    @Autowired
    private ProductsRepo productsRepo;
}
