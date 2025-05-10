package Actividad1;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    // Constructor que recibe el tamaño del arreglo
    public StackArray(int capacidad) {
        array = (E[]) new Object[capacidad]; // Se crea arreglo genérico
        tope = -1;
    }

    // Agrega un elemento a la pila
    public void push(E x) {
        if (isFull()) throw new RuntimeException("La pila está llena.");
        array[++tope] = x;
    }

    // Elimina y retorna el elemento en la cima
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila está vacía.");
        return array[tope--];
    }

    // Retorna el elemento en la cima sin eliminarlo
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("La pila está vacía.");
        return array[tope];
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return tope == -1;
    }

    // Verifica si la pila está llena
    public boolean isFull() {
        return tope == array.length - 1;
    }

    // Muestra los elementos de la pila de arriba hacia abajo
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
