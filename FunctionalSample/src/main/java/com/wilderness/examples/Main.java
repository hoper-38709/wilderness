package com.wilderness.examples;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Using Lambda Expression for addition
        Calculator additionCalculator = (a, b) -> a + b;

        // Using Lambda Expression for subtraction
        Calculator subtractionCalculator = (a, b) -> a - b;

        // Using Lambda Expression for multiplication
        Calculator multiplicationCalculator = (a, b) -> a * b;

        int resultAddition = additionCalculator.calculate(5, 3);
        int resultSubtraction = subtractionCalculator.calculate(5, 3);
        int resultMultiplication = multiplicationCalculator.calculate(5, 3);

        System.out.println("Modern Approach with Lambda - Addition: " + resultAddition);
        System.out.println("Modern Approach with Lambda - Subtraction: " + resultSubtraction);
        System.out.println("Modern Approach with Lambda - Multiplication: " + resultMultiplication);
    }
}