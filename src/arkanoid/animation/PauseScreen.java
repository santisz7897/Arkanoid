package arkanoid.animation;

import biuoop.DrawSurface;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class PauseScreen implements Animation {

    /**
     * does all the actions in a frame.
     *
     * @param d the drawsurface to draw the actions on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * @return true if the game should stop and false otherwise.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
