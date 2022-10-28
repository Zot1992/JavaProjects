package com.tfkfan.figure.rectangle;

import com.tfkfan.figure.Figure;

public interface Rectangle extends Figure {
    void setWidth(double width);
    void setLength(double length);

    double width();
    double length();
}
