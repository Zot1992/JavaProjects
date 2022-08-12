package Binary_tree.com;

import static org.junit.Assert.*;


public class BinaryTreeTest {

    @org.junit.Test
    public void contains1() {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        assertTrue(bt.contains(6));

    }
    @org.junit.Test
    public void contains2() {
        BinaryTree bt = new BinaryTree();

        bt.add(2);
        assertFalse(bt.contains(1));
    }
}