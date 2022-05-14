package com.tfkfan.gui;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.math.Vector2D;

import java.util.Arrays;

import static org.lwjgl.opengl.GL11.*;


public class MainView extends View {
    private final GeometryFactory factory = new GeometryFactory();

    private Polygon first;
    private Coordinate viewPoint;
    private Coordinate playerPoint;
    private Coordinate mousePoint = new Coordinate();
    private double len = 0.4d;
    private double rentgenR = 0.1d;
    private double dx = 0.01d;
    private double dy = 0.01d;
    private double R = len;
    private double phi0 = Math.toRadians(40);
    private int N = 20;

    private int W = 87;
    private int A = 65;
    private int D = 68;
    private int S = 83;

    public MainView() {
        first = factory.createPolygon(new Coordinate[]{
                new Coordinate(-0.5, -0.5),
                new Coordinate(-0.5, 0.0),
                new Coordinate(0.0, 0.0),
                new Coordinate(0.0, -0.5),
                new Coordinate(-0.5, -0.5)
        });
        viewPoint = new Coordinate(0.5, 0.5);
        playerPoint = new Coordinate(-0.6, -0.3);
    }

    @Override
    public void onMouseMove(double x, double y) {
        mousePoint.x = x;
        mousePoint.y = y;
    }

    @Override
    public void onMouseClick(double x, double y) {
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
        glColor3f(1.0f, 0.0f, 0.0f);
        glBegin(GL_POLYGON);
        Arrays.stream(first.getCoordinates()).forEach(coordinate -> {
            glVertex2d(coordinate.x, coordinate.y);
        });
        glEnd();

        glColor3f(0.2f, 0.2f, 0.2f);
        glPointSize(10);
        glBegin(GL_POINTS);
        glVertex2d(viewPoint.x, viewPoint.y);
        glEnd();

        glColor3f(0.0f, 1.0f, 0.0f);
        glPointSize(10);
        glBegin(GL_POINTS);
        glVertex2d(playerPoint.x, playerPoint.y);
        glEnd();
    }
}
