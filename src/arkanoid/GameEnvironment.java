// ID: 208985424
package arkanoid;

import arkanoid.collidables.Collidable;
import arkanoid.collidables.CollisionInfo;

import arkanoid.geometry.Point;
import arkanoid.geometry.Line;

import java.util.ArrayList;

/**
 * @author ido grossman <idoddii @ gmail.com>
 * @version 1.
 * @since 14-04-2021
 */
public class GameEnvironment {

    private final java.util.List<Collidable> coll = new ArrayList<>();

    /**
     * adds the given collidable to the environment.
     *
     * @param c the collidable to add.
     */
    public void addCollidable(Collidable c) {
        this.coll.add(c);
    }

    /**
     * removes the given collidable from the list.
     * @param c the collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.coll.remove(c);
    }

    /**
     * takes the given trajectory and checks whether or not there is a close collision.
     * <p>
     * if there is a close collision the function will return the info of that collision, else it will return null.
     *
     * @param trajectory the line to check collision with.
     * @return the collision info of the collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo c = new CollisionInfo();
        // a list to set the possible collision points.
        for (Collidable object : this.coll) {
            // checks if the collision point is valid.
            if (trajectory.closestIntersectionToStartOfLine(object.getCollisionRectangle()) != null) {
                // if the collision point is valid it adds it to the colision points list.
                Point collisionP = trajectory.closestIntersectionToStartOfLine(object.getCollisionRectangle());
                if (c.collisionPoint() == null) {
                    c.collisionInfoSet(collisionP, object);
                } else if (trajectory.start().closestPoint(collisionP, c.collisionPoint()) == collisionP) {
                    c.collisionInfoSet(collisionP, object);
                }
            }
        }
        // if there are no points it will return null and else it will return the closest point.
        if (c.collisionPoint() == null) {
            return null;
        }
        return c;
    }
}
