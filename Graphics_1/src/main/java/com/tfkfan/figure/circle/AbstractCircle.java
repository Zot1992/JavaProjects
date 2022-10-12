package com.tfkfan.figure.circle;

import com.vividsolutions.jts.geom.Coordinate;

public abstract class AbstractCircle implements Circle {
    protected final Coordinate center;
    protected final double radius;
    protected int partition;

    protected double deltaAngle;

    public AbstractCircle(Coordinate center, double radius, int partition) {
        this.center = center;
        this.radius = radius;
        this.setPartition(partition);
    }

    @Override
    public void move(double dx, double dy) {
        center.x += dx;
        center.y += dy;
    }

    @Override
    public void setPartition(int partition) {
        this.partition = partition;
        this.deltaAngle = 2 * Math.PI / partition;
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
