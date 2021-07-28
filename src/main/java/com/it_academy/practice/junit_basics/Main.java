package com.it_academy.practice.junit_basics;


public class Main {
    public static void main(String[] args) {

        int [] paramArray = Calculator.inputNeededParameters();

        Calculator calculatorNew = new Calculator(paramArray);

        System.out.println("Plus result: " + calculatorNew.calculate('+'));
        System.out.println("Minus result: " + calculatorNew.calculate('-'));
        System.out.println("Division result: " + calculatorNew.calculate('/'));
        System.out.println("Multiply result: " + calculatorNew.calculate('*'));
        System.out.println("Degree  result: " + calculatorNew.calculate('^'));
        System.out.println("Radical result: " + calculatorNew.calculate('q'));
    }
}
