import java.io.File;
import java.util.Stack;
import java.lang.String;

public class Main2 {
    public static String DFS(File root) {
        int indent = 1; // отступ
        Stack<File> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            for (int i = 0; i < indent; i++) {
                System.out.print(" ");
            }
            File current = stack.pop(); //Выкидывает из стека название директории чтобы она была первой при выводе
            System.out.println(current);
            indent++;

            for (File file : current.listFiles()) {
                if (file.isDirectory()) {// проверка файла на директорию
                    stack.push(file); // если файл является директорией, то он добавляется в стек
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        File mainfolder = new File("C://Users//ROMA//IdeaProjects//JavaProjects//Java_1//Директория");

        String Print=DFS(mainfolder);
        System.out.println(Print);
    }
}
