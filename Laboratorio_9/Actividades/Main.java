package Main;

import graph.*;

public class Main {
    public static void main(String[] args) {
        GraphLink<String, Integer> graph = new GraphLink<>();

        // Crear vértices
        Vertex<String> v1 = new Vertex<>("A", 1);
        Vertex<String> v2 = new Vertex<>("B", 2);
        Vertex<String> v3 = new Vertex<>("C", 3);

        // Agregar vértices al grafo
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        // Crear aristas
        Edge<String, Integer> e1 = new Edge<>(v1, v2, 10);
        Edge<String, Integer> e2 = new Edge<>(v2, v3, 5);

        // Agregar aristas al grafo
        graph.addEdge(e1);
        graph.addEdge(e2);

        // Imprimir el grafo
        graph.printGraph();

        // Realizar un recorrido DFS y BFS
        System.out.println("DFS:");
        graph.dfs(1);
        System.out.println("\nBFS:");
        graph.bfs(1);
    }
}
