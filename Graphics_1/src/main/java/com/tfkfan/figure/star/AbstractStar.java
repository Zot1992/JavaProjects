package com.tfkfan.figure.star;

import com.tfkfan.figure.AbstractFigure;
import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractStar extends AbstractFigure implements Star {
    /* Абстрактный класс может быть только родительским. В абстрактном классе можно писать абстрактные методы и обычные. В классах наследниках реализуются эти
    абстрактные методы*/
    protected int vertices;
    protected double size;
    protected double deltaAngle;
    protected Coordinate[] starPoints;

    public AbstractStar(double size, int vertices) {
        super();
        this.setVertices(vertices);
        this.setSize(size);
        this.starPoints = initStarPoints(this.size, this.vertices);
    }

    public AbstractStar(Coordinate center, double size, int vertices) {
        super(center);
        this.setVertices(vertices);
        this.setSize(size);
        this.starPoints = initStarPoints(this.size, this.vertices);
    }

    //Метод не должен быть переопределен в классах-потомках, ибо незачем
    private Coordinate[] initStarPoints(double size, int vertices) {//функция на создание точек звезды
        Coordinate[] points = new Coordinate[vertices];
        double x, y;
        for (int i = 0; i < points.length; i++) { //цикл обходит каждый полигон
            x = Math.cos(deltaAngle * i) * size;
            y = Math.sin(deltaAngle * i) * size;
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
    public int vertices() {
        return vertices;
    }

    @Override
    public double size() {
        return size;
    }

    @Override
    public void move(double dx, double dy) {
        super.move(dx, dy);
        for (Coordinate starPoint : starPoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            starPoint.y += dy;
            starPoint.x += dx;
        }
    }

    //функция вращения звезды вокруг произвольной точки
    @Override
    public void rotate(Coordinate axis, double alfa) {
        double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);
        for (Coordinate point : starPoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            double ox = point.x, oy = point.y;
            point.x = ((ox - axis.x) * cos - (oy - axis.y) * sin + axis.x);//Формула матрицы поворота в двумерном пространстве.
            // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
            point.y = ((ox - axis.x) * sin + (oy - axis.y) * cos + axis.y);
        }
    }
}

