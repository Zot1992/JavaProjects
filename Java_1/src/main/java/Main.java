import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {//IOException - Исключение ввода-вывода {
        Scanner sc = new Scanner(System.in);
        File file = new File("C:/Users/ROMA/IdeaProjects/JavaProjects/products.txt");//создает текстовый файл
        int count=0; // считает колличесво товаров
        int sum=0;// сумма цен всех товаров
        int average_price=0;// средняя цена
        ArrayList<Integer>product=new ArrayList<>();//записывать преобразованные в int числа
        int priceint=0;// цена в виде int
        System.out.println("Хотите создать файл?");
        if (sc.next().equals("да")) {
            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
            System.out.println("Файл создан");
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);
            System.out.println("По какой категории хотите узнать среднюю цену?");
            String сategory_ap = sc3.nextLine();
            System.out.println("Хотите добавить продукт?");
            while (sc2.next().equals("да")){ //цикл будет идти пока мы будем писать нужное слово которое задали
                Scanner sc4 = new Scanner(System.in);
                Product prod=new Product();
                System.out.print("Введите наименование продукта: ");
                String name=prod.getProduct();// переменной присваиваем раздел из объекта
                name = sc4.nextLine();//Задает данные в строку который мы вводим в консоли
                writer.write(name+'\t'); //добавляет введеную строку в текстовый файл и делает табуляцию
                System.out.print("Введите цену продукта: ");
                String price=prod.getPrice();
                price = sc4.nextLine();
                writer.write(price+'\t');
                System.out.print("Введите категорию продукта: ");
                String category=prod.getCategory();
                category = sc4.nextLine();
                writer.write(category);
                if(category.equals(сategory_ap)){ //Если мы вводим нужную категорию, то строка преобразуется в число и добавляется в список
                    priceint = Integer.parseInt(price);//метод parseInt преобразует строку в число
                    product.add(priceint);//добавляем преобразованное число в список
                    count++;
                }
                writer.write('\n');
                System.out.println("Хотите добавить продукт?");
            }
            for (int i=0;i<product.size();i++){ //цикл для подсчета суммы по выбранной категории
                sum+= product.get(i);
            }

            average_price=sum/count;
            System.out.println("среднее арифметическое цена по заданной категории: "+average_price);
            writer.write("среднее арифметическое цена по заданной категории: "+average_price);

            writer.close();//Закрывает поток ввода данных
        }
        else {
            System.out.println("Файл не создан");
        }

    }
}
