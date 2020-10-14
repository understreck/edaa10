package uppgifter;

import se.lth.cs.window.SimpleWindow;
import java.util.Random;
import java.lang.Math;

public class WanderingTurtles {
  public static void moveRandomly(Turtle turtle, Random rand) {
    int wanderLength = rand.nextInt() % 10 + 1;
    int rotation = rand.nextInt(359) - 179;

    turtle.forward(wanderLength);
    turtle.right(rotation);
  }

  public static void main(String[] args) {
    Random rand = new Random();
    SimpleWindow window = new SimpleWindow(600, 600, "Square");

    Turtle turtleOne = new Turtle(window, 250, 250);
    turtleOne.penDown();
    Turtle turtleTwo = new Turtle(window, 350, 350);
    turtleTwo.penDown();

    while (Math.sqrt(Math.pow((double) turtleTwo.getX() - turtleOne.getX(), 2)
        + Math.pow(turtleTwo.getY() - turtleOne.getY(), 2)) >= 50.0) {
      moveRandomly(turtleOne, rand);
      moveRandomly(turtleTwo, rand);
      // SimpleWindow.delay(10);
    }
    // window.close();
  }
}
