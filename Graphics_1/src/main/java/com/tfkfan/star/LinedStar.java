package com.tfkfan.star;

import com.vividsolutions.jts.geom.Coordinate;
import static org.lwjgl.opengl.GL11.*;



public class LinedStar implements Star{

    private Coordinate[] starPoints;
    public int vertices = 5;
    public double size = 0.5d;
    public double begin = -0.5;
    public double end = 0.5;
    Coordinate center = new Coordinate();
    public double speed = 0.005;
    public double alfa = 0.05;

    public LinedStar(){}

    public LinedStar(int vertices,double size,double begin,double end,double speed,double alfa){
        this.vertices=vertices;
        this.size=size;
        this.begin=begin;
        this.end=end;
        this.speed=speed;
        this.alfa=alfa;
    }

    public  void drawStar(double size, int vertices) {drawStar(makeStar(size, vertices));}//объединение всей конструкции кода звезды для ее норм вызова

    public  Coordinate[] makeStar(double size, int vertices) { //код на звезды(позиции точек)
        Coordinate[] points = new Coordinate[vertices];
        double x, y;
        double deltaAngleR = 2 * Math.PI / vertices;//нахождение угла для звезды.2*Math.PI-что бы получить 360 градусов.

        for (int i = 0; i < points.length; i++) { //цикл обходит каждый полигон
            x = Math.cos(deltaAngleR * i) * size;
            y = Math.sin(deltaAngleR * i) * size;
            points[i] = new Coordinate(x, y);
        }
        return points;
    }
        public  void drawStar (Coordinate[]points){ //код на звезды(смещение точек и отрисовка их на экране)
            glBegin(GL_LINE_LOOP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.
            int vertices = points.length;
            for (int i = 0; i < points.length; i++) {
                int shift = (i * 2) % vertices;   //Точки выводим со смещением на 2
                glVertex2d(points[shift].x, points[shift].y);//object[i].x только так можно вызвать из массива объектов нужный метод
            }

            glEnd();// конец отрисовки. Работает в паре с glBegin
        }

    @Override //позволяет изменить параметры метода
    public void draw() {
        drawStar(size,vertices);
    }

    protected void rotateStar(double alfa){//функция для вращения звезды
        double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);
        for (Coordinate point : starPoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            double ox = point.x,oy = point.y;
            point.x = ((ox - center.x)*cos - (oy - center.y)*sin + center.x);//Формула матрицы поворота в двумерном пространстве.
            // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
            point.y = ((ox - center.x)*sin + (oy - center.y)*cos + center.y);
        }
    }

    @Override
    public void move(double dx, double dy) {
        for (Coordinate starPoint : starPoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            starPoint.y += dy;
            starPoint.x += dx;
        }
        center.x +=dx;
        center.y +=dy;
    }
}

