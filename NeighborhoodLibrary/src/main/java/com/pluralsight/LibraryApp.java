package com.pluralsight;

import com.pluralsight.model.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the library app!");
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "978-0134685991", "Effective Java", false, ""));
        books.add(new Book(2, "978-0596009205", "Head First Java", false, ""));
        books.add(new Book(3, "978-1617294945", "Java in Action", false, ""));
        showMenu(scanner, books);
    }

    public static void showMenu(Scanner scanner, ArrayList<Book> books) {
        while (true) {
            System.out.println("\nSelect one of the following options:");
            System.out.println("\tA) Show Available Books");
            System.out.println("\tC) Show Checked Out Books");
            System.out.println("\tX) Exit Program");
            System.out.print("Your selection: ");

            String input = scanner.nextLine().trim().toUpperCase();
            switch (input) {
                case "A":
                    showAvailable(scanner, books);
                    break;
                case "C":
                    showCheckedOut(scanner, books);
                    break;
                case "X":
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid input! Please select A, C, or X.");
            }
        }
    }

    public static void showAvailable(Scanner scanner, ArrayList<Book> books) {
        for (Book book : books) {
            if (!book.getIsCheckedOut()) {
                System.out.println(book);
            }
        }
        while (true) {
            System.out.println("\nSelect one of the following options:");
            System.out.println("\tC) Check Out Book");
            System.out.println("\tR) Return to Menu");

            String input = scanner.nextLine().trim().toUpperCase();
            switch (input) {
                case "C":
                    checkOutBook(scanner, books);
                    break;
                case "R":
                    return;
                default:
                    System.out.println("Invalid input! Please select C or R.");
            }
        }
    }

    public static void showCheckedOut(Scanner scanner, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getIsCheckedOut()) {
                System.out.println(book);
            }
        }
        while (true) {
            System.out.println("\nSelect one of the following options:");
            System.out.println("\tC) Check In Book");
            System.out.println("\tR) Return to Menu");

            String input = scanner.nextLine().trim().toUpperCase();
            switch (input) {
                case "C":
                    checkInBook(scanner, books);
                    break;
                case "R":
                    return;
                default:
                    System.out.println("Invalid input! Please select C or R.");
            }
        }
    }

    public static void checkInBook(Scanner scanner, ArrayList<Book> books) {
        System.out.println("Enter the book id you want to return:");
        try {
            int bookId = scanner.nextInt();
            scanner.nextLine();

            boolean bookFound = false;
            for (Book book : books) {
                if (book.getId() == bookId && book.getIsCheckedOut()) {
                    book.checkIn();
                    System.out.printf("%s successfully returned successfully\n", book.getTitle());
                    System.out.println(book);
                    bookFound = true;
                    break;
                }
            }
            if (!bookFound) {
                System.out.println("Book not found or already checked in.\n");
            }

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        System.out.println("Thank you!");
    }

    public static void checkOutBook(Scanner scanner, ArrayList<Book> books) {
        try {
            System.out.println("Enter an id");
            int bookId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter your name:");
            String name = scanner.nextLine();

            boolean bookFound = false;
            for (Book book : books) {
                if (book.getId() == bookId && !book.getIsCheckedOut()) {
                    book.checkOut(name);
                    System.out.printf("%s successfully checked out\n", book.getTitle());
                    System.out.println(book);
                    bookFound = true;
                    break;
                }
            }
            if (!bookFound) {
                System.out.println("Book not found or already checked out.");
            }

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        System.out.println("Thank you!");

    }

}
