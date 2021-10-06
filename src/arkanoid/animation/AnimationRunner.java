package arkanoid.animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 04-06-2021
 */
public class AnimationRunner {

    private final GUI gui;

    private final int framesPerSecond;

    private final Sleeper sleeper;

    /**
     * the constructor of the class.
     * @param g the gui to run the animation on.
     * @param frames the frames of the animation.
     */
    public AnimationRunner(GUI g, int frames) {
        this.gui = g;
        this.framesPerSecond = frames;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * @return the gui of the animation
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * runs the animation in the main loop.
     * @param animation the animation to run
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        // running the animation until the stop condition is true.
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
