// ID: 324603422
package arkanoid.sprites;

import arkanoid.listeners.Counter;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class ScoreIndicator implements Sprite {

    private final Counter score;

    /**
     * the constructor of the score indicator.
     * @param score the score of the game.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * draws the Arkanoid.Sprites.Sprite on the given surface.
     *
     * @param d the given surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.BLACK);
        d.drawText(350, 20, "Score:" + this.score.toString(), 20);
    }

    /**
     * notifies the sprites that time has passed.
     */
    @Override
    public void timePassed() {
    }
}
