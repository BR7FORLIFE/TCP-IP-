package com.example.unitTest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepo {

    private Map<Integer, Integer> results = new HashMap<>();
    private ArrayList<Map<Integer, Integer>> saveResults = new ArrayList<>();

    public void save(int result, int index) {
        results.put(index, result);
        saveResults.add(results);
    }

}
