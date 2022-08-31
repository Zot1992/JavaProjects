package com.tfkfan.gui;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private long window;//Окно
    public int width;//Ширины
    public int height;//высота
    private View view; //Вид


    public Window(int width, int height){
        this.width=width;
        this.height=height;
    }

    public int getWidth(){return width;}
    public int getHeight(){return height;}


    public Window() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit())/*Функция glfwInit () используется для инициализации GLFW. Перед вызовом большинства других функций GLFW вам необходимо
        инициализировать GLFW. В случае успеха glfwInit () вернет GLFW_TRUE, в противном случае вернет GLFW_FALSE
        (GLFW_TRUE и GLFW_FALSE - это константы, определенные GLFW, определенные как 1 и 0).
        Другими словами, если возвращается GLFW_FALSE, это означает, что инициализация не удалась.*/
            throw new IllegalStateException("Unable to initialize GLFW"); // если инициализация не удалась, то вылезает ошибка

        glfwDefaultWindowHints(); // optional, the current window hints are already the default(необязательно, подсказки текущего окна уже установлены по умолчанию)
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation(окно останется скрытым после создания)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable(размер окна будет изменяться)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable(размер окна будет изменяться)
        glfwWindowHint(GLFW_DOUBLEBUFFER, GLFW_TRUE); // context will use double buffer(контекст будет использовать двойной буфер)

        width = 900;//ширина окна
        height = 600;//высота окна
        window = glfwCreateWindow(width, height, "OpenGL", NULL, NULL);//создание окна с ее высотой и шириной и названием
        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");

        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                glfwSetWindowShouldClose(window, true);
            else
                view.onKeyboardInput(key);
        });

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);
            glfwGetWindowSize(window, pWidth, pHeight);
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
    }

    public void shutdown() {//неисправность
        glfwFreeCallbacks(window);//Сбрасывает все обратные вызовы для указанного GLFW окна в NULL и освобождает все ранее установленные обратные вызовы.
        glfwDestroyWindow(window);
        glfwTerminate();

        GLFWErrorCallback errorCallback = glfwSetErrorCallback(null);
        if (errorCallback != null)
            errorCallback.free();
    }

    public void start() {
        GL.createCapabilities();
        view.clearColor();

        while (!glfwWindowShouldClose(window)) {
            DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
            DoubleBuffer y = BufferUtils.createDoubleBuffer(1);

            glfwGetCursorPos(window, x, y);
            view.onMouseMove((2.0f * x.get()) / width - 1.0f, 1.0f - (2.0f * y.get()) / height);

            if (glfwGetMouseButton(window, GLFW_MOUSE_BUTTON_1) == GLFW_PRESS) {
                x = BufferUtils.createDoubleBuffer(1);
                y = BufferUtils.createDoubleBuffer(1);
                view.onMouseClick((2.0f * x.get()) / width - 1.0f, 1.0f - (2.0f * y.get()) / height);
            }

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            view.display();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public void setView(View view) {
        this.view = view;
    }//установить вид
}
