// ID: 324603422
package arkanoid.collidables;

import arkanoid.Velocity;

import arkanoid.geometry.Rectangle;
import arkanoid.geometry.Point;

import arkanoid.sprites.Ball;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public interface Collidable {
    /**
     *
     * @return the collision rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * notifies the object and changes the velocity.
     *
     * @param hitter the ball that hit the collidable.
     * @param collisionPoint the point of collision,
     * @param currentVelocity the current velocity of the ball.
     * @return the new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
