package graphrepresentation;

import graph.Vertex;
import graph.Edge;
import java.util.*;

public class GraphListEdge {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public GraphListEdge() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        Edge edge = new Edge(v1, v2, weight);
        edges.add(edge);
    }
}
