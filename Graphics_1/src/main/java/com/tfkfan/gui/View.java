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

    public void onKeyboardInput(int code){//на входе с клавиатуры

    }

    protected void clearColor(){
        glClearColor(0.8f, 0.5f, 0.1f, 0.0f);
    } //Установить цвет
}
