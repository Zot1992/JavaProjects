package com.tfkfan.figure.star;

import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractStar implements Star{
    protected int vertices;
    protected double size;
    protected double deltaAngle;
    protected Coordinate[] starPoints;
    protected Coordinate center;

    public AbstractStar(double size, int vertices){
        this.starPoints = new Coordinate [vertices];
        this.setVertices(vertices);
        this.setSize(size);
    }
    public AbstractStar(Coordinate [] starPoints,int vertices) {
        this.starPoints = starPoints;
        this.setVertices(vertices);
    }

    @Override
    public void setVertices(int vertices){
        this.vertices=vertices;
        this.deltaAngle=2 * Math.PI / vertices;
    }
    @Override
    public void setSize(double size){this.size=size;}

    @Override
    public Coordinate center() {
        return center;
    }
    @Override
    public Coordinate[] starPoints() {
        return starPoints;
    }

    @Override
    public int vertices(){ return vertices;}
    @Override
    public double size(){return size;}

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

