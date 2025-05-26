package Actividad;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] valores = {30, 20, 10, 40, 50, 25, 45}; // Insertar claves que generen rotaciones

        for (int v : valores) {
            System.out.println("Insertando: " + v);
            avl.insert(v);
            avl.printTree();
            System.out.println("-----------------------------");
        }

        System.out.println("Recorrido Inorden:");
        avl.printInOrder();
    }
}
