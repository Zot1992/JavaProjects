/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.tfkfan.figure.circle.Circle;
import com.tfkfan.figure.circle.LinedCircle;
import com.tfkfan.figure.rectangle.FilledRectangle;
import com.tfkfan.figure.rectangle.LinedRectangle;
import com.tfkfan.figure.rectangle.Rectangle;
import com.tfkfan.figure.star.FilledStar;
import com.tfkfan.figure.star.LinedStar;
import com.tfkfan.figure.star.Star;

import static org.lwjgl.opengl.GL11.*;

public class MainView extends View {

    private final Circle circle = new LinedCircle(0.3, 4);//создание обьекта круг
    private final Star lstar = new LinedStar(0.5, 4);//создание обьекта прозначная звезда
    private final Star fstar = new FilledStar(0.5, 5);//создание обьекта залитая звезда
    private final Rectangle fRectangle =new FilledRectangle(0.5,0.5);
    private final Rectangle lRectangle = new LinedRectangle(0.5,0.5);
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

        //glColor3f(0.2f, 0.2f, 0.2f);
       glColor3f(0.2f, 0.2f, 0.2f);
        //lstar.draw();//вызов функции на отрисовку звезды линиями
        glColor3f(1.0f, 0.0f, 0.0f);
        //fstar.draw();
        //lstar.draw();
        //lrectangle.draw();
        fRectangle.draw();
        lRectangle.draw();
        //glColor3f(1.0f, 0.0f, 0.0f);
        if (current <= begin || current >= end) { //код на смену хода движения звезды
            speed = -speed;
        }
        current += speed;

        fRectangle.move(0, speed);
        lRectangle.move(speed, 0);
        //lstar.move(speed, 0);//вызов функции движения звезды
        //lstar.rotate(0.025);
        //fstar.move(0, speed);
        //fstar.rotate(0.025);

        //circle.draw();
        //circle.rotate(new Coordinate(0.25,0.25),0.05);

        /*count++;
        if (count >= 1000) {
            count = 0;
            circle.setPartition(circle.partition() + 1);
            if(circle.partition()>5)
                circle.setPartition(1);
            circle.setRadius(new Random().nextDouble());
        }
        circle.draw();
        circle.rotate(new Coordinate(0.25,0.25),0.05);

       /*



        /*if(center.x >= end || center.x <= begin)//если мы доходим до конца или до начала, то происходит смена знака
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



