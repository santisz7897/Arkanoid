//ID: 208985424

package arkanoid.geometry;

/**
 * @author ido grossman <idoddii @ gmail.com>
 * @version 1.
 * @since 19-03-2021
 */
public class Point {

    private final double x1;

    private final double y1;

    /**
     * constructs the class.
     * <p>
     * sets the x and y of the point to be the given x and y
     *
     * @param x the x of the class.
     * @param y the y of the class.
     */
    public Point(double x, double y) {
        this.x1 = x;
        this.y1 = y;
    }

    /**
     * measuring the distance between 2 points.
     * <p>
     *
     * @param other the second point to measure distance from
     * @return distance, the distance between the 2 points.
     */
    public double distance(Point other) {
        double x2 = other.getX();
        double y2 = other.getY();
        // returns the distance between the points with the known formula of distance between 2 points.
        return Math.sqrt(((this.x1 - x2) * (this.x1 - x2)) + ((this.y1 - y2) * (this.y1 - y2)));
    }

    /**
     * checking if the second point x and y are equal to this point x and y.
     * <p>
     *
     * @param other the second point to check equality with.
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        double x2 = other.getX();
        double y2 = other.getY();
        //checks if x1 equals x2 and y1 equals y2, returns true if it is.
        return (this.x1 == x2) && (this.y1 == y2);
    }

    /**
     *
     * @return a string with the details of the point.
     */
    public String toString() {
        return " x: " + this.x1 + " y: " + this.y1;
    }

    /**
     * checks which of the points is closer to the check
     * <p>
     * takes the given point and a check point and then returns the closest point to the check point.
     *
     * @param one the second point to check.
     * @param two the point to check with.
     * @return the closest point to the check point.
     */
    public Point closestPoint(Point one, Point two) {
        // checks if the first point is closer to the check point than the second.
        if (one.distance(this) < two.distance(this)) {
            return one;
        }
        return two;
    }

    /**
     * returns the x.
     * <p>
     *
     * @return x of this point.
     */
    public double getX() {
        return this.x1;
    }

    /**
     * returns the y.
     * <p>
     *
     * @return y of this point.
     */
    public double getY() {
        return this.y1;
    }
}
