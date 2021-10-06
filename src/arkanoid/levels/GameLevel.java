package arkanoid.levels;

import arkanoid.GameEnvironment;
// the animations to import.
import arkanoid.animation.AnimationRunner;
import arkanoid.animation.Animation;
import arkanoid.animation.KeyPressStoppableAnimation;
import arkanoid.animation.PauseScreen;
// the listeners to import
import arkanoid.listeners.BallRemover;
import arkanoid.listeners.BlockRemover;
import arkanoid.listeners.ScoreTrackingListener;
import arkanoid.listeners.Counter;
// the sprites to import.
import arkanoid.sprites.Sprite;
import arkanoid.sprites.LevelName;
import arkanoid.sprites.Ball;
import arkanoid.sprites.Paddle;
import arkanoid.sprites.ScoreIndicator;
import arkanoid.sprites.SpriteCollection;
// the collidables to import.
import arkanoid.collidables.Block;
import arkanoid.collidables.Collidable;
// the geometry to import.
import arkanoid.geometry.Rectangle;
import arkanoid.geometry.Point;
// the biuoop to import.
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class GameLevel implements Animation {

    private final SpriteCollection sprites;

    private final GameEnvironment environment;

    private final Counter remainingBalls;

    private final Counter remainingBlocks;

    private final Counter score;

    private final AnimationRunner runner;

    private boolean running;

    private final biuoop.KeyboardSensor keyboard;

    private final LevelInformation info;

    private boolean win;

    /**
     * the constructor of the game.
     *
     * @param information the levelinformation of this level.
     * @param sensor the keyboard sensor of the gui.
     * @param animation the animation of the level.
     * @param score the score of the player.
     */
    public GameLevel(LevelInformation information, KeyboardSensor sensor, AnimationRunner animation, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.keyboard = sensor;
        this.info = information;
        this.runner = animation;
        this.remainingBlocks = new Counter(this.info.numberOfBlocksToRemove());
        this.score = score;
        this.remainingBalls = new Counter(this.info.numberOfBalls());
        this.win = false;
    }

    /**
     * adds the given collidable to the game environment.
     * @param c the collidable to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * add the given sprite to the sprites collection.
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * removes the given collidable from the game environment.
     * @param c the collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * remove the given sprites from the sprite collection.
     * @param s the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * adds the blocks of the level to the game.
     */
    private void addBlocks() {
        List<Block> blocks = this.info.blocks();
        // creates the blockremover and scoretracking listeners and assigns them to the blocks.
        BlockRemover remover = new BlockRemover(this, this.remainingBlocks);
        ScoreTrackingListener scoreTrack = new ScoreTrackingListener(this.score);
        for (int i = 0; i < blocks.size(); i++) {
                blocks.get(i).addToGame(this);
                blocks.get(i).addHitListener(remover);
                blocks.get(i).addHitListener(scoreTrack);
        }
    }

    /**
     * creates the balls in the level.
     */
    private void createBalls() {
        Point[] bP = new Point[this.remainingBalls.getValue()];
        for (int i = 0; i < this.remainingBalls.getValue(); i++) {
            bP[i] = new Point(400, 560);
        }
        Ball[] ball = new Ball[this.remainingBalls.getValue()];
        for (int i = 0; i < bP.length; i++) {
            ball[i] = new Ball(bP[i], 5, Color.WHITE);
            ball[i].setVelocity(this.info.initialBallVelocities().get(i));
            ball[i].addToGame(this);
            ball[i].setEnvironment(this.environment);
        }
    }

    /**
     * initializes the game, sets the blocks and the ball and the paddle to their correct position and initialize them.
     */
    public void initialize() {
        this.addSprite(this.info.getBackground());
        // creates the balls and sets their values.
        int blockS = 4;
        this.createBalls();
        // creates all the blocks and every row sets a random color.
        this.addBlocks();
        // creates the corners of the screen.
        Point screenLUp = new Point(0, 20), screenR = new Point(780, 20);
        Rectangle[] rS = {new Rectangle(screenLUp, 20, 800), new Rectangle(screenR, 20, 580),
                new Rectangle(screenLUp, 800, 20)};
        Block[] bS = new Block[blockS];
        for (int i = 0; i < rS.length; i++) {
            bS[i] = new Block(rS[i], Color.GRAY);
            bS[i].addToGame(this);
        }
        Block death = new Block(new Rectangle(new Point(-50, 620), 860, 5), Color.GRAY);
        death.addToGame(this);
        BallRemover remove = new BallRemover(this, this.remainingBalls);
        death.addHitListener(remove);
        LevelName name = new LevelName(this.info.levelName());
        ScoreIndicator s = new ScoreIndicator(this.score);
        this.addSprite(s);
        this.addSprite(name);
    }

    /**
     * does all the actions in a frame.
     *
     * @param d the drawsurface to draw the actions on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.remainingBlocks.getValue() == 0) {
            this.score.increase(100);
            this.win = true;
            this.running = false;
        }
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("פ")) {
            Animation p = new PauseScreen();
            Animation pk = new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, p);
            this.runner.run(pk);
        }
    }

    /**
     * @return if the player won or lost.
     */
    public boolean nextLevel() {
        return this.win;
    }

    /**
     * @return true if the game should stop and false otherwise.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }


    /**
     * runs the animation of the game.
     */
    public void run() {
        // creates the paddle and adding it to the game.
        Paddle p = new Paddle(new Rectangle(new Point(380, 594), this.info.paddleWidth(), 5),
                this.keyboard, 21,  779, this.info.paddleSpeed());
        p.addToGame(this);
        this.running = true;
        this.runner.run(this);
        // runs the animation.
    }
}
