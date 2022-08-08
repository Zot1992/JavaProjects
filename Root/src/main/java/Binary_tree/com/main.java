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
        BinaryTree bt=new BinaryTree();

        bt.add(val);
        bt.contains(val2);

    }

}
