package com.tfkfan.figure.star;

import com.tfkfan.figure.Figure;
import com.vividsolutions.jts.geom.Coordinate;

public interface Star extends Figure { //полностью абстрактный класс который имеет методы без тел
    void setVertices(int vertices);
    void setSize(double size);

    double size();
    int vertices();

    Coordinate center();
    Coordinate[] starPoints();
}
