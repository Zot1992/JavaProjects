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

    public Vector_work addVector(Vector_work v) { // сумма векторов
        return new Vector_work(getX() + v.getX(), getY() + v.getY(), getZ() + v.getZ());
    }

    public Vector_work minusVector(Vector_work v) {// разность векторов
        return new Vector_work(getX() - v.getX(), getY() - v.getY(), getZ() - v.getZ());
    }

    public double lengthModuleVector(Vector_work v) { // длина (модуль) двух векторов
        return Math.sqrt((y * v.getZ() - z * v.getY()) * (y * v.getZ() - z * v.getY()) + (x * v.getZ() - z * v.getY())
                * (x * v.getZ() - z * v.getY()) + (x * v.getY() - y * v.getX()));
    }

    public double scalarProductVector(Vector_work v){ //скалярное произведение
        return  Math.sqrt((x * v.getX()) + (y * v.getY()) + (z * v.getZ()));
    }


    public double getX() {return x;}
    public void setX(double x) {this.x = x;}//set изменяет значения поля

    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

    public double getZ() {return z;}
    public void setZ(double z) {this.z = z;}
}

