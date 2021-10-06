package arkanoid.listeners;

import arkanoid.collidables.Block;
import arkanoid.sprites.Ball;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that is getting hit.
     * @param hitter the ball that hit the given block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
