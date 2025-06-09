package graph;

public class Edge<V, E> {
    private Vertex<V> vertex1;  // Primer vértice de la arista
    private Vertex<V> vertex2;  // Segundo vértice de la arista
    private E weight;           // Peso o coste de la arista (puede ser cualquier tipo)

    // Constructor
    public Edge(Vertex<V> vertex1, Vertex<V> vertex2, E weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    // Getters y Setters
    public Vertex<V> getVertex1() {
        return vertex1;
    }

    public void setVertex1(Vertex<V> vertex1) {
        this.vertex1 = vertex1;
    }

    public Vertex<V> getVertex2() {
        return vertex2;
    }

    public void setVertex2(Vertex<V> vertex2) {
        this.vertex2 = vertex2;
    }

    public E getWeight() {
        return weight;
    }

    public void setWeight(E weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", weight=" + weight +
                '}';
    }
}
