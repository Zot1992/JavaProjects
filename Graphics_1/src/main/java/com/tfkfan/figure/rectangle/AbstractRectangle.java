package com.tfkfan.figure.rectangle;

import com.tfkfan.figure.AbstractFigure;
import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractRectangle extends AbstractFigure implements Rectangle{
    protected  static final int vertices = 4;
    protected double width;
    protected double length;
    protected Coordinate[] RectanglePoints;
    protected double deltaAngle;

    public AbstractRectangle(double width,double length) {
        super();//обращаемся к пустому родительскому классу
        this.setWidth(width);
        this.setLength(length);
        this.RectanglePoints = initRectanglePoints(this.width,this.length);
    }

    public AbstractRectangle(Coordinate center, double width,double length) {
        super(center);//создаем центр из родительского класса
        this.setWidth(width);
        this.setLength(length);
        this.RectanglePoints = initRectanglePoints(this.width,this.length);
    }

    private Coordinate[] initRectanglePoints(double width,double length) {
        Coordinate[] points = new Coordinate[AbstractRectangle.vertices];
        Coordinate center=new Coordinate(0,0);
        double x, y;

        for (int i = 0; i < points.length; i++) {
            if (i==0){
                x=center.x-width/2;
                y=center.y+length/2;
                points[i] = new Coordinate(x, y);
            }
            else if (i==1){
                x=center.x-width/2;
                y=center.y-length/2;
                points[i] = new Coordinate(x, y);
            }
            else if (i==2){
                x=center.x+width/2;
                y=center.y-length/2;
                points[i] = new Coordinate(x, y);
            }
            else if (i==3){
                x=center.x+width/2;
                y=center.y+length/2;
                points[i] = new Coordinate(x, y);
            }

        }
        return points;
    }

    @Override
    public void setWidth(double  width) {
        this. width =  width;
    }

    @Override
    public double  width() {
        return  width;
    }

    @Override
    public void setLength(double  length) {
        this. length =  length;
    }

    @Override
    public double  length() {
        return  length;
    }


    @Override
    public void move(double dx, double dy) { //функция на движение
        super.move(dx, dy);//берем дефолтные значения и создаем переменные
        for (Coordinate RectanglePoint : RectanglePoints) { // тоже самое что for(int i=0;i<points;i++)
            RectanglePoint.y += dy;
            RectanglePoint.x += dx;
        }
    }

    @Override
    public void rotate(Coordinate axis, double alfa) {
        double cos = Math.cos(alfa);
        double sin = Math.sin(alfa);
        for (Coordinate RectanglePoint : RectanglePoints) { // тоже самое что for(int i=0;i<starPoints;i++)
            double ox = RectanglePoint.x, oy = RectanglePoint.y;
            RectanglePoint.x = ((ox - axis.x) * cos - (oy - axis.y) * sin + axis.x);//Формула матрицы поворота в двумерном пространстве.
            // Поворот выполняется путём умножения матрицы поворота на вектор-столбец, описывающий вращаемую точку
            RectanglePoint.y = ((ox - axis.x) * sin + (oy - axis.y) * cos + axis.y);
        }
    }
}
