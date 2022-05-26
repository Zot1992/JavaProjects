import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int val;
        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        for (int i = 0; i < size; i++) { // вводим по одному элементу и добавляем в список
            val = sc.nextInt();
            list.add(val);
        }
        for (int i=0;i<list.getSize();i++){System.out.print(list.get(i)+" ");}
        System.out.println();
        list.add(3); // добавляем элемент в конец
        list.remove(2); // удаляем элемент с индексом 2
        for (int i=0;i<list.getSize();i++){System.out.print(list.get(i)+" ");}
    }
}