package com.schmegmacht;//Написать класс для работы с векторами(геометрия).
//Необходимые методы:
//-сумма с другим вектором
//-разница с другим вектором
//-длина вектора
//-скалярное произведение
//-нормализация
//-получение угла с осью OX

public class main {


    public static void main(String[] args) {
        Vector v1 = new Vector(1, 2);//создание вектора и его координат
        Vector v2 = new Vector(10, 5);
        Vector v3;

        System.out.println("x1 = " + v1.getX() + " y1 = " + v1.getY());
        System.out.println("x2 = " + v2.getX() + " y2 = " + v2.getY());
        System.out.println(v1.addVector(v2));// сумма векторов
        System.out.println(v1.minusVector(v2));// разность векторов
        System.out.println(v1.lengthVector());// длина вектора
        System.out.println(v1.multiply(v2));//скалярное произведение
        v3=v1.normalize();
        System.out.println(v3);// нормализация вектора

    }
}

