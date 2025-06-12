package com.pluralsight.turtlesight.ui;

import com.pluralsight.turtlesight.models.*;

import java.util.Arrays;
import java.util.Scanner;

public class HomeScreen {
    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);

        //        Create the new world
        System.out.println("Enter the width of the world canvas");
        int width = scanner.nextInt();
        System.out.println("Enter the height of the world canvas");
        int height = scanner.nextInt();
        World world = new World(width, height);

        //       User action Selection
        String[] menuOptions = {"1) Add Shape", "2) Save Image", "0) Exit"};
        Arrays.stream(menuOptions).forEach(System.out::println);
        int choice;
        do {
            choice = scanner.nextInt();
            switch (choice) {
                case 0 -> System.out.println("Exiting...");
                case 1 -> addShape(world, scanner);
                case 2 -> saveImage(world, scanner);
                default -> System.out.println("Invalid choice.");
            }
            if (choice != 0) {
                Arrays.stream(menuOptions).forEach(System.out::println);
            }
        } while (choice != 0);
    }

    public void addShape(World world, Scanner scanner) {
        System.out.println("Choose a shape: ");
        String[] shapeOptions = {"1) Square", "2) Circle", "3) Triangle"};
        Arrays.stream(shapeOptions).forEach(System.out::println);
        int choice = scanner.nextInt();
        if (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Incorrect choice");
            return;
        }
        System.out.printf("What is the %s", choice == 2 ? "radius" : "length");
        int length = scanner.nextInt();

        System.out.println("What is the border width?");
        int borderWidth = scanner.nextInt();

        System.out.println("What is the x coordinate of the shape?");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is the y coordinate of the shape?");
        int y = scanner.nextInt();
        Point location = new Point(x, y);
        scanner.nextLine();

        Turtle turtle = new Turtle(world);
        System.out.println("Choose a color: red, blue, magenta, cyan");
        String turtleColor = scanner.nextLine();

        switch (choice) {
            case 1 -> {
                Square square = new Square(turtle, location, turtleColor, borderWidth, length);
                square.paint();
            }
            case 2 -> {
                Circle circle = new Circle(turtle, location, turtleColor, borderWidth, length);
                circle.paint();
            }
            case 3 -> {
                Triangle triangle = new Triangle(turtle, location, turtleColor, borderWidth, length);
                triangle.paint();

            }
            default -> System.out.println("Invalid shape");
        }
    }

    public void saveImage(World world, Scanner scanner) {
        System.out.println("Enter the image file name: ");
        String fileName = scanner.nextLine();
        world.saveAs(fileName + ".png");
    }
}
