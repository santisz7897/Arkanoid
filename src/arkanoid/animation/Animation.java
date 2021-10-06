package arkanoid.animation;

import biuoop.DrawSurface;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 2.
 * @since 04-06-2021
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
