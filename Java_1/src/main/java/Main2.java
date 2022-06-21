import java.io.File;
import java.util.Stack;
import java.lang.String;

public class Main2 {
    public static void printDirTree(File root) {

        int level=0;
        Stack<Directory> stack = new Stack<>();
        Directory dir_root=new Directory(root,level);
        stack.push(dir_root);

        while (!stack.empty()) {
            if (level==0) {System.out.print("-");}
            else if (level==1) {System.out.print("---");}
            else if (level==2) {System.out.print("-----");}
            else if (level==3) {System.out.print("-------");}
            File current = stack.pop(); //Выкидывает из стека название директории чтобы она была первой при выводе
            System.out.println(current);

            for (File file : current.listFiles()){
                if(file.exists()){level++;}//Проверяем на наличие директории в директории. Если есть, то увеличиваем уровень и присваиваем текущей директории
                else if(!file.exists()){level--;}//если директория пуста, то уменьшаем уровень
                Directory lev=new Directory(file,level);
                stack.push(lev); // если файл является директорией, то он добавляется в стек
            }
        }
    }

    public static void main(String[] args) {
        File mainfolder = new File("C://Users//ROMA//IdeaProjects//JavaProjects//Java_1//Директория");

        printDirTree(mainfolder);
    }
}
