package com.tfkfan.gui;

import static org.lwjgl.opengl.GL11.glClearColor;

public abstract class View {
    public void display(){
        clearColor();
        partialDisplay();
    }

    protected abstract void partialDisplay(); //частичное отображение

    public void onMouseClick(double x, double y){ //по щелчку мыши

    }

    public void onMouseMove(double x, double y){ //при движении мыши

    }

    public void onKeyboardInput(int code){//ОБРАБОТЧИК СОБЫТИЯ ВВОДА С КЛАВИАТУРЫ

    }

    protected void clearColor(){
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    } //Установить цвет
}
