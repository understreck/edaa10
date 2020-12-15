package uppgifter;

import se.lth.cs.window.SimpleWindow;

public final class Triangle extends Shape {
  /** Skapar en figur med läget x,y */
  Triangle(int xPos, int yPos, int size) {
    super(xPos, yPos);
    m_size = size;
  }

  /** Ritar upp figuren i fönstret w */
  public void draw(SimpleWindow window) {
    window.moveTo(x, y);

    window.lineTo(x + m_size, y);

    double topX = x - m_size * Math.cos(2.0 * Math.PI / 3.0);
    double topY = y - m_size * Math.sin(2.0 * Math.PI / 3.0);

    window.lineTo((int) Math.round(topX), (int) Math.round(topY));
    window.lineTo(x, y);
  }

  /**
   * Raderar bilden av figuren, flyttar figuren till newX,newY och ritar upp den
   * på sin nya plats i fönstret w
   */
  public void moveToAndDraw(SimpleWindow w, int newX, int newY) {
    java.awt.Color savedColor = java.awt.Color.BLACK;
    w.setLineColor(java.awt.Color.WHITE);
    draw(w);
    x = newX;
    y = newY;
    w.setLineColor(savedColor);
    draw(w);
  }

  /** Undersöker om punkten xc,yc ligger "nära" figuren */
  public boolean near(int xc, int yc) {
    return Math.abs(x - xc) < 10 && Math.abs(y - yc) < 10;
  }

  private final int m_size;
}
