import java.io.File;
import java.util.Stack;
import java.lang.String;

public class Main2 {
    public static void printDirTree(File root,int level) {

        Stack<File> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            if (level==0) {System.out.print("-");}
            else if (level==1) {System.out.print("---");}
            else if (level==2) {System.out.print("-----");}
            else if (level==3) {System.out.print("-------");}
            File current = stack.pop(); //Выкидывает из стека название директории чтобы она была первой при выводе
            System.out.println(current);


            for (File file : current.listFiles()) {
                if (file.isDirectory()) {// проверка файла на директорию
                    stack.push(file); // если файл является директорией, то он добавляется в стек
                }
            }
        }
    }

    public static void main(String[] args) {
        int level = 0;
        File mainfolder = new File("C://Users//ROMA//IdeaProjects//JavaProjects//Java_1//Директория");
        //File dir_level1=new File("C://Users//ROMA//IdeaProjects//JavaProjects//Java_1//Директория//директория 1");

        printDirTree(mainfolder,level);


    }
}
