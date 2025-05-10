package Actividad2;

public interface Queue<E> {
    void enqueue(E x);                    // Inserta un elemento al final
    E dequeue() throws ExceptionIsEmpty;  // Elimina y retorna el primer elemento
    E front() throws ExceptionIsEmpty;    // Muestra el primer elemento
    E back() throws ExceptionIsEmpty;     // Muestra el último elemento
    boolean isEmpty();                    // Verifica si la cola está vacía
}
