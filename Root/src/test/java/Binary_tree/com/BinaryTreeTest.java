package Binary_tree.com;

import static org.junit.Assert.*;


public class BinaryTreeTest {

    @org.junit.Test
    public void contains() {
        BinaryTree bt = new BinaryTree();

        assertTrue(bt.contains(6));
        assertTrue(bt.contains(4));

        assertFalse(bt.contains(1));
    }
}