package com.tfkfan.figure.circle;

import com.tfkfan.figure.Figure;
import com.vividsolutions.jts.geom.Coordinate;

public interface Circle extends Figure { //интерфейс
    void setPartition(int partition);
    int partition();
    void setRadius(double radius);
}
