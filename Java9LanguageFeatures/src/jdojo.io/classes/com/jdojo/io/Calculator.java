// Calculator.java
package com.jdojo.io;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Read three tokens from the console: operand-1 operation operand-2
        String msg = "You can evaluate an arithmetic expression.\n"
                + "Expression must be in the form: a op b\n"
                + "a and b are two numbers and op is +, -, * or /."
                + "\nPlease enter an expression and press Enter: ";
        System.out.print(msg);

        // Build a scanner for the standard input
        Scanner scanner = new Scanner(System.in);

        try {
            double n1 = scanner.nextDouble();
            String operation = scanner.next();
            double n2 = scanner.nextDouble();

            double result = calculate(n1, n2, operation);
            System.out.printf("%s %s %s = %.2f%n", n1,
                    operation, n2, result);
        } catch (Exception e) {
            System.out.println("An invalid expression.");
        }
    }

    public static double calculate(double op1, double op2, String operation) {
        switch (operation) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
        }

        return Double.NaN;
    }
}
