import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {//IOException - Исключение ввода-вывода {
        Scanner sc = new Scanner(System.in);
        File file = new File("products.txt");//создает текстовый файл в корневой папке
        int count = 0; // считает количество товаров
        int sum = 0;// сумма цен всех товаров
        int average_price = 0;// средняя цена
        ArrayList<Integer> product = new ArrayList<>();//записывать преобразованные в int числа
        int priceint = 0;// цена в виде int
        System.out.println("Хотите создать файл?");
        if (file.isFile()) {System.out.println("Файл уже создан");}
        else if (sc.next().equals("да")) { //# если введу ДА - не сработает, нужно привести строки к КАПСУ или нижнему регистру, str.toLowerCase()/str.toUpperCase()
            System.out.println("Файл создан");
        }
        else {
            System.out.println("Файл не создан");
            System.exit(0); //прерывает работу программы
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.println("По какой категории хотите узнать среднюю цену?");//# ввод категории должен быть сразу после окончания записи в файл
        // или отказа от нее(при наличии существующего файла)
        String сategory_ap = sc3.nextLine();
        System.out.println("Хотите добавить продукт?");
        while (sc2.next().equals("да")) { //цикл будет идти пока мы будем писать нужное слово которое задали
            Scanner sc4 = new Scanner(System.in);
            Product prod = new Product();
            System.out.print("Введите наименование продукта: ");
            String name;
            name = sc4.nextLine();//Задает данные в строку который мы вводим в консоли
            writer.write(name + '\t'); //добавляет введеную строку в текстовый файл и делает табуляцию
            System.out.print("Введите цену продукта: ");
            String price;
            price = sc4.nextLine(); //#разберись с nextFloat и подобным. Float val = sc4.nextFloat();
            writer.write(price + '\t');
            System.out.print("Введите категорию продукта: ");
            String category ;
            category = sc4.nextLine();
            writer.write(category);
            //#в итоге объект prod пустой и не содержит полей
            //также необходимо считать уже имеющиеся данные в существующем файле
            if (category.equals(сategory_ap)) { //Если мы вводим нужную категорию, то строка преобразуется в число и добавляется в список
                priceint = Integer.parseInt(price);//метод parseInt преобразует строку в число #парсить нужно в float
                product.add(priceint);//добавляем преобразованное число в список
                count++;
            }
            writer.write('\n');
            System.out.println("Хотите добавить продукт?");
        }
        for (int i = 0; i < product.size(); i++) { //цикл для подсчета суммы по выбранной категории
            sum += product.get(i);
        }
        average_price = sum / count;
        System.out.println("среднее арифметическое цена по заданной категории: " + average_price);
        writer.write(average_price);
        writer.close();//Закрывает поток ввода данных
    }
}

