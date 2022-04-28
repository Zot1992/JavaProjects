import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
public class Main {
    public static void main(String[] args) throws IOException {//IOException - Исключение ввода-вывода {
        Scanner sc = new Scanner(System.in);
        File file = new File("products.txt");//создает текстовый файл в корневой папке или использует существующий
        float count = 0; // считает количество товаров
        float sum = 0;// сумма цен всех товаров
        float average_price = 0;// средняя цена
        ArrayList<Float> product = new ArrayList<>();//записывать преобразованные в int числа
        float pricefloat = 0;// цена в виде int
        System.out.println("Хотите создать файл?");
        if (file.isFile()) {System.out.println("Файл уже создан");}
        else if (sc.next().equals("да")) { //# если введу ДА - не сработает, нужно привести строки к КАПСУ или нижнему регистру, str.toLowerCase()/str.toUpperCase()
            System.out.println("Файл создан");
        }
        else {
            System.out.println("Файл не создан");
            System.exit(0); //прерывает работу программы
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));//если дописываешь true, то дописывает файл, а не перезаписывает
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        System.out.println("Хотите добавить продукт?");
        while (sc2.next().equals("да")) { //цикл будет идти пока мы будем писать нужное слово которое задали
            Scanner sc4 = new Scanner(System.in);
            Product prod = new Product();
            writer.write(" ");
            System.out.print("Введите наименование продукта: ");
            String name;
            name = sc4.nextLine();//Задает данные в строку который мы вводим в консоли
            writer.write(name + " "); //добавляет введеную строку в текстовый файл и делает табуляцию
            System.out.print("Введите цену продукта: ");
            String price;
            price = sc4.nextLine(); //#разберись с nextFloat и подобным. Float val = sc4.nextFloat();
            writer.write(price + " ");
            System.out.print("Введите категорию продукта: ");
            String category;
            category = sc4.nextLine();
            writer.write(category);
            //#в итоге объект prod пустой и не содержит полей
            //также необходимо считать уже имеющиеся данные в существующем файле
            /*if (category.equals(сategory_ap)) { //Если мы вводим нужную категорию, то строка преобразуется в число и добавляется в список
                pricefloat = Float.parseFloat(price);
                product.add(pricefloat);//добавляем преобразованное число в список
                count++;
            } */
            writer.write('\n');
            System.out.println("Хотите добавить продукт?");
        }
        System.out.println("По какой категории хотите узнать среднюю цену?");
        String сategory_ap = sc3.nextLine();
        FileReader fr=new FileReader(file);//считывает файл
        BufferedReader reader=new BufferedReader(fr);
        String line=reader.readLine();
        ArrayList<Product>arrayProduct=new ArrayList<>();
        while (line!=null){
            String[] arr=line.split(" ");
            String Product=arr[0];
            Float Price=Float.parseFloat(arr[1]);
            String Category=arr[2];
            if (Category.equals(сategory_ap)) { //Если мы вводим нужную категорию, то строка преобразуется в число и добавляется в список
                product.add(Price);//добавляем преобразованное число в список
                count++;
            }

        }
        for (int i = 0; i < product.size(); i++) { //цикл для подсчета суммы по выбранной категории
            sum += product.get(i);
        }
        average_price = sum / count;
        String average_price_str = Float.toString(average_price);
        System.out.println("среднее арифметическое цена по заданной категории: " + average_price_str);
        writer.write(average_price_str);
        writer.close();//Закрывает поток ввода данных
    }
}

