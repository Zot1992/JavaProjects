/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class MainView extends View {
    private Coordinate viewPoint;
    private double dx = 0.01d;//перемещение по оси х(по горизонтали)
    private double dy = 0.01d;//перемещение по оси y(по вертикали)


    private int W = 87;//позиция символа в таблице аски
    private int A = 65;
    private int D = 68;
    private int S = 83;

    public MainView() {
        viewPoint = new Coordinate(0, 0);//начальное положение подвижной точки
    }

    public class ObjMass2 {//класс на массив объектов
        Coordinate[]points2=new Coordinate[1];
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
        //glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры

        //DrawHelper.drawRectangle(-0.5, -0.5,-0.5, 0.0,0.0, 0.0,0.0, -0.5);//вызов метода квадрата
        //DrawHelper.drawCircle(0,0,0.5,360);//вызов метода круга
        //DrawHelper.drawStar(0.8,5);

        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        //DrawHelper.drawStar(0.8,5);


        glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.

        int vertex=5;
        double size=0.8;
        double end=1.0;//конечное положение звезды

        Coordinate[]points2=new Coordinate[vertex];
        double x,y;
        double deltaAngleR = 2*Math.PI / vertex;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for(int i=0;i<points2.length;i++){ //цикл обходит каждый полигон
            x=Math.cos(deltaAngleR*i)*size;
            y=Math.sin(deltaAngleR*i)*size;
            points2[i]=new Coordinate(x,y);
        }

        for(int i=0;i<points2.length;i++){
            int shift = (i * 2) % vertex;//Точки выводим со смещением на 2
            glVertex2d(points2[shift].x,points2[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод
        }
        /*for (double i=-1.0;i<end;i++){

        }*/

        glEnd();





        /*glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_POINTS);
        glVertex2d(viewPoint.x, viewPoint.y);//динамичные координаты подвижной точки
        glEnd(); */
    }
}
