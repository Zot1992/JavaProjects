import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) throws IOException {//IOException - Исключение ввода-вывода {
        Scanner sc = new Scanner(System.in);
        File file = new File("C:/Users/ROMA/IdeaProjects/Project16/products.txt");//создает текстовый файл
        System.out.println("Хотите создать файл?");
        if (sc.next().equals("yes")) {
            file.createNewFile();
            System.out.println("Файл создан");
        }
        else {
            System.out.println("Файл не создан");
        }
    }
}
