package Btree;

public class Main {
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>(4);

        // Insertar claves en el árbol
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(10);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);
        tree.insert(100);
        tree.insert(110);

        // Mostrar el árbol después de las inserciones
        System.out.println("Árbol después de las inserciones:");
        System.out.println(tree);

        // Buscar claves en el árbol
        System.out.println("Buscar 40: " + tree.search(40));  // Buscar clave 40
        System.out.println("Buscar 100: " + tree.search(100));  // Buscar clave 100
        System.out.println("Buscar 150: " + tree.search(150));  // Buscar clave 150
    }
}
