package com.schmegmacht;//Свой собственный пакет

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
    public double multiply(Vector v) {return ((this.getX() * v.getX()) + (this.getY() * v.getY()));}//скалярное произведение.Единственный способ перемножить вектора
    public Vector normalize() // нормализация вектора
    {
        double locLength = lengthVector();
        double inv_length = (1 / locLength);
        return new Vector(inv_length * this.getX(), inv_length * this.getY());
    }
    public double angleTo(Vector v1) {//Получение угла с-осью OX. Cos A.
        double cos_alpha = this.multiply(v1) / (v1.lengthVector() * this.lengthVector());
        double alpha = Math.acos(cos_alpha);
        return alpha * 180 / Math.PI;
    }

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}//set изменяет значения поля
    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

    @Override
    public String toString(){
        return x+";"+y;
    } //для каждого класса свой toString и работает однотипно для всех объектов в этом классе

}


