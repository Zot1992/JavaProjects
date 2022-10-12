package com.tfkfan.figure.circle;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class LinedCircle extends AbstractCircle {
    public LinedCircle(double radius, int partition) {
        super(radius, partition);
    }

    public LinedCircle(Coordinate center, double radius, int partition) {
        super(center, radius, partition);
    }

    @Override
    public void draw() {
        glBegin(GL_LINE_STRIP);// чертит линии с заливкой

        for (int i = -1; i < partition; i++) //цикл обходит каждый полигон
            glVertex2d(Math.cos(deltaAngle * i) * radius + center.x,
                    Math.sin(deltaAngle * i) * radius + center.y);

        glEnd();
    }
}
