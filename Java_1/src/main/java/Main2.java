import java.io.File;//Написать программу, которая с помощью стека печатает 1 ветку дерева директорий(из директории запуска программы)
import java.util.Objects;
import java.util.Stack;
import java.lang.String;

public class Main2 {
    public static void printDirTree(File root) {
        Stack<Directory> stack = new Stack<>();
        Directory dir_root = new Directory(root, 1);
        stack.push(dir_root);// добавляем корневую папку в стек

        while (!stack.empty()) { // если стек не пустой, то мы заходим в данный цикл
            final Directory current = stack.pop(); //Выкидывает из стека название директории чтобы она была первой при выводе
            final File file = current.getFile();
            final File[] directories = file.listFiles(File::isDirectory);

            for (int i = 0; i < current.getLevel(); i++) //берем уровень директории и по ним через цикл делаем отступы
                System.out.print("\t");

            System.out.println(file);

            if (!Objects.isNull(directories))//проверка нужна если в директории нет вложенных директорий listFiles вернет в таком случае null
                for (File dir : directories) //обходим все директории и добавляем их в стек вместе с их уровнем
                    stack.push(new Directory(dir, current.getLevel() + 1)); // если файл является директорией, то он добавляется в стек и добавляем 1 уровень
        }
    }

    public static void main(String[] args) {
        File mainfolder = new File("C://Users//ROMA//IdeaProjects//JavaProjects//Java_1//Директория");

        printDirTree(mainfolder);
    }
}
