package com.tfkfan.figure.circle;

import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractCircle implements Circle {
    protected final Coordinate center;
    protected double radius;
    protected int partition;

    protected double deltaAngle;

    public AbstractCircle(double radius, int partition) {
        this.center = new Coordinate();
        this.setRadius(radius);
        this.setPartition(partition);
    }

    public AbstractCircle(Coordinate center, double radius, int partition) {
        this.center = center;
        this.setRadius(radius);
        this.setPartition(partition);
    }

    @Override
    public void move(double dx, double dy) {
        center.x += dx;
        center.y += dy;
    }

    @Override
    public void rotate(double alfa) {
        /*double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);
        double ox = point.x, oy = point.y;
        point.x = ((ox - center.x) * cos - (oy - center.y) * sin + center.x);//Формула матрицы поворота в двумерном пространстве.
        // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
        point.y = ((ox - center.x) * sin + (oy - center.y) * cos + center.y);*/
    }

    @Override
    public void setPartition(int partition) {
        this.partition = partition;
        this.deltaAngle = 2 * Math.PI / partition;
    }

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public int partition() {
        return partition;
    }

    @Override
    public Coordinate center() {
        return center;
    }
}
