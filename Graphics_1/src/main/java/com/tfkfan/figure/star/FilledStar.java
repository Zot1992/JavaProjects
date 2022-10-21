package com.tfkfan.figure.star;

import com.vividsolutions.jts.geom.Coordinate;

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
        double x, y;
        int vertices = starPoints.length;
        for (int i = 0; i < vertices - 1; i++) { //цикл обходит каждый полигон
            glBegin(GL_POLYGON);
            glVertex2d(starPoints[i].x, starPoints[i].y);
            x = center.x + Math.cos(deltaAngle * (i + 0.5)) * s;
            y = center.y + Math.sin(deltaAngle * (i + 0.5)) * s;
            glVertex2d(x, y);
            glVertex2d(center.x, center.y);
            glEnd();

            glBegin(GL_POLYGON);
            glVertex2d(starPoints[i + 1].x, starPoints[i + 1].y);
            glVertex2d(x, y);
            glVertex2d(center.x, center.y);
            glEnd();
        }
        x = center.x + Math.cos(deltaAngle * (vertices - 1 + 0.5)) * s;
        y = center.y + Math.sin(deltaAngle * (vertices - 1 + 0.5)) * s;
        glBegin(GL_POLYGON);
        glVertex2d(starPoints[0].x, starPoints[0].y);
        glVertex2d(x, y);
        glVertex2d(center.x, center.y);
        glEnd();
        glBegin(GL_POLYGON);
        glVertex2d(starPoints[vertices - 1].x, starPoints[vertices - 1].y);
        glVertex2d(x, y);
        glVertex2d(center.x, center.y);
        glEnd();
    }
}
