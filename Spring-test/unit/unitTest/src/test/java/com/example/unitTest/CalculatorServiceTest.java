package com.example.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unitTest.repository.CalculatorRepo;
import com.example.unitTest.service.Calculator;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    private CalculatorRepo calculatorRepo;

    @InjectMocks
    private Calculator calculator;

    @Test
    protected void testAdd() {
        int result = calculator.add(5, 3);
        assertEquals(8, result);
        verify(calculatorRepo, times(1)).save(8, 0);
        ;
    }

    @Test
    protected void testDivide() {
        int result = calculator.divide(5, 5);
        assertEquals(1, result);
        verify(calculatorRepo, times(1)).save(1, 0);
    }

    @Test
    void testDivideByZeroThrowsError() {
        Error error = assertThrows(Error.class, () -> calculator.divide(10, 0));
        assertEquals("Division by Zero!", error.getMessage());

        verify(calculatorRepo, never()).save(anyInt(), anyInt());
    }
}
