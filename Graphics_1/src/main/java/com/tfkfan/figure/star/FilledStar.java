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
    public void draw() { //функция по отрисовке залитой звезды
        double s = size / (3.0);
        int vertices = starPoints.length;
        glBegin(GL_TRIANGLES);
        for (int i = 0; i < vertices; i++) { //цикл обходит каждый полигон
            Coordinate current = starPoints[i];
            Coordinate next = i == (vertices - 1) ? starPoints[0] : starPoints[i + 1];

            double a = deltaAngle/2.0 + new Vector2D(current.x - center.x, current.y - center.y).angle();
            double x = center.x + Math.cos(a) * s;
            double y = center.y + Math.sin(a) * s;

            glVertex2d(current.x, current.y);
            glVertex2d(x, y);
            glVertex2d(center.x, center.y);

            glVertex2d(next.x, next.y);
            glVertex2d(x, y);
            glVertex2d(center.x, center.y);
        }
        glEnd();
    }
}
