import java.io.File;
import java.util.Stack;
import java.lang.String;

public class Main2 {
    public static void printDirTree(File root) {

        Stack<Directory> stack = new Stack<>();
        Directory dir_root = new Directory(root, 0);
        stack.push(dir_root);

        while (!stack.empty()) {
            Directory current = stack.pop(); //Выкидывает из стека название директории чтобы она была первой при выводе
            for (int i=0;i<current.getLevel();i++) {
                System.out.print("-");
            }
            System.out.println(current.getFile());

            for (File file : current.getFile().listFiles()) {

                Directory lev = new Directory(file, current.getLevel());
                stack.push(lev); // если файл является директорией, то он добавляется в стек
            }
        }
    }

    public static void main(String[] args) {
        File mainfolder = new File("C://Users//ROMA//IdeaProjects//JavaProjects//Java_1//Директория");

        printDirTree(mainfolder);
    }
}
