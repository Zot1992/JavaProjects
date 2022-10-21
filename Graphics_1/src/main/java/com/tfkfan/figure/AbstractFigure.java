package com.tfkfan.figure;

import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractFigure implements Figure{
    protected final Coordinate center;

    protected AbstractFigure(){
        center = new Coordinate();
    }
    protected AbstractFigure(Coordinate center) {
        this.center = center;
    }

    @Override
    public Coordinate center() {
        return center;
    }

    @Override
    public void move(double dx, double dy) {
        center.x += dx;
        center.y += dy;
    }

    @Override
    public void rotate(double alfa) {
        rotate(center, alfa);
    }
}
