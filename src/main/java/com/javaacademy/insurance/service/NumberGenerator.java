package com.javaacademy.insurance.service;

import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {
    private int number = 0;

    public String generateNumber() {
        number++;
        return "A" + number;
    }
}
