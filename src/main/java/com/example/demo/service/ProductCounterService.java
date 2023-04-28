package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductCounterService {


    private static final Set<Integer> productCounter = ConcurrentHashMap.newKeySet();


    public static Integer getProductCountSize() {
        return productCounter.size();
    }

    public static Set<Integer> getProductCounter() {
        return productCounter;
    }

    public Number getProductQuantity() {
        return getProductCountSize();
    }

}
