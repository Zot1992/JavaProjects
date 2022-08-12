package Binary_tree.com;


public class BinaryTree {

    static class Node {  /*Для реализации мы будем использовать вспомогательный класс Node
        который будет хранить значения int и сохранять ссылку на каждый дочерний элемент: */

        int value;//значение
        Node left;//левый узел в дереве
        Node right;//правый узел в дереве
        Node root;// Начальная ветка дерева и тут же вписывает остальные ветки и потомков;

        public Node() {}//стандартный конструктор

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) { // Конструктор для листа. Лист это узел который не имеет потомков.
            this.value = value;
        }//конструктор по добавлению нового узла

        void printAll(){ //Вывод значений дерева на экран
            if(root == null) { //если начальная ветка пустая, то выходим
                return;
            }
            if (left != null) { //пока не будет левая ветка пустая мы будем запускать рекурсию
                left.printAll();
            }
            if (right != null) {//пока не будет правая ветка пустая мы будем запускать рекурсию
                right.printAll();
            }
        }
    }

    Node root;  // Начальная ветка дерева и тут же вписывает остальные ветки и потомков;


    private Node addRecursive(Node current, int value) { //функция по добавлению нового элемента в дерево
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


    private boolean containsRecursive(Node current, int value) { //функция по поиску значения в дереве
        if (current == null) { //если текущего нет
            return false;
        }
        if (value == current.value) { //Если элемент который мы ищем есть в дереве, то возвращается true
            return true;
        }
        return value < current.value //если значение которое мы ищем меньше значения текущего
                ? containsRecursive(current.left, value) //if если меньше то обращаемся к левому узлу
                : containsRecursive(current.right, value); //else если больше то к правому
    }

    boolean contains(int value) { // функция по нахождению элемента
        return containsRecursive(root, value);
    }


    void printAll(){
        root.printAll();
    } //Вывод значений дерева на экран

}
