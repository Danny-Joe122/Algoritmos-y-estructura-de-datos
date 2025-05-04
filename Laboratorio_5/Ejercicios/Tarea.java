package lab05.listaenlazada;

public class Tarea {
    private String descripcion;
    private int prioridad;

    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "[Tarea: " + descripcion + " | Prioridad: " + prioridad + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tarea) {
            Tarea t = (Tarea) obj;
            return this.descripcion.equals(t.descripcion) && this.prioridad == t.prioridad;
        }
        return false;
    }
}
