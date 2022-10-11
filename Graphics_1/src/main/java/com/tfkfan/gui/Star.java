package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class Star {




    public static void drawStar(double size, int vertices) {drawStar(makeStar(size, vertices));}//объединение всей конструкции кода звезды для ее норм вызова

    public static Coordinate[] makeStar(double size, int vertices) { //код на звезды(позиции точек)
        Coordinate[] points = new Coordinate[vertices];
        double x, y;
        double deltaAngleR = 2 * Math.PI / vertices;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for (int i = 0; i < points.length; i++) { //цикл обходит каждый полигон
            x = Math.cos(deltaAngleR * i) * size;
            y = Math.sin(deltaAngleR * i) * size;
            points[i] = new Coordinate(x, y);
        }
        return points;
    }

    public static void drawStar(Coordinate[] points) { //код на звезды(смещение точек и отрисовка их на экране)
        glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.
        int vertices = points.length;
        for (int i = 0; i < points.length; i++) {
            int shift = (i * 2) % vertices;   //Точки выводим со смещением на 2
            glVertex2d(points[shift].x, points[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод
        }

        glEnd();// конец отрисовки. Работает в паре с glBegin
    }
}
