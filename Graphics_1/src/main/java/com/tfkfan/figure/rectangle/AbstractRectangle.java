package com.tfkfan.figure.rectangle;

import com.tfkfan.figure.AbstractFigure;
import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractRectangle extends AbstractFigure implements Rectangle{
    protected int vertices;
    protected double size;
    protected Coordinate[] RectanglePoints;
    protected double deltaAngle;

    public AbstractRectangle(double size, int vertices) {
        super();
        this.setVertices(vertices);
        this.setSize(size);
        this.RectanglePoints = initRectanglePoints(this.size, this.vertices);
    }

    public AbstractRectangle(Coordinate center, double size, int vertices) {
        super(center);//создаем центр с дефолтным значением
        this.setVertices(vertices);
        this.setSize(size);
        this.RectanglePoints = initRectanglePoints(this.size, this.vertices);
    }

    private Coordinate[] initRectanglePoints(double size, int vertices) {
        Coordinate[] points = new Coordinate[vertices];
        double x, y;

        return points;
    }

    @Override
    public void setSize(double size) {
        this.size = size;
    }
    @Override

    public void setVertices(int vertices) {
        this.vertices = vertices;
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
    public void move(double dx, double dy) { //функция на движение
        super.move(dx, dy);//берем дефолтные значения и создаем переменные
        for (Coordinate Rectanglepoint : RectanglePoints) { // тоже самое что for(int i=0;i<points;i++)
            Rectanglepoint.y += dy;
            Rectanglepoint.x += dx;
        }
    }

    @Override
    public void rotate(Coordinate axis, double alfa) {
        double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);
        for (Coordinate Rectanglepoint : RectanglePoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            double ox = Rectanglepoint.x, oy = Rectanglepoint.y;
            Rectanglepoint.x = ((ox - axis.x) * cos - (oy - axis.y) * sin + axis.x);//Формула матрицы поворота в двумерном пространстве.
            // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
            Rectanglepoint.y = ((ox - axis.x) * sin + (oy - axis.y) * cos + axis.y);
        }
    }
}
