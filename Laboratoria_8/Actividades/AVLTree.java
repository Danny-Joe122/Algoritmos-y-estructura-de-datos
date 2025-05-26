package Actividad;

public class AVLTree<E extends Comparable<E>> {
    private NodeAVL<E> root;

    public AVLTree() {
        this.root = null;
    }

    public boolean insert(E data) {
        root = insertAVL(root, data);
        return true;
    }

    private NodeAVL<E> insertAVL(NodeAVL<E> node, E data) {
        if (node == null) {
            return new NodeAVL<>(data);
        }

        int cmp = data.compareTo(node.data);

        if (cmp == 0) {
            throw new RuntimeException("Elemento duplicado");
        } else if (cmp < 0) {
            node.left = insertAVL(node.left, data);
            node.bf--;
            if (node.bf == -2) {
                node = balanceToRight(node);
            }
        } else {
            node.right = insertAVL(node.right, data);
            node.bf++;
            if (node.bf == 2) {
                node = balanceToLeft(node);
            }
        }
        return node;
    }

    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
        NodeAVL<E> hijo = node.right;
        if (hijo.bf >= 0) {
            node.bf = 0;
            hijo.bf = 0;
            node = rotateSL(node);
        } else {
            NodeAVL<E> nieto = hijo.left;
            switch (nieto.bf) {
                case -1:
                    node.bf = 0;
                    hijo.bf = 1;
                    break;
                case 0:
                    node.bf = 0;
                    hijo.bf = 0;
                    break;
                case 1:
                    node.bf = -1;
                    hijo.bf = 0;
                    break;
            }
            nieto.bf = 0;
            node.right = rotateSR(hijo);
            node = rotateSL(node);
        }
        return node;
    }

    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
        NodeAVL<E> hijo = node.left;
        if (hijo.bf <= 0) {
            node.bf = 0;
            hijo.bf = 0;
            node = rotateSR(node);
        } else {
            NodeAVL<E> nieto = hijo.right;
            switch (nieto.bf) {
                case 1:
                    node.bf = 0;
                    hijo.bf = -1;
                    break;
                case 0:
                    node.bf = 0;
                    hijo.bf = 0;
                    break;
                case -1:
                    node.bf = 1;
                    hijo.bf = 0;
                    break;
            }
            nieto.bf = 0;
            node.left = rotateSL(hijo);
            node = rotateSR(node);
        }
        return node;
    }

    private NodeAVL<E> rotateSL(NodeAVL<E> node) {
        NodeAVL<E> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private NodeAVL<E> rotateSR(NodeAVL<E> node) {
        NodeAVL<E> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    // Imprime árbol inorden con factor de equilibrio
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(NodeAVL<E> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.toString() + "  ");
            printInOrder(node.right);
        }
    }

    // Imprime el árbol por niveles (estructura)
    public void printTree() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }

    private void printLevel(NodeAVL<E> node, int level) {
        if (node == null) {
            System.out.print("    ");
            return;
        }
        if (level == 1) {
            System.out.print(node.data + "(" + node.bf + ") ");
        } else {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    private int height(NodeAVL<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
