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
    public void move(double dx, double dy,double alfa) {
        center.x += dx;
        center.y += dy;
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
