// ID: 324603422

package arkanoid.sprites;

import biuoop.DrawSurface;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public interface Sprite {
    /**
     * draws the Arkanoid.Sprites.Sprite on the given surface.
     * @param d the given surface.
     */
    void drawOn(DrawSurface d);

    /**
     * notifies the sprites that time has passed.
     */
    void timePassed();
}
