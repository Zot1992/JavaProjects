package com.tfkfan.gui;

import static org.lwjgl.opengl.GL11.*;

public class DrawHelper {

    public static void drawRectangle(double x1, double y1, double x2, double y2,
                                     double x3, double y3, double x4, double y4) {
        glBegin(GL_TRIANGLE_FAN);
        glVertex2d(x1, y1);//положение нижней левой точки фигуры(v-ось x. v1-ось y)(декартовы координаты это координаты x,y с осями под прямым углом)
        glVertex2d(x2, y2);//положение верхней левой точки фигуры
        glVertex2d(0.0, 0.0);//положение верхней правой точки фигуры
        glVertex2d(0.0, -0.5);//положение нижней правой точки фигуры
        glEnd();
    }

    public static void drawCircle(double centerX, double centerY, double radius, int partition) {
        double deltaAngle = 2 * Math.PI / partition;//нахождение угла для круга.2*Math.PI-что бы получить 360 градусов.

        glBegin(GL_LINE_STRIP);// чертит линии с заливкой

        for (int i = -1; i < partition; i++) { //цикл обходит каждый полигон, еще делаем второй ряд полигонов +1 чтобы круг был цельным
            double x = Math.sin(deltaAngle * i) * radius + centerX;
            double y = Math.cos(deltaAngle * i) * radius + centerY;
            glVertex2d(x, y);
        }

        glEnd();
    }
}
