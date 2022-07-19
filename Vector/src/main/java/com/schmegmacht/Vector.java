package com.schmegmacht;

import java.lang.Math;

public class Vector {

    private double x, y;

    public Vector() {
        setX(0);
        setY(0);
    }

    public Vector(double x, double y) {
        this.setX(x);
        this.setY(y);
    }
    public Vector(Vector v) {
        this.setX(v.getX());
        this.setY(v.getY());
    }

    public Vector addVector(Vector v) {return new Vector(getX() + v.getX(), getY() + v.getY());}//сумма векторов
    public Vector minusVector(Vector v) {return new Vector(getX() - v.getX(), getY() - v.getY());}//разность векторов
    public double lengthVector() {return Math.sqrt((this.getX() * this.getX()) + (this.getY() * this.getY()));}//Длина вектора. Math.sqrt-квадратный корень
    public double multiply(Vector v) {return ((this.getX() * v.getX()) + (this.getY() * v.getY()));}//скалярное произведение
    public Vector normalize() // нормализация вектора
    {
        double locLength = lengthVector();
        double inv_length = (1 / locLength);

        return new Vector(inv_length * x, inv_length * y);
    }
    public double getting_an_angle(Vector v1, Vector v2){
        double cos_alpha=v1.multiply(v2)/(v1.lengthVector()* v2.lengthVector());
        double alpha = Math.acos(cos_alpha);
        double degrees = alpha*180/Math.PI;
        return degrees;
    }//Получение угла с-осью OX. Cos A.

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}//set изменяет значения поля
    public double getY() {return y;}
    public void setY(double y) {this.y = y;}
}


