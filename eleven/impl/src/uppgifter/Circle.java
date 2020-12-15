package uppgifter;

import se.lth.cs.window.SimpleWindow;

public final class Circle extends Shape {
  /** Skapar en figur med läget x,y */
  Circle(int xPos, int yPos, int radius) {
    super(xPos, yPos);

    m_radius = radius;
    m_subdivisions = 100 + m_radius * m_radius;

    m_stepLength = (2 * Math.PI * m_radius) / m_subdivisions;
    m_stepAngle = (2 * Math.PI) / m_subdivisions;
  }

  /** Ritar upp figuren i fönstret w */
  public void draw(SimpleWindow window) {
    window.moveTo(x, y - m_radius);

    double currentAngle = 0.0;
    double currentX = x;
    double currentY = y - m_radius;

    for (int i = 0; i < m_subdivisions; i++) {
      double nextX = currentX + Math.cos(currentAngle) * m_stepLength;
      double nextY = currentY + Math.sin(currentAngle) * m_stepLength;

      window.lineTo((int) Math.round(nextX), (int) Math.round(nextY));

      currentAngle += m_stepAngle;
      currentX = nextX;
      currentY = nextY;
    }
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

  private final int m_radius;
  private final int m_subdivisions;

  private final double m_stepLength;
  private final double m_stepAngle;
}
