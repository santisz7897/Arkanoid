// ID: 324603422
package arkanoid.collidables;

import arkanoid.geometry.Point;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class CollisionInfo {

    private Point coll;

    private Collidable object;

    /**
     * sets the parameters of the collision info.
     *
     * @param p the point of the collision.
     * @param c the collidable it collided with.
     */
    public void collisionInfoSet(Point p, Collidable c) {
        this.coll = p;
        this.object = c;
    }

    /**
     *
     * @return the point of collision.
     */
    public Point collisionPoint() {
        return this.coll;
    }

    /**
     *
     * @return the collided object.
     */
    public Collidable collisionObject() {
        return this.object;
    }
}
