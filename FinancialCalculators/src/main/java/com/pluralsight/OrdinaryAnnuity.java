package com.pluralsight;

import java.util.Scanner;

public class OrdinaryAnnuity {

    public static void main(String[] args, String name, Scanner scanner) {
        System.out.printf("%s, you've chosen the Ordinary Annuity Calculator\n", name);
//        number of periods
        int n = validateYears(scanner, "How many years do you want to save for?");
//        monthly interest rate
        double r = validateInterestRate(scanner, "What is the expected monthly interest rate as a percentage? (1-20)");
//        payment per period
        double PMT = validatePMT(scanner, "What is the amount of your monthly annuity?");

        double PV = calculatePV(PMT, n, r);
        System.out.printf("%s, you need to invest $%.2f today in order to earn a monthly annuity of $%.2f over the " +
                        "next %d years.", name, PV, PMT
                , n / 12);
    }

    public static double calculatePV(double PMT, int n, double r) {
//        Formula: PV = PMT * [(1 - (1 + r)^-n) / r]
        double PV = PMT * (1 - Math.pow(1 + r, -n)) / r;
        return PV;
    }

    public static int validateYears(Scanner scanner, String message) {
        int y = 0;
        while (true) {
            try {
                System.out.println(message);
                y = scanner.nextInt();
                if (y < 1 || y > 50) {
                    System.out.println("Please enter a number of years between 1 and 50.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number of years.");
                scanner.next();
            }
        }
//        return number of periods
//        12 months times number of years equals number of periods
        int n = y * 12;
        return n;
    }

    public static double validateInterestRate(Scanner scanner, String message) {
        double r = 0;
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
                scanner.next();
            }
        }
//        return monthly interest rate (dividing by num months in year and converting perc to dec for formula)
        return r / 1200;
    }

    public static double validatePMT(Scanner scanner, String message) {
        double PMT;
        while (true) {
            try {
                System.out.println(message);
                PMT = scanner.nextDouble();
                if (PMT < 1 || PMT > 1000000) {
                    System.out.println("Please enter a valid deposit between $1-100,000.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        return PMT;
    }
//    Test case:
//     $3,000 monthly annuity
//     20 years
//     earns an expected 2.5% interest
//     you would need to invest $566,141.46 today
}
