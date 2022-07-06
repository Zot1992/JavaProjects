import java.lang.Math;

public class Vector_work {

    private double x, y, z;

    public Vector_work() {
        setX(0);
        setY(0);
        setZ(0);
    }

    public Vector_work(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public Vector_work(Vector_work v) {
        this.setX(v.getX());
        this.setY(v.getY());
        this.setZ(v.getZ());
    }

    public Vector_work addVector(Vector_work v) {return new Vector_work(getX() + v.getX(), getY() + v.getY(), getZ() + v.getZ());}//сумма векторов
    public Vector_work minusVector(Vector_work v) {return new Vector_work(getX() - v.getX(), getY() - v.getY(), getZ() - v.getZ());}//разность векторов
    public double lengthVector(Vector_work v){return  Math.sqrt((x * v.getX()) + (y * v.getY()) + (z * v.getZ()));}//Длина вектора. Math.sqrt-квадратный корень
    public double scalarProductVector(Vector_work v){return  ((x * v.getX()) + (y * v.getY()) + (z * v.getZ()));}//скалярное произведение
    public Vector_work normalization(Vector_work v) // нормализация вектора
    {
        double locLength = lengthVector(v);
        double inv_length = (1 / locLength);
        x = inv_length;
        y = inv_length;
        z = inv_length;
        return new Vector_work(x * v.getX(), y * v.getY(), z * v.getZ());
    }
    public double getting_an_angle(Vector_work v){return (v.getX()/Math.sqrt(v.getX()*v.getX()+v.getY()*v.getY()+v.getZ()*v.getZ()));}//Получение угла с-осью OX. Cos A.

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}//set изменяет значения поля

    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

    public double getZ() {return z;}
    public void setZ(double z) {this.z = z;}
}

