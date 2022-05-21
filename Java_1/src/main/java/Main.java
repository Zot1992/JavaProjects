import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int val;
        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            val = sc.nextInt();
            list.add(val);
        }
        list.add(3);
        list.remove(2);

        for (int i=0;i<list.getSize();i++){System.out.println(list[i]);}

    }
}