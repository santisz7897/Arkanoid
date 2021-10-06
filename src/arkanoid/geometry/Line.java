//ID: 324603422
package arkanoid.geometry;

import java.util.ArrayList;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class Line {

    private final Point starts;

    private final Point ends;

    private final double x1;

    private final double x2;

    private final double y1;

    private final double y2;

    private final double length;

    private final double m;

    private final double b;

    private double commonX;

    private double commonY;

    /**
     * if the user gives 4 parameters it creates two points and sends it to the 2 parameters constructor.
     * <p>
     *
     * @param x1 the 1st x value of the line.
     * @param x2 the 2nd x value of the line.
     * @param y1 the 1st y value of the line.
     * @param y2 the 2nd y value of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * sets the x and y values of the start and end point and the length, slope and b of the function.
     * <p>
     * sets all the parameters for a straight line function for calculating things later in the program.
     *
     * @param start the point where the line starts.
     * @param end the point where the line end.
     */
    public Line(Point start, Point end) {
        this.starts = start;
        this.ends = end;
        this.x1 = Math.min(start.getX(), end.getX());
        this.x2 = Math.max(start.getX(), end.getX());
        this.y1 = Math.min(start.getY(), end.getY());
        this.y2 = Math.max(start.getY(), end.getY());
        this.length = start.distance(end);
        if (this.x1 != this.x2) {
            this.m = (this.y1 - this.y2) / (this.x1 - this.x2);
        } else {
            this.m = 0;
        }
        this.b = this.y1 - this.m * this.x1;
    }

    /**
     * returns the length of the line.
     * <p>
     *
     * @return length of the line.
     */
    public double length() {
        return this.length;
    }

    /**
     * calculates the middle point of the line.
     * <p>
     *
     * @return middle point of the line x and y value.
     */
    public Point middle() {
        return new Point((this.x1 + this.x2) / 2, (this.y1 + this.y2) / 2);
    }

    /**
     * return the start of the line.
     * <p>
     *
     * @return line start x and y values.
     */
    public Point start() {
        return this.starts;
    }

    /**
     * constructs the class.
     * <p>
     *
     * @return line end x and y values.
     */
    public Point end() {
        return this.ends;
    }

    /**
     * checks if the two lines intersect or not.
     * <p>
     *  checks if the lines intersect by checking what point would they intersect if they weren't segments
     *  and then check if the x and y value of the intersection is within the segments of the lines.
     *
     * @param other the second line to check intersection with
     * @return false if the lines aren't intersecting, true otherwise.
     */
    public boolean isIntersecting(Line other) {
        // checks if only the y of the line changes and if so it sets the x and y to match it.
        if (this.x1 == this.x2 && other.x1 == other.x2 && (this.y1 > other.y2 || this.y2 < other.y1)) {
            return false;
        } else if (this.x1 == this.x2 && other.x1 == other.x2) {
            return true;
        } else if (this.x1 == this.x2) {
            this.commonY = other.m * this.x1 + other.b;
            this.commonX = this.x1;
        } else if (other.x1 == other.x2) {
            this.commonY = this.m * other.x1 + this.b;
            this.commonX = other.x1;
        } else if (other.y1 == other.y2) {
            this.commonX = (other.b - this.b) / (this.m - other.m);
            this.commonY = other.y1;
        } else {
            this.commonX = (other.b - this.b) / (this.m - other.m);
            this.commonY = (this.m * this.commonX) + this.b;
        }
        // checks if the intersection point is within the lines segments.
        return !this.equals(other) && !(this.commonX < this.x1) && !(this.commonX < other.x1)
                && !(this.commonX > this.x2) && !(this.commonX > other.x2) && !(this.commonY < this.y1)
                && !(this.commonY < other.y1) && !(this.commonY > this.y2) && !(this.commonY > other.y2);
    }

    /**
     * checks the intersection point of the line.
     * <p>
     *
     * @param other the other line to check intersection with.
     * @return point with the values of the intersection, null if they aren't intersecting.
     */
    public Point intersectionWith(Line other) {
        // checks if the lines intersect or not.
        if (!isIntersecting(other) || this.m == other.m) {
            return null;
        }
        return new Point(this.commonX, this.commonY);
    }

    /**
     * check if the two lines are equal
     * <p>
     * checks if the start and end of the two lines is equal or not.
     *
     * @param other the other line to check equality with.
     * @return true if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        double x3 = other.x1;
        double x4 = other.x2;
        double y3 = other.y1;
        double y4 = other.y2;
        // checks if the x and y values of the start and end of the lines are the same.
        return (this.x1 == x3 || this.x1 == x4) && (this.x2 == x4 || this.x2 == x3)
                && (this.y1 == y3 || this.y1 == y4) && (this.y2 == y4 || this.y2 == y3);
    }

    /**
     * checks if the given point is in the line or not.
     *
     * @param p the point to check.
     * @return true if the point in the line, else false.
     */
    public boolean pointInLine(Point p) {
        return p.getX() >= this.x1 && p.getX() <= this.x2 && p.getY() >= this.y1 && p.getY() <= this.y2;
    }

    /**
     * takes a rectangle and returns the closest intersection point to the start of the line.
     *
     * @param rect the rectangle to check with.
     * @return the closest intersection to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line[] edge = {rect.getUp(), rect.getRight(), rect.getDown(), rect.getLeft()};
        java.util.List<Point> lines = new ArrayList<>();
        if (!this.isIntersecting(edge[0]) && !this.isIntersecting(edge[1]) && !this.isIntersecting(edge[2])
                && !this.isIntersecting(edge[3])) {
                return null;
        }
        for (Line l : edge) {
            if (this.isIntersecting(l)) {
                lines.add(this.intersectionWith(l));
            }
        }
        Point closest = lines.get(0);
        for (Point p : lines) {
            if (this.starts.closestPoint(closest, p) == p) {
                closest = p;
            }
        }
        return closest;
    }
}
