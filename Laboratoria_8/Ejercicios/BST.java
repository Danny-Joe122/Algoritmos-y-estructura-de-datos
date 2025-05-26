package Ejercicios;

public class BST<E extends Comparable<E>> {
    protected Node<E> root;

    public BST() {
        root = null;
    }

    public Node<E> getRoot() {
        return root;
    }

    public boolean insert(E data) {
        root = insertRec(root, data);
        return true;
    }

    private Node<E> insertRec(Node<E> node, E data) {
        if (node == null) return new Node<>(data);

        int cmp = data.compareTo(node.data);
        if (cmp < 0) node.left = insertRec(node.left, data);
        else if (cmp > 0) node.right = insertRec(node.right, data);
        // Ignora duplicados
        return node;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }
}
