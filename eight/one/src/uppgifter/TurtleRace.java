package uppgifter;

import se.lth.cs.window.SimpleWindow;

public class TurtleRace {
    public static void main(String[] args) {
        final SimpleWindow window = new SimpleWindow(600, 800, "race");
        final RacingEvent race = new RacingEvent(new RaceTrack(700, 100), new Turtle(window, 200, 0),
                new Turtle(window, 400, 0));

        race.startPositions(window);
        race.start();
    }
}
