package Ejercicios;

import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import bstreeInterface.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private class Node {
        E data;
        Node left, right;
        Node(E data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public LinkedBST() {
        root = null;
    }

    // ===== Métodos básicos =====

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node node, E data) throws ItemDuplicated {
        if (node == null) return new Node(data);
        int cmp = data.compareTo(node.data);
        if (cmp == 0) throw new ItemDuplicated("Dato duplicado: " + data);
        else if (cmp < 0) node.left = insertRecursive(node.left, data);
        else node.right = insertRecursive(node.right, data);
        return node;
    }

    @Override
    public boolean search(E data) throws ExceptionIsEmpty, ItemNoFound {
        if (root == null) throw new ExceptionIsEmpty("Árbol vacío");
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node node, E data) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("Dato no encontrado: " + data);
        int cmp = data.compareTo(node.data);
        if (cmp == 0) return true;
        else if (cmp < 0) return searchRecursive(node.left, data);
        else return searchRecursive(node.right, data);
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty, ItemNoFound {
        if (root == null) throw new ExceptionIsEmpty("Árbol vacío");
        root = deleteRecursive(root, data);
    }

    private Node deleteRecursive(Node node, E data) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("Dato no encontrado: " + data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0) node.left = deleteRecursive(node.left, data);
        else if (cmp > 0) node.right = deleteRecursive(node.right, data);
        else {
            // Nodo encontrado
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // Nodo con dos hijos
            Node minNode = findMinNode(node.right);
            node.data = minNode.data;
            node.right = deleteRecursive(node.right, minNode.data);
        }
        return node;
    }

    private Node findMinNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // ===== Ejercicio 1 =====

    @Override
    public void destroyNodes() throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty("Árbol vacío");
        root = null;
    }

    @Override
    public int countAllNodes() throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty("Árbol vacío");
        return countNonLeafNodes(root);
    }

    private int countNonLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
    }

    @Override
    public int countNodes() throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty("Árbol vacío");
        return countAll(node -> true, root);
    }

    private int countAll(Predicate<Node> condition, Node node) {
        if (node == null) return 0;
        int count = condition.test(node) ? 1 : 0;
        count += countAll(condition, node.left);
        count += countAll(condition, node.right);
        return count;
    }

    @Override
    public int height(E x) throws ExceptionIsEmpty, ItemNoFound {
        if (root == null) throw new ExceptionIsEmpty("Árbol vacío");
        Node subRoot = findNodeIterative(root, x);
        if (subRoot == null) throw new ItemNoFound("Nodo no encontrado: " + x);
        return heightIterative(subRoot);
    }

    private Node findNodeIterative(Node node, E x) {
        Node current = node;
        while (current != null) {
            int cmp = x.compareTo(current.data);
            if (cmp == 0) return current;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }

    private int heightIterative(Node node) {
        if (node == null) return -1;
        int height = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return height;
    }

    @Override
    public int amplitude(int nivel) throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty("Árbol vacío");
        int h = heightIterative(root);
        if (nivel > h) return 0;
        return countNodesAtLevel(root, nivel);
    }

    private int countNodesAtLevel(Node node, int level) {
        if (node == null) return 0;
        if (level == 0) return 1;
        return countNodesAtLevel(node.left, level - 1) + countNodesAtLevel(node.right, level - 1);
    }

    // ===== Ejercicio 2 =====

    @Override
    public int areaBST() throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty("Árbol vacío");
        int hojas = countLeavesIterative();
        int altura = heightIterative(root);
        return hojas * altura;
    }

    private int countLeavesIterative() {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.left == null && curr.right == null) count++;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return count;
    }

    @Override
    public void drawBST() {
        System.out.println(drawRecursive(root, 0));
    }

    private String drawRecursive(Node node, int indent) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) sb.append("  ");
        sb.append(node.data).append("\n");
        sb.append(drawRecursive(node.left, indent + 1));
        sb.append(drawRecursive(node.right, indent + 1));
        return sb.toString();
    }

    @Override
    public boolean sameArea(BinarySearchTree<E> other) throws ExceptionIsEmpty {
        if (root == null || other == null) throw new ExceptionIsEmpty("Árbol vacío");
        if (!(other instanceof LinkedBST<?>)) throw new IllegalArgumentException("Debe ser LinkedBST");
        LinkedBST<E> otherTree = (LinkedBST<E>) other;
        return this.areaBST() == otherTree.areaBST();
    }

    // ===== Ejercicio 3 =====

    @Override
    public void parenthesize() {
        parenthesize(root, 0, true);
    }

    private void parenthesize(Node node, int indent, boolean isLast) {
        if (node == null) return;
        for (int i = 0; i < indent; i++) System.out.print("  ");
        System.out.print(node.data);
        if (node.left != null || node.right != null) System.out.print(" (");
        System.out.println();

        if (node.left != null) parenthesize(node.left, indent + 1, false);
        if (node.right != null) parenthesize(node.right, indent + 1, true);

        for (int i = 0; i < indent; i++) System.out.print("  ");
        if (node.left != null || node.right != null) System.out.println(")");
    }
}
