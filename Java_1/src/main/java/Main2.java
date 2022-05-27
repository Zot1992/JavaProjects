import java.io.File;
import java.nio.file.Files;
import java.util.Stack;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main2 {
    public static void main(String[] args) {

        Path path = Paths.get("C:/Users/ROMA/IdeaProjects/JavaProjects/Java_1/Директория");

        Stack st = new Stack();

        if (Files.exists(path)) {// действия, если папка существует
            File dir1 = new File("Директория1");
            File dir1_1 = new File(dir1+"Директория1.1");
            File dir1_2 = new File(dir1+"Директория1.2");
            File dir2 = new File("Директория2");
            File dir2_1 = new File(dir2+"Директория2.1");
            File dir2_2 = new File(dir2+"Директория2.2");
            File dir3 = new File("Директория3");
            File dir3_1 = new File(dir3+"Директория3.1");
            File dir3_1_1 = new File(dir3_1+"Директория3.1.1");
            File dir4 = new File("Директория4");
            File dir4_1 = new File(dir4+"Директория4.1");
            File dir4_2 = new File(dir4+"Директория4.2");
            st.push(dir1);
            st.push(dir1_1);
            st.push(dir1_2 );
            st.push(dir2);
            st.push(dir2_1);
            st.push(dir2_2);
            st.push(dir3);
            st.push(dir3_1);
            st.push(dir3_1_1);
            st.push(dir4);
            st.push(dir4_1);
            st.push(dir4_2);
        }

        if (!st.empty()) {
            while (st != null) {
                System.out.println(st.peek());  // вызывает элемент и удаляет его из стека
                st.pop();
            }
        }
    }
}
