package lab05.listaenlazada;

public interface TDAList<T> {
    void agregarTarea(T tarea);
    boolean eliminarTarea(T tarea);
    boolean contieneTarea(T tarea);
    void imprimirTareas();
    int contarTareas();
    void invertirTareas();
}
