package Ejercicios;

public class Recorridos<E> {
    public void bfsRecursivo(Node<E> root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private void printLevel(Node<E> node, int level) {
        if (node == null) return;
        if (level == 1) System.out.print(node.data + " ");
        else {
            printLevel(node.left, level -1);
            printLevel(node.right, level -1);
        }
    }

    public void preorden(Node<E> node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorden(node.left);
        preorden(node.right);
    }
}
