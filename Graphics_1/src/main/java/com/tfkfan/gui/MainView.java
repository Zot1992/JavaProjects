/*Написать графическую программу, выполняющую:
        3) рисующую красную пятиконечную звезду */

package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;


import static org.lwjgl.opengl.GL11.*;

public class MainView extends View {
    private Coordinate viewPoint;
    private double dx = 0.01d;//перемещение по оси х(по горизонтали)
    private double dy = 0.01d;//перемещение по оси y(по вертикали)
    private double numRays=5;
    private double deltaAngleR = 2*Math.PI / numRays;


    private int W = 87;
    private int A = 65;
    private int D = 68;
    private int S = 83;

    public MainView() {
        viewPoint = new Coordinate(0.5, 0.5);//начальное положение подвижной точки
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
        //glBegin(GL_POLYGON);// чертит линии с заливкой
        glBegin(GL_LINES);//начало отрисовки (чертит линии без заливки).
        /*glVertex2d(-0.5, -0.5);//положение нижней левой точки фигуры(v-ось x. v1-ось y)(декартовы координаты это координаты x,y с осями под прямым углом)
        //glVertex2d(-0.5, 0.0);//положение верхней левой точки фигуры
        //glVertex2d(0.0, 0.0);//положение верхней правой точки фигуры
        //glVertex2d(0.0, -0.5);//положение нижней правой точки фигуры */ //код прямоугольника

        /*glVertex2d(-0.25, -0.25);
        glVertex2d(0.0, 0.0);
        glVertex2d(-0.5, 0.0);//код развернутого треугольника */

        /*glVertex2d(0.0, 0.8); // код звезды (неправильный)
        glVertex2d(0.6, -0.7);
        glVertex2d(-0.8, 0.1);
        glVertex2d(0.8, 0.1);
        glVertex2d(-0.6, -0.7);
        glVertex2d(0.0, 0.8); */

        glVertex2d(-0.4, 0.5);//код квадрата
        glVertex2d(-0.4, -0.5);
        glVertex2d(0.4, 0.5);
        glVertex2d(0.4, -0.5);
        glVertex2d(-0.4, 0.5);
        glVertex2d(0.4, 0.5);
        glVertex2d(-0.4, -0.5);
        glVertex2d(0.4, -0.5);

        //код для создания круга в квадрате
        glVertex2d(-0.4, 0.5);//верхняя левая вершина квадрата
        glVertex2d(0.4, -0.5);//нижняя правая вершина квадрата



        glEnd();//конец отрисовки

        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_POINTS);
        glVertex2d(viewPoint.x, viewPoint.y);//динамичные координаты подвижной точки
        glEnd();
    }
}
