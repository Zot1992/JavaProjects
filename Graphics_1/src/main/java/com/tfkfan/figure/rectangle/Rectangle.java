package com.tfkfan.figure.rectangle;

import com.tfkfan.figure.Figure;

public interface Rectangle extends Figure {
    void setVertices(int vertices);
    void setSize(double size);

    double size();
    int vertices();
}
