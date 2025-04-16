package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args, String name, Scanner scanner) {
        MortgageCalculator mortgageCalculator = new MortgageCalculator();
        System.out.printf("%s, you've selected the Mortgage Calculator.\n", name);
//      collect user input - ensure they are valid amounts
        double P = mortgageCalculator.validatePrinciple(scanner, "Enter your principal: ");
        double r = mortgageCalculator.validateRate(scanner, "Enter your interest rate percentage (ie 7.625): ");
        int y = mortgageCalculator.validateYears(scanner, "Enter your loan term in years: ");
        scanner.close();
//      number of monthly payments
        double n = 12 * y;
//      monthly interest rate
        double i = r / 12;
//      monthly payment
        double M = P * (i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1);
//      total interest
        double totalInterest = (M * n) - P;

//      output
        System.out.printf("Your monthly payment is: $%.2f\n", M);
        System.out.printf("Your total interest is: $%.2f\n", totalInterest);

//    test case:
//    53k Principle
//    7.625% interest rate
//    15-year loan term
//    $495.09/mo payment
//    total interest of $36115.99
    }


    public double validatePrinciple(Scanner scanner, String message) {
        double P;
        while (true) {
            try {
                System.out.println(message);
                P = scanner.nextDouble();
                if (P < 10000) {
                    System.out.println("We only loan amounts greater than $10,000.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        return P;
    }

    public int validateYears(Scanner scanner, String message) {
        int y;
        while (true) {
            try {
                System.out.println(message);
                y = scanner.nextInt();
                if (y < 1 || y > 50) {
                    System.out.println("Please enter a number between 1 and 50.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        return y;
    }

    public double validateRate(Scanner scanner, String message) {
        double r;
        while (true) {
            try {
                System.out.println(message);
                r = scanner.nextDouble();
                if (r < 0.01 || r > 20) {
                    System.out.println("Please enter an interest rate percentage between 1 and 20.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        return r / 100;
    }

}

