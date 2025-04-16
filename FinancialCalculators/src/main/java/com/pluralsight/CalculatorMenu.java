package com.pluralsight;

import java.util.Scanner;

public class CalculatorMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, welcome to Financial Calc Org.");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.printf("%s, please select a calculator option from the menu: \n 1) Mortgage Calculator \n 2) " +
                "Compound Interest Calculator \n 3) Ordinary Annuity Calculator \n", name);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Loading...");
                MortgageCalculator.main(null, name, scanner);
                break;
            case 2:
                System.out.println("Loading...");
                CompoundInterest.main(null, name, scanner);
                break;
            case 3:
                System.out.println("You've selected the Ordinary Annuity Calculator. \n Loading...");
                OrdinaryAnnuity.main(null, name, scanner);
                break;
            case 4:
                System.out.println("Exiting calculator menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}