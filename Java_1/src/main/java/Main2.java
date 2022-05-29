import java.io.File;
import java.util.Stack;


public class Main2 {
    public static void main(String[] args) {

        File mainfolder = new File("C:/Users/ROMA/IdeaProjects/JavaProjects/Java_1/Директория");

        int indent=1; // отступ
        Stack <String> st = new Stack<>();

        for (File file : mainfolder.listFiles()) {
            if (file.isDirectory()) {// проверка файла на директорию
                st.push(file.getName()); // если файл является директорией, то он добавляется в стек
            }
        }

        if (!st.empty()) {
            for(int i = 0; i<indent; i++) {
                System.out.print("  ");
            }
            for (int i = 0; i < st.size(); i++){
                System.out.println(st.pop()); // выводит название директории и удаляет ее из стека
                indent++; // увеличивает отступ
            }
        }
    }
}
