import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {//IOException - Исключение ввода-вывода {
        Scanner sc = new Scanner(System.in);
        File file = new File("C:/Users/ROMA/IdeaProjects/JavaProjects/products.txt");//создает текстовый файл
        System.out.println("Хотите создать файл?");
        if (sc.next().equals("yes")) {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            System.out.println("Файл создан");
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Хотите добавить продукт?");
            while (sc2.next().equals("yes")){ //цикл будет идти пока мы будем писать нужное слово которое задали
                Scanner sc3 = new Scanner(System.in);
                System.out.print("Введите наименование продукта: ");
                String name = sc3.nextLine();//Задает данные в строку который мы вводим в консоли
                writer.write(name+'\t'); //добавляет введеную строку в текстовый файл и делает табуляцию
                System.out.print("Введите цену продукта: ");
                String price = sc3.nextLine();
                writer.write(price+'\t');
                System.out.print("Введите категорию продукта: ");
                String category = sc3.nextLine();
                writer.write(category);
                writer.write('\n');
                System.out.println("Хотите добавить продукт?");
                sc2.next();//вводим слово и от него зависит выйдем мы из цикла или начнем его сначала
            }
            writer.close();//Закрывает поток ввода данных
        }
        else {
            System.out.println("Файл не создан");
        }

    }
}
