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
    public void checkRemove() throws Exception {
        tree.clean();
        tree.insert(16);
        tree.remove(16);
        assertFalse(tree.contains(16));

        tree.insert(24, 36, 19, 44, 28, 61, 74, 83);
        tree.remove(44);
        assertFalse(tree.contains(44));
        tree.remove(61);
        assertFalse(tree.contains(61));
        tree.remove(83);
        assertFalse(tree.contains(83));
        tree.remove(74);
        assertFalse(tree.contains(74));
        tree.remove(44);
        assertFalse(tree.contains(44));

    }

    @Test
    public void checkRemoveIF() throws Exception {
        tree.clean();

        tree.insert(1,2,3,4,5,6,7,8,9,0);
        tree.remove(1);
        assertFalse(tree.contains(1));
        tree.remove(2);
        assertFalse(tree.contains(2));
        tree.remove(3);
        assertFalse(tree.contains(3));
        tree.remove(4);
        assertFalse(tree.contains(4));
        tree.remove(5);
        assertFalse(tree.contains(5));
        tree.remove(6);
        assertFalse(tree.contains(6));
        tree.remove(7);
        assertFalse(tree.contains(7));
        tree.remove(8);
        assertFalse(tree.contains(8));
        tree.remove(9);
        assertFalse(tree.contains(9));

    }

    @Test
    public void checkRemoveIFS() throws Exception {
        tree.clean();

        tree.insert(1,2,3,4,5,6,7,8,9,0);
        tree.remove(6);
        assertFalse(tree.contains(6));
        tree.remove(3);
        assertFalse(tree.contains(3));
        tree.remove(4);
        assertFalse(tree.contains(4));
        tree.remove(7);
        assertFalse(tree.contains(7));
        tree.remove(8);
        assertFalse(tree.contains(8));
        tree.remove(1);
        assertFalse(tree.contains(1));

    }

    @Test
    public void checkRemoveIFT() throws Exception {
        tree.clean();

        tree.insert(1,2,3,4,5,6,7,8,9,0);
        tree.remove(9);
        assertFalse(tree.contains(9));
        tree.remove(8);
        assertFalse(tree.contains(8));
        tree.remove(6);
        assertFalse(tree.contains(6));
        tree.remove(5);
        assertFalse(tree.contains(5));
        tree.remove(4);
        assertFalse(tree.contains(4));
        tree.remove(3);
        assertFalse(tree.contains(3));
        tree.remove(2);
        assertFalse(tree.contains(2));
        tree.remove(1);
        assertFalse(tree.contains(1));

    }

    @Test
    public void testBalanceOfTree() throws Exception {
        assertTrue(tree.isEmpty());


        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));

        tree.insert(16, 24, 36, 19, 44, 28, 61, 74, 83, 64, 52, 65, 86, 93, 88);
        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));

        tree.remove(88);
        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));
        assertFalse(tree.contains(88));

        tree.remove(32);
        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));
        assertFalse(tree.contains(32));
    }

    @Test
    public void testExeptionOfTree() throws Exception {
        assertTrue(tree.isEmpty());

        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));

        tree.insert(16, 24, 36, 19, 44, 28, 61, 74, 83, 64, 52, 65, 86, 93);
        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));

        tree.remove(86);
        assertTrue(checkBalanceOfTree(tree.root));
        assertTrue(checkOrderingOfTree(tree.root));
        assertFalse(tree.contains(86));
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
