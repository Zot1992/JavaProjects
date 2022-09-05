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
        glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры

        /*double x,y,x2,y2;
        double pol=360;//количество полигонов в фигуре
        double l= 0.5;//размер
        double deltaAngleR = 2*Math.PI / pol;//нахождение угла для круга.2*Math.PI-что бы получить 360 градусов.


        glBegin(GL_POLYGON);// чертит линии с заливкой

        for(int i=-1;i<pol;i++){ //цикл обходит каждый полигон, еще делаем второй ряд полигонов +1 чтобы круг был цельным
            x=Math.sin(deltaAngleR*i)*l;
            y=Math.cos(deltaAngleR*i)*l;
            x2=Math.sin(deltaAngleR*(i+1))*l;
            y2=Math.cos(deltaAngleR*(i+1))*l;
            glVertex2d(x,y);
            glVertex2d(x2,y2);
        } */ //код на круг

        //glBegin(GL_LINES);//начало отрисовки (чертит линии без заливки).


        //glBegin(GL_TRIANGLE_FAN);// объединяет все точки
        /*glVertex2d(-0.5, -0.5);//положение нижней левой точки фигуры(v-ось x. v1-ось y)(декартовы координаты это координаты x,y с осями под прямым углом)
        //glVertex2d(-0.5, 0.0);//положение верхней левой точки фигуры
        //glVertex2d(0.0, 0.0);//положение верхней правой точки фигуры
        //glVertex2d(0.0, -0.5);//положение нижней правой точки фигуры */ //код прямоугольника


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
        double l= 0.5;//размер
        ArrayList<Double> list=new ArrayList<>();
        double deltaAngleR = 2*Math.PI / pol;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for(int i=0;i<pol;i++){ //цикл обходит каждый полигон
            x=Math.sin(deltaAngleR*i)*l;
            y=Math.cos(deltaAngleR*i)*l;
            list.add(x);
            list.add(y);
        }  //код на звезды

        for(int i=0;i<list.size();i++){
            glVertex2d(list.get(0),list.get(1));
            glVertex2d(list.get(2),list.get(3));
            glVertex2d(list.get(4),list.get(5));
            glVertex2d(list.get(6),list.get(7));
            glVertex2d(list.get(8),list.get(9));
        }

        /*glVertex2f(0.0f, 0.0f); // Центр звезды
        glVertex2f(-0.18f, 0.26f);
        glVertex2f(0.18f, 0.26f);

        glVertex2f(0.0f, 0.0f);
        glVertex2f(0.18f, 0.26f);
        glVertex2f(0.30f, -0.10f);

        glVertex2f(0.0f, 0.0f);
        glVertex2f(0.30f, -0.10f);
        glVertex2f(0.0f, -0.32f);

        glVertex2f(0.0f, 0.0f);
        glVertex2f(0.0f, -0.32f);
        glVertex2f(-0.30f, -0.10f);

        glVertex2f(0.0f, 0.0f);
        glVertex2f(-0.30f, -0.10f);
        glVertex2f(-0.18f, 0.26f);

        glEnd();//конец отрисовки */

        //glBegin(GL_TRIANGLES);

       /* glVertex2f(-0.18f, 0.26f);//внешние треугольники звезды
        glVertex2f(0.0f, 0.80f);
        glVertex2f(0.18f, 0.26f);


        glVertex2f(0.18f, 0.26f);
        glVertex2f(0.80f, 0.26f);
        glVertex2f(0.30f, -0.10f);


        glVertex2f(0.30f, -0.10f);
        glVertex2f(0.50f, -0.68f);
        glVertex2f(0.0f, -0.32f);


        glVertex2f(0.0f, -0.32f);
        glVertex2f(-0.50f, -0.68f);
        glVertex2f(-0.30f, -0.10f);


        glVertex2f(-0.30f, -0.10f);
        glVertex2f(-0.80f, 0.26f);
        glVertex2f(-0.18f, 0.26f);
        glEnd();  */

        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_POINTS);
        glVertex2d(viewPoint.x, viewPoint.y);//динамичные координаты подвижной точки
        glEnd();
    }
}
