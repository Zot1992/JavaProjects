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
        int val2;
        val= tree.nextInt();
        val2= tree.nextInt();
        BinaryTree.Node root= new BinaryTree.Node(20,
                new BinaryTree.Node(19),
                                             new BinaryTree.Node(25));  // Начальная ветка дерева и тут же вписывает остальные ветки и потомков

        BinaryTree.add(val);
        BinaryTree.add(val2);

    }

}
