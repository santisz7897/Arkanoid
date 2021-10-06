package arkanoid.levels;

import arkanoid.animation.AnimationRunner;

import arkanoid.animation.EndScreen;
import arkanoid.animation.KeyPressStoppableAnimation;
import arkanoid.listeners.Counter;
import arkanoid.animation.Animation;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class GameFlow {

    private final KeyboardSensor keyboardSensor;

    private final AnimationRunner animationRunner;

    private boolean win;

    private final Counter score;

    /**
     * the constructor of the class.
     * @param ar the animation to run.
     * @param ks the keyboard sensor of the gui.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter(0);
        this.win = true;
    }

    /**
     * running the levels of the game.
     * @param levels the levels to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.score);
            level.initialize();
            level.run();
            // if the player won the level it takes him to the next level.
            if (level.nextLevel()) {
                continue;
            }
            // if the player lost the level it ends the game.
            if (level.shouldStop()) {
                this.win = false;
                break;
            }
        }
        // runs the end screen and closes the game.
        Animation end = new EndScreen(this.win, this.score);
        Animation endk = new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY, end);
        this.animationRunner.run(endk);
        this.animationRunner.getGui().close();
    }
}
