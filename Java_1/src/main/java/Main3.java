//Написать класс для работы с векторами(геометрия).
//Необходимые методы:
//-сумма с другим вектором
//-разница с другим вектором
//-длина вектора
//-скалярное произведение
//-нормализация
//-получение угла с осью OX

public class Main3 {
    public static void main(String[] args) {
        Vector_work v1 = new Vector_work(1, 2, 3);//создание вектора и его координат
        Vector_work v2 = new Vector_work(1, 2, 3);

        System.out.println("x1 = "+v1.getX()+" y1 = "+ v1.getY()+" z1 = "+ v1.getZ());
        System.out.println("x2 = "+v2.getX()+" y2 = "+ v2.getY()+" z2 = "+ v2.getZ());
        System.out.println(v1.addVector(v2));// сумма векторов
        System.out.println(v1.minusVector(v2));// разность векторов
        System.out.println(v1.lengthVector(v2));// длина вектора
        System.out.println(v1.scalarProductVector(v2));//скалярное произведение
        System.out.println(v1.normalization(v2));// нормализация вектора
        System.out.println(v1.getting_an_angle(v2));//получение угла с осью OX. Cos A.
    }
}
