//ID: 324603422
package arkanoid.sprites;
// imports from the main arkanoid package.
import arkanoid.levels.GameLevel;
import arkanoid.Velocity;
import arkanoid.GameEnvironment;
// import the geometry package.
import arkanoid.geometry.Point;
import arkanoid.geometry.Line;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class Ball implements Sprite {

    private Point point;

    private final int radius;

    private final Color color;

    private Velocity velo;

    private GameEnvironment game;

    /**
     * sets the center radius and color of the ball.
     *
     * @param center the center point of the ball.
     * @param r the radius of the ball.
     * @param color  the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.point = center;
        this.radius = r;
        this.color = color;
    }

    /**
     * sets the x and y of the center of the ball and the radius and color.
     *
     * @param x the x of the center of the ball
     * @param y the y of the center of the ball.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this(new Point(x, y), r, color);
    }

    /**
     * returns the x of the center of the ball.
     *
     * @return x the center of the ball.
     */
    public int getX() {
        return (int) this.point.getX();
    }

    /**
     * returns the y of the center of the ball.
     *
     * @return y the center of the ball.
     */
    public int getY() {
        return (int) this.point.getY();
    }


    /**
     * returns the radius of the ball.
     *
     * @return radius of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * returns the color of the ball.
     *
     * @return color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * draws the ball on the given surface.
     *
     * @param surface the surface to draw to ball on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), radius);
    }

    /**
     * activates the moveOneStep method.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * sets the velocity of the ball by assigning the dx and dy of the ball.
     *
     * @param v the given velocity to the ball.
     */
    public void setVelocity(Velocity v) {
        this.velo = v;
    }

    /**
     * sets the velocity of the ball by assigning the dx and dy of the ball.
     *
     * @param dx the change of the x of the ball.
     * @param dy the change of the y of the ball.
     */
    public void setVelocity(double dx, double dy) {
        this.setVelocity(new Velocity(dx, dy));
    }

    /**
     * returns the velocity of the ball.
     *
     * @return velocity with the dx and dy of the ball.
     */
    public Velocity getVelocity() {
        return this.velo;
    }

    /**
     * moves the ball by changing using the applytopoint of the velocity of the ball.
     */
    public void moveOneStep() {
        this.point = this.getVelocity().applyToPoint(this.point);
        Line traj = computeTrajectory();
        // if there is a close collision with the trajectory it will set a new velocity for the ball.
        if (this.game.getClosestCollision(traj) != null) {
            Velocity newVel = this.game.getClosestCollision(traj).collisionObject().hit(
                    this, this.game.getClosestCollision(traj).collisionPoint(), this.getVelocity());
            this.setVelocity(newVel);
        }
    }

    /**
     * sets the game environment of the ball.
     *
     * @param g the game environment.
     */
    public void setEnvironment(GameEnvironment g) {
        this.game = g;
    }

    /**
     * adds the object to the given game.
     * @param g the game to add the object to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     *
     * @return a string with the stats of the ball: center points, radius and velocity values.
     */
    public String toString() {
        if (this.velo == null) {
            return "center of the ball," + this.point.toString() + ". radius: " + this.radius + ". color, "
                    + this.color.toString() + ". velocity: null";
        }
        return "center of the ball," + this.point.toString() + ". radius: " + this.radius + ". color, "
                + this.color.toString() + ". velocity," + this.velo.toString();
    }

    /**
     * removes the ball from the given game.
     * @param g the game to remove from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * computes the trajectory of the ball.
     *
     * @return the trajectory of the ball.
     */
    private Line computeTrajectory() {
        double xChange = this.velo.getDx(), yChange = this.velo.getDy(), epsilon = 0;
        // check in what poisition and movement the ball is and sets the next point it will be in.
        if (xChange <= 0 && yChange >= 0) {
            Point end = new Point(this.point.getX() + xChange - this.radius - epsilon,
                    this.point.getY() + yChange + this.radius + epsilon);
            return new Line(this.point, end);
        } else if (xChange >= 0 && yChange <= 0) {
            Point end = new Point(this.point.getX() + xChange + this.radius + epsilon,
                    this.point.getY() + yChange - this.radius - epsilon);
            return new Line(this.point, end);
        } else if (xChange >= 0 && yChange >= 0) {
            Point end = new Point(this.point.getX() + xChange + this.radius + epsilon,
                    this.point.getY() + yChange + this.radius + epsilon);
            return new Line(this.point, end);
        } else {
            Point end = new Point(this.point.getX() + xChange - this.radius - epsilon,
                    this.point.getY() + yChange - this.radius - epsilon);
            return new Line(this.point, end);
        }
    }
}