package com.tfkfan.figure.rectangle;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class LinedRectangle extends AbstractRectangle{

    public LinedRectangle (double width,double height) {
        super(width,height);
    }

    public LinedRectangle (Coordinate center, double width,double height) {
        super(center, width,height);
    }


    @Override
    public void draw() {
        glBegin(GL_LINE_STRIP);//Рисуется ломаная, причем ее последняя точка соединяется с первой.
        glVertex2d(rectanglePoints[0].x, rectanglePoints[0].y);
        glVertex2d(rectanglePoints[1].x, rectanglePoints[1].y);
        glVertex2d(rectanglePoints[2].x, rectanglePoints[2].y);
        glVertex2d(rectanglePoints[3].x, rectanglePoints[3].y);
        glVertex2d(rectanglePoints[0].x, rectanglePoints[0].y);
        glEnd();
    }
}
