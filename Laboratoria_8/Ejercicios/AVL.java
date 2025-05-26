package Ejercicios;

public class AVL<E extends Comparable<E>> {
    private NodeAVL<E> root;

    public AVL() {
        root = null;
    }

    public Node<E> getRoot() {
        return root;
    }

    public boolean insert(E data) {
        root = insertAVL(root, data);
        return true;
    }

    private NodeAVL<E> insertAVL(NodeAVL<E> node, E data) {
        if (node == null) return new NodeAVL<>(data);

        int cmp = data.compareTo(node.data);
        if (cmp == 0) throw new RuntimeException("Elemento duplicado");
        else if (cmp < 0) {
            node.left = insertAVL((NodeAVL<E>) node.left, data);
            node.bf--;
            if (node.bf == -2) node = balanceRight(node);
        } else {
            node.right = insertAVL((NodeAVL<E>) node.right, data);
            node.bf++;
            if (node.bf == 2) node = balanceLeft(node);
        }
        return node;
    }

    private NodeAVL<E> balanceLeft(NodeAVL<E> node) {
        NodeAVL<E> hijo = (NodeAVL<E>) node.right;
        if (hijo.bf >= 0) {
            node.bf = 0;
            hijo.bf = 0;
            node = rotateSL(node);
        } else {
            NodeAVL<E> nieto = (NodeAVL<E>) hijo.left;
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

    private NodeAVL<E> balanceRight(NodeAVL<E> node) {
        NodeAVL<E> hijo = (NodeAVL<E>) node.left;
        if (hijo.bf <= 0) {
            node.bf = 0;
            hijo.bf = 0;
            node = rotateSR(node);
        } else {
            NodeAVL<E> nieto = (NodeAVL<E>) hijo.right;
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
        NodeAVL<E> temp = (NodeAVL<E>) node.right;
        node.right = (NodeAVL<E>) temp.left;
        temp.left = node;
        return temp;
    }

    private NodeAVL<E> rotateSR(NodeAVL<E> node) {
        NodeAVL<E> temp = (NodeAVL<E>) node.left;
        node.left = (NodeAVL<E>) temp.right;
        temp.right = node;
        return temp;
    }

    public int height() {
        return height(root);
    }

    private int height(NodeAVL<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height((NodeAVL<E>) node.left), height((NodeAVL<E>) node.right));
    }
}
