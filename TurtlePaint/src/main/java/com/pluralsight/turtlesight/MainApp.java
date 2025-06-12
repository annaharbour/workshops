package com.pluralsight.turtlesight;

import com.pluralsight.turtlesight.models.Square;
import com.pluralsight.turtlesight.models.Turtle;
import com.pluralsight.turtlesight.models.World;
import com.pluralsight.turtlesight.models.Point;
import com.pluralsight.turtlesight.ui.HomeScreen;

import java.awt.*;

public class MainApp
{
    public static void main(String[] args)
    {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

        // The world is your canvas
//        World world = new World(500, 500);
//        Turtle turtle = new Turtle(world);
//        Point location = new Point(20, 20);
//        turtle.penDown();
//        Square square = new Square(turtle, location, "red", 1, 20);
//        square.paint();
//        turtle.penUp();
//        turtle.goTo(100, 100);
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.displayMainMenu();
    }
}
