package task2;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AvlTreeTest {

    private final AvlTree<Integer> tree = new AvlTree<>();

    private boolean checkBalanceOfTree(AvlNode<Integer> current) {
        if (current != null) {
            boolean balancedRight = true, balancedLeft = true;
            int leftHeight = 0, rightHeight = 0;

            if (current.right != null) {
                balancedRight = checkBalanceOfTree(current.right);
                rightHeight = getDepth(current.right);
            }

            if (current.left != null) {
                balancedLeft = checkBalanceOfTree(current.left);
                leftHeight = getDepth(current.left);
            }
            return balancedLeft && balancedRight && Math.abs(leftHeight - rightHeight) < 2;
        }
        return true;
    }

    private int getDepth(AvlNode<Integer> n) {
        int leftHeight = 0, rightHeight = 0;

        if (n.right != null)
            rightHeight = getDepth(n.right);
        if (n.left != null)
            leftHeight = getDepth(n.left);

        return Math.max(rightHeight, leftHeight)+1;
    }

    private boolean checkOrderingOfTree(AvlNode<Integer> current) {
        if (current != null) {
            if (current.left != null) {
                if (current.left.element.compareTo(current.element) > 0)
                    return false;
                else
                    return checkOrderingOfTree(current.left);
            } else if (current.right != null) {
                if (current.right.element.compareTo(current.element) < 0)
                    return false;
                else
                    return checkOrderingOfTree(current.right);
            }
        }
        return true;
    }

    @Test
    public void checkHeight() throws Exception {
        tree.clean();
        tree.insert(16, 21, 23, 24);
        assertEquals(2, tree.height(tree.root));

    }
    @Test
    public void checkMax() throws Exception {
        tree.clean();
        tree.insert(16, 24, 36, 19, 44, 28, 61, 74, 83, 64, 52, 65, 86, 93, 88);
        assertEquals(93, tree.findMax());
    }

    @Test
    public void checkMin() throws Exception {
        tree.clean();
        tree.insert(16, 24, 36, 19, 44, 28, 61, 74, 83, 64, 52, 65, 86, 93, 88);
        assertEquals(16, tree.findMin());
        tree.insert(1, 2, 3);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        tree.insert(9, 8, 7);
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(7));
        tree.clean();
        tree.insert(-3, -1, -2);
        assertTrue(tree.contains(-3));
        assertTrue(tree.contains(-1));
        assertTrue(tree.contains(-2));
        tree.clean();
        tree.insert(1, 3, 2);
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        tree.clean();
        tree.insert(9, 1, 3);
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(3));
    }

    @Test
    public void check() throws Exception {
        tree.clean();
        tree.insert(16, 24, 36, 19, 44, 28, 61, 74, 83, 64, 52, 65, 86, 93, 88);
        assertEquals(16, tree.findMin());
        tree.insert(1, 2, 3);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        tree.insert(9, 8, 7);
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(7));
        tree.clean();
        tree.insert(-3, -1, -2);
        assertTrue(tree.contains(-3));
        assertTrue(tree.contains(-1));
        assertTrue(tree.contains(-2));
        tree.clean();
        tree.insert(1, 3, 2);
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        tree.clean();
        tree.insert(9, 1, 3);
        assertTrue(tree.contains(9));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(3));
    }

    @Test
    public void checkInsert() throws Exception {
        tree.clean();
        tree.insert(16);
        assertTrue(tree.contains(16));
        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));

    }

    @Test
    public void checkContainsNull() {
        assertFalse(tree.contains(null));
    }



    @Test
    public void testBalanceOfTree() throws Exception {
        assertTrue(tree.isEmpty());


        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));

        tree.insert(16, 24, 36, 19, 44, 28, 61, 74, 83, 64, 52, 65, 86, 93, 88);
        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));
    }

    @Test
    public void testExeptionOfTree() throws Exception {
        assertTrue(tree.isEmpty());

        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));

        tree.insert(16, 24, 36, 19, 44, 28, 61, 74, 83, 64, 52, 65, 86, 93);
        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));
    }

    @Test
    public void checkClean() throws Exception {
        tree.clean();
        tree.insert(16);
        assertTrue(tree.contains(16));
        tree.clean();
        assertFalse(tree.contains(null));

    }

    @Test
    public void checkContains() throws Exception {
        tree.clean();
        tree.insert(16);
        assertTrue( tree.contains(16));

    }

    @Test
    public void checkRotateWithLeftChild() throws Exception {
        tree.clean();
        AvlNode<Integer> test = new AvlNode<>(5, new AvlNode<>(6), new AvlNode<>(7));
        AvlNode<Integer> n = tree.rotateWithLeftChild(test);
        assertEquals(6, n.element);
        assertNull(n.left);
        assertEquals(5, n.right.element);
        assertEquals(7, n.right.right.element);
    }

    @Test
    public void checkRotateWithRightChild() throws Exception {
        tree.clean();
        AvlNode<Integer> test = new AvlNode<>(7, new AvlNode<>(6), new AvlNode<>(5));
        AvlNode<Integer> n = tree.rotateWithRightChild(test);
        assertEquals(5, n.element);
        assertNull(n.right);
        assertEquals(7, n.left.element);
        assertEquals(6, n.left.left.element);
    }

    @Test
    public void checkDoubleWithLeftChild() throws Exception {
        tree.clean();
        AvlNode<Integer> test = new AvlNode<>(5, new AvlNode<>(6), new AvlNode<>(7));
        tree.rotateWithLeftChild(test);
        assertEquals(5, test.element);
        assertNull(test.left);
        assertEquals(7, test.right.element);
    }

    @Test
    public void checkDoubleWithRightChild() throws Exception {
        tree.clean();
        AvlNode<Integer> test = new AvlNode<>(7, new AvlNode<>(6), new AvlNode<>(5));
        AvlNode<Integer> n = tree.rotateWithRightChild(test);
        assertEquals(7, test.element);
        assertNull(test.right);
        assertEquals(6, test.left.element);
    }

    @Test
    void checkDuplicateValue() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> {
                    tree.clean();
                    tree.insert(16);
                    tree.insert(16);
                },
                "Attempting to insert duplicate value"
        );
        assertTrue(thrown.getMessage().contains("Attempting to insert duplicate value"));
    }
}
