package com.tfkfan.figure.star;

import com.tfkfan.figure.Figure;
import com.vividsolutions.jts.geom.Coordinate;

public interface Star extends Figure { //полностью абстрактный класс который имеет методы без тел
    public void setVertices(int vertices);
    public void setSize(double size);
    public void setBegin(double begin);
    public void setEnd(double end);
    public void setSpeed(double speed);
    public void setAlfa(double alfa);

    double size();
    double begin();
    double end();
    double speed();
    double alfa();
    int vertices();

    Coordinate center();
    Coordinate[] starPoints();
}
