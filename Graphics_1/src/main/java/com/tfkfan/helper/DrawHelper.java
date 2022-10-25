package com.tfkfan.helper;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;

public class DrawHelper {

    public static void drawRectangle(double x1, double y1, double x2, double y2,
                                     double x3, double y3, double x4, double y4) { //код прямоугольника
        glBegin(GL_POLYGON);
        glVertex2d(x1, y1);//положение нижней левой точки фигуры(v-ось x. v1-ось y)(декартовы координаты это координаты x,y с осями под прямым углом)
        glVertex2d(x2, y2);//положение верхней левой точки фигуры
        glVertex2d(x3, y3);//положение верхней правой точки фигуры
        glVertex2d(x4, y4);//положение нижней правой точки фигуры
        glEnd();
    }
}
