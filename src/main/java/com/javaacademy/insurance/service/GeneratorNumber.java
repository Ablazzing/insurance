package com.javaacademy.insurance.service;

public class GeneratorNumber {
    private static int number = 0;

    public static void main(String[] args) {
        GeneratorNumber ex1 = new GeneratorNumber();
        GeneratorNumber ex2 = new GeneratorNumber();
        String number1 = "ex1: number contract " + ex1.generateNumber();
        String number2 = "ex2: number contract " + ex2.generateNumber();
        String number3 = "ex2: number contract " + ex2.generateNumber();
        String number4 = "ex2: number contract " + ex2.generateNumber();

        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        System.out.println(number4);
    }

    public String generateNumber() {
        number++;
        return "A" + number;
    }
}
