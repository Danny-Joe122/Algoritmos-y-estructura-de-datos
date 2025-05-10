package Actividad2;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;  // Apunta al primer nodo de la lista
    private Node<E> last;   // Apunta al último nodo de la lista

    // Constructor inicializa la cola vacía
    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    // Inserta un nuevo elemento al final de la cola
    @Override
    public void enqueue(E x) {
        Node<E> nuevo = new Node<>(x);  // Crea un nuevo nodo con el dato
        if (isEmpty()) {
            first = nuevo;  // Si la cola está vacía, primero y último son el mismo nodo
        } else {
            last.setNext(nuevo);  // Conecta el último nodo al nuevo nodo
        }
        last = nuevo;  // Actualiza el último nodo de la cola
    }

    // Elimina el primer elemento de la cola y lo retorna
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        E valor = first.getData();  // Obtiene el dato del primer nodo
        first = first.getNext();    // Mueve el primer nodo al siguiente
        if (first == null) last = null;  // Si la cola está vacía, también el último nodo es null
        return valor;
    }

    // Muestra el primer elemento de la cola sin eliminarlo
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        return first.getData();
    }

    // Muestra el último elemento de la cola sin eliminarlo
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        return last.getData();
    }

    // Verifica si la cola está vacía
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    // Método para mostrar la cola en formato de cadena
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> aux = first;
        while (aux != null) {
            sb.append(aux.getData());
            aux = aux.getNext();
            if (aux != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
