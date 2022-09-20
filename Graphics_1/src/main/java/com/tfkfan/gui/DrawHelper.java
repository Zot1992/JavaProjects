package com.tfkfan.gui;

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

    public static void drawCircle(double centerX, double centerY, double radius, int partition) { //код круга
        double deltaAngle = 2 * Math.PI / partition;//нахождение угла для круга.2*Math.PI-что бы получить 360 градусов.

        glBegin(GL_LINE_STRIP);// чертит линии с заливкой

        for (int i = -1; i < partition; i++) { //цикл обходит каждый полигон, еще делаем второй ряд полигонов +1 чтобы круг был цельным
            double x = Math.cos(deltaAngle * i) * radius + centerX;
            double y = Math.sin(deltaAngle * i) * radius + centerY;
            glVertex2d(x, y);
        }

        glEnd();
    }
    public static void drawStar(double size,int vertices){ //код на звезды
        glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.
        Point[]points=new Point[vertices];
        double x,y;
        double deltaAngleR = 2*Math.PI / vertices;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for(int i=0;i<points.length;i++){ //цикл обходит каждый полигон
            x=Math.cos(deltaAngleR*i)*size;
            y=Math.sin(deltaAngleR*i)*size;
            points[i]=new Point(x,y);
        }

        for(int i=0;i<points.length;i++){
            int shift = (i * 2) % vertices;   //Точки выводим со смещением на 2
            glVertex2d(points[shift].getX(),points[shift].getY());//object[i].x только так можно вызвать из массива объектов нужный метод
        }

        glEnd();// конец отрисовки. Работает в паре с glBegin
    }
}
