package uppgifter;

import se.lth.cs.window.SimpleWindow;
import java.util.ArrayList;

public class ShapeList {
  ShapeList() {
    m_shapes = new ArrayList<Shape>();
  }

  public void insert(Shape s) {
    m_shapes.add(s);
  }

  public void draw(SimpleWindow w) {
    for (Shape shape : m_shapes) {
      shape.draw(w);
    }
  }

  public Shape findHit(int xc, int yc) {
    for (Shape shape : m_shapes) {
      if (shape.near(xc, yc)) {
        return shape;
      }
    }

    return null;
  }

  private final ArrayList<Shape> m_shapes;
}
