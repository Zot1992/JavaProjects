import java.io.File;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args){

        File file1=new File("a.txt");
        File file2=new File("b.txt");
        File file3=new File("c.txt");
        File file4=new File("d.txt");
        Stack st=new Stack();

        st.push(file1);
        st.push(file2);
        st.push(file3);
        st.push(file4);

        if (!st.empty()) {
            while (st != null) {
                System.out.println(st.peek()); // вызывает элемент, но оставляет его в стеке
            }
            while (st != null) {
                st.pop();  // вызывает элемент и удаляет его из стека
            }
        }
    }
}
