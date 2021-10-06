// ID: 208985424
package arkanoid.collidables;

import arkanoid.geometry.Point;

/**
 * @author ido grossman <idoddii @ gmail.com>
 * @version 1.
 * @since 14-04-2021
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
