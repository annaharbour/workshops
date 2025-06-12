package com.pluralsight.turtlesight.models;

import java.awt.*;

public class Square extends Shape {
    private int length;

    public Square(Turtle turtle, Point location, String color, int border, int length) {
        super(turtle, location, color, border);
        this.length = length;
    }

    public void paint() {
        turtle.penUp();
        this.setTurtleColor();
        turtle.setPenWidth(border);
        turtle.goTo(location.getX(), location.getY());
        turtle.penDown();
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < length; j++){
                turtle.forward(1);
            }
            turtle.turnRight(90);
        }

    }

}
