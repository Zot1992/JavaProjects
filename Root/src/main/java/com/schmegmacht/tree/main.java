package com.schmegmacht.tree;
/*Написать класс, реализующий бинарное дерево целых чисел.
        Необходимые методы:
        void add(int value)
        boolean contains(int value)
        void printAll() */

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner consoleScan = new Scanner(System.in);//для ввода значения

        int val = consoleScan.nextInt();
        int val2 = consoleScan.nextInt();
        int val3 = consoleScan.nextInt();
        int val4 = consoleScan.nextInt();
        BinaryTree bt = new BinaryTree();

        bt.add(val);
        bt.add(val2);
        bt.add(val3);

        System.out.println(bt.contains(val4));

        bt.printAll();
    }

}
