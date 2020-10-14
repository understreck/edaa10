package uppgifter;

import java.util.Random;

import se.lth.cs.window.SimpleWindow;

public class RacingEvent {
    RacingEvent(RaceTrack track, Turtle left, Turtle right) {
        m_track = track;
        m_leftRacer = left;
        m_rightRacer = right;
    }

    void startPositions(SimpleWindow window) {
        window.clear();
        m_track.draw(window);

        m_leftRacer.turnNorth();
        m_leftRacer.jumpTo(m_leftRacer.getX(), m_track.yStart);
        m_leftRacer.penDown();

        m_rightRacer.turnNorth();
        m_rightRacer.jumpTo(m_rightRacer.getX(), m_track.yStart);
        m_rightRacer.penDown();
    }

    void start() {
        while ((m_leftRacer.getY() > m_track.yFinish) && (m_rightRacer.getY() > m_track.yFinish)) {
            m_leftRacer.forward(rng.nextInt(3));
            m_rightRacer.forward(rng.nextInt(3));

            SimpleWindow.delay(10);
        }

        System.out.println((m_leftRacer.getY() <= m_track.yFinish ? "Left" : "Right") + " wins the race!");
    }

    private final RaceTrack m_track;
    private final Turtle m_leftRacer;
    private final Turtle m_rightRacer;

    private final Random rng = new Random();
}
