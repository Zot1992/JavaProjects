package com.tfkfan.gui;

public class Arr_points {
    public int pol;
    public double [] arrX=new double[pol];
    public double [] arrY=new double[pol];

    public Arr_points(){}

    public Arr_points(double [] arrX,double [] arrY,int pol){
        this.arrX=arrX;
        this.arrY=arrY;
        this.pol=pol;
    }

    /*public double[] getArrX() {
        return arrX;
    }

    public double[] getArrY() {
        return arrY;
    }

    public int getPol() {
        return pol;
    }*/


}
