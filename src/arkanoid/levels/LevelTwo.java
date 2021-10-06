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
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 04-06-2021
 */
public class LevelTwo implements LevelInformation {
    /**
     * @return the number of balls in the given level.
     */
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     * @return The initial velocity of each ball
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(Velocity.fromAngleAndSpeed(290, 5));
        v.add(Velocity.fromAngleAndSpeed(305, 5));
        v.add(Velocity.fromAngleAndSpeed(320, 5));
        v.add(Velocity.fromAngleAndSpeed(335, 5));
        v.add(Velocity.fromAngleAndSpeed(350, 5));
        v.add(Velocity.fromAngleAndSpeed(10, 5));
        v.add(Velocity.fromAngleAndSpeed(25, 5));
        v.add(Velocity.fromAngleAndSpeed(40, 5));
        v.add(Velocity.fromAngleAndSpeed(55, 5));
        v.add(Velocity.fromAngleAndSpeed(70, 5));
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
        return 200;
    }

    /**
     * @return the name of the level.
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * @return the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new Block(new Rectangle(new Point(0, 20), 800, 580), Color.BLACK);
    }

    /**
     * The Blocks that make up this level, each block contains, its size, color and location.
     *
     * @return the blocks of the level.
     */
    @Override
    public List<Block> blocks() {
        int columns = 15, width = 51, height = 30;
        Color darkGreen = new Color(29, 101, 51);
        List<Block> blocks = new ArrayList<>();
        for (int j = 0; j < columns; j++) {
            blocks.add(new Block(new arkanoid.geometry.Rectangle(new Point(20 + width * j, 110 + height),
                    width, height), darkGreen));
            }
        return blocks;
    }

    /**
     * @return Number of blocks that should be removed before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
