import java.io.File;
import java.io.FileFilter;
import java.util.Objects;
import java.util.Stack;
import java.lang.String;

public class Main2 {
    public static void printDirTree(File root) {
        Stack<Directory> stack = new Stack<>();
        Directory dir_root = new Directory(root, 1);
        stack.push(dir_root);

        while (!stack.empty()) {
            final Directory current = stack.pop(); //Выкидывает из стека название директории чтобы она была первой при выводе
            final File file = current.getFile();
            final File[] directories = file.listFiles(File::isDirectory);

            for (int i = 0; i < current.getLevel(); i++)
                System.out.print("\t");

            System.out.println(file);

            if (!Objects.isNull(directories))
                for (File dir : directories)
                    stack.push(new Directory(dir, current.getLevel() + 1)); // если файл является директорией, то он добавляется в стек
        }
    }

    public static void main(String[] args) {
        File mainfolder = new File("C://Users//ROMA//IdeaProjects//JavaProjects//Java_1//Директория");

        printDirTree(mainfolder);
    }
}
