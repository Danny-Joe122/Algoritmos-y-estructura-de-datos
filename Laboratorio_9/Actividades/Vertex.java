package graph;

public class Vertex<V> {
    private V info;  // Información asociada al vértice
    private int position;  // Posición o identificador único del vértice

    // Constructor
    public Vertex(V info, int position) {
        this.info = info;
        this.position = position;
    }

    // Getters y Setters
    public V getInfo() {
        return info;
    }

    public void setInfo(V info) {
        this.info = info;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "info=" + info +
                ", position=" + position +
                '}';
    }
}
