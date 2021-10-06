package arkanoid.levels;

import arkanoid.Velocity;
import arkanoid.sprites.Sprite;
import arkanoid.collidables.Block;

import java.util.List;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public interface LevelInformation {

    /**
     * @return the number of balls in the given level.
     */
    int numberOfBalls();

    /**
     * @return The initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the speed of the paddle.
     */
    int paddleSpeed();

    /**
     * @return the width paddle.
     */
    int paddleWidth();

    /**
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains, its size, color and location.
     * @return the blocks of the level.
     */
    List<Block> blocks();

    /**
     *
     * @return Number of blocks that should be removed before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}
