//Написать класс для работы с векторами(геометрия).
//Необходимые методы:
//-сумма с другим вектором
//-разница с другим вектором
//-длина вектора
//-скалярное произведение
//-нормализация
//-получение угла с осью OX


import java.lang.Math;

public class Main3 {
    public static void main(String[] args) {
        Vector_work v1 = new Vector_work(1, 2, 3);
        Vector_work v2 = new Vector_work(1, 2, 3);

        System.out.println(v1.addVector(v2));
    }
}
