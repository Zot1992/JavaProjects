package com.tfkfan.gui;

public class Arr_points {
    private int pol;
    private double [] arrX;
    private double [] arrY;

    public Arr_points(double [] arrX,double [] arrY,int pol){
        this.arrX=arrX;
        this.arrY=arrY;
        this.pol=pol;
    }

    public double[] getArrX() {
        return arrX;
    }

    public double[] getArrY() {
        return arrY;
    }

    public int getPol() {
        return pol;
    }
}
