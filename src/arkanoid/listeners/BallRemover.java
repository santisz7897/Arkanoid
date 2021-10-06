package arkanoid.listeners;

import arkanoid.levels.GameLevel;
import arkanoid.collidables.Block;
import arkanoid.sprites.Ball;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class BallRemover implements HitListener {

    private final GameLevel gameLevel;

    private final Counter remainingBalls;

    /**
     * the constructor of the ball remover.
     * @param gameLevel the game of the ball.
     * @param balls the counter of balls.
     */
    public BallRemover(GameLevel gameLevel, Counter balls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = balls;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the block that is getting hit.
     * @param hitter   the ball that hit the given block.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.gameLevel);
    }
}
