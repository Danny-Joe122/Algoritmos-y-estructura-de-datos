package graph;

public class Edge {
    private Vertex v1, v2;
    private int weight;

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Vertex getOtherVertex(Vertex vertex) {
        return vertex.equals(v1) ? v2 : v1;
    }

    public int getWeight() {
        return weight;
    }
}
