/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.tfkfan.figure.circle.Circle;
import com.tfkfan.figure.circle.LinedCircle;
import com.tfkfan.figure.star.FilledStar;
import com.tfkfan.figure.star.LinedStar;
import com.tfkfan.figure.star.Star;
import com.vividsolutions.jts.geom.Coordinate;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

public class MainView extends View {

    private final Circle circle = new LinedCircle(0.3, 2);
    private final Star lstar = new LinedStar(0.5, 5);
    private final Star fstar = new FilledStar(0.5, 5);
    int count = 0;
    double current = 0;
    double begin = -0.5;
    double end = 0.5;
    double speed = 0.005;

    public MainView() {
    }


    @Override //указывает, что далее мы собираемся переопределять метод базового класса.
    protected void partialDisplay() { //функция по отрисовке графики
        //glColor3f(2.0f, 0.0f, 0.0f);//цвет неподвижной фигуры
        //DrawHelper.drawRectangle(-0.5, -0.5,-0.5, 0.0,0.0, 0.0,0.0, -0.5);//вызов метода квадрата
        //DrawHelper.drawCircle(0,0,0.5,360);//вызов метода круга
        //DrawHelper.drawStar(0.8,5);

        glColor3f(0.2f, 0.2f, 0.2f);
        lstar.draw();//вызов функции на отрисовку звезды линиями
        glColor3f(1.0f, 0.0f, 0.0f);
        fstar.draw();

        if (current <= begin || current >= end) { //код на смену хода движения звезды
            speed = -speed;
        }
        current += speed;
        lstar.move(speed, 0);//вызов функции движения звезды
        lstar.rotate(0.025);
        fstar.move(0, speed);
        fstar.rotate(0.025);

        /*count++;
        if (count >= 100) {
            count = 0;
            circle.setPartition(circle.partition() + 1);
            circle.setRadius(new Random().nextDouble());
        }
        circle.draw(); */

       /*

        if(center.x >= end || center.x <= begin)//если мы доходим до конца или до начала, то происходит смена знака
            speed = -speed;//если - присевается 2 раза, то он преобразуется в +
        moveStar(speed,0);//вызов функции движения звезды
        rotateStar(alfa);//вызов функции вращения звезды*/
    }
}

/* private Coordinate[] starPoints; параметры звезды
    public int vertices = 5;
    public double size = 0.5d;
    public double begin = -0.5;
    public double end = 0.5;
    Coordinate center = new Coordinate();
    public double speed = 0.005;
    public double alfa = 0.05;*/



