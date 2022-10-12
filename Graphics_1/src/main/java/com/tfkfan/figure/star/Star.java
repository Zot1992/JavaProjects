package com.tfkfan.figure.star;

import com.tfkfan.figure.Figure;
import com.vividsolutions.jts.geom.Coordinate;

public interface Star extends Figure { //полностью абстрактный класс который имеет методы без тел
    public void setVertices(int vertices);
    int vertices();
    Coordinate center();
}
