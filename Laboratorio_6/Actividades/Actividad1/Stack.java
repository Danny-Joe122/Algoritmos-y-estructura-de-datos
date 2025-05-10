package Actividad1;

public interface Stack<E> {
    void push(E x);                    // Agrega un elemento a la pila
    E pop() throws ExceptionIsEmpty;   // Elimina y retorna el elemento en la cima
    E top() throws ExceptionIsEmpty;   // Retorna el elemento en la cima sin eliminarlo
    boolean isEmpty();                 // Verifica si la pila está vacía
}
