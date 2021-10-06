//ID: 324603422
package arkanoid.sprites;

import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class SpriteCollection {

    private java.util.List<Sprite> sprites = new ArrayList<>();

    /**
     * add the given sprite to the collection.
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * removes the spirte from the sprite list.
     * @param s the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * loops over all the sprites and notifies them that time has passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }

    /**
     * loops over all the sprites and draws the on the given surface.
     * @param d the surface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.sprites) {
            sprite.drawOn(d);
        }
    }
}
