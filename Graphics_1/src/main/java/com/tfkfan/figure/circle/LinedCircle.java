package com.tfkfan.figure.circle;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class LinedCircle implements Circle {
    final Coordinate center;
    final double radius;
    int partition;

     double deltaAngle;

    public LinedCircle(Coordinate center, double radius, int partition) {
        this.center = center;
        this.radius = radius;
        this.setPartition(partition);
    }


    @Override
    public void draw() {
        glBegin(GL_LINE_STRIP);// чертит линии с заливкой

        for (int i = -1; i < partition; i++) //цикл обходит каждый полигон, еще делаем второй ряд полигонов +1 чтобы круг был цельным
            glVertex2d(Math.cos(deltaAngle * i) * radius + center.x,
                    Math.sin(deltaAngle * i) * radius + center.y);

        glEnd();

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
