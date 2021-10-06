package arkanoid.animation;

import biuoop.DrawSurface;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public interface Animation {
    /**
     * does all the actions in a frame.
     * @param d the drawsurface to draw the actions on.
     */
    void doOneFrame(DrawSurface d);

    /**
     *
     * @return true if the game should stop and false otherwise.
     */
    boolean shouldStop();
}
