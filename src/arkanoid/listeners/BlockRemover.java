package arkanoid.listeners;

import arkanoid.collidables.Block;
import arkanoid.levels.GameLevel;
import arkanoid.sprites.Ball;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 20-05-2021
 */
public class BlockRemover implements HitListener {

    private final GameLevel gameLevel;

    private final Counter remainingBlocks;

    /**
     * the constructor of the block remover.
     * @param gameLevel the game of the listener.
     * @param removedBlocks the ammount of blocks in the game.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
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
        this.remainingBlocks.decrease(1);
        beingHit.removeFromGame(this.gameLevel);
        beingHit.removeHitListener(this);
    }
}
