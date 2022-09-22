/*Написать графическую программу, выполняющую:
        4) анимирующую движение звезды по оси OX */

package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class MainView extends View {
    private Coordinate viewPoint;
    private Coordinate viewPoint2;
    private Coordinate viewPoint3;
    private Coordinate viewPoint4;
    private Coordinate viewPoint5;
    private double dx = 0.01d;//перемещение по оси х(по горизонтали)
    private double dy = 0.01d;//перемещение по оси y(по вертикали)


    private int W = 87;//позиция символа в таблице аски
    private int A = 65;
    private int D = 68;
    private int S = 83;

    private int F = 70;
    private int T = 84;
    private int G = 71;
    private int H = 72;

    public MainView() {
        viewPoint = new Coordinate(0, 0);//начальное положение подвижной точки
        viewPoint2 = new Coordinate(0.5, 0);
        viewPoint3 = new Coordinate(-0.5, 0);
        viewPoint4 = new Coordinate(0, 0.5);
        viewPoint5 = new Coordinate(0, -0.5);
    }

    public class ObjMass2 {//класс на массив объектов
        Coordinate[]points2=new Coordinate[1];
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


        else if (code == W) //если мы с клавиатуры вводим W
            viewPoint2.y += dy;//то точки координаты увеличиваются на заданное значение dy с каждым нажатием по оси y
        else if (code == S)//если мы с клавиатуры вводим S
            viewPoint2.y -= dy;//то точки координаты уменьшаются на заданное значение dy с каждым нажатием по оси y
        else if (code == A)//если мы с клавиатуры вводим A
            viewPoint2.x -= dx;//то точки координаты уменьшаются на заданное значение dx с каждым нажатием по оси x
        else if (code == D)//если мы с клавиатуры вводим D
            viewPoint2.x += dx;//то точки координаты увеличиваются на заданное значение dx с каждым нажатием по оси x

        else if (code == W) //если мы с клавиатуры вводим W
            viewPoint3.y += dy;//то точки координаты увеличиваются на заданное значение dy с каждым нажатием по оси y
        else if (code == S)//если мы с клавиатуры вводим S
            viewPoint3.y -= dy;//то точки координаты уменьшаются на заданное значение dy с каждым нажатием по оси y
        else if (code == A)//если мы с клавиатуры вводим A
            viewPoint3.x -= dx;//то точки координаты уменьшаются на заданное значение dx с каждым нажатием по оси x
        else if (code == D)//если мы с клавиатуры вводим D
            viewPoint3.x += dx;//то точки координаты увеличиваются на заданное значение dx с каждым нажатием по оси x

        else if(code == W) //если мы с клавиатуры вводим W
            viewPoint4.y += dy;//то точки координаты увеличиваются на заданное значение dy с каждым нажатием по оси y
        else if (code == S)//если мы с клавиатуры вводим S
            viewPoint4.y -= dy;//то точки координаты уменьшаются на заданное значение dy с каждым нажатием по оси y
        else if (code == A)//если мы с клавиатуры вводим A
            viewPoint4.x -= dx;//то точки координаты уменьшаются на заданное значение dx с каждым нажатием по оси x
        else if (code == D)//если мы с клавиатуры вводим D
            viewPoint4.x += dx;//то точки координаты увеличиваются на заданное значение dx с каждым нажатием по оси x

        else if(code == W) //если мы с клавиатуры вводим W
            viewPoint5.y += dy;//то точки координаты увеличиваются на заданное значение dy с каждым нажатием по оси y
        else if (code == S)//если мы с клавиатуры вводим S
            viewPoint5.y -= dy;//то точки координаты уменьшаются на заданное значение dy с каждым нажатием по оси y
        else if (code == A)//если мы с клавиатуры вводим A
            viewPoint5.x -= dx;//то точки координаты уменьшаются на заданное значение dx с каждым нажатием по оси x
        else if (code == D)//если мы с клавиатуры вводим D
            viewPoint5.x += dx;//то точки координаты увеличиваются на заданное значение dx с каждым нажатием по оси x


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

        int vertex=5;
        double size=0.5;
        double current=0.0;
        double begin=-1.0;
        double end=1.0;//конечное положение звезды
        double speed = 0.05d;


        Coordinate[]points2=new Coordinate[vertex];

        double x,y;
        double deltaAngleR = 2*Math.PI / vertex;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for(int i=0;i<points2.length;i++){ //цикл обходит каждый полигон
            x=Math.cos(deltaAngleR*i)*size;
            y=Math.sin(deltaAngleR*i)*size;
            points2[i]=new Coordinate(x,y);
        }

        for(int i=0;i<points2.length;i++){
            int shift = (i * 2) % vertex;//Точки выводим со смещением на 2
            glVertex2d(points2[shift].x,points2[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод
        }
        for (int i=0;i<points2.length;i++){
            for (double j=0.0;j<end;j+=0.1) {
                if (current != end) {
                    speed += speed;
                } else if (current != begin) {
                    speed -= speed;
                }
            }
        }

        glEnd();





        glColor3f(0.2f, 0.2f, 0.2f);//цвет подвижной точки
        glPointSize(10);//размер подвижной точки
        glBegin(GL_LINE_LOOP);
        glVertex2d(viewPoint.x, viewPoint.y);//динамичные координаты подвижной точки
        glVertex2d(viewPoint2.x, viewPoint2.y);
        glVertex2d(viewPoint3.x, viewPoint3.y);
        glVertex2d(viewPoint4.x, viewPoint4.y);
        glVertex2d(viewPoint5.x, viewPoint5.y);
        glEnd();
    }
}
