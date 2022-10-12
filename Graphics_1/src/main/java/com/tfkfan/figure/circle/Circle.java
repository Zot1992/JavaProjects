package com.tfkfan.figure.circle;

import com.tfkfan.figure.Figure;
import com.vividsolutions.jts.geom.Coordinate;

public interface Circle extends Figure {
    void setPartition(int partition);
    int partition();

    Coordinate center();

    void setRadius(double radius);
}
