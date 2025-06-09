package graph;

import java.util.*;

public class GraphLink {
    private List<Vertex> vertices;  // Lista de vértices
    private List<Edge> edges;      // Lista de aristas

    public GraphLink() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    // Método para agregar vértices
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    // Método para agregar aristas
    public void addEdge(Vertex v1, Vertex v2, int weight) {
        Edge edge = new Edge(v1, v2, weight);
        v1.addEdge(edge);
        v2.addEdge(edge);
        edges.add(edge);
    }

    // Método para obtener la lista de vértices
    public List<Vertex> getVertices() {
        return vertices;
    }

    // Método para obtener el grado de un vértice (número de aristas conectadas)
    public int getDegree(Vertex vertex) {
        int degree = 0;
        for (Edge edge : vertex.getEdges()) {
            if (edge.getOtherVertex(vertex) != null) {
                degree++;
            }
        }
        return degree;
    }

    // Otros métodos según lo necesites...
}
