/*Написать графическую программу, выполняющую:
        3) рисующую красную пятиконечную звезду */

package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class MainView extends View {
    private Coordinate viewPoint;
    private double dx = 0.01d;//перемещение по оси х(по горизонтали)
    private double dy = 0.01d;//перемещение по оси y(по вертикали)


    private int W = 87;
    private int A = 65;
    private int D = 68;
    private int S = 83;

    public MainView() {
        viewPoint = new Coordinate(-0.1, 0.5);//начальное положение подвижной точки
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
    }

    @Override
    protected void clearColor() {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }//Цвет фона

    @Override //указывает, что далее мы собираемся переопределять метод базового класса.
    protected void partialDisplay() { //Отображение подвижной и неподвижной фигуры
        glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры

        //DrawHelper.drawRectangle(-0.5, -0.5,-0.5, 0.0,0.0, 0.0,0.0, -0.5);//вызов метода квадрата
        //DrawHelper.drawCircle(0,0,0.5,360);//вызов метода круга


        /*glBegin(GL_LINE_LOOP);
        glVertex2d(0.0, 0.8); // код звезды (неправильный)
        glVertex2d(0.6, -0.7);
        glVertex2d(-0.8, 0.1);
        glVertex2d(0.8, 0.1);
        glVertex2d(-0.6, -0.7);
        glVertex2d(0.0, 0.8);*/

        glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.

        double x,y;
        int pol=5;//количество полигонов в фигуре
        double l= 0.8;//размер

        Arr_points[]points=new Arr_points[pol];

        double deltaAngleR = 2*Math.PI / pol;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for(int i=0;i<points.length;i++){ //цикл обходит каждый полигон
            x=Math.sin(deltaAngleR*i)*l;
            y=Math.cos(deltaAngleR*i)*l;
            points[i]=new Arr_points(x,y);
        }  //код на звезды

        for(int i=0;i<points.length;i++){
            int shift = (i * 2) % pol;   //Точки выводим со смещением на 2
            glVertex2d(points[shift].getX(),points[shift].getY());//object[i].x только так можно вызвать из массива объектов нужный метод
        }



        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_POINTS);
        glVertex2d(viewPoint.x, viewPoint.y);//динамичные координаты подвижной точки
        glEnd();
    }
}
