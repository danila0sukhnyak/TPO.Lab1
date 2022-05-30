package task2;


public class AvlNode<T> {
    protected T element;
    protected AvlNode<T> left;
    protected AvlNode<T> right;
    protected int height;

    public AvlNode(T theElement) {
        this(theElement, null, null);
    }

    public AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt) {
        element = theElement;
        left = lt;
        right = rt;
    }
}