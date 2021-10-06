package arkanoid.levels;

import arkanoid.Velocity;
import arkanoid.collidables.Block;
import arkanoid.geometry.Point;
import arkanoid.geometry.Rectangle;
import arkanoid.sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class LevelFour implements LevelInformation {
    /**
     * @return the number of balls in the given level.
     */
    @Override
    public int numberOfBalls() {
        return 3;
    }

    /**
     * @return The initial velocity of each ball.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(Velocity.fromAngleAndSpeed(0, 5));
        v.add(Velocity.fromAngleAndSpeed(320, 5));
        v.add(Velocity.fromAngleAndSpeed(40, 5));
        return v;
    }

    /**
     * @return the speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return 10;
    }

    /**
     * @return the width paddle.
     */
    @Override
    public int paddleWidth() {
        return 70;
    }

    /**
     * @return the level name will be displayed at the top of the screen.
     */
    @Override
    public String levelName() {
        return "Final Four";
    }

    /**
     * @return a sprite with the background of the level
     */
    @Override
    public Sprite getBackground() {
        return new Block(new Rectangle(new Point(0, 20), 800, 580), Color.BLACK);
    }

    /**
     * The Blocks that make up this level, each block contains, its size, color and location.
     * @return the blocks of the level.
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {Color.ORANGE, Color.YELLOW, Color.RED, Color.WHITE, Color.cyan, Color.DARK_GRAY, Color.GREEN};
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 20; col++) {
                blocks.add(new Block(new Rectangle(new Point(20 + (40 * col), 100 + (20 * row)), 40, 20),
                        colors[row]));
            }
        }
        return blocks;
    }

    /**
     * @return Number of blocks that should be removed before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 140;
    }
}
