package com.tfkfan.figure.star;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.math.Vector2D;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class FilledStar extends AbstractStar {

    public FilledStar(double size, int vertices) {
        super(size, vertices);
    }

    public FilledStar(Coordinate center, double size, int vertices) {
        super(center, size, vertices);
    }

    @Override
    public void draw() {
        double s = size / (3.0);
        double x, y, a;
        int vertices = starPoints.length;
        Vector2D v1, v2;
        glBegin(GL_TRIANGLES);
        for (int i = 0; i < vertices - 1; i++) { //цикл обходит каждый полигон
            v1 = new Vector2D(starPoints[i].x - center.x, starPoints[i].y - center.y);
            v2 = new Vector2D(starPoints[i + 1].x - center.x, starPoints[i + 1].y - center.y);
            a = v1.angleTo(v2);
            x = center.x + Math.cos((a / 2.0 +v1.angle() )) * s;
            y = center.y + Math.sin((a / 2.0 +v1.angle())) * s;

            glVertex2d(starPoints[i].x, starPoints[i].y);
            glVertex2d(x, y);
            glVertex2d(center.x, center.y);

            glVertex2d(starPoints[i + 1].x, starPoints[i + 1].y);
            glVertex2d(x, y);
            glVertex2d(center.x, center.y);

        }
        v1 = new Vector2D(starPoints[vertices - 1].x - center.x, starPoints[vertices - 1].y - center.y);
        v2 = new Vector2D(starPoints[0].x - center.x, starPoints[0].y - center.y);
        a = v1.angleTo(v2);

        x = center.x + Math.cos(a / 2 + v1.angle()) * s;
        y = center.y + Math.sin(a / 2 + v1.angle()) * s;

        glVertex2d(starPoints[0].x, starPoints[0].y);
        glVertex2d(x, y);
        glVertex2d(center.x, center.y);

        glVertex2d(starPoints[vertices - 1].x, starPoints[vertices - 1].y);
        glVertex2d(x, y);
        glVertex2d(center.x, center.y);

        glEnd();
    }
}
