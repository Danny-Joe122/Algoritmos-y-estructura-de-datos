package graph;

public class VertexObj<V, E> {
    protected V info;   // Información que guarda el vértice
    protected int position;  // Posición en la lista o el grafo (opcional)

    public VertexObj(V info, int position) {
        this.info = info;
        this.position = position;
    }

    public V getInfo() {
        return info;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "VertexObj{" +
               "info=" + info +
               ", position=" + position +
               '}';
    }
}
