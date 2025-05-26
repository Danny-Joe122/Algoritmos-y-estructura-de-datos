package Ejercicios;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        AVL<Integer> avl = new AVL<>();
        Recorridos<Integer> rec = new Recorridos<>();

        int[] valores = {50, 30, 70, 20, 40, 60, 80};

        for (int v : valores) {
            bst.insert(v);
            avl.insert(v);
        }

        System.out.println("Altura BST: " + bst.height());
        System.out.println("Altura AVL: " + avl.height());

        System.out.println("\nRecorrido BFS BST:");
        rec.bfsRecursivo(bst.getRoot());

        System.out.println("\nRecorrido BFS AVL:");
        rec.bfsRecursivo(avl.getRoot());

        System.out.println("\nRecorrido Preorden AVL:");
        rec.preorden(avl.getRoot());
        System.out.println();
    }
}
