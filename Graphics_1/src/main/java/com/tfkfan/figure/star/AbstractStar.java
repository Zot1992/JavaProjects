package com.tfkfan.figure.star;

import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractStar implements Star{
    protected int vertices;
    protected double size;
    protected double begin;
    protected double end;
    protected double speed;
    protected double alfa;
    protected Coordinate[] starPoints;
    protected final Coordinate center;

    public AbstractStar(Coordinate center) {
        this.center = center;
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

