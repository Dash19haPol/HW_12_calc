package org.example;
/**
 * To run:
 * java -jar HW_calculator-1.0-SNAPSHOT.jar 10 8 +
 */

public class Calculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide two numbers and an operation (e.g. 5 3 +).");
            return;
        }

        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            String operation = args[2];

            Calculator calculator = new Calculator();
            double result = calculator.calculate(num1, num2, operation);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please provide valid numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private double calculate(double num1, double num2, String operation) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "x" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    throw new IllegalArgumentException("Error: Division by zero.");
                }
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Invalid operation. Supported operations: +, -, x, /");
        };
    }

}