package graph;

import java.util.*;

public class GraphLink<V, E> {
    private Map<Integer, Vertex<V>> vertices;   // Mapa de vértices
    private List<Edge<V, E>> edges;              // Lista de aristas

    // Constructor
    public GraphLink() {
        this.vertices = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    // Método para agregar un vértice al grafo
    public void addVertex(Vertex<V> vertex) {
        vertices.put(vertex.getPosition(), vertex);
    }

    // Método para agregar una arista
    public void addEdge(Edge<V, E> edge) {
        edges.add(edge);
    }

    // Buscar un vértice
    public Vertex<V> searchVertex(int position) {
        return vertices.get(position);
    }

    // Buscar una arista entre dos vértices
    public Edge<V, E> searchEdge(int position1, int position2) {
        for (Edge<V, E> edge : edges) {
            if ((edge.getVertex1().getPosition() == position1 && edge.getVertex2().getPosition() == position2) ||
                (edge.getVertex1().getPosition() == position2 && edge.getVertex2().getPosition() == position1)) {
                return edge;
            }
        }
        return null; // Si no existe la arista
    }

    // Eliminar un vértice
    public void removeVertex(int position) {
        vertices.remove(position);
        edges.removeIf(edge -> edge.getVertex1().getPosition() == position || edge.getVertex2().getPosition() == position);
    }

    // Eliminar una arista
    public void removeEdge(int position1, int position2) {
        edges.removeIf(edge -> (edge.getVertex1().getPosition() == position1 && edge.getVertex2().getPosition() == position2) ||
                                 (edge.getVertex1().getPosition() == position2 && edge.getVertex2().getPosition() == position1));
    }

    // Recorrido DFS (en profundidad)
    public void dfs(int startPosition) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(startPosition, visited);
    }

    private void dfsRecursive(int position, Set<Integer> visited) {
        if (visited.contains(position)) return;
        visited.add(position);
        System.out.print(position + " ");

        // Recorrer los vértices conectados
        for (Edge<V, E> edge : edges) {
            if (edge.getVertex1().getPosition() == position && !visited.contains(edge.getVertex2().getPosition())) {
                dfsRecursive(edge.getVertex2().getPosition(), visited);
            }
            if (edge.getVertex2().getPosition() == position && !visited.contains(edge.getVertex1().getPosition())) {
                dfsRecursive(edge.getVertex1().getPosition(), visited);
            }
        }
    }

    // Recorrido BFS (en anchura)
    public void bfs(int startPosition) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(startPosition);
        queue.add(startPosition);

        while (!queue.isEmpty()) {
            int position = queue.poll();
            System.out.print(position + " ");

            // Recorrer los vértices conectados
            for (Edge<V, E> edge : edges) {
                if (edge.getVertex1().getPosition() == position && !visited.contains(edge.getVertex2().getPosition())) {
                    visited.add(edge.getVertex2().getPosition());
                    queue.add(edge.getVertex2().getPosition());
                }
                if (edge.getVertex2().getPosition() == position && !visited.contains(edge.getVertex1().getPosition())) {
                    visited.add(edge.getVertex1().getPosition());
                    queue.add(edge.getVertex1().getPosition());
                }
            }
        }
    }

    // Mostrar el grafo
    public void printGraph() {
        System.out.println("Vértices:");
        for (Vertex<V> vertex : vertices.values()) {
            System.out.println(vertex);
        }

        System.out.println("Aristas:");
        for (Edge<V, E> edge : edges) {
            System.out.println(edge);
        }
    }
}
