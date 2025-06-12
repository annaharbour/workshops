package com.pluralsight.turtlesight.models;

import java.awt.*;

public abstract class Shape {
//    the turtle that is used to paint the shape
    protected Turtle turtle;
//    Point -- the x,y coordinate where the shape should be drawn
    protected Point location;
    //color: the color used for the border
    protected String color;
    //border: the width of the shape border
    protected int border;

    public Shape(Turtle turtle, Point location, String color, int border) {
        this.turtle = turtle;
        this.location = location;
        this.color = color;
        this.border = border;
    }

    public void setTurtleColor(){
        switch (color.toUpperCase()) {
            case "RED" -> turtle.setColor(Color.RED);
            case "BLUE" -> turtle.setColor(Color.BLUE);
            case "MAGENTA" -> turtle.setColor(Color.MAGENTA);
            case "CYAN" -> turtle.setColor(Color.CYAN);
            default -> turtle.setColor(Color.GREEN);
        }
    }

    //paint() - the method that paints the shape
    abstract void paint();
}
