package com.tfkfan.figure.star;

import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractStar implements Star{
    protected int vertices;
    protected double size;
    protected double begin;
    protected double end;
    protected double speed;
    protected double alfa;
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

    public AbstractStar(){
        this.center=new Coordinate();
    }

    public AbstractStar(Coordinate center,double alfa){
        this.center=center;
        this.setAlfa(alfa);
    }


    @Override
    public void setVertices(int vertices){
        this.vertices=vertices;
        this.deltaAngle=2 * Math.PI / vertices;
    }
    @Override
    public void setSize(double size){this.size=size;}
    @Override
    public void setBegin(double begin){this.begin=begin;}
    @Override
    public void setEnd(double end){this.end=end;}
    @Override
    public void setSpeed(double speed){this.speed=speed;}
    @Override
    public void setAlfa(double alfa){this.alfa=alfa;}
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
    public double begin(){return begin;}
    @Override
    public double size(){return size;}
    @Override
    public double end(){return end;}
    @Override
    public double speed(){return speed;}
    @Override
    public double alfa(){return alfa;}


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

