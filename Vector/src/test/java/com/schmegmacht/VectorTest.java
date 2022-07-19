package com.schmegmacht;

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
        Vector v2 = new Vector(1, 0);
        double result = v1.lengthVector();
        Assert.assertEquals(1, result,0.001);
    }

    @org.junit.Test
    public void scalarProductVector() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0);
        double result = v1.scalarProductVector(v2);
        Assert.assertEquals(1, result,0.001);
    }

    @org.junit.Test
    public void normalization() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        Vector v2 = new Vector(1, 0);
        Vector result = v1.normalization();
        Assert.assertEquals(1, result.getX(),0.001);
        Assert.assertEquals(1, result.getY(),0.001);
    }

    @org.junit.Test
    public void getting_an_angle0() {
        Vector v1 = new Vector(1, 1);//создание вектора и его координат
        Vector v2 = new Vector(1, 1);
        Vector v3 = new Vector();
        double result = v3.getting_an_angle(v1,v2);
        Assert.assertEquals(0, result,0.001);
    }
    @org.junit.Test
    public void getting_an_angle45() {
        Vector v1 = new Vector(3, 1);//создание вектора и его координат
        Vector v2 = new Vector(50, 100);
        Vector v3 = new Vector();
        double result = v3.getting_an_angle(v1,v2);
        Assert.assertEquals(45, result,0.001);
    }
    @org.junit.Test
    public void getting_an_angle90() {
        Vector v1 = new Vector(1, 0);//создание вектора и его координат
        Vector v2 = new Vector(0, 1);
        Vector v3 = new Vector();
        double result = v3.getting_an_angle(v1,v2);
        Assert.assertEquals(90, result,0.001);
    }
}