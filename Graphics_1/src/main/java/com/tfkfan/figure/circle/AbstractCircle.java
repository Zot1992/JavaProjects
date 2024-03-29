package com.tfkfan.figure.circle;

import com.tfkfan.figure.AbstractFigure;
import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractCircle extends AbstractFigure implements Circle {
    protected double radius;
    protected int partition;

    protected Coordinate[] points;
    protected double deltaAngle;

    public AbstractCircle(double radius, int partition) {
        super();
        this.setRadius(radius);
        this.setPartition(partition);
    }

    public AbstractCircle(Coordinate center, double radius, int partition) {
        super(center);//создаем центр с дефолтным значением
        this.setRadius(radius);
        this.setPartition(partition);
    }

    private void initPoints() {
        points = new Coordinate[partition + 1];//пишем +1 что бы сделать фигуру не курсивом, а сплошной линией
        for (int i = -1; i < partition; i++) //цикл обходит каждый полигон
            points[i + 1] = new Coordinate(Math.cos(deltaAngle * i) * radius + center.x,
                    Math.sin(deltaAngle * i) * radius + center.y);
    }

    @Override
    public void move(double dx, double dy) {
        super.move(dx, dy);
        for (Coordinate point : points) {
            point.x += dx;
            point.y += dy;
        }
    }

    @Override
    public void rotate(Coordinate axis, double alfa) {
        double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);

        for (Coordinate point : points) { // тоже самое что for(int i=0;i<starPoints;i++)
            double ox = point.x, oy = point.y;
            point.x = ((ox - axis.x) * cos - (oy - axis.y) * sin + axis.x);//Формула матрицы поворота в двумерном пространстве.
            // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
            point.y = ((ox - axis.x) * sin + (oy - axis.y) * cos + axis.y);
        }
    }

    @Override
    public void setPartition(int partition) {
        this.partition = partition;
        this.deltaAngle = 2 * Math.PI / partition;
        initPoints();
    }

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
        initPoints();
    }

    @Override
    public int partition() {
        return partition;
    }
}
