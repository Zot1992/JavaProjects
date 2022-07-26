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

    static Node root= new Node(20,
    new Node(19),
                       new Node(25)); // Начальная ветка дерева и тут же вписывает остальные ветки и потомков

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
    static void add(int value) {
        root = addRecursive(root, value);
    } // функция по добавлению нового элемента в дерево

    boolean contains(int value) {

    }

    void printAll() {

    }


}
