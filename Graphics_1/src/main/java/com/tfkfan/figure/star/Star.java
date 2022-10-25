package com.tfkfan.figure.star;

import com.tfkfan.figure.Figure;


public interface Star extends Figure { //полностью абстрактный класс который имеет методы без тел
    void setVertices(int vertices);
    void setSize(double size);

    double size();
    int vertices();
}
