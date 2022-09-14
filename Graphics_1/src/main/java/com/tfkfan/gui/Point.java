package com.tfkfan.gui;

public class Point {

    private double x = 0;
    private double y = 0;

    public Point() {
    }

    public Point(double X, double Y) {
        this.x = X;
        this.y = Y;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public class ObjMass {//класс на массив обьектов
        Point[]points=new Point[1];
    }
}
