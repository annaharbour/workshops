package com.pluralsight.turtlesight.models;

public class Triangle extends Shape {
    private int sideLength;

    public Triangle(Turtle turtle, Point location, String color, int border, int sideLength) {
        super(turtle, location, color, border);
        this.sideLength = sideLength;
    }

    public void paint() {
        turtle.penUp();
        this.setTurtleColor();
        turtle.setPenWidth(border);
        turtle.goTo(location.getX(), location.getY());
        turtle.penDown();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < sideLength; j++) {
                turtle.forward(1);
            }
            turtle.turnRight(120);
        }

//        int width = 200;
//        int height = 200;
//
//        // calculate the hypotenuse (diagonal)
//        // a2 + b2 = c2
//        double widthSquared = Math.pow(width, 2);
//        double heightSquared = Math.pow(height, 2);
//        double hypotenuse = Math.sqrt(widthSquared + heightSquared);
//
//        turtle.setPenWidth(3);
//        turtle.setColor(Color.GREEN);
//
//        turtle.turnRight(45);
//        turtle.forward(hypotenuse);
//
//        turtle.penUp();
//        turtle.goTo(100, 100);
//        turtle.turnRight(90);
//
//        turtle.penDown();
//        turtle.forward(hypotenuse);
    }

}
