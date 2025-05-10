package Actividad3;

public interface PriorityQueue<E, N extends Comparable<N>> {
    void enqueue(E x, N pr);          // Inserta un elemento con prioridad
    E dequeue() throws ExceptionIsEmpty;  // Elimina y retorna el elemento de mayor prioridad
    E front() throws ExceptionIsEmpty;    // Muestra el elemento con mayor prioridad
    E back() throws ExceptionIsEmpty;     // Muestra el elemento de menor prioridad
    boolean isEmpty();                    // Verifica si está vacía
}
