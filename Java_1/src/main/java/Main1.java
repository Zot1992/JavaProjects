/**
 * @author Baltser Artem com.tfkfan
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main1 {
    public final static String yes = "Да";
    public final static String separator = "\t";

    public static void main(String[] args) throws IOException {//IOException - Исключение ввода-вывода {
        try (Scanner sc = new Scanner(System.in)) {
            File file = new File("products.txt");//создает текстовый файл в корневой папке или использует существующий

            System.out.println("Хотите создать файл?");
            if (file.exists()) {
                System.out.println("Файл уже создан");
            } else if (sc.next().equalsIgnoreCase(yes.toLowerCase())) { //# если введу ДА - не сработает, нужно привести строки к КАПСУ или нижнему регистру, str.toLowerCase()/str.toUpperCase()
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл не создан");
                System.exit(0); //прерывает работу программы
            }

            writing(sc, file);

            System.out.println("По какой категории хотите узнать среднюю цену?");
            sc.nextLine();
            calculation(file, sc.nextLine());
        }
    }

    private static void writing(Scanner sc, File file) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {//если дописываешь true, то дописывает файл, а не перезаписывает
            boolean res = isAdd(sc);
            while (res) { //цикл будет идти пока мы будем писать нужное слово которое задали

                System.out.println("Введите наименование продукта: ");
                sc.nextLine();//После println и перед =sc.nextLine() нужно счесть символ новой строки, чтобы второй вызов nextLine был корректным
                String name = sc.nextLine();//Задает данные в строку который мы вводим в консоли
                fileWriter.write(name + separator); //добавляет введеную строку в текстовый файл и делает табуляцию

                System.out.println("Введите цену продукта: ");
                Float price = sc.nextFloat();
                fileWriter.write(price + separator);

                System.out.println("Введите категорию продукта: ");
                sc.nextLine();
                String category = sc.nextLine();
                fileWriter.write(category);

                fileWriter.write('\n');
                res = isAdd(sc);
            }
        }
    }

    private static void calculation(File file, String categoryParam) throws IOException {
        float count = 0f; // считает количество товаров
        float sum = 0f;// сумма цен всех товаров которые мы хотим добавить в файл
        float average_price = 0f;// средняя цена

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { /*try(...=new ...()) {} это для AutoCloseable классов, то есть для потоков,
             файлов и прочее, что нужно закрыть, закроется автоматом в конце инструкции {}*/
            String line;

            while ((line = reader.readLine()) != null) { //цикл будет идти пока не кончатся строки
                String[] arr = line.split(separator);
                String price = arr[1];
                float val2 = Float.parseFloat(price);
                String category = arr[2];
                if (category.equals(categoryParam)) { //Если мы вводим нужную категорию, то строка преобразуется в число и добавляется в список
                    sum += val2;
                    count++;
                }
            }
            average_price = sum / count;
            String average_price_str = Float.toString(average_price);
            System.out.println("среднее арифметическое цена по заданной категории: " + average_price_str);
        }
    }

    private static boolean isAdd(Scanner sc) { //создаем свой метод
        System.out.println("Хотите добавить товар?");
        return sc.next().equalsIgnoreCase(yes); //пока будем вводить нужное слово, то будет снова и снова заходить в этот метод
    }
}


