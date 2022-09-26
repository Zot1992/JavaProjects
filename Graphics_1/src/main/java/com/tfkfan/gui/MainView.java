/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class MainView extends View {
    private Coordinate viewPoint;

    private double dx = 0.005d;//перемещение по оси х(по горизонтали)
    private double dy = 0.005d;//перемещение по оси y(по вертикали)


    private int W = 87;//позиция символа в таблице аски
    private int A = 65;
    private int D = 68;
    private int S = 83;


    public MainView() {
        viewPoint = new Coordinate(0, 0);//начальное положение подвижной точки
    }

    Coordinate[] points2 = new Coordinate[5];




    @Override
    public void onKeyboardInput(int code) { //ОБРАБОТЧИК СОБЫТИЯ ВВОДА С КЛАВИАТУРЫ
        /*if (code == W) //если мы с клавиатуры вводим W
            viewPoint.y += dy;//то точки координаты увеличиваются на заданное значение dy с каждым нажатием по оси y
        else if (code == S)//если мы с клавиатуры вводим S
            viewPoint.y -= dy;//то точки координаты уменьшаются на заданное значение dy с каждым нажатием по оси y
        else if (code == A)//если мы с клавиатуры вводим A
            viewPoint.x -= dx;//то точки координаты уменьшаются на заданное значение dx с каждым нажатием по оси x
        else if (code == D)//если мы с клавиатуры вводим D
            viewPoint.x += dx;//то точки координаты увеличиваются на заданное значение dx с каждым нажатием по оси x */


        for (int i = 0; i < points2.length; i++){
            if (code == W) //если мы с клавиатуры вводим W
                points2[i].y += dy;//то точки координаты увеличиваются на заданное значение dy с каждым нажатием по оси y
            else if (code == S)//если мы с клавиатуры вводим S
                points2[i].y -= dy;//то точки координаты уменьшаются на заданное значение dy с каждым нажатием по оси y
            else if (code == A)//если мы с клавиатуры вводим A
                points2[i].x -= dx;//то точки координаты уменьшаются на заданное значение dx с каждым нажатием по оси x
            else if (code == D)//если мы с клавиатуры вводим D
                points2[i].x += dx;//то точки координаты увеличиваются на заданное значение dx с каждым нажатием по оси x
        }
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


        //glLoadIdentity();//делает один цикл и тормозит остальные функции opengl чтобы они не вызывались бесконечно
        //glRotatef(20,0.0f,0.0f,0.0f);//функция  opengl которая делает поворот объекта
        //glTranslated(0.001,0.0,0.0);//функция opengl которое создает движение сетки(она сдвигает систему координат на экране)

        glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.

        int vertex = 5;
        double size = 0.5;
        double current = 0.0;
        double begin = -1.0;
        double end = 1.0;//конечное положение звезды
        double speed = 0.05d;


        //Coordinate[] points2 = new Coordinate[vertex];

        double x, y;
        double deltaAngleR = 2 * Math.PI / vertex;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for (int i = 0; i < points2.length; i++) { //цикл обходит каждый полигон
            x = Math.cos(deltaAngleR * i) * size;
            y = Math.sin(deltaAngleR * i) * size;
            points2[i] = new Coordinate(x, y);
        }

        for (int i = 0; i < points2.length; i++) {
            int shift = (i * 2) % vertex;//Точки выводим со смещением на 2
            glVertex2d(points2[shift].x, points2[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод

        }
        /*for (int i = 0; i < points2.length; i++) {
            for (double j = 0.0; j < end; j += 0.5) {
                if (current != end) {
                    onKeyboardInput(D);
                    //speed += speed;
                } else if (current != begin) {
                    onKeyboardInput(A);
                    //speed -= speed;
                }
            }
        } */
        glEnd();


        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_POINTS);
        //glVertex2d(viewPoint.x, viewPoint.y);//динамичные координаты подвижной точки
        for (int i = 0; i < points2.length; i++){
        glVertex2d(points2[i].x, points2[i].y);}
        glEnd();

    }
}

