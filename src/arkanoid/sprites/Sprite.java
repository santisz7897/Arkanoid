// ID: 208985424

package arkanoid.sprites;

import biuoop.DrawSurface;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 17-04-2021
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
