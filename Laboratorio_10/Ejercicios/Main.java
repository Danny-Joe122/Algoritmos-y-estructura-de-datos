package Main;

import Model.RegistroEstudiante;
import Tree.BTree;

public class Main {
    public static void main(String[] args) {
        BTree<RegistroEstudiante> arbol = new BTree<>(4);

        RegistroEstudiante[] estudiantes = {
            new RegistroEstudiante(103, "Ana"),
            new RegistroEstudiante(110, "Luis"),
            new RegistroEstudiante(101, "Carlos"),
            new RegistroEstudiante(120, "Lucía"),
            new RegistroEstudiante(115, "David"),
            new RegistroEstudiante(125, "Jorge"),
            new RegistroEstudiante(140, "Camila"),
            new RegistroEstudiante(108, "Rosa"),
            new RegistroEstudiante(132, "Ernesto"),
            new RegistroEstudiante(128, "Denis"),
            new RegistroEstudiante(145, "Enrique"),
            new RegistroEstudiante(122, "Karina"),
            new RegistroEstudiante(108, "Juan") // Duplicado
        };

        System.out.println("--- Inserciones ---");
        for (RegistroEstudiante e : estudiantes) arbol.insert(e);

        System.out.println("\n--- Estado del Árbol ---");
        System.out.println(arbol);

        System.out.println("\n--- Búsquedas ---");
        arbol.search(new RegistroEstudiante(115, ""));
        arbol.search(new RegistroEstudiante(132, ""));
        arbol.search(new RegistroEstudiante(999, ""));

        System.out.println("\n--- Inserción adicional ---");
        arbol.insert(new RegistroEstudiante(106, "Sara"));
        arbol.search(new RegistroEstudiante(106, ""));

        System.out.println("\n--- Buscar Nombre ---");
        System.out.println("115 → " + arbol.buscarNombre(115));
        System.out.println("132 → " + arbol.buscarNombre(132));
        System.out.println("999 → " + arbol.buscarNombre(999));

        System.out.println("\n--- Eliminación ---");
        arbol.remove(new RegistroEstudiante(101, ""));
        arbol.search(new RegistroEstudiante(101, ""));

        System.out.println("\n--- Estado del Árbol después de eliminar 101 ---");
        System.out.println(arbol);

        System.out.println("\n--- Análisis de Complejidad ---");
        System.out.println("- Búsqueda: O(log n)");
        System.out.println("- Inserción: O(log n)");
        System.out.println("- Eliminación: O(log n)");
        System.out.println("El orden t afecta directamente la altura: mayor t, menor altura.");

        System.out.println("\n--- Aplicaciones de B-Trees ---");
        System.out.println("1. Bases de datos: índices eficientes.");
        System.out.println("2. Sistemas de archivos: NTFS, HFS+, etc.");
    }
}
