// ID: 208985424
package arkanoid.sprites;

import arkanoid.levels.GameLevel;
import arkanoid.Velocity;

import arkanoid.geometry.Rectangle;
import arkanoid.geometry.Point;
import arkanoid.geometry.Line;

import arkanoid.collidables.Collidable;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author ido grossman <idoddii @ gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class Paddle implements Sprite, Collidable {

    private final biuoop.KeyboardSensor keyboard;

    private Rectangle form;

    private final int left;

    private final int right;

    private final int speed;

    /**
     * the constructor of the paddle.
     * @param r the form of the paddle.
     * @param sensor the keyboard sensor taken from the gui.
     * @param leftLim the left limit of the screen.
     * @param rightLim the right limit of the screen.
     * @param change the change of the x value of the paddle.
     */
    public Paddle(Rectangle r, biuoop.KeyboardSensor sensor, int leftLim, int rightLim, int change) {
        this.form = r;
        this.keyboard = sensor;
        this.left = leftLim;
        this.right = rightLim;
        this.speed = change;
    }

    /**
     * whenever this function is activated it moves the paddle three x values to the left.
     * if the paddle hits the end of the screen it will stay there.
     */
    public void moveLeft() {
        Point after;
        if (this.form.getUpperLeft().getX() - this.speed <= this.left) {
            after = new Point(this.left, this.form.getUpperLeft().getY());
        } else {
            after = new Point(this.form.getUpperLeft().getX() - this.speed, this.form.getUpperLeft().getY());
        }
        this.form = new Rectangle(after, this.form.getWidth(), this.form.getHeight());
    }

    /**
     * whenever this function is activated it moves the paddle three x values to the right.
     * if the paddle hits the end of the screen it will stay there.
     */
    public void moveRight() {
        Point after;
        if (this.form.getUpperLeft().getX() + this.speed + this.form.getWidth() >= this.right) {
            after = new Point(this.right - this.form.getWidth(), this.form.getUpperLeft().getY());
        } else {
            after = new Point(this.form.getUpperLeft().getX() + this.speed, this.form.getUpperLeft().getY());
        }
        this.form = new Rectangle(after, this.form.getWidth(), this.form.getHeight());
    }

    /**
     * checks which of the buttons the player pressed and activates the moveRight/moveLeft function accordingly.
     */
    public void timePassed() {
        if (this.keyboard.isPressed("a") || this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)
            || this.keyboard.isPressed("ש") || this.keyboard.isPressed("A")) {
            this.moveLeft();
        } else if (this.keyboard.isPressed("d") || this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)
                || this.keyboard.isPressed("ג") || this.keyboard.isPressed("D")) {
            this.moveRight();
        }
    }

    /**
     * draw the paddle on the given surface.
     *
     * @param d the given surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLUE);
        d.fillRectangle((int) this.form.getUpperLeft().getX(), (int) this.form.getUpperLeft().getY(),
                (int) this.form.getWidth(), (int) this.form.getHeight());
        d.setColor(Color.BLACK);
    }

    /**
     *
     * @return the collision rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.form;
    }

    /**
     * returns the right velocity when the ball hits the paddle.
     * @param hitter the ball that hit the Paddle.
     * @param collisionPoint the point of collision,
     * @param currentVelocity the current velocity of the ball.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        int division = 5;
        double rectX = this.form.getUpperLeft().getX(), rectY = this.form.getUpperLeft().getY(),
                rectW = this.form.getWidth(), rectH = this.form.getHeight();
        Point[] p = new Point[division];
        Rectangle[] r = new Rectangle[division];
        Line[] l = new Line[division];
        // builds division amount of rectangle and creates an array of their upper lines.
        for (int i = 0; i < division; i++) {
            p[i] = new Point(rectX + i * (rectW / division), rectY);
            r[i] = new Rectangle(p[i], rectW / division, rectH);
            l[i] = r[i].getUp();
        }
        // depends on where the ball hits the function will return the new velocity.
        Velocity v;
        double ballSpeed = currentVelocity.getSpeed();
        if (l[0].pointInLine(collisionPoint)) {
            v = Velocity.fromAngleAndSpeed(300, ballSpeed);
        } else if (l[1].pointInLine(collisionPoint)) {
            v = Velocity.fromAngleAndSpeed(330, ballSpeed);
        } else if (l[2].pointInLine(collisionPoint)) {
            v = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else if (l[3].pointInLine(collisionPoint)) {
            v = Velocity.fromAngleAndSpeed(30, ballSpeed);
        } else {
            v = Velocity.fromAngleAndSpeed(60, ballSpeed);
        }
        return v;
    }

    /**
     * adds the paddle to the given game.
     * @param g the game to add the paddle to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
