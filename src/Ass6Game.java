//ID: 324603422
import arkanoid.animation.AnimationRunner;
import arkanoid.levels.LevelOne;
import arkanoid.levels.LevelTwo;
import arkanoid.levels.LevelInformation;
import arkanoid.levels.LevelThree;
import arkanoid.levels.LevelFour;
import biuoop.GUI;

import arkanoid.levels.GameFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class Ass6Game {

    /**
     * creates a new game class, initializing and running it.
     * @param args the given arguments from the user.
     */
    public static void main(String[] args) {
        List<LevelInformation> l = new ArrayList<>();
            for (String str : args) {
                if (str.equals("1")) {
                    l.add(new LevelOne());
                } else if (str.equals("2")) {
                    l.add(new LevelTwo());
                } else if (str.equals("3")) {
                    l.add(new LevelThree());
                } else if (str.equals("4")) {
                    l.add(new LevelFour());
                }
            }
        if (l.isEmpty()) {
            l.add(new LevelOne());
            l.add(new LevelTwo());
            l.add(new LevelThree());
            l.add(new LevelFour());
        }
        GUI gui = new GUI("arkanoid", 800, 600);
        AnimationRunner animation = new AnimationRunner(gui, 60);
        GameFlow flow = new GameFlow(animation, gui.getKeyboardSensor());
        flow.runLevels(l);
    }
}
