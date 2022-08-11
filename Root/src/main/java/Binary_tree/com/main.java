package Binary_tree.com;
/*Написать класс, реализующий бинарное дерево целых чисел.
        Необходимые методы:
        void add(int value)
        boolean contains(int value)
        void printAll() */

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner tree=new Scanner(System.in);//для ввода значения

        int val= tree.nextInt();
        int val2= tree.nextInt();
        int val3= tree.nextInt();
        int val4= tree.nextInt();
        BinaryTree bt=new BinaryTree();

        bt.add(val);
        bt.add(val2);
        bt.add(val3);

        bt.contains(val4);

        bt.printAll();

    }

}
