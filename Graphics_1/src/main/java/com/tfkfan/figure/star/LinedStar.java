package com.tfkfan.figure.star;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glBegin;


public class LinedStar extends AbstractStar {//extends-расширяет абстрактный класс AbstractStar

    public LinedStar(double size, int vertices) {
        super(size, vertices);
    }

    public LinedStar(Coordinate center, double size, int vertices) {
        super(center, size, vertices);
    }

    @Override //позволяет изменить параметры метода
    public void draw() {  //код на звезды(смещение точек и отрисовка их на экране)
        glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.
        int vertices = starPoints.length;
        for (int i = 0; i < starPoints.length; i++) {
            //int shift = (i * 2) % vertices;   //Точки выводим со смещением на 2
            int shift = i  % vertices;
            glVertex2d(starPoints[shift].x,starPoints[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод
        }
        glEnd();
    }
}


