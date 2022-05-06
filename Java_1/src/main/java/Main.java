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
        float count = 0f; // считает количество товаров
        float sum = 0f;// сумма цен всех товаров которые мы хотим добавить в файл
        float sum2=0f;//сумма цен товаров которые уже были добавлены в файл
        float average_price = 0;// средняя цена
        //ArrayList<Float> product = new ArrayList<>();//записывать преобразованные в int числа
        //float pricefloat = 0f;// цена в виде float
        String str="Да"; //строка которая должна быть введена при создании файла и добавлении нового продукта
        System.out.println("Хотите создать файл?");
        if (file.isFile()) {System.out.println("Файл уже создан");}
        else if (sc.next().equals(str.toLowerCase()) || sc.next().equals(str.toUpperCase())) { //# если введу ДА - не сработает, нужно привести строки к КАПСУ или нижнему регистру, str.toLowerCase()/str.toUpperCase()
            System.out.println("Файл создан");
        }
        else {
            System.out.println("Файл не создан");
            System.exit(0); //прерывает работу программы
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));//если дописываешь true, то дописывает файл, а не перезаписывает
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.println("По какой категории хотите узнать среднюю цену?");
        String сategory_ap = sc3.nextLine();
        Scanner sc4 = new Scanner(System.in);
        System.out.println("Хотите добавить продукт?");
        while (sc2.next().equals(str.toLowerCase()) || sc2.next().equals(str.toUpperCase())) { //цикл будет идти пока мы будем писать нужное слово которое задали
            writer.write(" ");
            System.out.print("Введите наименование продукта: ");
            String name;
            name = sc4.nextLine();//Задает данные в строку который мы вводим в консоли
            writer.write(name + " "); //добавляет введеную строку в текстовый файл и делает табуляцию
            System.out.print("Введите цену продукта: ");
            /*String price;
            price = sc4.nextLine();
            writer.write(price + " "); */
            float val = sc4.nextFloat();
            String price=Float.toString(val);
            writer.write(price + " ");
            System.out.print("Введите категорию продукта: ");
            String category;
            category = sc4.nextLine();
            writer.write(category);
            if (category.equals(сategory_ap)) { //Если мы вводим нужную категорию, то строка преобразуется в число и добавляется в список
                /*pricefloat = Float.parseFloat(price);
                product.add(pricefloat);//добавляем преобразованное число в список */
                sum+=val;
                count++;
            }
            writer.write('\n');
            System.out.println("Хотите добавить продукт?");
        }

        /*System.out.println("По какой категории хотите узнать среднюю цену?");
        String сategory_ap = sc3.nextLine(); */

        FileReader fr=new FileReader(file);//считывает файл
        BufferedReader reader=new BufferedReader(fr);
        String line;
        ArrayList<Product>arrayProduct=new ArrayList<>();
        while ((line=reader.readLine())!=null){ //цикл будет идти пока не кончатся строки
            String[] arr=line.split(" ");
            String Product=arr[0];
            float Price=Float.parseFloat(arr[1]);
            String Category=arr[2];
            Product prod = new Product(Product,Price,Category);
            arrayProduct.add(prod);
            if (Category.equals(сategory_ap)) { //Если мы вводим нужную категорию, то строка преобразуется в число и добавляется в список
                sum2 += Price;
                count++;
            }
        }
        for (Product product2:arrayProduct){

        }
        /*for (int i = 0; i < product.size(); i++) { //цикл для подсчета суммы по выбранной категории
            sum += product.get(i);
        } */
        average_price = (sum+sum2) / count;
        String average_price_str = Float.toString(average_price);
        System.out.println("среднее арифметическое цена по заданной категории: " + average_price_str);
        writer.write(average_price_str);
        writer.close();//Закрывает поток ввода данных
        sc.close();
        sc2.close();
        sc3.close();
        sc4.close();
    }
}

