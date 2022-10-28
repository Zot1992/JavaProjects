package com.tfkfan.figure.rectangle;

import com.tfkfan.figure.AbstractFigure;
import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractRectangle extends AbstractFigure implements Rectangle {
    protected double width;
    protected double height;
    protected Coordinate[] rectanglePoints = new Coordinate[4];

    public AbstractRectangle(double width, double height) {
        super();//обращаемся к пустому родительскому классу
        this.setWidth(width);
        this.setHeight(height);
        initRectanglePoints(this.width, this.height);
    }

    public AbstractRectangle(Coordinate center, double width, double height) {
        super(center);//создаем центр из родительского класса
        this.setWidth(width);
        this.setHeight(height);
        initRectanglePoints(this.width, this.height);
    }

    private void initRectanglePoints(double width, double length) {
        rectanglePoints[0] = new Coordinate(center.x - width / 2, center.y + length / 2);
        rectanglePoints[1] = new Coordinate(center.x - width / 2, center.y - length / 2);
        rectanglePoints[2] = new Coordinate(center.x + width / 2, center.y - length / 2);
        rectanglePoints[3] = new Coordinate(center.x + width / 2, center.y + length / 2);
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double width() {
        return width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double height() {
        return height;
    }


    @Override
    public void move(double dx, double dy) { //функция на движение
        super.move(dx, dy);//берем дефолтные значения и создаем переменные
        for (Coordinate RectanglePoint : rectanglePoints) { // тоже самое что for(int i=0;i<points;i++)
            RectanglePoint.y += dy;
            RectanglePoint.x += dx;
        }
    }

    @Override
    public void rotate(Coordinate axis, double alfa) {
        double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);
        for (Coordinate RectanglePoint : rectanglePoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            double ox = RectanglePoint.x, oy = RectanglePoint.y;
            RectanglePoint.x = ((ox - axis.x) * cos - (oy - axis.y) * sin + axis.x);//Формула матрицы поворота в двумерном пространстве.
            // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
            RectanglePoint.y = ((ox - axis.x) * sin + (oy - axis.y) * cos + axis.y);
        }
    }
}
