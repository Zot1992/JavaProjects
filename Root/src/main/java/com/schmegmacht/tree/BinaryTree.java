package com.schmegmacht.tree;

public class BinaryTree {
    private static class Node {
        /*Для реализации мы будем использовать вспомогательный класс Node
        который будет хранить значения int и сохранять ссылку на каждый дочерний элемент: */

        int value;//значение
        Node left;//левый узел в дереве
        Node right;//правый узел в дереве

        public Node(int value) {
            this.value = value;
        }//конструктор по добавлению нового узла

        @Override
        public String toString() { //метод возвращает значение строки
            return String.valueOf(value);//valueOf(int i) — возвращает строковое представление int аргумента.
        }
    }

    private Node root;  // Начальная ветка дерева и тут же вписывает остальные ветки и потомков;

    public void add(int value) {
        root = addRecursive(root, value);
    } // функция по добавлению нового элемента в дерево

    public boolean contains(int value) { // функция по нахождению элемента
        return containsRecursive(root, value);
    }//функция по поиску значения в дереве

    public void printAll() {
        printRecursive(root);
    } //Вывод значений дерева на экран

    private void printRecursive(Node current) {
        if (current == null) //если узел пустой, то просто выходим
            return;
        System.out.println(current);
        printRecursive(current.left);
        printRecursive(current.right);
    }

    private Node addRecursive(Node current, int value) { //функция по добавлению нового элемента в дерево
        if (current == null)  //когда текущий узел равен null, мы достигли конечного узла, и мы можем вставить новый узел в эту позицию
            return new Node(value);

        if (value < current.value) //если значение нового узла ниже, чем значение текущего узла, мы переходим к левому дочернему узлу
            current.left = addRecursive(current.left, value);
        else if (value > current.value)  //если значение нового узла больше, чем значение текущего узла, мы переходим к правому дочернему узлу
            current.right = addRecursive(current.right, value);

        return current;
    }

    private boolean containsRecursive(Node current, int value) { //функция по поиску значения в дереве
        if (current == null) //если текущего нет
            return false;
        if (value == current.value) //Если элемент который мы ищем есть в дереве, то возвращается true
            return true;
        return value < current.value //если значение которое мы ищем меньше значения текущего
                ? containsRecursive(current.left, value) //if если меньше то обращаемся к левому узлу
                : containsRecursive(current.right, value); //else если больше то к правому
    }
}
