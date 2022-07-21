package com.schmegmacht;//Свой собственный пакет
//Написать класс для работы с векторами(геометрия).
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
        System.out.println("Сумма векторов");
        System.out.println(v1.addVector(v2));// сумма векторов
        v3=v1.addVector(v2);
        System.out.println(v3.getX());
        System.out.println(v3.getY());
        System.out.println("разность векторов");
        System.out.println(v1.minusVector(v2));// разность векторов
        v3=v1.minusVector(v2);
        System.out.println(v3.getX());
        System.out.println(v3.getY());
        System.out.println(v1.lengthVector());// длина вектора
        System.out.println("скалярное произведение");
        System.out.println(v1.multiply(v2));//скалярное произведение
        System.out.println("нормализация вектора");
        v3=v1.normalize();
        System.out.println(v3);// нормализация вектора
        System.out.println(v3.getX());
        System.out.println(v3.getY());
        System.out.println("получение угла с осью OX. Cos A.");
        System.out.println(v1.angleTo(v2));//получение угла с осью OX. Cos A.
    }
}

