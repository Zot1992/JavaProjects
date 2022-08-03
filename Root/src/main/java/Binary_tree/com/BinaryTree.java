package Binary_tree.com;


public class BinaryTree {

    static class Node {  /*Для реализации мы будем использовать вспомогательный класс Node
        который будет хранить значения int и сохранять ссылку на каждый дочерний элемент: */

        private int value;
        private Node left;
        private Node right;

        public Node() {}

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) { // Конструктор для листа. Лист это узел который не имеет потомков.
            this.value = value;
        }
    }

     Node root;  // Начальная ветка дерева и тут же вписывает остальные ветки и потомков;

    private static Node addRecursive(Node current, int value) {
        if (current == null) { //когда текущий узел равен null, мы достигли конечного узла, и мы можем вставить новый узел в эту позицию
            return new Node(value);
        }

        if (value < current.value) { //если значение нового узла ниже, чем значение текущего узла, мы переходим к левому дочернему узлу
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) { //если значение нового узла больше, чем значение текущего узла, мы переходим к правому дочернему узлу
            current.right = addRecursive(current.right, value);
        } else { // если значение уже существует
            return current;
        }

        return current;
    }
     void add(int value) {
        root = addRecursive(root, value);
    } // функция по добавлению нового элемента в дерево

    private BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(7);

        return bt;
    }

    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) { //Если элемент который мы ищем есть в дереве, то возвращается true
            return true;
        }
        return value < current.value
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    boolean contains(int value) { // функция по нахождению элемента
        return containsRecursive(root, value);
    }

    void printAll() {

    }


}
