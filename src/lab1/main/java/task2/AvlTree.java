package task2;


public class AvlTree<T extends Comparable<? super T>> {
    public AvlNode<T> root;
    public int countInsertions;
    public int countSingleRotations;
    public int countDoubleRotations;

    public AvlTree() {
        root = null;
        countInsertions = 0;
        countSingleRotations = 0;
        countDoubleRotations = 0;
    }

    public int height(AvlNode<T> t) {
        if (t == null) return -1;
        return t.height;
    }

    public void insert(T... list) throws Exception {
        for (T item : list) this.insert(item);
    }

    public boolean insert(T x) throws Exception {
        root = insert(x, root);
        countInsertions++;
        return true;
    }


    protected AvlNode<T> insert(T x, AvlNode<T> t) throws Exception {
        if (t == null)
            t = new AvlNode<T>(x);
        else if (x.compareTo(t.element) < 0) {
            t.left = insert(x, t.left);

            if (height(t.left) - height(t.right) == 2) {
                if (x.compareTo(t.left.element) < 0) {
                    t = rotateWithLeftChild(t);
                    countSingleRotations++;
                } else {
                    t = doubleWithLeftChild(t);
                    countDoubleRotations++;
                }
            }
        } else if (x.compareTo(t.element) > 0) {
            t.right = insert(x, t.right);

            if (height(t.right) - height(t.left) == 2)
                if (x.compareTo(t.right.element) > 0) {
                    t = rotateWithRightChild(t);
                    countSingleRotations++;
                } else {
                    t = doubleWithRightChild(t);
                    countDoubleRotations++;
                }
        } else {
            throw new Exception("Attempting to insert duplicate value");
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }


    protected AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return (k1);
    }


    protected AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }


    protected AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;

        return (k2);
    }


    protected AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }


    public void clean(){
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public T findMin() {
        if (isEmpty()) return null;
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) return null;
        return findMax(root).element;
    }


    private AvlNode<T> findMin(AvlNode<T> t) {
        if (t == null) return t;
        while (t.left != null)
            t = t.left;
        return t;
    }


    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t == null) return t;
        while (t.right != null)
            t = t.right;
        return t;
    }


    public boolean contains(T x) {
        return contains(x, root);
    }   
    protected boolean contains(T x, AvlNode<T> t) {
        if (t == null) {
            return false;
        } else if (x.compareTo(t.element) < 0) {
            return contains(x, t.left);
        } else if (x.compareTo(t.element) > 0) {
            return contains(x, t.right);
        }
        return true;
    }
}