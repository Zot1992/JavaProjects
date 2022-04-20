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
            BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
            System.out.println("Файл создан");
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Хотите добавить продукт?");
            while (sc2.next().equals("yes")){
                Scanner sc3 = new Scanner(System.in);
                System.out.print("Введите наименование продукта: ");
                String name = sc3.nextLine();
                System.out.print("Введите цену продукта: ");
                int price = sc3.nextInt();
                System.out.print("Введите категорию продукта:");
                String category = sc3.nextLine();
            }

            writer.close();
        }
        else {
            System.out.println("Файл не создан");
        }

    }
}
