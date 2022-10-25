package com.tfkfan.figure.rectangle;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;

public class FilledRectangle extends AbstractRectangle {


    public FilledRectangle(double size, int vertices) {
        super(size, vertices);
    }

    public FilledRectangle(Coordinate center, double size, int vertices) {
        super(center, size, vertices);
    }

    @Override
    public void draw() {
        glBegin(GL_POLYGON);//Р
        int vertices = RectanglePoints.length;
        for (int i = 0; i < RectanglePoints.length; i++) {
            int shift = i  % vertices;

            glVertex2d(RectanglePoints[shift].x,RectanglePoints[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод
        }
        glEnd();
    }


}

