package com.pluralsight;

import java.util.Scanner;

public class CompoundInterest {

    public static void main(String[] args, String name, Scanner scanner) {
        System.out.printf("%s, you've chosen the Compound Interest Calculator.\n", name);
        // Principal (P): This is the initial deposit amount.
        double P = validateDeposit(scanner, "Enter the amount of your one-time deposit:");
        // Annual Interest Rate (r): The nominal annual interest rate in decimal form (e.g., 1.75% = 0.0175)
        double r = validateInterestRate(scanner, "Enter the annual interest rate (as a percentage such as 1.75%):");
        // Number of Years (t): The total number of years the deposit will earn interest.
        int t = validateYears(scanner, "Enter the number of years the money will be invested:");
        // Future Value (FV)
        double FV = calculateFutureValue(P, r, t);
        System.out.printf("The future value of your investment of %.2f is $%.2f after %d years.\n", P, FV, t);
        // Total Interest Earned = FV - P
        double totalInterestEarned = FV - P;
        System.out.printf("The total interest earned is $%.2f.%n", totalInterestEarned);
    }

    public static double calculateFutureValue(double P, double r, int t) {
        // FV = P × (1 + (r / 365))^(365 × t)
        double FV = P * Math.pow((1 + (r / 365)), (365 * t));
        return FV;
    }

    public static double validateDeposit(Scanner scanner, String message) {
        double P;
        while (true) {
            try {
                System.out.println(message);
                P = scanner.nextDouble();
                if (P < 1) {
                    System.out.println("Please enter a valid deposit amount of $1 or greater.");
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

    public static double validateInterestRate(Scanner scanner, String message) {
        double r;
        while (true) {
            try {
                System.out.println(message);
                r = scanner.nextDouble();
                if (r < 1 || r > 20) {
                    System.out.println("Please enter an interest rate percentage between 1 and 20.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return r / 100;
    }

    public static int validateYears(Scanner scanner, String message) {
        int t;
        while (true) {
            try {
                System.out.println(message);
                t = scanner.nextInt();
                if (t < 1 || t > 50) {
                    System.out.println("Please enter a number between 1 and 50.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        return t;
    }

//    test case:
//    deposit 1000
//    interest 1.75% (remember to divide by 100)
//    years 5
//    balance 1092.62
//    interest earned 92.62
}