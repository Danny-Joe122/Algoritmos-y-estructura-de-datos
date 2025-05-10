package Actividad3;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    // Clase interna para combinar dato y prioridad
    private class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void enqueue(E x, N pr) {
        EntryNode nuevo = new EntryNode(x, pr);
        Node<EntryNode> nuevoNodo = new Node<>(nuevo);

        if (isEmpty() || pr.compareTo(first.getData().priority) > 0) {
            // Inserta al inicio si la cola está vacía o el elemento tiene mayor prioridad
            nuevoNodo.setNext(first);
            first = nuevoNodo;
            if (last == null) last = nuevoNodo;
        } else {
            // Inserta en la posición adecuada manteniendo el orden por prioridad
            Node<EntryNode> actual = first;
            while (actual.getNext() != null && pr.compareTo(actual.getNext().getData().priority) <= 0) {
                actual = actual.getNext();
            }
            nuevoNodo.setNext(actual.getNext());
            actual.setNext(nuevoNodo);
            if (nuevoNodo.getNext() == null) last = nuevoNodo;
        }
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        E valor = first.getData().data;
        first = first.getNext();
        if (first == null) last = null;
        return valor;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        return first.getData().data;
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía.");
        return last.getData().data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<EntryNode> aux = first;
        while (aux != null) {
            sb.append(aux.getData().data).append(" (").append(aux.getData().priority).append(")");
            aux = aux.getNext();
            if (aux != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
