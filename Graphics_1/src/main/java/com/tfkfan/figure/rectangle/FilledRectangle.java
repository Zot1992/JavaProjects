package com.tfkfan.figure.rectangle;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;

public class FilledRectangle extends AbstractRectangle {


    public FilledRectangle(double width,double height) {
        super(width,height);
    }

    public FilledRectangle(Coordinate center, double width,double height) {
        super(center, width,height);
    }

    @Override
    public void draw() {
        glBegin(GL_QUADS);
        glVertex2d(rectanglePoints[0].x, rectanglePoints[0].y);
        glVertex2d(rectanglePoints[1].x, rectanglePoints[1].y);
        glVertex2d(rectanglePoints[2].x, rectanglePoints[2].y);
        glVertex2d(rectanglePoints[3].x, rectanglePoints[3].y);
        glEnd();
    }


}

