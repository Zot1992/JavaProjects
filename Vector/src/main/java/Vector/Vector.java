package Vector;

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
    public double lengthVector() {return Math.sqrt((x * x) + (y * y));}//Длина вектора. Math.sqrt-квадратный корень
    public double scalarProductVector(Vector v) {return ((x * v.getX()) + (y * v.getY()));}//скалярное произведение
    public Vector normalization(Vector v) // нормализация вектора
    {
        double locLength = lengthVector();
        double inv_length = (1 / locLength);
        x = inv_length;
        y = inv_length;
        return new Vector(x * v.getX(), y * v.getY());
    }
    public double getting_an_angle(Vector v){return (v.getX() / Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY()));}//Получение угла с-осью OX. Cos A.

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}//set изменяет значения поля
    public double getY() {return y;}
    public void setY(double y) {this.y = y;}
}


