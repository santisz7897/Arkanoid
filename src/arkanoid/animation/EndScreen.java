package arkanoid.animation;

import arkanoid.listeners.Counter;
import biuoop.DrawSurface;


/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 06-06-2021
 */
public class EndScreen implements Animation {

    private final boolean win;

    private final Counter score;

    /**
     * the constructor of the class.
     *
     * @param win checks if the player won the game or lost.
     * @param score the score of the player.
     */
    public EndScreen(boolean win, Counter score) {
        this.win = win;
        this.score = score;
    }

    /**
     * does all the actions in a frame.
     *
     * @param d the drawsurface to draw the actions on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // if the player won it sets the win screen and if he lost the game over screen/
        if (this.win) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 32);
        } else {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(), 32);
        }
    }

    /**
     * @return true if the game should stop and false otherwise.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
