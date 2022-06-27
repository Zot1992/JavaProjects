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

    public Vector_work addVector(Vector_work v) { // сумма векторов
        return new Vector_work(getX() + v.getX(), getY() + v.getY(), getZ() + v.getZ());
    }

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}//set изменяет значения поля

    public double getY() {return y;}
    public void setY(double x) {this.y = y;}

    public double getZ() {return z;}
    public void setZ(double x) {this.z = z;}
}

