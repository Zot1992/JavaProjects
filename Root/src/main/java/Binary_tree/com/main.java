package Binary_tree.com;
/*Написать класс, реализующий бинарное дерево целых чисел.
        Необходимые методы:
        void add(int value)
        boolean contains(int value)
        void printAll() */

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner tree=new Scanner(System.in);
        int val;

        val= tree.nextInt();

        BinaryTree.add(val);


    }

}
