package com.tfkfan.gui;

import com.vividsolutions.jts.geom.Coordinate;

import static org.lwjgl.opengl.GL11.*;

public class MainView extends View {
    private Coordinate viewPoint;
    private double dx = 0.01d;
    private double dy = 0.01d;

    private int W = 87;
    private int A = 65;
    private int D = 68;
    private int S = 83;

    public MainView() {
        viewPoint = new Coordinate(0.5, 0.5);
    }

    @Override
    public void onKeyboardInput(int code) {
        if (code == W)
            viewPoint.y += dy;
        else if (code == S)
            viewPoint.y -= dy;
        else if (code == A)
            viewPoint.x -= dx;
        else if (code == D)
            viewPoint.x += dx;
    }

    @Override
    protected void clearColor() {
        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
    }

    @Override
    protected void partialDisplay() {
        glColor3f(0.0f, 1.0f, 0.0f);
        glBegin(GL_POLYGON);
        glVertex2d(-0.5, -0.5);
        glVertex2d(-0.5, 0.0);
        glVertex2d(0.0, 0.0);
        glEnd();

        glColor3f(0.2f, 0.2f, 0.2f);
        glPointSize(10);
        glBegin(GL_POINTS);
        glVertex2d(viewPoint.x, viewPoint.y);
        glEnd();
    }
}
