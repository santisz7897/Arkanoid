// ID: 324603422
package arkanoid.collidables;

import arkanoid.levels.GameLevel;
import arkanoid.Velocity;

import arkanoid.geometry.Rectangle;
import arkanoid.geometry.Point;

import arkanoid.listeners.HitListener;
import arkanoid.listeners.HitNotifier;

import arkanoid.sprites.Sprite;
import arkanoid.sprites.Ball;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private final Rectangle form;

    private final java.awt.Color color;

    private final List<HitListener> hitListeners;

    /**
     * the constructor for the block, sets its form as the given rectangle.
     *
     * @param rectangle the form of the block.
     * @param c the color of the block.
     */
    public Block(Rectangle rectangle, java.awt.Color c) {
        this.form = rectangle;
        this.color = c;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * draws the block on the given surface.
     *
     * @param d the drawsurface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.form.getUpperLeft().getX(), (int) this.form.getUpperLeft().getY(),
                (int) this.form.getWidth(), (int) this.form.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.form.getUpperLeft().getX(), (int) this.form.getUpperLeft().getY(),
                (int) this.form.getWidth(), (int) this.form.getHeight());
    }

    /**
     * adds the object to the given game.
     * @param g the game to add the object to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     *
     * @return the form of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.form;
    }

    /**
     * notifies the listener that this block got hit.
     *@param hitter the ball that hit this block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * if the ball hit the block it will change his velocity.
     *
     * @param collisionPoint the point where the block got hit.
     * @param currentVelocity the current velocity of the ball.
     * @return new velocity of the ball after it hit the block.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        if (this.form.getUp().pointInLine(collisionPoint) || this.form.getDown().pointInLine(collisionPoint)) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
    }

    /**
     * time passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * removes the block from the given game.
     * @param gameLevel the game to remove from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * @param hl Add hl as a listener to hit events.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * @param hl Remove hl from the list of listeners to hit events.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
