package uppgifter;

import se.lth.cs.window.SimpleWindow;

public class ShapeListTest {
  public static void main(String[] args) {
    SimpleWindow window = new SimpleWindow(600, 600, "ShapeListTest");
    ShapeList shapes = new ShapeList();
    shapes.insert(new Square(100, 300, 100));
    shapes.insert(new Triangle(400, 200, 100));
    shapes.insert(new Circle(400, 400, 50));
    shapes.insert(new Square(450, 450, 50));
    shapes.insert(new Square(200, 200, 35));

    shapes.draw(window);

    Shape selectedShape = null;
    boolean selected = false;

    while (true) {
      window.waitForMouseClick();

      selectedShape = shapes.findHit(window.getMouseX(), window.getMouseY());
      selected = selectedShape != null;

      if (!selected) {
        continue;
      }

      window.waitForMouseClick();
      selectedShape.moveToAndDraw(window, window.getMouseX(), window.getMouseY());
    }
  }
}
