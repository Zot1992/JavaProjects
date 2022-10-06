/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.tfkfan.shared.Constants;
import com.vividsolutions.jts.geom.Coordinate;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class MainView extends View {
    private Coordinate[] starPoints;
    int vertices = 5;
    double size = 0.5d;
    double begin = -0.025d;
    double end = 0.025d;
    double current = 0;
    double speed = 0.005;

    public MainView() {
        starPoints = DrawHelper.makeStar(size, vertices);
    }

    @Override
    public void onKeyboardInput(int code) { //ОБРАБОТЧИК СОБЫТИЯ ВВОДА С КЛАВИАТУРЫ
        if (code == Constants.W) //если мы с клавиатуры вводим W
            moveStar(0, Constants.dy);//то точки координаты увеличиваются на заданное значение dy с каждым нажатием по оси y
        if (code == Constants.S)//если мы с клавиатуры вводим S
            moveStar(0, -Constants.dy);//то точки координаты уменьшаются на заданное значение dy с каждым нажатием по оси y
        if (code == Constants.A)//если мы с клавиатуры вводим A
            moveStar(-Constants.dx, 0);//то точки координаты уменьшаются на заданное значение dx с каждым нажатием по оси x
        if (code == Constants.D)//если мы с клавиатуры вводим D
            moveStar(Constants.dx, 0);//то точки координаты увеличиваются на заданное значение dx с каждым нажатием по оси x
    }

    protected void moveStar(double ddx, double ddy) {// функция для движения звезды
        for (Coordinate starPoint : starPoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            starPoint.y += ddy;
            starPoint.x += ddx;
        }
    }


    @Override //указывает, что далее мы собираемся переопределять метод базового класса.
    protected void partialDisplay() { //функция по отрисовке графики
        //glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры
        //DrawHelper.drawRectangle(-0.5, -0.5,-0.5, 0.0,0.0, 0.0,0.0, -0.5);//вызов метода квадрата
        //DrawHelper.drawCircle(0,0,0.5,360);//вызов метода круга
        //DrawHelper.drawStar(0.8,5);

        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        DrawHelper.drawStar(starPoints);

        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_POINTS);


        //if (Constants.dx<begin){moveStar(Constants.dx,0);current+=speed;}
        //else if(Constants.dx==end){moveStar(-Constants.dx,0);}

        if (current<150){
            moveStar(Constants.dx, 0);
            for (int i=0;i<1;i++) {
                current++;
            }
        }
        else if(current<300){
            moveStar(-Constants.dx, 0);
            for (int i=0;i<1;i++) {
                current++;
            }
        }
         else if(current==300){current=0;}



        //moveStar(-Constants.dx,0);



        /*for (Coordinate starPoint : starPoints) {


            //if (starPoint.x<begin){moveStar(Constants.dx,0);}
            //else if(starPoint.x==end){moveStar(-Constants.dx,0);}
        }*/


        //for (Coordinate coordinate : starPoints) glVertex2d(coordinate.x, coordinate.y);

        glEnd();
    }
}

