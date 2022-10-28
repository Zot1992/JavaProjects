package com.tfkfan.figure.rectangle;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class LinedRectangle extends AbstractRectangle{

    public LinedRectangle (double width,double length) {
        super(width,length);
    }

    public LinedRectangle (Coordinate center, double width,double length) {
        super(center, width,length);
    }


    @Override
    public void draw() {
        glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.
        int vertices = RectanglePoints.length;
        for (int i = 0; i < RectanglePoints.length; i++) {
            int shift = i  % vertices;   //Точки выводим со смещением на 2

            glVertex2d(RectanglePoints[shift].x,RectanglePoints[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод
        }
        glEnd();
    }
}
