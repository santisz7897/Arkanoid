package arkanoid.sprites;

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 06-06-2021
 */
public class LevelName implements Sprite {

    private final String name;

    /**
     * @param name the name of the level.
     */
    public LevelName(String name) {
        this.name = name;
    }

    /**
     * draws the Arkanoid.Sprites.Sprite on the given surface.
     *
     * @param d the given surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(450, 20, "Level Name:" + name, 20);
    }

    /**
     * notifies the sprites that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
