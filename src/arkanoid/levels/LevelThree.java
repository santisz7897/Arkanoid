package arkanoid.levels;

import arkanoid.Velocity;
import arkanoid.collidables.Block;
import arkanoid.geometry.Point;
import arkanoid.geometry.Rectangle;
import arkanoid.sprites.Level3Background;
import arkanoid.sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 16-06-2021
 */
public class LevelThree implements LevelInformation {


    /**
     * @return the number of balls in the given level.
     */
    @Override
    public int numberOfBalls() {
        return 2;
    }

    /**
     * @return The initial velocity of each ball.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(Velocity.fromAngleAndSpeed(330, 5));
        v.add(Velocity.fromAngleAndSpeed(30, 5));
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
        return 100;
    }

    /**
     * @return the level name will be displayed at the top of the screen.
     */
    @Override
    public String levelName() {
        return "Green 3";
    }

    /**
     * @return a sprite with the background of the level
     */
    @Override
    public Sprite getBackground() {
        return new Level3Background();
    }

    /**
     * The Blocks that make up this level, each block contains, its size, color and location.
     *
     * @return the blocks of the level.
     */
    @Override
    public List<Block> blocks() {
        int rows = 5, columns = 10, width = 40, height = 20;
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < columns; j++) {
                blocks.add(new Block(new Rectangle(new Point(380 + width * j, 100 + height * i),
                        width, height), Color.RED));
            }
        }
        return blocks;
    }

    /**
     * @return Number of blocks that should be removed before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
