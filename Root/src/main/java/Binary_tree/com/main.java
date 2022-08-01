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
        int val,val2,val3,val4;

        val= tree.nextInt();
        val2= tree.nextInt();
        val3= tree.nextInt();
        val4= tree.nextInt();
        BinaryTree.Node root= new BinaryTree.Node(val,
                new BinaryTree.Node(val2),
                                             new BinaryTree.Node(val3));  // Начальная ветка дерева и тут же вписывает остальные ветки и потомков

        BinaryTree.add(val4);


    }

}
