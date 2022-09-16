/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class MainView extends View {
   /* private Coordinate viewPoint;
    private double dx = 0.01d;//перемещение по оси х(по горизонтали)
    private double dy = 0.01d;//перемещение по оси y(по вертикали)


    private int W = 87;
    private int A = 65;
    private int D = 68;
    private int S = 83;

    public MainView() {
        viewPoint = new Coordinate(0, 0);//начальное положение подвижной точки
    }

    @Override
    public void onKeyboardInput(int code) { //ОБРАБОТЧИК СОБЫТИЯ ВВОДА С КЛАВИАТУРЫ
        if (code == W) //если мы с клавиатуры вводим W
            viewPoint.y += dy;//то точки координаты увеличиваются на заданное значение dy с каждым нажатием по оси y
        else if (code == S)//если мы с клавиатуры вводим S
            viewPoint.y -= dy;//то точки координаты уменьшаются на заданное значение dy с каждым нажатием по оси y
        else if (code == A)//если мы с клавиатуры вводим A
            viewPoint.x -= dx;//то точки координаты уменьшаются на заданное значение dx с каждым нажатием по оси x
        else if (code == D)//если мы с клавиатуры вводим D
            viewPoint.x += dx;//то точки координаты увеличиваются на заданное значение dx с каждым нажатием по оси x
    } */

    private Coordinate viewPoint,viewPoint2,viewPoint3;
    //private double dx=0.05d;// передвижение звезды по оси х
    private double dx=0.05d;

    Object[] viewPoints=new Object[3];//массив обьектов координат подвижных точек


    private int A = 65;
    private int D = 68;


    public MainView() {
        viewPoint = new Coordinate(-0.25, 0);
        viewPoint2 =new Coordinate( 0.25, 0);
        viewPoint3 =new Coordinate(-0.76, 0.25);

    }
    @Override
    public void onKeyboardInput(int code) { //ОБРАБОТЧИК СОБЫТИЯ ВВОДА С КЛАВИАТУРЫ
        if (code == A){viewPoint.x -= dx;}
        else if (code == D){viewPoint.x += dx;}
    }
    @Override
    protected void clearColor() {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }//Цвет фона


    @Override //указывает, что далее мы собираемся переопределять метод базового класса.
    protected void partialDisplay() { //Отображение подвижной и неподвижной фигуры
        //glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры

        //DrawHelper.drawRectangle(-0.5, -0.5,-0.5, 0.0,0.0, 0.0,0.0, -0.5);//вызов метода квадрата
        //DrawHelper.drawCircle(0,0,0.5,360);//вызов метода круга
        //DrawHelper.drawStar(0.8,5);
        int vertices=5;
        double size=0.8;
        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        //DrawHelper.drawStar(0.8,5);
        glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.
        Point[]points=new Point[vertices];
        double x,y;
        double deltaAngleR = 2*Math.PI / vertices;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for(int i=0;i<points.length;i++){ //цикл обходит каждый полигон
            x=Math.sin(deltaAngleR*i)*size;
            y=Math.cos(deltaAngleR*i)*size;
            points[i]=new Point(x,y);
        }

        for(int i=0;i<points.length;i++){
            int shift = (i * 2) % vertices;   //Точки выводим со смещением на 2
            glVertex2d(points[shift].getX(), points[shift].getY());//object[i].x только так можно вызвать из массива объектов нужный метод
        }
        glVertex2d(viewPoint.x, viewPoint.y);



        glEnd();
        //glVertex2d(viewPoint.x, viewPoint.y);
        //glEnd();


        /*glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_POINTS);
        glVertex2d(viewPoint.x, viewPoint.y);//динамичные координаты подвижной точки
        glEnd(); */
    }
}
