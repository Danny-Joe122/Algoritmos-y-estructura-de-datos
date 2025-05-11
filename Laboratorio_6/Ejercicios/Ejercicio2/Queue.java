package Ejercicio2;

public interface Queue<E> {
    void enqueue(E x);                         // Agrega al final
    E dequeue() throws ExceptionIsEmpty;       // Elimina del frente
    E front() throws ExceptionIsEmpty;         // Ver frente sin eliminar
    E back() throws ExceptionIsEmpty;          // Ver último sin eliminar
    boolean isEmpty();                         // Verifica si está vacía
}
