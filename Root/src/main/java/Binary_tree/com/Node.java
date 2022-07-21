package Binary_tree.com;


public class Node {
    public class BinaryTree { // Начальная ветка дерева
        Node node;
    }
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node() {}
    public Node(int value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    void add(int value){}

    boolean contains(int value){}

    void printAll(){}
}
