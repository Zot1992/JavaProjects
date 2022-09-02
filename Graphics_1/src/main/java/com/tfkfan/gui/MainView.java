/*Написать графическую программу, выполняющую:
        3) рисующую красную пятиконечную звезду */

package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;


import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class MainView extends View {
    private Coordinate viewPoint;
    private double dx = 0.01d;//перемещение по оси х(по горизонтали)
    private double dy = 0.01d;//перемещение по оси y(по вертикали)

    private double numRays=5;


    private double deltaAngleR = 2*Math.PI / numRays;//нахождение угла для звезды


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
        glColor3f(0.0f, 0.0f, 1.0f);
        DrawHelper.drawRectangle(-0.5,-0.5, -0.5, 0.0, 0.0, 0.0,0.0, -0.5);

        glColor3f(1.0f, 0.0f, 0.0f);//цвет неподвижной фигуры
        DrawHelper.drawCircle(0d,0d,0.3d,360);

        double x,y;
        int pol=5;//количество полигонов в фигуре
        double l= 0.5;//размер
        //double [] arrX=new double[pol];
        //double [] arrY=new double[pol];
        ArrayList<?> list=new ArrayList<>();
        double deltaAngleR = 2*Math.PI / pol;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for(int i=0;i<pol+1;i++){ //цикл обходит каждый полигон
            x=Math.sin(deltaAngleR*i)*l;
            y=Math.cos(deltaAngleR*i)*l;
        }  //код на звезды
    }
}
