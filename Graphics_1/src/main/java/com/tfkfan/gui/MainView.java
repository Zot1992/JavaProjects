package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;

public class MainView extends View {
    private Coordinate viewPoint;
    private double dx = 0.01d;//перемещение по оси х(по горизонтали)
    private double dy = 0.01d;//перемещение по оси y(по вертикали)

    private int W = 87;
    private int A = 65;
    private int D = 68;
    private int S = 83;

    public MainView() {
        viewPoint = new Coordinate(0.5, 0.5);
    } //начальное положение подвижной точки

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

    @Override
    protected void partialDisplay() { //Отображение подвижной и неподвижной фигуры
        glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры
        glBegin(GL_POLYGON);
        glVertex2d(-0.5, -0.5);//положение нижней левой точки фигуры
        glVertex2d(-0.5, 0.0);//положение верхней левой точки фигуры
        glVertex2d(0.0, 0.0);//положение верхней правой точки фигуры
        glVertex2d(0.0, -0.5);//положение нижней правой точки фигуры
        glEnd();

        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_POINTS);
        glVertex2d(viewPoint.x, viewPoint.y);//динамичные координаты подвижной точки
        glEnd();
    }
}
