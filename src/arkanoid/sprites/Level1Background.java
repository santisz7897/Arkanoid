package arkanoid.sprites;

import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Szterenberg <santisz7897@gmail.com>
 * @version 1.
 * @since 18-04-2021
 */
public class Level1Background implements Sprite {

    /**
     * draws the Arkanoid.Sprites.Sprite on the given surface.
     *
     * @param d the given surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(153, 102, 0));
        d.fillRectangle(0, 20, 800, 580);
        d.setColor(Color.BLACK);
        List<Polygon> triangles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            triangles.add(new Polygon());
            Polygon triangle1 = triangles.get(i);
            triangle1.addPoint(100 + 150 * i, 550 - 100 * i);
            triangle1.addPoint(110 + 150 * i, 500 - 100 * i);
            triangle1.addPoint(120 + 150 * i, 550 - 100 * i);
        }
        for (int i = 3; i < 5; i++) {
            int y = -(i - 4);
            triangles.add(new Polygon());
            Polygon triangle1 = triangles.get(i);
            triangle1.addPoint(100 + 150 * i, 550 - 100 * y);
            triangle1.addPoint(110 + 150 * i, 500 - 100 * y);
            triangle1.addPoint(120 + 150 * i, 550 - 100 * y);
        }
        for (Polygon triangle : triangles) {
            d.fillPolygon(triangle);
        }
    }

    /**
     * notifies the sprites that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
