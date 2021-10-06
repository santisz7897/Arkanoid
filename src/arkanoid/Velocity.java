//ID: 208985424
package arkanoid;

import arkanoid.geometry.Point;

/**
 * @author ido grossman <idoddii@gmail.com>
 * @version 1.
 * @since 21-03-2021
 */
public class Velocity {

    private final double dx;

    private final double dy;

    private final double speed;

    private double angle;

    /**
     * sets the dx and dy of the velocity (dx is the change in the x and dy is the in y values).
     *
     * @param dx sets the dx to the given dx.
     * @param dy sets the dy to the given dy.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        // calculates the speed and angle from the dx and dy.
        this.speed = Math.sqrt((dx * dx) + (dy * dy));
        this.angle = Math.toDegrees(Math.acos(-dy / this.speed));
        if (this.angle <= 0) {
            this.angle += 180;
        }
    }

    /**
     * returns the dx of the velocity.
     *
     * @return the dx of the velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * returns the dy of the velocity.
     *
     * @return dy of the velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * moves a point by applying the dx and dy to her values.
     *
     * @param p the point to move.
     * @return the new point after it was moved.
     */
    public Point applyToPoint(Point p) {
        // gets the x and y of the given point.
        double x = p.getX();
        double y = p.getY();
        // returns a new point and adds the dx and dy to this point.
        return new Point(x + this.dx, y + this.dy);
    }

    /**
     *
     * @return a string with the values of the velocity.
     */
    public String toString() {
        return " dx: " + this.dx + " dy: " + this.dy + " speed: " + this.speed + " angle: " + this.angle;
    }
    /**
     *
     * @return the speed of the velocity.
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     *
     * @return the angle of the velocity.
     */
    public double getAngle() {
        return this.angle;
    }

    /**
     * converts angel to change in x and y.
     * <p>
     *  converts the angel to change in x by taking the cos and multiplying by the speed, does the same to the y
     *  and then return the new velocity with those dx and dy.
     * </p>
     * @param angle the given angle for the velocity.
     * @param speed the given speed for the velocity.
     * @return new velocity with the change in x and change in y.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -(Math.cos(Math.toRadians(angle)) * speed);
        return new Velocity(dx, dy);
    }
}