package uppgifter;

import se.lth.cs.window.SimpleWindow;

public class Turtle {
  /**
   * skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
   * sköldpaddan i punkten xHome,yHome med pennan lyft och huvudet pekande rakt
   * uppåt i fönstret, dvs i negativ y-riktning
   */
  Turtle(SimpleWindow w, int xHome, int yHome) {
    m_windowRef = w;
    m_posX = xHome;
    m_posY = yHome;
  }

  /** sänker pennan */
  void penDown() {
    m_penDown = true;
  }

  /** lyfter pennan */
  void penUp() {
    m_penDown = false;
  }

  private static double xCathetus(double theta, double hypotenuse) {
    return hypotenuse * Math.cos(theta);
  }

  private static double yCathetus(double theta, double hypotenuse) {
    return hypotenuse * Math.sin(theta);
  }

  /** går rakt framåt n pixlar i huvudets riktning */
  void forward(int n) {
    m_windowRef.moveTo(m_posX, m_posY);

    m_posX += (int) xCathetus(m_direction, (double) n);
    m_posY -= (int) yCathetus(m_direction, (double) n);

    if (m_penDown) {
      m_windowRef.lineTo(m_posX, m_posY);
    } else {
      m_windowRef.moveTo(m_posX, m_posY);
    }
  }

  private static double normalizeRadians(double angle) {
    final double TAU = Math.PI * 2.0;

    if (angle > Math.PI) {
      angle -= TAU;
    } else if (angle <= -Math.PI) {
      angle += TAU;
    }

    return angle;
  }

  /** vrider huvudet beta grader åt vänster */
  void left(int beta) {
    m_direction += Math.toRadians(beta);
    m_direction = normalizeRadians(m_direction);
  }

  /** vrider hvudet beta grader åt höger */
  void right(int beta) {
    m_direction -= Math.toRadians(beta);
    m_direction = normalizeRadians(m_direction);
  }

  /**
   * går till punkten newX,newY utan att rita. Pennans läge och huvudets riktning
   * påverkas inte
   */
  void jumpTo(int newX, int newY) {
    m_posX = newX;
    m_posY = newY;

    m_windowRef.moveTo(m_posX, m_posY);
  }

  /** återställer huvudets riktning till den ursprungliga */
  void turnNorth() {
    m_direction = Math.PI / 2.0;
  }

  /** tar reda på sköldpaddans aktuella x-koordinat */
  int getX() {
    return m_posX;
  }

  /** tar reda på sköldpaddans aktuella y-koordinat */
  int getY() {
    return m_posY;
  }

  private final SimpleWindow m_windowRef;

  private int m_posX;
  private int m_posY;

  private double m_direction = Math.PI / 2.0;
  private boolean m_penDown = false;
}
