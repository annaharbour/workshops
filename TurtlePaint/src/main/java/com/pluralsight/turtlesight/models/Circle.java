package com.pluralsight.turtlesight.models;

public class Circle extends Shape {
    private int radius;

    public Circle(Turtle turtle, Point location, String color, int border, int radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    public void paint(){
        this.setTurtleColor();
        turtle.penUp();
        turtle.setPenWidth(border);
        turtle.goTo(location.getX(), location.getY());
        turtle.penDown();
//        double circumference = 2 * Math.PI * radius;
//
//        for (int i = 0; i < 720; i++) { // Increase the number of steps for smoother circle
//            turtle.forward(circumference / 720); // Adjust the step size accordingly
//            turtle.turnRight(0.5); // Turn by a smaller angle
//        }
        double circumference = 2 * Math.PI * radius; // Calculate the circumference
        int steps = 360; // Number of steps to approximate the circle
        double stepLength = circumference / steps; // Length of each step
        double stepAngle = 360.0 / steps; // Angle to turn at each step

        for (int i = 0; i < steps; i++) {
            turtle.forward(stepLength); // Move forward by the step length
            turtle.turnRight(stepAngle); // Turn right by the step angle
        }
        turtle.penUp(); // Lift the pen when done


    }

}
