package main;

import graph.*;
import graphidentifier.GraphTypeIdentifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear el grafo
        GraphLink graph = new GraphLink();

        // Crear vértices
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");

        // Agregar vértices al grafo
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);

        // Agregar aristas al grafo
        graph.addEdge(vertex1, vertex2, 1);
        graph.addEdge(vertex2, vertex3, 1);
        graph.addEdge(vertex3, vertex4, 1);
        // Si deseas un ciclo, agrega esta línea
        graph.addEdge(vertex4, vertex1, 1);

        // Mostrar el menú
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Verificar si es un Camino");
            System.out.println("2. Verificar si es un Ciclo");
            System.out.println("3. Agregar un vértice");
            System.out.println("4. Agregar una arista");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Verificar si es un Camino
                    boolean isPath = GraphTypeIdentifier.isPath(graph);
                    System.out.println("¿Es un camino? " + isPath);
                    break;
                case 2:
                    // Verificar si es un Ciclo
                    boolean isCycle = GraphTypeIdentifier.isCycle(graph);
                    System.out.println("¿Es un ciclo? " + isCycle);
                    break;
                case 3:
                    // Agregar un vértice
                    System.out.print("Introduce el nombre del vértice: ");
                    String vertexName = scanner.next();
                    Vertex newVertex = new Vertex(vertexName);
                    graph.addVertex(newVertex);
                    System.out.println("Vértice " + vertexName + " agregado.");
                    break;
                case 4:
                    // Agregar una arista
                    System.out.print("Introduce el vértice de origen: ");
                    String startVertex = scanner.next();
                    System.out.print("Introduce el vértice de destino: ");
                    String endVertex = scanner.next();
                    System.out.print("Introduce el peso de la arista: ");
                    int weight = scanner.nextInt();
                    
                    // Buscar los vértices
                    Vertex v1 = null, v2 = null;
                    for (Vertex v : graph.getVertices()) {
                        if (v.getName().equals(startVertex)) v1 = v;
                        if (v.getName().equals(endVertex)) v2 = v;
                    }
                    if (v1 != null && v2 != null) {
                        graph.addEdge(v1, v2, weight);
                        System.out.println("Arista agregada entre " + startVertex + " y " + endVertex + " con peso " + weight);
                    } else {
                        System.out.println("Vértices no encontrados.");
                    }
                    break;
                case 5:
                    // Salir
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (choice != 5);  // Continuar hasta que se elija salir
    }
}
