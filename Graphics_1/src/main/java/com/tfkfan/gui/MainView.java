/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.tfkfan.figure.circle.Circle;
import com.tfkfan.figure.circle.LinedCircle;
import com.vividsolutions.jts.geom.Coordinate;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

public class MainView extends View {

    private final Circle circle = new LinedCircle(0.3, 2);
    int count = 0;

    public MainView() {
    }


    @Override //указывает, что далее мы собираемся переопределять метод базового класса.
    protected void partialDisplay() { //функция по отрисовке графики
        //glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры
        //DrawHelper.drawRectangle(-0.5, -0.5,-0.5, 0.0,0.0, 0.0,0.0, -0.5);//вызов метода квадрата
        //DrawHelper.drawCircle(0,0,0.5,360);//вызов метода круга
        //DrawHelper.drawStar(0.8,5);

        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки


        count++;
        if (count >= 100) {
            count = 0;
            circle.setPartition(circle.partition() + 1);
            circle.setRadius(new Random().nextDouble());
        }
        circle.draw();
       /*

        if(center.x >= end || center.x <= begin)//если мы доходим до конца или до начала, то происходит смена знака
            speed = -speed;//если - присевается 2 раза, то он преобразуется в +
        moveStar(speed,0);//вызов функции движения звезды
        rotateStar(alfa);//вызов функции вращения звезды*/
    }
}

