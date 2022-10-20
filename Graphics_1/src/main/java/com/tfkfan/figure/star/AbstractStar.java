package com.tfkfan.figure.star;

import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractStar implements Star {
    /* Абстрактный класс может быть только родительским. В абстрактном классе можно писать абстрактные методы и обычные. В классах наследниках реализуются эти
    абстрактные методы*/
    protected int vertices;
    protected double size;
    protected double deltaAngle;
    protected Coordinate[] starPoints;
    protected Coordinate center;

    public AbstractStar(double size,int vertices) {
        this.starPoints = makeStar(size,vertices);
        this.center = new Coordinate();
        this.setVertices(vertices);
        this.setSize(size);
    }

    public AbstractStar(Coordinate center, double size, int vertices) {
        this.starPoints = makeStar(size,vertices);
        this.center = center;
        this.setVertices(vertices);
        this.setSize(size);
    }

    public Coordinate[] makeStar(double size, int vertices) {//функция на создание точек звезды
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



    @Override
    public void setVertices(int vertices) {
        this.vertices = vertices;
        this.deltaAngle = 2 * Math.PI / vertices;
    }

    @Override
    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public Coordinate center() {
        return center;
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public double size() {
        return size;
    }

    @Override
    public void move(double dx, double dy) {
        for (Coordinate starPoint : starPoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            starPoint.y += dy;
            starPoint.x += dx;
        }
        center.x += dx;
        center.y += dy;
    }
    @Override
    public void rotate(double alfa){ //функция для вращения звезды
        double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);
        for (Coordinate point : starPoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            double ox = point.x, oy = point.y;
            point.x = ((ox - center.x) * cos - (oy - center.y) * sin + center.x);//Формула матрицы поворота в двумерном пространстве.
            // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
            point.y = ((ox - center.x) * sin + (oy - center.y) * cos + center.y);
        }
    }
}

