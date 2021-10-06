package arkanoid.sprites;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 06-06-2021
 */
public class Level3Background implements Sprite {

    /**
     * draws the Sprite on the given surface.
     *
     * @param d the given surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(154, 119, 47));
        d.fillRectangle(0, 20, 800, 580);
        d.setColor(Color.BLACK);
    }

    /**
     * notifies the sprites that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
