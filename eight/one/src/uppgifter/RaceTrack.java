package uppgifter;

import se.lth.cs.window.SimpleWindow;

public class RaceTrack {
  RaceTrack(int yStart, int yFinish) {
    this.yStart = yStart;
    this.yFinish = yFinish;
  }

  static void drawLineWithinWindow(SimpleWindow window, int yLevel) {
    final int clampedY = Math.min(window.getHeight(), yLevel);

    window.moveTo(0, clampedY);
    window.lineTo(window.getWidth(), clampedY);
  }

  void draw(SimpleWindow window) {
    drawLineWithinWindow(window, yStart);
    drawLineWithinWindow(window, yFinish);
  }

  final int yStart;
  final int yFinish;
}
