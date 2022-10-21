package com.tfkfan.figure.circle;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.glVertex2d;

public abstract class AbstractCircle implements Circle {
    protected final Coordinate center;
    protected double radius;
    protected int partition;

    protected Coordinate[] points;
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

    private void initPoints() {
        points = new Coordinate[partition + 1];
        for (int i = -1; i < partition; i++) //цикл обходит каждый полигон
            points[i + 1] = new Coordinate(Math.cos(deltaAngle * i) * radius + center.x,
                    Math.sin(deltaAngle * i) * radius + center.y);
    }

    @Override
    public void move(double dx, double dy) {
        center.x += dx;
        center.y += dy;
        for (Coordinate point : points) {
            point.x += dx;
            point.y += dy;
        }
    }

    @Override
    public final void rotate(double alfa) {
        double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);

        for (Coordinate point : points) { // тоже самое что for(int i=0;i<starPoints;i++)
            double ox = point.x, oy = point.y;
            point.x = ((ox - center.x) * cos - (oy - center.y) * sin + center.x);//Формула матрицы поворота в двумерном пространстве.
            // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
            point.y = ((ox - center.x) * sin + (oy - center.y) * cos + center.y);
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

    @Override
    public Coordinate center() {
        return center;
    }
}
