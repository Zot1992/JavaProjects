package com.schmegmacht;
//Тесты для проверки
import org.junit.Assert;

public class VectorTest {

    @org.junit.Test
    public void addVector() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0);
        Vector result = v1.addVector(v2);
        Assert.assertEquals(2, result.getX(),0.001 );
        Assert.assertEquals(0, result.getY(),0.001 );
    }

    @org.junit.Test
    public void minusVector() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0);
        Vector result = v1.minusVector(v2);
        Assert.assertEquals(0, result.getX(),0.001);
        Assert.assertEquals(0, result.getY(),0.001);
    }

    @org.junit.Test
    public void lengthVector() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        double result = v1.lengthVector();
        Assert.assertEquals(1, result,0.001);
    }

    @org.junit.Test
    public void scalarProductVector() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0);
        double result = v1.multiply(v2);
        Assert.assertEquals(1, result,0.001);
    }

    @org.junit.Test
    public void normalization() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        Vector result = v1.normalize();
        Assert.assertEquals(1, result.getX(),0.001);
        Assert.assertEquals(1, result.getY(),0.001);
    }

    @org.junit.Test
    public void angle0Test() {
        Vector v1 = new Vector(1, 1);//создание вектора и его координат
        Vector v2 = new Vector(1, 1);
        double result = v1.angleTo(v2);
        Assert.assertEquals(0, result,0.001);
    }
    @org.junit.Test
    public void angle45Test() {
        Vector v1 = new Vector(3, 1);//создание вектора и его координат
        Vector v2 = new Vector(50, 100);
        double result = v1.angleTo(v2);
        Assert.assertEquals(45, result,0.001);
    }
    @org.junit.Test
    public void angle90Test() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        Vector v2 = new Vector(0, 1);
        double result = v1.angleTo(v2);
        Assert.assertEquals(90, result,0.001);
    }
}