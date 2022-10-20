package com.tfkfan.figure;

public interface Figure {
    void draw();//функция для отрисовки
    void move(double dx, double dy);//функция для движения
    void rotate(double alfa); //функция для вращения
}
