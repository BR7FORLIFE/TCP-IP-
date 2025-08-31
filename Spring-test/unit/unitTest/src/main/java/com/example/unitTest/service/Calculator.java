package com.example.unitTest.service;

import org.springframework.stereotype.Service;

import com.example.unitTest.repository.CalculatorRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Calculator {

    private int index = 0;
    private final CalculatorRepo calculatorRepo;

    public int add(int a, int b) {
        int result = a + b;
        calculatorRepo.save(result, index);
        index++;
        return result;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new Error("Division by Zero!");
        }
        int result = a / b;
        calculatorRepo.save(result, index);
        index++;
        return result;
    }
}
