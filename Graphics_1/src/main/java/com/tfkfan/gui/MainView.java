/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.tfkfan.shared.Constants;
import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;

public class MainView extends View {


    public MainView() {
    }




    @Override //указывает, что далее мы собираемся переопределять метод базового класса.
    protected void partialDisplay() { //функция по отрисовке графики
        //glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры
        //DrawHelper.drawRectangle(-0.5, -0.5,-0.5, 0.0,0.0, 0.0,0.0, -0.5);//вызов метода квадрата
        //DrawHelper.drawCircle(0,0,0.5,360);//вызов метода круга
        //DrawHelper.drawStar(0.8,5);

        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
       /*

        if(center.x >= end || center.x <= begin)//если мы доходим до конца или до начала, то происходит смена знака
            speed = -speed;//если - присевается 2 раза, то он преобразуется в +
        moveStar(speed,0);//вызов функции движения звезды
        rotateStar(alfa);//вызов функции вращения звезды*/
    }
}

