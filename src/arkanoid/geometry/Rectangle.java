// ID: 208985424
package arkanoid.geometry;

import java.util.ArrayList;

/**
 * @author ido grossman <idoddii @ gmail.com>
 * @version 1.
 * @since 14-04-2021
 */
public class Rectangle {

    private final Point start;

    private final double rWidth;

    private final double rHeight;

    private final Line upperL;

    private final Line downL;

    private final Line leftL;

    private final Line rightL;

    /**
     * constructor.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.start = upperLeft;
        this.rWidth = width;
        this.rHeight = height;
        double rectX = upperLeft.getX(), rectY = upperLeft.getY(), rectR = rectX + width, rectD = rectY + height;
        this.upperL = new Line(rectX, rectY, rectR, rectY);
        this.rightL = new Line(rectR, rectY, rectR, rectD);
        this.downL = new Line(rectX, rectD, rectR, rectD);
        this.leftL = new Line(rectX, rectY, rectX, rectD);
    }


    /**
     * returns a list of intersection between line and the rectangle.
     *
     * @param line the line to check intersection with.
     * @return list of intersection points between the line and the rectangle.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        // makes a list of points and adds all the intersection points.
        java.util.List<Point> list = new ArrayList<>();
        list.add(line.intersectionWith(upperL));
        list.add(line.intersectionWith(downL));
        list.add(line.intersectionWith(rightL));
        list.add(line.intersectionWith(leftL));
        return list;
    }


    /**
     * returns the width.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.rWidth;
    }

    /**
     * returns the height.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.rHeight;
    }


    /**
     * return the upper left point of the rectangle.
     *
     * @return the start point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.start;
    }

    /**
     *
     * @return the upper line of the rectangle
     */
    public Line getUp() {
        return this.upperL;
    }

    /**
     *
     * @return the right line of the rectangle.
     */
    public Line getRight() {
        return this.rightL;
    }

    /**
     *
     * @return the lower line of the rectangle.
     */
    public Line getDown() {
        return this.downL;
    }

    /**
     *
     * @return the left line of the rectangle.
     */
    public Line getLeft() {
        return this.leftL;
    }
}
