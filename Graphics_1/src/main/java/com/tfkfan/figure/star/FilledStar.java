package com.tfkfan.figure.star;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class FilledStar extends AbstractStar{

    public FilledStar(double size, int vertices) {
        super(size, vertices);
    }

    public FilledStar(Coordinate[] starPoints, double size, int vertices) {
        super(starPoints, size, vertices);
    }

    @Override
    public void draw() {
        glBegin(GL_POLYGON);
        int vertices = starPoints.length;
        for (int i = 0; i < starPoints.length; i++) {
            int shift = (i * 2) % vertices;   //Точки выводим со смещением на 2
            glVertex2d(starPoints[shift].x, starPoints[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод
        }
        glEnd();
    }
}
